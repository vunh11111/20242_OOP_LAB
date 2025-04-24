package hust.soict.hedspi.aims.media;

public class Disc {
	protected float length;
	protected String director;
	
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

	public Disc() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String toString() {
		return "Disc [length=" + length + ", director=" + director + "]";
	}

}
