package hust.soict.hedspi.aims.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemsToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String artist = artistField.getText();
            float cost = Float.parseFloat(costField.getText());

            CompactDisc cd = new CompactDisc(title, category, cost, artist);
            store.addMedia(cd);

            dispose();
            new StoreManagerScreen(store);
        });

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.add(titleLabel);    panel.add(titleField);
        panel.add(categoryLabel); panel.add(categoryField);
        panel.add(artistLabel);   panel.add(artistField);
        panel.add(costLabel);     panel.add(costField);
        panel.add(new JLabel());  panel.add(addButton);

        return panel;
    }
}
