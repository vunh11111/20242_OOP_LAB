package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.util.function.Predicate;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    public CartController(Cart cart) {
        this.cart = cart;
    }
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnViewStore;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> updateButtonBar(newVal));

        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> showFilteredMedia(newVal));

        ToggleGroup filterGroup = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(filterGroup);
        radioBtnFilterTitle.setToggleGroup(filterGroup);

        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            filteredList.setAll(cart.getItemsOrdered());
            updateTotalCost();
        }
    }

    private void showFilteredMedia(String filter) {
        filteredList.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) return true;

            String lower = filter.toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lower);
            } else {
                return media.getTitle().toLowerCase().contains(lower);
            }
        });
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
				((Playable) media).play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/ViewStore.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.emptyCart();
        filteredList.setAll(cart.getItemsOrdered());
        updateTotalCost();
    }

    public void updateTotalCost() {
        float total = cart.totalCost();
        costLabel.setText(String.format("%.2f $", total));
    }
}
