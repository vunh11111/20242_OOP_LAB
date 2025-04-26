package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo 5 DVD (là các đối tượng Media)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix");

        // Test addMedia
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        // Hiển thị Store
        store.displayStore();

        // Test removeMedia
        store.removeMedia(dvd3); // Aladdin
        store.removeMedia(dvd1); // The Lion King

        // Test remove media không tồn tại
        Media dvd6 = new DigitalVideoDisc("Not in store");
        store.removeMedia(dvd6);

        // Hiển thị Store sau khi xoá
        store.displayStore();
    }
}
