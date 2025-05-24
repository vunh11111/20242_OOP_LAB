package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costCompare = Float.compare(m1.getCost(), m2.getCost());
        if (costCompare != 0) return costCompare;
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}
