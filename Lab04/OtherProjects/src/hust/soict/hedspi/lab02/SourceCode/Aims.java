
public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin       ", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc[] dvdList1 = new DigitalVideoDisc[3];
		dvdList1[0] = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 29.95f);
		dvdList1[1] = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 22.95f);
		dvdList1[2] = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 25.95f);
		anOrder.addDigitalVideoDisc(dvdList1);
		System.out.println("Total Cost is: " + anOrder.totalCost());
		anOrder.displayCart();
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 27.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Dark Knight", "Action", "Christopher Nolan", 152, 23.99f);
		anOrder.addDigitalVideoDisc(dvd7, dvd8);

		//Test removeDVD
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.displayCart();
	}
}
