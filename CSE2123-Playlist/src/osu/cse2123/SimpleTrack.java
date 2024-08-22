package osu.cse2123;

/**
 * An implementation of the PlayListTrack interface
 *
 * @author ERIKA THOMAS
 * @version 10/30/2023
 *
 */
public class SimpleTrack implements Track {
	public String songName;
	public String artistName;
	public String albumName;

	public SimpleTrack() {
		this.songName = new String();
		this.artistName = new String();
		this.albumName = new String();
	}

	@Override
	/*
	 * returns the song name
	 *
	 */
	public String getName() {
		return this.songName;
	}

	@Override
	/*
	 * sets the song name
	 *
	 */
	public void setName(String name) {
		Track nameSet = new SimpleTrack();
		this.songName = name;
	}

	@Override
	/*
	 * returns the artist's name
	 */
	public String getArtist() {
		return this.artistName;
	}

	@Override
	/*
	 * sets the artist name
	 *
	 */
	public void setArtist(String artist) {
		Track artistSet = new SimpleTrack();
		this.artistName = artist;
	}

	@Override
	/*
	 * returns the album name
	 *
	 */
	public String getAlbum() {
		return this.albumName;
	}

	@Override
	/*
	 * sets the album name
	 *
	 */
	public void setAlbum(String album) {
		Track albumSet = new SimpleTrack();
		this.albumName = album;
	}

	@Override
	/*
	 * this sees if any track into matches another track info
	 *
	 */
	public boolean equals(Object obj) {
		boolean areEqual = false;
		if (obj == this) {
			areEqual = true;
		} else if (obj instanceof SimpleTrack) {
			SimpleTrack localOther = (SimpleTrack) obj;
			areEqual = this.artistName.equals(localOther.artistName) && this.songName.equals(localOther.songName)
					&& this.albumName.equals(localOther.albumName);
		}
		return areEqual;
	}

	@Override
	/*
	 * puts artistName, songName, and albumName into a String
	 *
	 */
	public String toString() {
		String str = "(" + artistName + " / " + songName + " / " + albumName + ")";
		return str;
	}

	@Override
	/*
	 * finds the total hashCode of artistName, songName, and albumName
	 *
	 */
	public int hashCode() {
		int code = this.artistName.hashCode() + this.songName.hashCode() + this.albumName.hashCode();
		return code;
	}
}