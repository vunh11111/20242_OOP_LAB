package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ORDERS = 200;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore >= MAX_NUMBERS_ORDERS) {
            System.out.println("Store is full. Cannot add more DVDs.");
            return;
        }
        itemsInStore[qtyInStore] = disc;
        qtyInStore++;
        System.out.println("Added DVD: " + disc.getTitle());
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].equals(disc)) {
                // Shift elements to left
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("Removed DVD: " + disc.getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in store.");
        }
    }
}
