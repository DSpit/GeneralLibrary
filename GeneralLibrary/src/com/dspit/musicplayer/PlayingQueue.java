package com.dspit.musicplayer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class PlayingQueue implements Queue<Song>{
	 
	final protected  Node mHead;
	protected Node mTail;
	protected int mSize;
	
	protected PlayingQueue(){
		mHead = mTail = new Node();
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
		
		Song[] array = new Song[mSize];	//output array
		
		//iterates through the queue to put each song in the return array
		int counter = 0;
		Node current = mHead;
		while(current.hasNext()){
			current = current.getNext();
			array[counter] = current.getSong();;
			
			counter++;
		}
		
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		
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

			//if the nodes song matchs the parameters song, the remove the song 
			//from the queue by setting the next next song as the next song of the 
			//current node.
			if(current.getNext().getSong() == t){
				current.setNext(current.getNext().getNext());
				return true;
			}
			
			current = current.getNext();	//swaps the current variable with the next one in line.
		}
		
		//if the loop has exited, all the nodes have been iterated over and a 
		//match hasnt been found, so the queue does not contain it.
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		for( Object t : c){
			if(!this.contains(t)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Song> c){
		for(Song s : c){
			this.offer(s);
		}
		
		return true;
	}

	/**
	 * This remove method will always output <b>true</b> even if none of the
	 * collection elements are in the queue.
	 * 
	 * @param c	The collection of elements to remove
	 * @return <b>true</b>
	 */
	@Override
	public boolean removeAll(Collection<?> c){
		for(Object s : c){
			this.remove(s);
		}
		
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c){
		
		Node current = mHead;
		while(current.hasNext()){
			
			if(!c.contains(current.getNext().getSong())){
				current.setNext(current.getNext().getNext());
			}else{
				c.remove(current.getNext().getSong());
			}
			
			current = current.getNext();
		}
		
		return c.isEmpty();
	}

	@Override
	public void clear() {
		mHead.setNext(null);
		mTail = mHead;
	}

	@Override
	public boolean add(Song e) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offer(Song e) {
		Node node = new Node(e, null);
		mTail.setNext(node);
		mTail = node;
		return true;
	}

	@Override
	public Song remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Song poll() {
		Node t = mHead.getNext();
		mHead.setNext(mHead.getNext().getNext());
		return t.getSong();
	}

	@Override
	public Song element() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Song peek() {
		return mHead.getNext().getSong();
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
