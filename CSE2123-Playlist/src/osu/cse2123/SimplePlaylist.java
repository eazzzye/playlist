package osu.cse2123;

/**
 * An implementation of the Playlist interface
 *
 * @author ERIKA THOMAS
 * @version 10/31/2023
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class SimplePlaylist implements Playlist {
	public Queue<Track> queue;

	/**
	 * No-argument constructor - creates an empty PlayList
	 * 
	 * @postcond playlist object is empty
	 */
	public SimplePlaylist() {
		this.queue = new LinkedList<>();
	}

	@Override
	public Track getTrack() {
		return this.queue.poll();
	}

	@Override
	public Track peekAtTrack() {
		return this.queue.peek();
	}

	@Override
	public void addTrack(Track track) {
		this.queue.add(track);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (this.queue.isEmpty()) {
			empty = true;
		} else {
			empty = false;
		}
		return empty;
	}
}