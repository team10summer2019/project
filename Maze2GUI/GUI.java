/**
 * @author Steven On and Haine Kim
 *
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.animation.Transition;


public class GUI extends Application{

	//Instance variables
	private int xCoord = 0;
	private int yCoord = 0;
	Image map = new Image("MazeLayout/map.jpg"); // adds the map image. 400 by 400 pixels
	ImageView theMap = new ImageView(map);			//Image variable must be converted to ImageView variable before use
	
	// Launches the GUI, if not written in file, will write by default
	public static void main(String[] args) {
		launch(args);
	}
	
	//Like the main method
	@Override
	public void start(Stage primaryStage) {
		
		//These commented out lines were testing out each individual rooms. It will work without these lines.
		/*
		//ImageView instance can only be added once, make new instance of ImageView 
		Image room0 = new Image("MazeLayout/room0.jpg");
		ImageView roomZero = new ImageView(room0);
		Image room1 = new Image("MazeLayout/room1.jpg");
		ImageView roomOne = new ImageView(room1);
		Image room2 = new Image("MazeLayout/room2.jpg");
		ImageView roomTwo = new ImageView(room2);
		Image room3 = new Image("MazeLayout/room3.jpg");
		ImageView roomThree= new ImageView(room3);
		Image room4 = new Image("MazeLayout/room4.jpg");
		ImageView roomFour = new ImageView(room4);
		Image room5 = new Image("MazeLayout/room5.jpg");
		ImageView roomFive = new ImageView(room5);
		Image room6 = new Image("MazeLayout/room6.jpg");
		ImageView roomSix = new ImageView(room6);
		Image room7 = new Image("MazeLayout/room7.jpg");
		ImageView roomSeven = new ImageView(room7);
		Image room8 = new Image("MazeLayout/room8.jpg");
		ImageView roomEight = new ImageView(room8);
		Image player = new Image("MazeLayout/player.jpg");
		ImageView playerPic = new ImageView(player);
		
		GridPane mazeGrid = new GridPane();
		mazeGrid.addRow(0, roomZero, roomThree, roomSeven, roomEight);
		mazeGrid.addRow(1, roomOne, roomSix, roomSeven, roomFive);
		mazeGrid.addRow(2, roomTwo, roomFive, roomZero, roomOne);
		mazeGrid.addRow(3, roomThree, roomFour, roomTwo, roomFour);
		mazeGrid.add(playerPic, yCoord, xCoord);    
		
		
		Image room0 = new Image("MazeLayout/room0.jpg");
		Image room1 = new Image("MazeLayout/room1.jpg");
		Image room2 = new Image("MazeLayout/room2.jpg");
		Image room3 = new Image("MazeLayout/room3.jpg");
		Image room4 = new Image("MazeLayout/room4.jpg");
		Image room5 = new Image("MazeLayout/room5.jpg");
		Image room6 = new Image("MazeLayout/room6.jpg");
		Image room7 = new Image("MazeLayout/room7.jpg");
		Image room8 = new Image("MazeLayout/room8.jpg");
		Image player = new Image("MazeLayout/player.jpg");
		*/
		
		theMap.setViewport(new Rectangle2D(0,0,100,100));		//Sets the window view to starting room at (0,0) 100 by 100 pixels
		
		GridPane mazeGrid = new GridPane();
		/*
		mazeGrid.addRow(0, new ImageView (room0), new ImageView (room3), new ImageView (room7), new ImageView (room8));
		mazeGrid.addRow(1, new ImageView (room1), new ImageView (room6), new ImageView (room7), new ImageView (room5));
		mazeGrid.addRow(2, new ImageView (room2), new ImageView (room5), new ImageView (room0), new ImageView (room1));
		mazeGrid.addRow(3, new ImageView (room3), new ImageView (room4), new ImageView (room2), new ImageView (room4));
		*/
		
		mazeGrid.addRow(0, theMap);
		
		/*
		for (int i = 0; i < 4; i++) {			//add player to every room
			for (int j = 0; j < 4; j++) {
				mazeGrid.add(new ImageView (player), i, j);
			}
		}
		*/
		
		//mazeGrid.add(new ImageView (player), yCoord, xCoord);
		/*
		BorderPane theCenter = new BorderPane(); 
		theCenter.setCenter(mazeGrid);
		*/
		Scene scene = new Scene(mazeGrid, 400, 600);
		
		scene.setOnKeyTyped(new HandleKeyboardEvents());
		
		primaryStage.setTitle("Maze Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//Keyboard events that works properly with the map, however you can go through walls
	public class HandleKeyboardEvents implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent keyInput) {
			if (keyInput.getCharacter().charAt(0) == 'q') {
				System.exit(0);
			}
			if (keyInput.getCharacter().charAt(0) == 'w') {
				theMap.setViewport(new Rectangle2D(xCoord,yCoord-=100,100,100));
			}
			if (keyInput.getCharacter().charAt(0) == 'a') {
				theMap.setViewport(new Rectangle2D(xCoord-=100,yCoord,100,100));
			}
			if (keyInput.getCharacter().charAt(0) == 's') {
				theMap.setViewport(new Rectangle2D(xCoord,yCoord+=100,100,100));
			}
			if (keyInput.getCharacter().charAt(0) == 'd') {
				theMap.setViewport(new Rectangle2D(xCoord+=100,yCoord,100,100));
			}
			if (keyInput.getCharacter().charAt(0) == 'm') {
				theMap.setViewport(new Rectangle2D(0,0,0,0));
			}
		}
	}
}
