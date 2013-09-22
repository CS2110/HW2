import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author Jeffrey Cannon jmc5fm 
 * Homework 1 
 * Section 100
 * 
 * Sources:
 * 	http://docs.oracle.com/javase/tutorial/java/data/numberformat.html -
 * 	For formatting time String
 */
public class PlayList {

	private String name; // contains the name of the playlist
	private ArrayList<Song> songList; // ArrayList of songs that make up the
										// playlist

	// Getters/Setters for all fields

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	// --------------------

	/**
	 * @return String representation of a PlayList specifying the name and song
	 *         list.
	 */
	@Override
	public String toString() {
		return "{PlayList name=" + name + " songList=" + songList + "}";
	}

	/**
	 * Creates a PlayList named "Untitled"
	 */
	public PlayList() {
		this("Untitled");
	}

	/**
	 * Designated constructor for PlayList.
	 * 
	 * @param newName
	 *            Name of the playlist
	 */
	public PlayList(String newName) {
		name = newName;
		songList = new ArrayList<Song>();
	}

	/**
	 * Loads songs from a file.
	 * 
	 * @param fileName
	 *            Name of the file
	 * @return True if the file was successfully read and songs were added to
	 *         the list, false otherwise.
	 */
	public boolean loadSongs(String fileName) {
		// Create a File object and try to create a Scanner to read from it
		File file = new File(fileName);
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("File couldn't be found!");
			return false;
		}

		// Declare placeholder variables
		Song s;
		String title;
		String artist;
		String[] time;
		int minutes;
		int seconds;

		// Iterate through the file
		while (reader.hasNextLine()) {
			title = reader.nextLine().trim();
			artist = reader.nextLine().trim();
			time = reader.nextLine().trim().split(":");
			minutes = Integer.parseInt(time[0]);
			seconds = Integer.parseInt(time[1]);
			s = new Song(artist, title, minutes, seconds);
			addSong(s);
			reader.nextLine();
		}
		reader.close();
		return true;
	}

	/**
	 * Removes all songs.
	 * 
	 * @return True if the songList was changed, false otherwise.
	 */
	public boolean clear() {
		return songList.removeAll(songList);
	}

	/**
	 * Adds a Song to the end of the PlayList.
	 * 
	 * @param s
	 *            Song to be added
	 * @return True if the Song was successfully added, false otherwise.
	 */
	public boolean addSong(Song s) {
		return songList.add(s);
	}

	/**
	 * Removes Song at index from the list and returns it.
	 * 
	 * @param index
	 *            Index of the Song to be removed
	 * @return The Song that was removed, null if the specified index was out of
	 *         bounds.
	 */
	public Song removeSong(int index) {
		Song s;
		try {
			s = songList.get(index);
			songList.remove(index);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
		return s;
	}

	/**
	 * Removes the specified Song from the list and returns it.
	 * 
	 * @param s
	 *            The Song to be removed
	 * @return The Song that was removed, null if the specified Song was not
	 *         found.
	 */
	public Song removeSong(Song s) {
		Song ret = null;
		while (songList.contains(s)) {
			ret = s;
			songList.remove(s);
		}
		return ret;
	}

	/**
	 * Returns the Song at the appropriate index.
	 * 
	 * @param index
	 *            Index of the Song to be returned
	 * @return The Song at the specified, null if the specified index is out of
	 *         bounds.
	 */
	public Song getSong(int index) {
		Song s;
		try {
			s = songList.get(index);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
		return s;
	}

	/**
	 * Sorts the class's song list by artist first, then by title if the artists
	 * are equal, then shortest first if both artist and title fields are equal.
	 */
	public void sortByArtist() {
		Collections.sort(songList);
	}

	/**
	 * Plays the PlayList by calling play() on each Song in the PlayList in
	 * order.
	 */
	public void play() {
		for (Song s : songList) {
			s.play();
		}
	}

	/**
	 * @return Number of songs in the PlayList.
	 */
	public int size() {
		return songList.size();
	}

	/**
	 * Returns the total time the PlayList will take in the format HH:MM:SS if
	 * there are hours, or MM:SS if there are no hours.
	 * 
	 * @return String format of time.
	 */
	public String totalPlayTime() {
		int seconds = 0;
		int minutes = 0;
		int hours = 0;
		for (Song s : songList) {
			seconds += s.getSeconds();
			minutes += s.getMinutes();
		}
		minutes += seconds / 60;
		seconds %= 60;
		hours += minutes / 60;
		minutes %= 60;
		if (hours == 0)
			return String.format("%02d:%02d", minutes, seconds);
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	/**
	 * Returns the total time the PlayList will take as the number of seconds.
	 * 
	 * @return Total time of PlayList in seconds.
	 */
	public int getPlayTimeSeconds() {
		int seconds = 0;
		for (Song s : songList) {
			seconds += s.length();
		}
		return seconds;
	}

	/**
	 * For testing purposes
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PlayList p = new PlayList();
		System.out.println(p.loadSongs("test.txt"));
		System.out.println(p);
		System.out.println(p.totalPlayTime());
		System.out.println(p.getPlayTimeSeconds());
	}

}
