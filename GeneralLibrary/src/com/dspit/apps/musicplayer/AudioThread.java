package com.dspit.apps.musicplayer;

public abstract class AudioThread extends Thread{
	
	private static AudioThread sThread = null;
	
	private AudioThread(){
		
	}
	
	public static AudioThread getInstance(){
		if(sThread == null){
			sThread = new AudioThread();
		}
		
		return sThread;
	}
	
	abstract public boolean playAudio();
	
	abstract public boolean pauseAudio();
	
	abstract public boolean stopAudio();
	
}
