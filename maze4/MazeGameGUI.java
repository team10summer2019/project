import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.input.*;

public class MazeGameGUI extends Application {

//////////////////////////INSTANCE VARIABLES ///////////////////////////////////

	int level = 1 ;   // set the level to increase through 4 levels
	int mazeSize=4;	 // Initialize with 4x4 maze for level 1 
	int currentLevel=level;
	Player tempHero;  // temporary value to look at Hero stats
	Room tempRoom;    // temporary value to look at a room 
	Monster tempMonster; // temporary value to look at Monster stats
	String storeInput="";  // storage for user input
	int moveCounter = 0;  // count the number of moves
    boolean victory=false;
	Random randGen = new Random(100);  // random number generator
	Button tempButton;  // temporary button pointer
    Maze gameBoard = new Maze(mazeSize);  // make a 4x4 room maze 
    
    /// get the number of columns and rows in a roomGrid in a Room object in gameBoard
    int cols = gameBoard.getCurrentRoom().getRoomCols();
    int rows = gameBoard.getCurrentRoom().getRoomRows();
    
    // make a button grid with the same number of columns and rows as a roomGrid
	private Button[][] buttonGrid = new Button[cols][rows];  
	// make a messageLabel with a message for user interaction / Prompts
	private Label messageLabel = new Label("Welcome to the Maze");
	
	TextField textIn = new TextField(); // javafx.scene.control.TextField
	
///////////////////////////// START METHOD //////////////////////////////////////////////////	
	
	@Override
	public void start(Stage primaryStage) { // this is like the main method 
		
		// use the GridPane layout (instead of vBox, hBox or Group)
		  GridPane grid = new GridPane();
		
		// build grid of buttons for the board (visual component)
		//// initialize the button grid representing a virtual room 
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++){
				Button b = new Button(" ");  // make a new button with blank space as text
				buttonGrid[i][j] = b;       // add the new button to the buttonGrid
				grid.add(buttonGrid[i][j], i, j);				
			}
		}
		
		// make a VBox object 
		VBox verticalBox = new VBox();  // Vbox layout manager , stacks downward
		
		// send the text field to the storeInput string
		Button sendButton = new Button("Enter");
		// attempt a cold boot setup of the room 
		Button startButton = new Button("Start");
		
		// Add the items to the vertical box 
		verticalBox.getChildren().add(textIn);
		verticalBox.getChildren().add(sendButton);
		verticalBox.getChildren().add(startButton);
		
		// set the sendButton to pass the text field above it to storeInput string
		sendButton.setOnAction( new HandleInputSendClick() ); 
		// set the startButton to perform a setup operation
		startButton.setOnAction( new HandleInputStartClick() ); 
		
	
///////////////////////////// SCENE and STAGE SHOW ////////////////////////////////////////////
		// build entire scene: grid and label
		
		BorderPane root = new BorderPane();
		//root.setCenter(grid);
		root.setCenter(grid);
		root.setRight(verticalBox);
		root.setBottom(messageLabel);  // place to put the messages to user output
		
		Scene scene = new Scene(root, 400, 300);
		
		// key press action events
		root.setOnKeyTyped( new HandleKeyBoardInput() );
			
		// setup and show the stage and scene 
		primaryStage.setTitle("Maze Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
////////////////////////// END OF START METHOD ////////////////////////////////////////
	
//////////////////////////  EMBEDED HANDLER CLASSES ///////////////////////////////////////

////////////KEY BOARD INPUT CONTROLS	
public class HandleKeyBoardInput implements EventHandler<KeyEvent> {
	public void handle(KeyEvent event){
		if (event.getCharacter().charAt(0) == 'q') {
			storeInput="quit";
			messageLabel.setText(storeInput);
		} else if (event.getCharacter().charAt(0) == 'a') {
			storeInput="left";
			messageLabel.setText("Move Left");
		} else if (event.getCharacter().charAt(0) == 's') {
			storeInput="down";
			messageLabel.setText("Move Down");
		} else if (event.getCharacter().charAt(0) == 'd') {
			storeInput="right";
			messageLabel.setText("Move Right");
		} else if (event.getCharacter().charAt(0) == 'w') {
			storeInput="up";
			messageLabel.setText("Move Up");
		} else if (event.getCharacter().charAt(0) == 'r') {
			storeInput="Return";
			messageLabel.setText("Return");
		} else if (event.getCharacter().charAt(0) == 't') {
			storeInput="take";
			messageLabel.setText("Take");
		} else if (event.getCharacter().charAt(0) == 'o') {
			storeInput="open";
			messageLabel.setText("Open");
		} else if (event.getCharacter().charAt(0) == 'e') {
			storeInput="escape";
			messageLabel.setText("Escape");
		} else if (event.getCharacter().charAt(0) == 'h') {
			storeInput="help";
			messageLabel.setText(storeInput);
		} else if (event.getCharacter().charAt(0) == 'f') {
			storeInput="fight";
			messageLabel.setText(storeInput);
		} else if (event.getCharacter().charAt(0) == 'm') {
			storeInput="map";
			messageLabel.setText(storeInput);
		} else if (event.getCharacter().charAt(0) == 'l') {
			messageLabel.setText(storeInput);
	}
	
		// display the textMode output 
		textModeOutput();
		monsterWalk(randGen,gameBoard);// move the monster
		
	}
}


// input text box with send button handler 
public class HandleInputSendClick implements EventHandler<ActionEvent> {	
	public void handle(ActionEvent event){
			// grab the input text from the text box
			storeInput=textIn.getText();
			// output to the message label
			messageLabel.setText("Command: " + storeInput);
			
			// show the textMode display in the console 
			textModeOutput();	
			monsterWalk(randGen,gameBoard);// move the monster
		}
	}

//input text box with send button handler 
public class HandleInputStartClick implements EventHandler<ActionEvent> {	
	public void handle(ActionEvent event){
		
		// Perform these operations on click
		/// attempt to print out a room but fails 
		setLevel(1);   // set the level to 1 
		resetMazeSize(level);  // reset the Maze Size 
		setBoard(gameBoard);   // construct the maze for level 1 
		gameBoard.setCurrentRoom(0,0); // reset the current room after setting up the board
		tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
		tempHero = gameBoard.getHero();
		postCurrentRoom();   // display the current room 
        // show the text mode output
		textModeOutput();
		printHelp();
		}
	}

///////////////////////////     OTHER METHODS      ////////////////////////////////////////


public void textModeOutput() {
	// pass to input control
	inputControl();
	postCurrentRoom();
	// update the hero current condition and display Hero stats
	tempHero = gameBoard.getHero();
	tempHero.displayStats();
	//draw the current room and display the room stats 
	tempRoom.drawRoomGrid();
    tempRoom.displayRoomStats();
	// update the monster's current condition and display Monster stats
	tempMonster = gameBoard.getMonster();
	tempMonster.displayStats();
	
}

	public int getLevel(){
	return level;
	}
	
	public void setLevel(int input) {
		if (input >=1 && input < 5){
			level = input;
		}
	}		
	
    public void resetMazeSize(int level){
    	if (level == 1 ){
    		mazeSize=4;
    	}else if (level ==2){
    		mazeSize=6;
    	}else if (level==3){
    		mazeSize=8;
    	}
    }

    public void postCurrentRoom() {
    	// get the current room
    	tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
    	wipeGrid();  // clear previous text
    	// copy it into the button grid for display
    	for (int i = 0; i < cols; i++) {
    		for (int j = 0; j < rows; j++){
    			tempButton = buttonGrid[i][j]; // point to the button in the button grid			
    			tempButton.setText(""+tempRoom.getRoomGrid()[i][j]);
    		}
    	}
    }
    
    public void wipeGrid() {   	
    	// copy it into the button grid for display
    	for (int i = 0; i < cols; i++) {
    		for (int j = 0; j < rows; j++){
    			tempButton = buttonGrid[i][j]; // point to the button in the button grid			
    			tempButton.setText(" ");
    		}
    	}
    }
    
    
    
 // sets up the walls and items, doors and monsters
 	public void setBoard( Maze m){
 	
 		if (level ==1){
 		//////////////////// MAZE IS HAND DESIGNED //////////////////////////////
 		// setRoom(x,y,left,right,up,down,key,door,map,monster)
 		// setRoomWalls(int x,int y, boolean left, boolean right, boolean up, boolean down){
 		//setRoomItems(int x, int y ,boolean key, boolean door ,boolean map, boolean monster, boolean riddle ){ 
 		//ROW 0
 		m.setRoomWalls(0,0,true,true,true,false); // setup the first room 
 		m.setRoomPlayer(0,0,true);  // place the player in the first room
 		// room (1.0)   
 		m.setRoomWalls(1,0,true,false,true,true);
 		m.setRoomItems(1,0,false,true,false,false,false); // has door
 		// room (2,0)
 		m.setRoomWalls(2,0,false,false,true,true);
 		// room (0,3)
 		m.setRoomWalls(3,0,false,true,true,false);
 		// room (1,0)
 		m.setRoomWalls(0,1,true,true,false,false);
 		// room (1,1)
 		m.setRoomWalls(1,1,true,false,true,false); 
 		// room (2,1)
 		m.setRoomWalls(2,1,false,false,true,true);
 		// room (3,1)
 		m.setRoomWalls(3,1,false,true,false,false);
 		// room (0,2)
 		m.setRoomWalls(0,2,true,false,false,true);
 		// room (1,2)
 		m.setRoomWalls(1,2,false,true,false,false);
 		// room (2,2)
 		m.setRoomWalls(2,2,true,true,true,false);
 		m.setRoomItems(2,2,true,false,false,false,false); // has key
 		// room (3,2)
 		m.setRoomWalls(3,2,true,true,false, false);
 		// room (0,3)
 		m.setRoomWalls(0,3,true,false,true,true);
 		m.setRoomItems(0,3,false,false,true,false,false); // has map
 		// room (1,3)
 		m.setRoomWalls(1,3,false,true,false,true);
 		// room (3,2)
 		m.setRoomWalls(2,3,true,false,false,true);
 		m.setRoomItems(2,3,false,false,false,false,true); //place the riddle in the room below the key
 		// room (3,3)
 		m.setRoomWalls(3,3,false,true,false,true);
 		
 		
 		// get a random location within the map 
 		Point randLocation = new Point();
 		randLocation.setRandom(m.getMazeSize());
 		Room tempRoom = m.getRoom(randLocation);  // get a copy of the room at randLocation
 		// set the monster to be at the location 
 		m.setMonsterLocation(randLocation);  
 		// randomize monster start location but don't overwrite previous conditions except moster variable 
 		m.setRoomItems(randLocation,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasRiddle());  // Working
 		
 		}
 	
 	
 		if (level ==2){
 		
 		/////////////////// MAZE IS HAND DESIGNED ////////////////////////////
 		// setRoomWalls(int x,int y, boolean left, boolean right, boolean up, boolean down){
 		//ROW 0
 		m.setRoomWalls(0,0,true,true,true,false); // setup the first room 
 		m.setRoomPlayer(0,0,true);  // place the player in the first room
 		m.setRoomWalls(1,0,true,false,true,false);
 		m.setRoomWalls(2,0,false,true,true,true);
 		m.setRoomWalls(3,0,true,false,true,false);
 		m.setRoomWalls(4,0,false,false,true,true);
 		m.setRoomWalls(5,0,false,true,true,true);
 		// ROW 1
 		m.setRoomWalls(0,1,true,true,false,false);
 		m.setRoomWalls(1,1,true,false,false,true);
 		m.setRoomWalls(2,1,false,false,true,true);
 		m.setRoomWalls(3,1,false,false,false,true);
 		m.setRoomWalls(4,1,false,false,true,true);
 		m.setRoomWalls(5,1,false,true,true,false);
 		// ROW 2
 		m.setRoomWalls(0,2,true,false,false,true);
 		m.setRoomWalls(1,2,false,false,true,true);
 		m.setRoomWalls(2,2,false,true,true,false);
 		m.setRoomWalls(3,2,true,false,true, false);
 		m.setRoomWalls(4,2,false,true,true, false);
 		m.setRoomWalls(5,2,true,true,false, false);
 		// ROW 3
 		m.setRoomWalls(0,3,true,false,true,false);
 		m.setRoomWalls(1,3,false,true,true,false);
 		m.setRoomWalls(2,3,true,true,false,false);
 		m.setRoomWalls(3,3,true,true,false,false);	
 		m.setRoomWalls(4,3,true,true,false,false);
 		m.setRoomWalls(5,3,true,true,false,false);	
 		// ROW 4
 		m.setRoomWalls(0,4,true,true,false,false);
 		m.setRoomWalls(1,4,true,true,false,false);
 		m.setRoomWalls(2,4,true,true,false,false);
 		m.setRoomWalls(3,4,true,true,false,true);	
 		m.setRoomWalls(4,4,true,false,false,false);
 		m.setRoomWalls(5,4,false,true,false,false);	
 		// ROW 5
 		m.setRoomWalls(0,5,true,true,false,true);
 		m.setRoomWalls(1,5,true,false,false,true);
 		m.setRoomWalls(2,5,false,false,false,true);
 		m.setRoomWalls(3,5,false,false,true,true);	
 		m.setRoomWalls(4,5,false,true,false,true);
 		m.setRoomWalls(5,5,true,true,false,true);
 		
 		
 		// set the items now  
 		//setRoomItems(Point p , boolean key, boolean door ,boolean map, boolean monster, boolean riddle ){
 		
 		// semi random Map Placement 
 		Random randGen = new Random(100); // make a random number generator 
 		int rand; // integer to hold random number
 		rand = randGen.nextInt(); // get a random number  
 		if (rand % 3 ==0){
 		m.setRoomItems(3,4,false,false,true,false,false); // Place the map in (3,5)
 		} else if (rand% 3 ==1){
 		m.setRoomItems(2,0,false,false,true,false,false); // Place the map in (2,0)
 		} else { 
 		m.setRoomItems(5,5,false,false,true,false,false); // Place the map in (2,0)
 		}
 		
 		// place door in specific location
 		m.setRoomItems(0,5,false,true,false,false,false);
 		m.setDoorLocation(0,5);  // change the door location 
 		// place the key in specific location
 		m.setRoomItems(5,0,true,false,false,false,false);
 		// place the riddle in a specific location infront of the key (opens wall to get key)
 		m.setRoomItems(4,0,false,false,false,false,true);
 		
 		
 		// get a random location within the map 
 		Point randLocation = new Point();
 		randLocation.setRandom(m.getMazeSize());
 		Room tempRoom = new Room();
 		tempRoom = m.getRoom(randLocation);  // get a copy of the room at randLocation
 		// set the monster to be at the location 
 		m.setMonsterLocation(randLocation);  
 		// randomize monster start location but don't overwrite previous conditions except moster variable 
 		m.setRoomItems(randLocation,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasRiddle());  // Working
 		
 		}
 	
 		if (level ==3){
 		
 		//////////////// MAZE IS HAND DESIGNED /////////////////////////////////////////////
 		// setRoomWalls(int x,int y, boolean left, boolean right, boolean up, boolean down){
 		//ROW 0
 		m.setRoomWalls(0,0,true,false,true,true); // setup the first room 
 		m.setRoomPlayer(0,0,true);  // place the player in the first room
 		m.setRoomWalls(1,0,false,false,true,false);
 		m.setRoomWalls(2,0,false,false,true,true);
 		m.setRoomWalls(3,0,false,true,true,true);
 		m.setRoomWalls(4,0,true,false,true,false);
 		m.setRoomWalls(5,0,false,true,true,true);
 		m.setRoomWalls(6,0,true,false,true,false);
 		m.setRoomWalls(7,0,false,true,true,true);
 		// ROW 1
 		m.setRoomWalls(0,1,true,true,true,false);
 		m.setRoomWalls(1,1,true,false,false,true);
 		m.setRoomWalls(2,1,false,false,true,true);
 		m.setRoomWalls(3,1,false,false,true,true);
 		m.setRoomWalls(4,1,false,false,false,true);
 		m.setRoomWalls(5,1,false,true,true,false);
 		m.setRoomWalls(6,1,true,false,false,true);
 		m.setRoomWalls(7,1,false,true,true,false);
 		// ROW 2
 		m.setRoomWalls(0,2,true,false,false,true);
 		m.setRoomWalls(1,2,false,false,true,true);
 		m.setRoomWalls(2,2,false,false,true,true);
 		m.setRoomWalls(3,2,false,false,true,true);
 		m.setRoomWalls(4,2,false,true,true,false);
 		m.setRoomWalls(5,2,true,false,false,false);
 		m.setRoomWalls(6,2,false,false,true,true);
 		m.setRoomWalls(7,2,false,true,false,false);
 		// ROW 3  
 		m.setRoomWalls(0,3,true,false,true,false);
 		m.setRoomWalls(1,3,false,true,true,true);
 		m.setRoomWalls(2,3,true,false,true,false);
 		m.setRoomWalls(3,3,false,true,true,false);	
 		m.setRoomWalls(4,3,true,true,false,false);
 		m.setRoomWalls(5,3,true,false,false,false);
 		m.setRoomWalls(6,3,false,true,true,false);
 		m.setRoomWalls(7,3,true,true,false,true);	
 		// ROW 4
 		m.setRoomWalls(0,4,true,false,false,false);
 		m.setRoomWalls(1,4,false,true,true,false);
 		m.setRoomWalls(2,4,true,true,false,false);
 		m.setRoomWalls(3,4,true,true,false,true);	
 		m.setRoomWalls(4,4,true,false,false,false);
 		m.setRoomWalls(5,4,false,true,false,false);	
 		m.setRoomWalls(6,4,true,false,false,true);
 		m.setRoomWalls(7,4,false,true,true,false);	
 		// ROW 5
 		m.setRoomWalls(0,5,true,true,false,true);
 		m.setRoomWalls(1,5,true,false,false,true);
 		m.setRoomWalls(2,5,false,false,false,true);
 		m.setRoomWalls(3,5,false,false,true,false);	
 		m.setRoomWalls(4,5,false,true,false,true);
 		m.setRoomWalls(5,5,true,true,false,true);
 		m.setRoomWalls(6,5,true,true,true,false);
 		m.setRoomWalls(7,5,true,true,false,true);
 		// ROW 6  
 		m.setRoomWalls(0,6,true,false,true,false);
 		m.setRoomWalls(1,6,false,true,true,false);
 		m.setRoomWalls(2,6,true,true,true,false);
 		m.setRoomWalls(3,6,true,false,false,true);	
 		m.setRoomWalls(4,6,false,false,true,false);
 		m.setRoomWalls(5,6,false,true,true,false);
 		m.setRoomWalls(6,6,true,false,false,true);
 		m.setRoomWalls(7,6,false,true,true,false);
 		// ROW 7
 		m.setRoomWalls(0,7,true,true,false,true);
 		m.setRoomWalls(1,7,true,false,false,true);
 		m.setRoomWalls(2,7,false,false,false,true);
 		m.setRoomWalls(3,7,false,false,true,true);	
 		m.setRoomWalls(4,7,false,true,false,true);
 		m.setRoomWalls(5,7,true,false,false,true);
 		m.setRoomWalls(6,7,false,false,true,true);
 		m.setRoomWalls(7,7,false,true,false,true);
 		/////////////////////////////////////////////////////////////////////
 		
 		// TOTAL RANDOMIZATION OF ITEMS AND RIDDLES
 		// USER MUST LOOK AT BOOLEANS for each room if there is more than one item in a room
 		// set the items now  
 		//setRoomItems(int x, int y,boolean key, boolean door ,boolean map, boolean monster, boolean riddle ){
 				
 		int mazeSize=m.getMazeSize();
 		
 		Room tempRoom = new Room();  // make a temporary pointer of type Room
 		Point randPoint = new Point();  // make a pointer of type Point
 		
 		// get a random location within the map 
 		randPoint.setRandom(mazeSize); // get a new random point 
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		// set the monster to be at the location 
 		m.setMonsterLocation(randPoint);  
 		// randomize monster start location but don't overwrite previous conditions except moster variable 
 		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasRiddle());  // Working
 		
 		
 		// get a new random location within the maze
 		randPoint.setRandom(mazeSize);	// get a new random point
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		
 		// set MAP location preserving prior booleans 
 		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),true,tempRoom.getHasMonster(),tempRoom.getHasRiddle()); // Place the map 

 		randPoint.setRandom(mazeSize);	
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		// place door
 	
 		m.setRoomItems(randPoint,tempRoom.getHasKey(),true,tempRoom.getHasMap(),tempRoom.getHasMonster(),tempRoom.getHasRiddle());
 		m.setDoorLocation(randPoint);  // change the door location 
 		
 		randPoint.setRandom(mazeSize); // get a new random point
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		// place the key 
 		m.setRoomItems(randPoint,true,tempRoom.getHasDoor(),tempRoom.getHasMap(),tempRoom.getHasMonster(),tempRoom.getHasRiddle());
 		
 		//place the riddle 
 		randPoint.setRandom(mazeSize);
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),tempRoom.getHasMonster(),true);	
 					
 		}
 		return;
 	}
    
 	
	public void monsterWalk(Random randGen, Maze gameBoard){
		
	int randNum = randGen.nextInt(4);  // 4 options for motion: left,right,up,down,  
		if (randNum % 4 == 0){
		 gameBoard.moveMonsterLeft();
		} else if (randNum % 4 == 1){
		 gameBoard.moveMonsterRight();
		} else if (randNum % 4 == 2){
		 gameBoard.moveMonsterUp();	
		} else if (randNum % 4 == 3){
		 gameBoard.moveMonsterDown();
		} 
	return;
	
	}
	
	public void inputControl() {
		
		// if user input was "MAP" display map unit until user types return
		if ( storeInput.equalsIgnoreCase("map") ) {
		
			if (gameBoard.getHero().getHasMap() ) {
		
				while (!storeInput.equalsIgnoreCase("Return")) {	
				printMap();  // print the map
				}
			} else {
			messageLabel.setText("You don't have a Map...");
			System.out.println("You don't have a Map...");
			}

	        }
		
		
		// if user input was "OPEN" display map unit until user types return
		if ( storeInput.equalsIgnoreCase("open") ) {
		
		// store the location of the door
		Point doorLocation = gameBoard.getDoor().getLocation();
		Point currentLocation = gameBoard.getCurrentRoom().getLocation();
		
			// check that player has the key, and is in the location that the door is in
			if (gameBoard.getHero().getHasKey()  && currentLocation.isEqual(doorLocation) && gameBoard.getCurrentRoom().getHasDoor() ) {
			gameBoard.unlockDoor();
			messageLabel.setText("The Door is now Open, you may now Escape...");
			System.out.println("The Door is now Open, you may now Escape...");

			} else {
			messageLabel.setText("You don't have a Key, or You're not at the Door...");
			System.out.println("You don't have a Key, or You're not at the Door...");
			}
	        }
		
		// if user input was "ESCAPE"  if you are at the door and the door is open exit the game winning.
		if ( storeInput.equalsIgnoreCase("Escape") ) {
		
		// store the location of the door
		Point doorLocation = gameBoard.getDoor().getLocation();
		Point currentLocation = gameBoard.getCurrentRoom().getLocation();
			// check that player has the key, and is in the location that the door is in and that the door is open
			if (gameBoard.getHero().getHasKey()  && currentLocation.isEqual(doorLocation) && gameBoard.getCurrentRoom().getHasDoor()  && !gameBoard.getDoor().getIsLocked() ) {
				
				level++; 
				if (level == 4){
					victory=true;  // switch victory flag		
				}
				gameBoard.lockDoor(); // lock the exit door for the next level 
				// increment to the next level 	
				
			} else {
			messageLabel.setText("Either the door isn't opened, or You're not at the Door...");
			System.out.println("Either the door isn't opened, or You're not at the Door...");
			
			}
	        }	
		
		// if user input was "HELP" display help unit until user types return
		if ( storeInput.equalsIgnoreCase("help") ) {
			while (!storeInput.equalsIgnoreCase("Return")) {	
			printHelp();  // print the help message with user input keywords
			storeInput = getUserInput();
			}
	        }
		
		// if user input is "Down"	
		if ( storeInput.equalsIgnoreCase("Down")){
		// increment the move counter to change the room
		gameBoard.moveDown();
		tempRoom = gameBoard.getCurrentRoom();
		moveCounter++;
		}	
			
		// if user input is "Up"	
		if ( storeInput.equalsIgnoreCase("Up")){
		// increment the move counter to change the room
		gameBoard.moveUp();
		tempRoom = gameBoard.getCurrentRoom();
		moveCounter++;
		}	
		
		// if user input is "Right"	
		if ( storeInput.equalsIgnoreCase("Right")){
		// increment the move counter to change the room
		gameBoard.moveRight();
		tempRoom = gameBoard.getCurrentRoom();
		moveCounter++;
		}	
		
		// if user input is "Left"	
		if ( storeInput.equalsIgnoreCase("Left")){
		// increment the move counter to change the room
		gameBoard.moveLeft();
		tempRoom = gameBoard.getCurrentRoom();
		moveCounter++;
		}
		
		// if user input is "Take"	
		if ( storeInput.equalsIgnoreCase("Take")){
		// increment the move counter to change the room
		tempRoom = gameBoard.getCurrentRoom();
			if (tempRoom.getHasKey()){
			gameBoard.takeKey();
			System.out.println("You took the key!");
			messageLabel.setText("You took the key!");
			moveCounter++;
			}else if (tempRoom.getHasMap()){
			gameBoard.takeMap();
			System.out.println("You took the Map!");
			messageLabel.setText("You took the Map!");
			moveCounter++;
			}else{
			System.out.println("There is nothing in the room to take...");
			messageLabel.setText("There is nothing in the room to take...");
			}
		// update the room 
		tempRoom = gameBoard.getCurrentRoom();
		}
		
		// if user input is "Fight"	
		if ( storeInput.equalsIgnoreCase("Fight")){
		
		tempRoom = gameBoard.getCurrentRoom();
		tempHero = gameBoard.getHero();
		tempMonster = gameBoard.getMonster();
		
			if (tempRoom.getHasMonster() && tempMonster.isAlive() && tempMonster.getPosition().isEqual(tempHero.getPosition()) ){
			messageLabel.setText("Fight Method Not Yet Implemented");
			} else {
			messageLabel.setText("There is nobody in the room to fight...");

			}
		// update the room 
		tempRoom = gameBoard.getCurrentRoom();
		}			
		
		
		
		
	return;
	}
	
	
	
 /////////////////////////////   THESE METHODS OUTPUT TO THE CONSOLE REPLACE THEM  /////////////////////////////	
 //////////////////////////////// METHODS THE REQUIRE REPLACEMENT/TRANSLATION //////////////////////////////////	
 	/// replace with a textBox substitute method 
	public void printHelp(){
	System.out.println("Welcome to THE MAZE, Commands are case insensitive. Here are the current Commands:");
	System.out.println("__________________________________________________");	
	System.out.println("Help : prints the usage commands");
	System.out.println("Quit : exits the maze");
	System.out.println("Return: if in map or help dialog this returns to the maze from a help window");
	System.out.println("Map: Prints out a static map version of the maze");
	System.out.println("Right: Moves the player to the right of current room if no wall");
	System.out.println("Left: Moves the player to the left of current room if no wall");
	System.out.println("Down: Moves the player to Room below the current room if no wall");
	System.out.println("Up: Moves the player to Room above the current room if no wall");
	System.out.println("Take: Takes either a key or map from the room and places it in the player inventory");
	System.out.println("Fight: Fight the maze Wraith");
	System.out.println("Attack: Fight the maze Wraith in the fighting dialogue");
	System.out.println("Run: Run away from the maze Wraith in the fighting dialogue");
	System.out.println("Open: Opens the Door if you Have a Key");
	System.out.println("Escape: Escape the Maze if the Door is Open");
	System.out.println("__________________________________________________");
	System.out.println("");
	System.out.println("Type \"Return\" and press Enter to return to the Maze");
	return;
	}
 	
	public void printMap(){
		
		if (level ==1){
		System.out.println("You unfold the map from your pocket and take a look:");
		System.out.println("");	
		System.out.println("    -------LEVEL 1--------   ");
		System.out.println("_____________________________");
		System.out.println("|      |      |      |      |");
		System.out.println("|  *   |  D      W          |");
		System.out.println("|_    _|______|______|_    _|");
		System.out.println("|      |      |      |      |");
		System.out.println("|      |                    |");
		System.out.println("|_    _|_    _|______|_    _|");
		System.out.println("|      |      |      |      |");
		System.out.println("|             |   K  |      |");
		System.out.println("|______|_    _|__   _|_    _|");
		System.out.println("|      |      |      |      |");
		System.out.println("|  M          |             |");
		System.out.println("|______|______|______|______|");
		System.out.println("");
		System.out.println("Type \"Return\" and press Enter to return to the Maze");
		}
		
		if (level ==2) {
		System.out.println("You unfold the map from your pocket and take a look:");
		System.out.println("");	
		System.out.println("    -------------LEVEL 2--------------- ");
		System.out.println("___________________________________________ ");
		System.out.println("|      |      |      |      |      |      | ");
		System.out.println("|  *   |             |                    |");
		System.out.println("|_    _|_    _|______|_    _|______|______|");
		System.out.println("|      |      |      |      |      |      |");
		System.out.println("|      |                                  |");
		System.out.println("|_    _|______|______|______|______|_    _|");
		System.out.println("|      |      |      |      |      |      |");
		System.out.println("|                    |             |      |");
		System.out.println("|______|______|_    _|_    _|_    _|_    _|");
		System.out.println("|      |      |      |      |      |      |");
		System.out.println("|             |      |      |      |      |");
		System.out.println("|_    _|_    _|_    _|_    _|_    _|_    _|");
		System.out.println("|      |      |      |      |      |      |");
		System.out.println("|             |      |      |             |");
		System.out.println("|_    _|_    _|_    _|______|_    _|_    _|");
		System.out.println("|      |      |      |      |      |      |");
		System.out.println("|   D  |                           |      |");
		System.out.println("|______|______|______|______|______|______|");
		System.out.println("");
		System.out.println("Type \"Return\" and press Enter to return to the Maze");
		}
	
		if (level ==3) {
		System.out.println("You unfold the map from your pocket and take a look:");
		System.out.println("");	
		System.out.println("      -------------------LEVEL 3--------------------   ");
		System.out.println("_________________________________________________________ ");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|  *                        |             |             |");
		System.out.println("|______|_    _|______|______|_    _|______|_    _|______|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|      |                                  |             |");
		System.out.println("|_    _|______|______|______|______|_    _|______|_    _|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|                                  |                    |");
		System.out.println("|______|______|______|______|_    _|_    _|______|__  __|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|             |             |      |             |      |");
		System.out.println("|_    _|______|_    _|_    _|_    _|_    _|_    _|______|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|             |      |      |             |             |");
		System.out.println("|_    _|_    _|_    _|______|_    _|_    _|______|_    _|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|      |                           |      |      |      |");
		System.out.println("|______|______|______|_    _|______|______|_    _|______|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|             |      |                    |             |");
		System.out.println("|_    _|_    _|_    _|______|_    _|_    _|______|_    _|");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("|      |                           |                    |");
		System.out.println("|______|______|______|______|______|______|______|______|");
		System.out.println("");
		System.out.println("Type \"Return\" and press Enter to return to the Maze");
		}
	
	return;
	}
	
	
	public String getUserInput(){
	String input;
	Scanner keyboard = new Scanner(System.in);
	messageLabel.setText("Please enter a command:");
	input = new String(keyboard.nextLine());
	keyboard.close(); // close the input stream
	return input;
	}

	
	// Use this to clear the screen taken from source: 	
	//  https://stackoverflow.com/questions/2979383/java-clear-the-console		
	public final static void clearScreen()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
} // Class Ending Brace

/////////////////////////////////   END OF FILE    ///////////////////////////////////////////////////
