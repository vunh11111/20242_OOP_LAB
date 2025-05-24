package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERS = 20;

    private List<Media> itemsOrdered = new ArrayList<>();
    public List<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }
    public Media searchById(int id) {
        for (Media disc : itemsOrdered) {
            if (disc != null && disc.getId() == id) {
                System.out.println("Found DVD with id = " + id + ": ");
                System.out.println(disc.toString());
                return disc; // Trả về media tìm thấy
            }
        }
        System.out.println("No DVD found with ID = " + id);
        return null; // Không tìm thấy
    }

    public List<Media> searchByTitle(String title) {
        List<Media> matchedMedia = new ArrayList<>();
        for (Media disc : itemsOrdered) {
            if (disc != null && disc.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchedMedia.add(disc);
            }
        }

        if (matchedMedia.isEmpty()) {
            System.out.println("No DVD found with title matching \"" + title + "\"");
        } else {
            System.out.println("Found DVD(s) with title { " + title + " }:");
            for (Media media : matchedMedia) {
                System.out.println(media.toString());
            }
        }

        return matchedMedia;
    }


    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart() {
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index++ + "\t " + media.getTitle() + "\t " + media.getCost());
        }
        System.out.println("\tTotal cost:\t " + totalCost());
    }

    public void print() {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items: ");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index++ + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("****************************************************");
    }

    // Thêm chức năng thêm Media vào giỏ
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERS) {
            itemsOrdered.add(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Cart is full. Cannot add more media.");
        }
    }

    // Thêm chức năng xoá Media khỏi giỏ
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            public int compare(Media m1, Media m2) {
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            }
        });
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            public int compare(Media m1, Media m2) {
                return Float.compare(m1.getCost(), m2.getCost());
            }
        });
        System.out.println("Cart sorted by cost.");
    }
    public void removeMediaFromCart(String title) {
        Media mediaToRemove = null;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToRemove = media;
                break;
            }
        }

        if (mediaToRemove != null) {
            itemsOrdered.remove(mediaToRemove);
            System.out.println("Media \"" + title + "\" has been removed from the cart.");
        } else {
            System.out.println("No media found with title \"" + title + "\" in the cart.");
        }
    }
	public void placeOrder() {
	    if (itemsOrdered.isEmpty()) {
	        System.out.println("Your cart is empty. No order placed.");
	    } else {
	        System.out.println("An order has been created.");
	        itemsOrdered.clear(); // xóa toàn bộ giỏ hàng
	    }
	}
	public void emptyCart() {
	    itemsOrdered.clear();
	    System.out.println("The cart has been emptied.");
	}

}
