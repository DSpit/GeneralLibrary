package com.dspit.musicplayer;

public class Player {

	protected static Player sPlayer = null;
	protected static PlayingQueue sQueue;
	protected static AudioThread sAudio;
	
	private Player(){
		sQueue = new PlayingQueue();
		sAudio = new AudioThread();
	}
	
	public static Player getInstance(){
		if(sPlayer == null){
			sPlayer = new Player(); 
		}
		
		return sPlayer;
	}
	
	public Song play(){
		
	}
	
	public Song playNext(){

	}
	
	public static void main(String[] args){
		
	}
}
