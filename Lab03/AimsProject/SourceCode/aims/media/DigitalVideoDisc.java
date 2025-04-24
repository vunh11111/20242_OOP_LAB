package hust.soict.hedspi.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Media implements Playable {
    private float length;
    private String director;

    private int id;
    private String title;
    private String category;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public DigitalVideoDisc(String title) {
        this.setId(++nbDigitalVideoDiscs);
        this.setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.setId(++nbDigitalVideoDiscs);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.setId(++nbDigitalVideoDiscs);
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.setId(++nbDigitalVideoDiscs);
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public void printDetails() {
        System.out.println("ID: " + getId()
                + "\t Title: " + getTitle()
                + "\t Category: " + getCategory()
                + "\t Director: " + getDirector()
                + "\t Length: " + getLength()
                + "\t Cost: " + getCost());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        if (getDirector() == null)
            return "DVD - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $ ";
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - "
                + getLength() + " : " + getCost() + " $ ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        DigitalVideoDisc other = (DigitalVideoDisc) obj;
        return getId() == other.getId()
                && getLength() == other.getLength()
                && Float.compare(getCost(), other.getCost()) == 0
                && Objects.equals(getTitle(), other.getTitle())
                && Objects.equals(getCategory(), other.getCategory())
                && Objects.equals(getDirector(), other.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getCategory(), getCost(), getDirector(), getLength());
    }

    // ✅ Đã implement các getter/setter đúng
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public float getCost() {
        return cost;
    }

    @Override
    public void setCost(float cost) {
        this.cost = cost;
    }
}
