/**
 * 
 * @author Jeffrey Cannon jmc5fm 
 * Homework 1 
 * Section 100
 * 
 */
public class Song implements Comparable<Song> {

	private String artist; // artist performing the song
	private String title; // title of song
	private int minutes; // number of min in length
	private int seconds; // number of sec in length (always less than 60)

	// Getters/Setters for all fields

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	/**
	 * If the passed in number of seconds is less than 60, it assigns that value
	 * to the seconds field. Otherwise, minutes and seconds are adjusted
	 * accordingly.
	 * 
	 * @param seconds
	 *            Number of seconds in length (Always less than 60)
	 */
	public void setSeconds(int seconds) {
		if (seconds < 60)
			this.seconds = seconds;
		else {
			this.minutes += seconds / 60;
			this.seconds = seconds % 60;
		}
	}

	// --------------------

	/**
	 * Creates a Song that is 0 minutes and 0 seconds long with the specified
	 * artist and title.
	 * 
	 * @param artist
	 *            Artist of the song
	 * @param title
	 *            Title of the song
	 */
	public Song(String artist, String title) {
		this(artist, title, 0, 0);
	}

	/**
	 * Designated constructor for a Song.
	 * 
	 * @param artist
	 *            Artist of the song
	 * @param title
	 *            Title of the song
	 * @param minutes
	 *            Number of minutes in length
	 * @param seconds
	 *            Number of seconds in length (Always less than 60)
	 */
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		setSeconds(seconds);
	}

	/**
	 * Creates a Song with the same attributes as the passed in Song.
	 * 
	 * @param s
	 *            Song to be copied
	 */
	public Song(Song s) {
		this(s.artist, s.title, s.minutes, s.seconds);
	}

	/**
	 * @return True if the passed in object is a Song and has the same exact
	 *         values for all fields, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song s = (Song) o;
			return this.artist.equalsIgnoreCase(s.artist)
					&& this.title.equalsIgnoreCase(s.title)
					&& this.minutes == s.minutes && this.seconds == s.seconds;
		}
		return false;
	}

	/**
	 * @return String representation of a Song specifying the title and artist.
	 */
	@Override
	public String toString() {
		return "{Song: title=" + title + " artist=" + artist + "}";
	}

	/**
	 * Prints to the console that this Song is playing.
	 */
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist,
				title);
	}

	/**
	 * Compares this Song's artist and the passed in Song's artist
	 * lexicographically. If they are the same artist, then it compares the
	 * songs' title fields lexicographically. If the title fields are the same
	 * then it compares the length of the songs.
	 * 
	 * @param s
	 *            Song to be compared
	 * @return The value 0 if the passed in Song has the same artist and title
	 *         fields and are the same length; a value less than 0 if this
	 *         Song's artist or title field is lexicographically less than the
	 *         passed in Song's; a value greater than 0 if this Song's artist or
	 *         title field is lexicographically greater than the passed in
	 *         Song's;
	 */
	@Override
	public int compareTo(Song s) {
		int compare = artist.compareTo(s.getArtist());
		if (compare != 0)
			return compare;
		compare = title.compareTo(s.getTitle());
		if (compare != 0)
			return compare;
		return length() - s.length();
	}

	/**
	 * @return Length of Song in seconds.
	 */
	public int length() {
		return minutes * 60 + seconds;
	}

}
