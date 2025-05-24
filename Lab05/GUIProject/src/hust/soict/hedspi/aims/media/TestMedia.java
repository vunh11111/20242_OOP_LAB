package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMedia {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        // Tạo các đối tượng Media
        DigitalVideoDisc dvd = new DigitalVideoDisc("Avengers", "Action", 19.95f);
        Book book = new Book("The Hobbit", "Fantasy", 12.99f);
        CompactDisc cd = new CompactDisc("Thriller", "Music", 15.50f);

        // Thêm vào danh sách
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // In ra danh sách gốc
        System.out.println("Original media list:");
        for (Media m : mediae) {
            System.out.println(m.getTitle() + " - $" + m.getCost());
        }

        // Sắp xếp theo Title rồi Cost
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        System.out.println("\nSorted by TITLE then COST:");
        for (Media m : mediae) {
            System.out.println(m.getTitle() + " - $" + m.getCost());
        }

        // Sắp xếp theo Cost rồi Title
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\nSorted by COST then TITLE:");
        for (Media m : mediae) {
            System.out.println(m.getTitle() + " - $" + m.getCost());
        }
    }
}
