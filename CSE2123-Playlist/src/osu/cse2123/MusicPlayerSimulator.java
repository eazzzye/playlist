package osu.cse2123;

/**
 * A simulator of an MP3 player using the Playlist and Track interfaces.
 *
 * @author ERIKA THOMAS
 * @version 11/1/2023
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MusicPlayerSimulator {
	/*
	 * Reads the info in the file user inputed and puts it in a List
	 *
	 * ALGORITHIM: create a new queue, file, and scanner while scanner reads the
	 * file and until the file is empty create a new str to insert the file in and a
	 * new track and get the song, artist, and album name from the str. after that
	 * make tracks into a string and add it into the queue close scanner and return
	 * queue
	 *
	 * @param fileName file name to insert
	 */
	public static Playlist loadTracksFromFile(String fileName) throws FileNotFoundException {
		Playlist playlistInfo = new SimplePlaylist();
		File textFile = new File(fileName);
		Scanner textScanner = new Scanner(textFile);
		while (textScanner.hasNext()) {
			String str = textScanner.nextLine();
			Track tracks = new SimpleTrack();
			String[] strSplit = str.split(",");
			tracks.setName(strSplit[0]);
			tracks.setArtist(strSplit[1]);
			tracks.setAlbum(strSplit[2]);
			playlistInfo.addTrack(tracks);
		}
		textScanner.close();
		// System.out.println(playlistInfo.peekAtTrack());
		return playlistInfo;
	}

	/*
	 * Displays the current track and the next track
	 *
	 * ALGORITHIM: print the current track and remove it and play the next track
	 *
	 * @param queue queue to get the playlist from
	 */
	public static void displayTracks(Playlist queue) {
		if (!queue.isEmpty()) {
			System.out.println("Currently playing: " + queue.getTrack());
			System.out.println("Next: " + queue.peekAtTrack());
		}
	}

	/*
	 * Asks user to either choose play track, add track, or quit program
	 *
	 * ALGORITHM: create a new scanner print out the options if user wants to play
	 * next track, add next track, or quit program create a char varaiable to put
	 * the user input in print out their input if input equals p then use
	 * displayTracks method if input equals a then use addTrack method else print
	 * out user input
	 *
	 * @param queue queue to get the playlist from
	 *
	 */
	public static void userPlaylist(Playlist queue) {
		Scanner scan = new Scanner(System.in);
		System.out.println("[P]lay next track");
		System.out.println("[A]dd a new track");
		System.out.println("[Q]uit");
		String input = scan.next();
		System.out.println(input);
	}

	/*
	 * This adds track info when user wants to add another track
	 *
	 * ALGORITHIM: create a new scanner create a new SimpleTrack object asks for
	 * track name, artist name, and album name set the track name, artist name, and
	 * album name get the track name, artist name, and album name turn the track
	 * into a string and add track into the queue use the method add more tracks to
	 * ask the user if they want to add more tracks use displayTracks method to
	 * display the current and next track
	 *
	 *
	 * @param queue queue to get the playlist from
	 *
	 */
	public static void addTrack(Playlist queue) {
		Scanner scanny = new Scanner(System.in);
		SimpleTrack track = new SimpleTrack();
		System.out.print("Track name: ");
		String song = scanny.nextLine();
		track.setName(song);
		System.out.print("Artist name: ");
		String artist = scanny.nextLine();
		track.setArtist(artist);
		System.out.print("Album name: ");
		String album = scanny.nextLine();
		track.setAlbum(album);
		System.out.println("Track: " + track.getName());
		System.out.println("Artist: " + track.getArtist());
		System.out.println("Album: " + track.getAlbum());
		track.toString();
		addMoreTracks(queue, track);
		System.out.println();
		displayTracks(queue);
	}

	/**
	 * Asks the user if they want to add the track they inputed
	 *
	 * ALGORITHIM: create a new scanner asks the user if they want to add the new
	 * track they added into the playlist create a char to get the user input if
	 * input equals n then use the addTrack method else add track to the playlist
	 *
	 * @param queue queue to get the playlist from
	 * @param track track to get track from
	 */
	public static void addMoreTracks(Playlist queue, SimpleTrack track) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Are you sure you want to add this track [y/n]? ");
		String input = scan.next();
		if (input.equals("n")) {
			addTrack(queue);
		} else {
			queue.addTrack(track);
		}
	}

	/*
	 * Tells user what tracks are remaining when they quit the program
	 *
	 * ALGORTIHIM: output "tracks reamining in playlist" create an int and initilize
	 * it to 1 if queue is not empty then prints out the remaining songs in the
	 * playlist
	 *
	 * @param queue queue to get the playlist from
	 *
	 */
	public static void tracksRemaining(Playlist queue) {
		System.out.println("Tracks remaining in play list");
		System.out.println("------------------------------------------------------------");
		int i = 1;
		while (!queue.isEmpty()) {
			System.out.println(i + " - '" + queue.getTrack() + "'");
			i++;
		}
	}

	/*
	 * Outputs the whole program
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter database filename: ");
		String fname = scan.nextLine();
		System.out.println();
		Playlist queue = loadTracksFromFile(fname);
		System.out.println("[P]lay next track");
		System.out.println("[A]dd a new track");
		System.out.println("[Q]uit");
		String input = scan.next();
		System.out.println(input);
		while (!input.equals("q")) {
			if (input.equals("p")) {
				displayTracks(queue);
			} else if (input.equals("a")) {
				addTrack(queue);
			}
			System.out.println("[P]lay next track");
			System.out.println("[A]dd a new track");
			System.out.println("[Q]uit");
			input = scan.next();
			System.out.println(input);
		}
		tracksRemaining(queue);
		System.out.println();
	}
}