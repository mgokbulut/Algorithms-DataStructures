package Tutorial_3;
import java.util.*;

public class assignment5 {
	public static void main(String[] args) {
		System.out.println("s");
		String[] b = {"a","b","c","d","e","f"};
		PlayList a = new PlayList(b);
		a.playSong();
		a.nextSong();
	    System.out.println( a.previousSong());
	}
}

class PlayList {
	
	LibraryStack frontStack;
	LibraryStack backStack;
	String currentlyPlaying;
	
	/**
	   * Constructor of the playlist, creates a playlist with the given songs.
	   * @param songs - the songs that will be part of this playlist
	   */
	  public PlayList(String[] songs) {
		  
		  this.frontStack = new LibraryStack();
		  this.backStack = new LibraryStack();
		  
		  for (String string : songs) {
			this.backStack.push(string);
		  }
		  for (int i = 0; i < songs.length ; i++) {
			this.frontStack.push(this.backStack.pop());
		  }
	  }

	  /**
	   * Starts playing the first song in the playlist, if no songs was playing yet.
	   * @return the first song that will be played if no song was playing, otherwise null
	   */
	  public String playSong() {
		  if(this.currentlyPlaying == null) {
			  this.currentlyPlaying = this.frontStack.pop();
			  return this.currentlyPlaying;
		  }
		  return null;
	  }

	  /**
	   * Switches to the next song in the playlist.
	   * @return the next song in the playlist
	   */
	  public String nextSong() {
		  this.backStack.push(this.currentlyPlaying);
		  this.currentlyPlaying = this.frontStack.pop();
		  return this.currentlyPlaying;
	  }

	  /**
	   * Switches back to the previous song in the playlist.
	   * @return the previous song in the playlist
	   */
	  public String previousSong() {
		  this.frontStack.push(this.currentlyPlaying);
		  this.currentlyPlaying = this.backStack.pop();
		  return this.currentlyPlaying;
	  }
	  
	  /*
	String currentlyPlaying;
	LibraryQueue playlist_queue;
	LibraryStack playlist_stack;
	  
	  public PlayList(String[] songs) {
		  this.playlist_queue = new LibraryQueue();
		  this.playlist_stack = new LibraryStack();
		  for (String string : songs) {
			this.playlist_queue.enqueueBack(string);
		  }
	  }

	  public String playSong() {
		  if(this.currentlyPlaying == null) {
			  this.currentlyPlaying = this.playlist_queue.dequeue();
			  this.playlist_queue.enqueueFront(this.currentlyPlaying);
			  return this.currentlyPlaying;
		  }
		  return null;
	  }

	  
	  public String nextSong() {
		  this.playlist_stack.push(this.currentlyPlaying);
		  this.currentlyPlaying = this.playlist_queue.dequeue();
		  return this.currentlyPlaying;
	  }

	  
	  public String previousSong() {
		  this.currentlyPlaying = this.playlist_stack.pop();
		  this.playlist_queue.enqueueFront(this.currentlyPlaying);
		  return this.currentlyPlaying;
	  }
	  
	  */
	}



class LibraryStack {

  List<String> items;

  public LibraryStack() {
    items = new ArrayList<>();
  }

  public boolean isEmpty() {
    return this.items.isEmpty();
  }

  public void push(String s) {
    this.items.add(s);
  }

  public String pop() {
    return this.items.remove(this.items.size() - 1);
  }

  public String top() {
    return this.items.get(this.items.size() - 1);
  }
}

class LibraryQueue {

  List<String> items;

  public LibraryQueue() {
    items = new ArrayList<>();
  }

  public boolean isEmpty() {
    return this.items.isEmpty();
  }

  public void enqueueFront(String s) {
    this.items.add(0, s);
  }

  public void enqueueBack(String s) {
    this.items.add(s);
  }

  public String dequeue() {
    return this.items.remove(0);
  }

  public String first() {
    return this.items.get(0);
  }
}
