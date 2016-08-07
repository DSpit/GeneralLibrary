package com.dspit.apps.musicplayer;

import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Player extends Application{
	
	public static final String TITLE = "Absynth Player";
	public static final int WIDTH  = 800;
	public static final int HEIGHT = 800;
	
	private ImageView PLAY_IMAGE;
//	private final ImageView PAUSE_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_pause.png").toString());
//	private final ImageView STOP_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_stop.png").toString());
//	private final ImageView NEXT_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_next.png").toString());
//	private final ImageView PERVIOUS_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_previous.png").toString());
//	private final ImageView SHUFFLE_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_shuffle.png").toString());
//	private final ImageView REPEAT_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_repeat.png").toString());
	
	protected static PlayingQueue sQueue;
	protected static MediaPlayer sAudio;
	protected static File sDirectory;
	protected static ListView<Media> library;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		sQueue = new PlayingQueue();
		
		//set up directory viewer and load all folders and files
		sDirectory = new File("C:\\Users\\David\\Music\\DaftPunk\\01 - Albums (CD Original)\\Random Access Memories\\");
		library = new ListView<Media>();
		ObservableList<Media> directoryList = FXCollections.observableArrayList();
		
/*		if(sDirectory.exists()){		//TODO later cause this seems like a bitch
			File[] file = sDirectory.listFiles();
			for(File f: file){
				if(f.isDirectory()){
					
				}else if(f.isFile()){
					System.out.println(URLDecoder.decode(f.toURI()));
					Media m = new Media(f.toURI().toString());
					directoryList.add(m);
				}else{
					System.out.println("Something wierd happened when loading files.");
				}
			}
		}*/
		
		library.setItems(directoryList);
		
		
		//sets up the music cotrol bar
		HBox musicControls = new HBox();
		musicControls.setAlignment(Pos.CENTER);
		
		PLAY_IMAGE = new ImageView(getClass().getClassLoader().getResource("res/9_av_play.png").toString());		//DEBUG
		
		Button playButton = new Button("", PLAY_IMAGE);
//		Button nextButton = new Button("", NEXT_IMAGE);
//		Button perviousButton = new Button("", PERVIOUS_IMAGE);
//		Button stopButton = new Button("", STOP_IMAGE);
//		Button shuffleButton = new Button("", SHUFFLE_IMAGE);
//		Button repeatButton = new Button("", REPEAT_IMAGE);
		
		playButton.setShape(new Circle(10));
		playButton.setPrefHeight(70);
		playButton.setPrefWidth(70);
		BorderPane.setAlignment(playButton, Pos.CENTER);
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(sAudio.getStatus().equals(MediaPlayer.Status.READY)){
					if(play()){
//						((Button) event.getSource()).setGraphic(PAUSE_IMAGE);
					}
					
				}else if(sAudio.getStatus().equals(MediaPlayer.Status.PLAYING)){
					if(pause()){
						((Button) event.getSource()).setGraphic(PLAY_IMAGE);
					}
						
				}else{
					System.out.println("Not ready to play");
				}
			}
		});
		
		musicControls.getChildren().add(playButton);
		
//		//TESTING
//		File f = new File("C:\\Users\\David\\Music\\Sticky Fingers\\Land of Pleasure\\11 Dreamland.m4a");
//		Media m = new Media(f.toURI().toString());
//		sAudio = new MediaPlayer(m);
		
		//put it all together in the root
		BorderPane root = new BorderPane();
		root.setBottom(musicControls);
		root.setCenter(library);
		
		
		
		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.setTitle(TITLE);
		primaryStage.show();
		
	}
	
	public boolean play(){
		if(sAudio == null){
			return false;																//else theres nothing to play
			
		}else if(MediaPlayer.Status.READY.equals(sAudio.getStatus())){		//makes sure the audio file is ready to be played
			sAudio.play();
			return true;
			
		}else{
			System.out.println("not ready");	//DEBUG
			return false;
		}
	}
	
	public boolean pause(){
		if(sAudio == null){
			return false;				//else theres nothing to pause
		}else if(MediaPlayer.Status.PLAYING.equals(sAudio.getStatus())){
			sAudio.pause();
			return true;
		}
		
		return false;//else nothing to pause
	}
	
	public  void stop(){
		if(sAudio != null){
			sAudio.stop();
		}
	}
	
	public void next(){
		
	}
	
	public void previous(){
		
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
