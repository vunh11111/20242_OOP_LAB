package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f, 1000);
		cart.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f, 1001);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		
		//Test the print method
		cart.print();
		// Test the search method here
		cart.searchById(1000);
		cart.searchById(1002);
		cart.searchByTitle("The Lion King");
		cart.searchByTitle("Manchester United");
	}
}
