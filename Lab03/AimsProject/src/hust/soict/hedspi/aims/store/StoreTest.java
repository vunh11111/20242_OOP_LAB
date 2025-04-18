package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo 5 DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix");
        // Test addDVD
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);
        store.addDVD(dvd5);

        // Test removeDVD
        store.removeDVD(dvd3); // Aladdin
        store.removeDVD(dvd1); // The Lion King

        // Test remove DVD không tồn tại
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Not in store");
        store.removeDVD(dvd6);
    }
}
