package com.dspit.musicplayer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * A queue which is designed to keep track of the upcoming (but not current) song
 * that the user would like to play.
 * 
 * @author David Boivin (Spit)
 *
 */
public class PlayingQueue implements Queue<Song>{
	 
	final protected  Node mHead;
	protected Node mTail;
	protected int mSize;
	
	/**
	 * Instantiates the queue with a fixed head and a starting size of zero.
	 */
	protected PlayingQueue(){
		mHead = mTail = new Node();
		mSize = 0;
	}

	/**
	 * @return The size of the queue, meaning the number of elements inside.
	 */
	@Override
	public int size() {
		return mSize;
	}

	/**
	 * @return <b>true</b> if the size of the queue is 0 and <b>false</b> 
	 * 				otherwise
	 */
	@Override
	public boolean isEmpty() {
		return mSize == 0;
	}

	/**
	 * Checks whether the Object passed as a parameter is of type {@link Node}
	 * or of type {@link Song} and then sees if it is contained within the queue.
	 * 
	 * @param o The object which looked for in the search.
	 * @return	<b>true></b> if the object is in the list and <b>false</b> 
	 * 				otherwise.
	 */
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
	
	/**
	 * @return An iterator which iterates through the queue without removing
	 * 			its elements nor reveling the private data held within the
	 * 			structure.
	 */
	@Override
	public Iterator<Song> iterator() {
		return new Iterator<Song>(){

			private Node mCurrent = mHead;
			
			@Override
			public boolean hasNext() {
				return mCurrent.hasNext();
			}

			@Override
			public Song next() {
				Node t = mCurrent;
				mCurrent = mCurrent.getNext();
				return t.getSong();
			}
			
		};
	}

	/**
	 * @return The queue in the shape of a newly created array of base type
	 * 			{@link Object}.
	 */
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

	/**
	 * Creates a new array and then turns it into the type of the given parameter
	 * array. This method assumes that the user of this method knows the type
	 * of the content held within the queue.
	 * 
	 * @param a Parameter primarily used to figure out what type to return 
	 * 			the newly created array.
	 * @return The given parameter with a newly assigned array containing all
	 * 			the elements in the queue.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		a = (T[]) this.toArray();
		return a;
	}

	/**
	 * Method which removes the given object if it is of the same type as the 
	 * data within the queue. In this case a {@link Song}
	 * 
	 * @param o The object to remove from the queue.
	 * @return <b>true</b> if the parameter object was removed from the queue and
	 * 			<b>false</b> if not.
	 */
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
				mSize--;
				return true;
			}
			
			current = current.getNext();	//swaps the current variable with the next one in line.
		}
		
		//if the loop has exited, all the nodes have been iterated over and a 
		//match hasnt been found, so the queue does not contain it.
		return false;
	}

	/**
	 * Iterates through the collection and checks if the queue contains each 
	 * element.
	 * 
	 * @param c	The collection of elements to check in the queue.
	 * @return <b>true</b> if all the elements where found in the queue and <b>
	 * 				false</b> otherwise.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		
		for( Object t : c){
			if(!this.contains(t)){
				return false;
			}
		}
		return true;
	}

	/**
	 * This method uses the  {@link #offer(Song)} to add all the elements in 
	 * the parameter collection to the queue.
	 * 
	 * @param c The collection of elements to add into the queue.
	 * @return Always returns <b>true</b>
	 */
	@Override
	public boolean addAll(Collection<? extends Song> c){
		for(Song s : c){
			this.offer(s);
			mSize++;
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

	/**
	 * This method iterates through the queue and checks to see if each element
	 * is contained in the parameter collection. If the collection does contain
	 * the element then the element is removed from the collection. If it does
	 * not, the element is removed from the queue. At the end of the process, if
	 * the collection still contains elements, then the method returns false.
	 * 
	 * @param c The collection of elements to keep in the queue.
	 * @return <b>true</b> if all the elements of the parameter collection have
	 * 				been found in the queue and <b>false</b> otherwise.
	 */
	@Override
	public boolean retainAll(Collection<?> c){
		
		Node current = mHead;
		while(current.hasNext()){
			
			if(!c.contains(current.getNext().getSong())){
				current.setNext(current.getNext().getNext());	//note: didnt use remove method so as not to run a second loop when i have all the info here
				mSize--;
			}else{
				c.remove(current.getNext().getSong());
			}
			
			current = current.getNext();
		}
		
		return c.isEmpty();
	}

	/**
	 * This method simply removes all the elements of the queue.
	 */
	@Override
	public void clear() {
		mHead.setNext(null);
		mTail = mHead;
		mSize = 0;
	}
	
	@Override
	public boolean add(Song e) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * Adds the parameter song to the queue.
	 * 
	 * @param e
	 * @return
	 */
	@Override
	public boolean offer(Song e) {
		Node node = new Node(e, null);
		mTail.setNext(node);
		mTail = node;
		mSize++;
		return true;
	}

	@Override
	public Song remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Song poll() {
		Node t = mHead.getNext();
		try{
			mHead.setNext(mHead.getNext().getNext());
			mSize--;
		}catch(NullPointerException e){
			//do nothing (simply the end of queue)
		}
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
