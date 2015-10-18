package com.dspit.musicplayer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class PlayingQueue implements Queue<Song>{
	 
	final protected  Node mHead;
	protected int mSize;
	
	protected PlayingQueue(){
		mHead = new Node();
		mSize = 0;
	}

	@Override
	public int size() {
		return mSize;
	}

	@Override
	public boolean isEmpty() {
		return mSize == 0;
	}

	@Override
	public boolean contains(Object o) {
		
		Song t;	//song variable to check against
		
		//if the object is either a Node or a Song, turn it into a Song for easier
		//processing else it cant contain it so false
		if(o instanceof Node){
			t = ((Node) o).getSong();
		}else if(o instanceof Song){
			t = (Song) o;
		}else{
			return false;
		}
		
		//iterate through all of the nodes in the queue and checks to see if
		//the song they contain is the song which was passed as a parameter.
		Node current = mHead;
		while(current.hasNext()){
			current = current.getNext();	//swaps the current variable with the next one in line.
			
			//if the nodes song matchs the parameters song, then the queue contains it.
			if(current.getSong() == t){
				return true;
			}
		}
		
		//if the loop has exited, all the nodes have been iterated over and a 
		//match hasnt been found, so the queue does not contain it.
		return false;
	}

	@Override
	public Iterator<Song> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Song> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Song e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Song e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Song remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This class represents a node in the PlayingQueue. It contains a song, 
	 * which is fixed for the lifetime of the instance and provides a one way
	 * link to the next node in the queue. This implementation provides a 
	 * <i>head</i> instantiation feature which contains a dud song for the
	 * PlayingQueue to be implemented using a fixed starting point.
	 * 
	 * @author David Boivin (Spit)
	 *
	 */
	protected class Node{
		
		protected final Song mSong;
		protected Node mNext = null;
		
		/**
		 * Initializes this Node with a dud Song. This type of initialization
		 * is for creating the head of the queue. This provides a fixed stating 
		 * point for the queue, one which it can reliably know will be there,
		 * even if the queue is considered empty. This facilitates some
		 * operations and generally improves readability of code.
		 */
		public Node(){
			mSong = new Song();
		}
		
		/**
		 * Initializes this Node with a song and no next node. This either 
		 * means that the next node is currently unknown and will be added later
		 * or that this is the last node in the queue.
		 * 
		 * @param song The Song which this node is created to store in the 
		 * 			queue.
		 */
		public Node(Song song){
			mSong = song;
		}
		
		/**
		 * Initializes this Node with a song and a next node. A useful 
		 * feature for adding a song mid queue.
		 * 
		 * @param song The Song which this node is created to store in the 
		 * 			queue.
		 * @param next The next node in the queue
		 */
		public Node(Song song, Node next){
			mSong = song;
			mNext = next;
		}
		
		/**
		 * @return This nodes queue.
		 */
		public Song getSong(){
			return mSong;
		}
		
		/**
		 * @return The next Node in the queue.
		 */
		public Node getNext(){
			return mNext;
		}
		
		/**
		 * @param next The next Node in the queue
		 * @return The node being replaced by the new parameter. This can be
		 * <b>null</b> or an actual Node.
		 */
		public Node setNext(Node next){
			Node t = mNext;
			mNext = next;
			return t;
		}
		
		/**
		 * @return <b>true</b> if the next variable is not <b>null</b> and
		 * will return <b>false</b> otherwise because the queue contains a node
		 * behind this current one.
		 */
		public boolean hasNext(){
			return mNext != null;
		}
	}
}
