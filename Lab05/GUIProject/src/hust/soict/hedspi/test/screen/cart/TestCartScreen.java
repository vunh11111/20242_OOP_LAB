package hust.soict.hedspi.test.screen.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application {
    private Cart cart;

    @Override
    public void start(Stage primaryStage) {
        try {
            // 1. Khởi tạo Cart và thêm dữ liệu mẫu
            cart = new Cart();
            Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 0, "Roger Allers", 87);
            Media dvd2 = new DigitalVideoDisc("Star Wars");
            Media dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, "John Musker", 90);
            Media cd1 = new CompactDisc("Thriller", "Pop", 15.0f, "Michael Jackson");
            Media book1 = new Book("Java Programming", "Education", 35.0f);

            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
            cart.addMedia(cd1);
            cart.addMedia(book1);

            // 2. Load giao diện FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            CartController controller = new CartController(cart);
            loader.setController(controller);

            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Cart Test Screen");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

