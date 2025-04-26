package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable{
    private String artist;
    private List<Track> tracks;

    // Constructor mặc định
    public CompactDisc() {
        super(); // Gọi constructor mặc định của Disc
        this.tracks = new ArrayList<>();
    }

    // Constructor có thêm artist
    public CompactDisc(String artist) {
        this(); // Gọi constructor mặc định trước
        this.artist = artist;
    }

    public CompactDisc(String string, String string2, float f) {
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String cdTitle, String cdCategory, float cdCost, String artist2) {
		// TODO Auto-generated constructor stub
	}

	// Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Thêm một track nếu chưa có trong danh sách
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Xóa một track nếu có trong danh sách
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Tính tổng độ dài các track trong CD
    public float getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

	@Override
	public void play() {
	    System.out.println("Artist: " + getArtist());
	    System.out.println("Total tracks: " + tracks.size());
	    for (Track track : tracks) {
	        track.play();
	    }
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCategory(String category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCost(float cost) {
		// TODO Auto-generated method stub
		
	}


}
