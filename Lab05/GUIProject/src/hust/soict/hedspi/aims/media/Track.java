package hust.soict.hedspi.aims.media;

import java.util.Objects;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	public Track() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Track [title=" + title + ", length=" + length + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
	    } else {
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}
	@Override
	public int hashCode() {
		return Objects.hash(length, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		return length == other.length && Objects.equals(title, other.title);
	} 
	
}
