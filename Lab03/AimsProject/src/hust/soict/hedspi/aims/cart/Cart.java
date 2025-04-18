package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERS = 20;
	private DigitalVideoDisc items[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
	private int qtyOrdered = 0;
	// Thêm DVD vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERS) {
            items[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc [" + disc.getTitle() + "] has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERS) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERS) {
            for(int i = 0; i < dvdList.length; i++) {
            	items[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc [" + dvdList[i].getTitle() + "] has been added.");
            }
            if (qtyOrdered == MAX_NUMBERS_ORDERS) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
    //Method addDigitalVideoDisc() which allows to pass an arbitrary number of arguments for dvd.
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//        for (DigitalVideoDisc dvd : dvds) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered++] = dvd;
//                System.out.println("Added: " + dvd.getTitle());
//            } else {
//                System.out.println("The order is full! Cannot add " + dvd.getTitle());
//                break; // Stop adding if order is full
//            }
//        }
//    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERS) {
            items[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The disc [" + dvd1.getTitle() + "] has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERS) {
                System.out.println("The cart is almost full.");
            }
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERS) {
            items[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The disc [" + dvd2.getTitle() + "] has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERS) {
                System.out.println("The cart is almost full.");
            }
        } 
        else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
    // Xóa DVD khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int found = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i] == disc) {
                found = 1;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items[j] = items[j + 1]; 
                }
                items[qtyOrdered - 1] = null; 
                qtyOrdered--;
                System.out.println("The disc [" + disc.getTitle() + "] has been removed.");
                break;
            }
        }
        if (found == 0) {
            System.out.println("The disc was not found in the cart.");
        }
    }
    public void searchById(int id) {
        boolean found = false;
        for (DigitalVideoDisc disc : items) {
            if (disc != null && disc.getId() == id) {
                System.out.println("Found DVD with id = " + id + ": ");
                System.out.println(disc.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID = " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (DigitalVideoDisc disc : items) {
            if (disc != null && disc.getTitle().toLowerCase().contains(title.toLowerCase())) {
                if (!found) {
                    System.out.println("Found DVD with title " + "{ " + title + " }" + ":" );
                }
                System.out.println(disc.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title matching \"" + title + "\"");
        }
    }
    // Tính tổng giá trị giỏ hàng
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost();
        }
        return total;
    }
    
    // Hiển thị danh sách DVD trong giỏ
    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1)+"\t " + items[i].getTitle() + "\t " + items[i].getCost());
        }
        System.out.println("\tTotal cost:\t " + totalCost());
    }
	public void print() {
		System.out.println("************************CART************************");
		System.out.println("Ordered Items: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.print(i + 1 + ". ");
            System.out.println(items[i].toString());
        }
        System.out.println("Total cost:" + totalCost());
        System.out.println("****************************************************");
	}
}
