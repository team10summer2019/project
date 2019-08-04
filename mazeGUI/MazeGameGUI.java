import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
//import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.image.Image;

public class MazeGameGUI extends Application {

//////////////////////////INSTANCE VARIABLES ///////////////////////////////////

	private int level = 1 ;   // set the level to increase through 4 levels
	private int mazeSize=4;	 // Initialize with 4x4 maze for level 1 
	private int currentLevel=level;
	

	private Monster tempMonster; // temporary value to look at Monster stats
	private String storeInput="";  // storage for user input
	private int moveCounter = 0;  // count the number of moves
    private boolean victory=false;
	private Random randGen = new Random(100);  // random number generator
	private Button tempButton;  // temporary button pointer
    
	private  Maze gameBoard = new Maze(mazeSize);  // make a 4x4 room maze 
	
	private Room tempRoom = gameBoard.getCurrentRoom();    // temporary value to look at a room 
	private Player tempHero = gameBoard.getHero();  // temporary value to look at Hero stats
	
    /// get the number of columns and rows in a roomGrid in a Room object in gameBoard
    private int cols = gameBoard.getCurrentRoom().getRoomCols();
    private int rows = gameBoard.getCurrentRoom().getRoomRows();
    
    // make a button grid with the same number of columns and rows as a roomGrid
	private Button[][] buttonGrid = new Button[cols][rows];  	
	private Rectangle[][] rectGrid = new Rectangle[cols][rows];
	
	// make a messageLabel with a message for user interaction / Prompts
	private Label messageLabel = new Label("Welcome to the Maze");
	
	private TextField textIn = new TextField(); // javafx.scene.control.TextField
	
	private Label playerLabel1 = new Label("Hero Stats:" + gameBoard.getHero().getHealth()+" " +gameBoard.getHero().getPosition().toString());
	private Label playerLabel2 = new Label("Hero Items: Map=" + gameBoard.getHero().getHasMap()+" Key= " +gameBoard.getHero().getHasKey());
	
	private Image image;
	
	
///////////////////////////// START METHOD //////////////////////////////////////////////////	
	
	@Override
	public void start(Stage primaryStage) { // this is like the main method 
		
		// use the GridPane layout (instead of vBox, hBox or Group)
		  GridPane grid = new GridPane();  

		  GridPane grid2 = new GridPane();  // grid for rectangle objects 
	
		  // make a key input handler
		  HandleKeyBoardInput keyInput =  new HandleKeyBoardInput(); 
		  HandleInputSendClick sendClick = new HandleInputSendClick();
		  HandleInputStartClick startClick = new HandleInputStartClick();
		  
		// build grid of buttons for the board (visual component)
		//// initialize the button grid representing a virtual room 
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++){
				Button b = new Button(" ");  // make a new button with blank space as text
			//	b.setOnKeyTyped( keyInput);  // set on a key press
				buttonGrid[i][j] = b;       // add the new button to the buttonGrid
				grid.add(buttonGrid[i][j], i, j);		
			}
		}
		
		// make a VBox object 
		VBox verticalBox = new VBox();  // Vbox layout manager , stacks downward
		
		// send the text field to the storeInput string
		Button sendButton = new Button("Enter");
		// attempt a cold boot setup of the room 
		Button startButton = new Button("Restart");
		
	//	Button updateButton = new Button("Update");
		
		Canvas canvas = new Canvas(200,200);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++){
				Rectangle rect = new Rectangle();  // make a new rectangle 
				rect.setWidth(50);
				rect.setHeight(50);
				rect.setFill(Color.BLACK);
				rect.setOnKeyPressed( new HandleKeyBoardInput());
				rectGrid[i][j] = rect;       // add the new rectangle to the rectGrid
				grid2.add(rectGrid[i][j], i, j);		
			}
		}
		

		// Add the items to the vertical box 
		verticalBox.getChildren().add(textIn);
		verticalBox.getChildren().add(sendButton);
		verticalBox.getChildren().add(playerLabel1);
		verticalBox.getChildren().add(playerLabel2);
		verticalBox.getChildren().add(startButton);	
		// verticalBox.getChildren().add(updateButton);
		
		// set the sendButton to pass the text field above it to storeInput string
		sendButton.setOnAction( sendClick ); 
		// set the startButton to perform a setup operation
		startButton.setOnAction( startClick ); 
		
		
///////////////////////////// SCENE and STAGE SHOW ////////////////////////////////////////////
		// build entire scene: grid and label
		
		BorderPane root = new BorderPane();
		//root.setCenter(grid);
		root.setCenter(grid);  // add a grid to the center pane 
		root.setRight(verticalBox);  // add a vbox to the right pane
		root.setBottom(messageLabel);  // place to put the messages to user output
		root.setTop(canvas); // add a canvas to the left pane
		
		
		Scene scene = new Scene(root, 500, 500);
		
		// key press action events
		root.setOnKeyTyped( keyInput );
		
		startMeUp(); // setup the game
		
		initDraw(gc);
		
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
		//https://stackoverflow.com/questions/22014950/javafx-moving-image-with-arrow-keys-and-spacebar
		} else if (event.getCharacter().charAt(0) == 'a' || event.getCode() == KeyCode.LEFT ) {
			storeInput="left";
			messageLabel.setText("Move Left");
		} else if (event.getCharacter().charAt(0) == 's' || event.getCode() == KeyCode.DOWN ) {
			storeInput="down";
			messageLabel.setText("Move Down");
		} else if (event.getCharacter().charAt(0) == 'd' || event.getCode() == KeyCode.RIGHT ) {
			storeInput="right";
			messageLabel.setText("Move Right");
		} else if (event.getCharacter().charAt(0) == 'w' || event.getCode() == KeyCode.UP ) {
			storeInput="up";
			messageLabel.setText("Move Up");
		} else if (event.getCode() == KeyCode.SPACE ) {
			storeInput="SpaceBar";	
		} else if (event.getCode() == KeyCode.ENTER) {
			storeInput="Enter";	
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
		if (storeInput.equalsIgnoreCase("map") || storeInput.equalsIgnoreCase("help") || storeInput.equalsIgnoreCase("fight") ) {
		inputControl(); // parse the input
		} else {
		inputControl(); // parse the input
		textModeOutput();  // output the text-mode response
		}
		
		// move the monster if alive
		if(gameBoard.getMonster().isAlive()) {
		monsterWalk(randGen,gameBoard);// move the monster
		}
		
		// Update Hero Statistics 
		playerLabel1.setText("Hero HEALTH: " + gameBoard.getHero().getHealth()+" Position: " +gameBoard.getHero().getPosition().toString());
		playerLabel2.setText("Hero Items: Map=" + gameBoard.getHero().getHasMap()+" Key= " +gameBoard.getHero().getHasKey());
			
		/// Routines to update the boxes
		postCurrentRoom();

	}
}

// input text box with send button handler 
public class HandleInputSendClick implements EventHandler<ActionEvent> {	
	public void handle(ActionEvent event){
			gameBoard.setCurrentRoom(gameBoard.getHero().getPosition()); 
			tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
			tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

			tempHero = gameBoard.getHero();
			// grab the input text from the text box
			storeInput=textIn.getText();
			// output to the message label
			messageLabel.setText("Command: " + storeInput);
						
			textModeOutput();	// show the updated display
			inputControl();
			// move the monster if alive
			if(gameBoard.getMonster().isAlive()) {
			monsterWalk(randGen,gameBoard);// move the monster
			}
			
			// Update Hero Statistics
			playerLabel1.setText("Hero HEALTH: " + gameBoard.getHero().getHealth()+" Position: " +gameBoard.getHero().getPosition().toString());
			playerLabel2.setText("Hero Items: Map=" + gameBoard.getHero().getHasMap()+" Key= " +gameBoard.getHero().getHasKey());
				
			/// Routines to update the current room boxes
			postCurrentRoom();

		}
	}

//input text box with send button handler 
public class HandleInputStartClick implements EventHandler<ActionEvent> {	
	public void handle(ActionEvent event){
		
		resetGameBoard(); // reset the gameBoard
		gameBoard.setCurrentRoom(0,0); // reset the current room after setting up the board
		// get the current room
		//gameBoard.setCurrentRoom(gameBoard.getHero().getPosition()); 
		
		// THIS CALL IS CAUSING A BUG I DONT GET IT!!
		tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		tempHero = gameBoard.getHero();
		
		postCurrentRoom();   // display the current room 
        // show the text mode output
		textModeOutput();
		printHelp();
		inputControl();
		}
	}

	

///////////////////////////     OTHER METHODS      ////////////////////////////////////////

public void startMeUp() {
	
	resetGameBoard(); // reset the gameBoard
	gameBoard.setCurrentRoom(0,0); // reset the current room after setting up the board
	// get the current room
	//gameBoard.setCurrentRoom(gameBoard.getHero().getPosition()); 
	
	// THIS CALL IS CAUSING A BUG I DONT GET IT!!
	tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
	tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

	tempHero = gameBoard.getHero();
	
	postCurrentRoom();   // display the current room 
    // show the text mode output
	textModeOutput();
	printHelp();
	inputControl();
}


 public void resetGameBoard() {
		setLevel(level);   // set the level to 1 
		resetMazeSize();  // reset the Maze Size  
		gameBoard = new Maze(mazeSize); // make a new gameBoard of the proper size
		setBoard(gameBoard);   // construct the maze for the current level
		gameBoard.copyHero(tempHero); // copy over the player from the previous level
		gameBoard.setPlayerLocation(0,0); // reset to the top
		gameBoard.resetPlayerItems(); // remove the key and the map from the player
		// set the current room to current position 
		gameBoard.setCurrentRoom(gameBoard.getHero().getPosition());
		tempRoom = gameBoard.getCurrentRoom();  // get the tempRoom to be the current room.
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid


 }


// attempt at graphics display
public void postCurrentRoom() {
	// get the current room
	gameBoard.setCurrentRoom(gameBoard.getHero().getPosition()); 
	
	// THE FOLLOWING LINE CAUSES A BUG TO NOT DISPLAY THE CURRENT ROOM...????
	tempRoom = gameBoard.getCurrentRoom();  // get the tempRoom to be the current room.
	tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

	char ch='A';
	String temp="";
	wipeGrid();  // clear previous text
	// copy it into the button grid for display
	for (int i = 0; i < cols; i++) {
		for (int j = 0; j < rows; j++){
			temp="";
			//tempButton = buttonGrid[i][j]; // point to the button in the button grid
			ch=tempRoom.getRoomGrid()[i][j] ;  // store the character in the room grid
			temp=temp+ch;
			buttonGrid[i][j].setText(temp);
			if (ch == ' ' ) {
			buttonGrid[i][j].setOpacity(0.3);
			rectGrid[i][j].setFill(Color.GREY);
			} else {
			buttonGrid[i][j].setOpacity(1);
			rectGrid[i][j].setFill(Color.RED);
			}
		}
	}
}

// attempt to wipe graphics display
public void wipeGrid() {   	
	// copy it into the button grid for display
	for (int i = 0; i < cols; i++) {
		for (int j = 0; j < rows; j++){
			buttonGrid[i][j].setText(" ");	
			rectGrid[i][j].setFill(Color.WHITE);
		}
	}
}

public void textModeOutput() {
	//draw the current room and display the room stats 
	tempRoom = gameBoard.getCurrentRoom();
	tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

	
	/// THIS IS THE CRITICAL ITEM THAT IS REQUIRED (LOAD THE GRID INFO)
	//tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

	tempRoom.drawRoomGrid();  
    
	
	tempRoom.displayRoomStats();
	// update the hero current condition and display Hero stats
	tempHero = gameBoard.getHero();
	tempHero.displayStats();
	// update the monster's current condition and display Monster stats
	tempMonster = gameBoard.getMonster();
	tempMonster.displayStats();
	
	System.out.println("You are currently on level: "+level);
	
}

	public int getLevel(){
	return level;
	}
	
	public void setLevel(int input) {
		if (input >=1 && input < 5){
			level = input;
		}
		return;
	}		
	
    public void resetMazeSize(){
    	if ( level == 1 ){
    		mazeSize=4;
    	}else if ( level ==2){
    		mazeSize=6;
    	}else if (level==3){
    		mazeSize=8;
    	}
    	return;
    }
   
 // sets up the walls and items, doors and monsters
 	public void setBoard( Maze m){
 	
 		// local variables 
 		int mazeSize=m.getMazeSize();
 		Room tempRoom = new Room();  // make a temporary pointer of type Room
 		Point randPoint = new Point();  // make a pointer of type Point
 		
 		
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
 		tempRoom = m.getRoom(randLocation);  // get a copy of the room at randLocation
 		// set the monster to be at the location 
 		m.setMonsterLocation(randLocation);  
 		// randomize monster start location but don't overwrite previous conditions except moster variable 
 		m.setRoomItems(randLocation,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasRiddle());  // Working
 		
 		} // level 1 end if brace
 	
 	
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
 		
 		////////////////////////////////////////////////////////////////////////
 		// set the items now  
 		//setRoomItems(Point p , boolean key, boolean door ,boolean map, boolean monster, boolean riddle ){
 		
 		
 		///// RANDOM PLACEMENT OF THE MONSTER ////////////////
 		// get a random location within the map 
 		randPoint.setRandom(mazeSize); // get a new random point 
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		// set the monster to be at the location 
 		m.setMonsterLocation(randPoint);  
 		// randomize monster start location but don't overwrite previous conditions except moster variable 
 		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasRiddle());  // Working
 		
 		////// RANDOM PLACEMENT OF THE MAP ////////////////
 		// get a new random location within the maze
 		randPoint.setRandom(mazeSize);	// get a new random point
 		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
 		// set MAP location preserving prior booleans 
 		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),true,tempRoom.getHasMonster(),tempRoom.getHasRiddle()); // Place the map 

 		/////////////////// NON RANDOM ITEMS ////////////////////////////
 		// place door in specific location
 		m.setRoomItems(0,5,false,true,false,false,false);
 		m.setDoorLocation(0,5);  // change the door location 
 		// place the key in specific location
 		m.setRoomItems(5,0,true,false,false,false,false);
 		// place the riddle in a specific location in front of the key (opens wall to get key)
 		m.setRoomItems(4,0,false,false,false,false,true);
 		
 		} // level 2 end if brace
 		////////////////////////     LEVEL 3   ///////////////////////////////////////
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
 				
 		mazeSize=m.getMazeSize();
 		
 		tempRoom = new Room();  // make a temporary pointer of type Room
 		randPoint = new Point();  // make a pointer of type Point
 		
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
 					
 		} // level 3 end if brace
 		
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
			
				printMap();  // print the map
				
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
				System.out.println("You have escaped, and are now on Level: " + level );
				messageLabel.setText("You have escaped, and are now on Level: " + level );	
				resetGameBoard();  // get a new level
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
			printHelp();  // print the help message with user input keywords	
	        }
		
		// if user input is "Down"	
		if ( storeInput.equalsIgnoreCase("Down")){
		// increment the move counter to change the room
		gameBoard.moveDown();
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		moveCounter++;
		}	
			
		// if user input is "Up"	
		if ( storeInput.equalsIgnoreCase("Up")){
		// increment the move counter to change the room
		gameBoard.moveUp();
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		moveCounter++;
		}	
		
		// if user input is "Right"	
		if ( storeInput.equalsIgnoreCase("Right")){
		// increment the move counter to change the room
		gameBoard.moveRight();
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		moveCounter++;
		}	
		
		// if user input is "Left"	
		if ( storeInput.equalsIgnoreCase("Left")){
		// increment the move counter to change the room
		gameBoard.moveLeft();
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		moveCounter++;
		}
		
		// if user input is "Take"	
		if ( storeInput.equalsIgnoreCase("Take")){
		// increment the move counter to change the room
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

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
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		}
		
		// if user input is "Fight"	
		if ( storeInput.equalsIgnoreCase("Fight")){
		
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		tempHero = gameBoard.getHero();
		tempMonster = gameBoard.getMonster();
		
			if (tempRoom.getHasMonster() && tempMonster.isAlive() && tempMonster.getPosition().isEqual(tempHero.getPosition()) ){
			fightMonster(gameBoard);
			} else {
			messageLabel.setText("There is nobody in the room to fight...");

			}
		// update the room 
		tempRoom = gameBoard.getCurrentRoom();
		tempRoom.populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid

		
		postCurrentRoom();
		}	
		
		/// closing message to user if Win
		if ( level ==4 && victory ){
		 System.out.println("Congratulations! You are free from THE MAZE!");
		 messageLabel.setText("Congratulations! You are free from THE MAZE!");
		 System.exit(0);
		}
		
		/// closing message to user if fail to win or quit
		if ( moveCounter > 400 || !gameBoard.getHero().isAlive() || storeInput.equalsIgnoreCase("quit") ){
		 System.out.println("Thanks for playing THE MAZE.  Better Luck Next Time!");
		 messageLabel.setText("Thanks for playing THE MAZE.  Better Luck Next Time!");
		 System.exit(0);
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
	System.out.println("Control Keys: a: left, s: down,d: right,w: up");
	System.out.println("Control Keys: r: return, m: map, t: take , q: quit, h: help o: open, e: escape, f:fight");
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
	

	public static void pressSPACE( String input){

	System.out.println("<<<<Press SPACEBAR>>>>");	
		
	return;
	}
	
	public static void displayMazeWraith(){
	System.out.println("............................................................");
	System.out.println(".........................       ............................");
	System.out.println(".......................           ..........................");           
	System.out.println("....................... oOo   oOo  .........................");
	System.out.println("........... ..........      J       ........................");
	System.out.println("............   ....... TTTTTTTTTTTT ............  ..........");
	System.out.println("..............  ........IIIIIIIIII.............  ...........");
	System.out.println("...............   .........    .............  ..............");
	System.out.println(".................   .....         ........   ...............");
	System.out.println("...................  ....          ....   ..................");
	System.out.println(".....................                   ....................");
	System.out.println("........................            ........................");
	}
		

	public void fightMonster(Maze gameBoard){	
	

		if (  gameBoard.getMonster().isAlive() && gameBoard.getHero().isAlive() ){
		
			if (storeInput.equalsIgnoreCase("Attack") || storeInput.equalsIgnoreCase("Fight") ) {
				gameBoard.fightTurn();
				} 
			
			
			// obsolete remove this if statement
			if (storeInput.equalsIgnoreCase("Run") ) {
				textModeOutput();
				return;
				} 
		
			System.out.println("You Attacked the MAZE WRAITH ") ;
			clearScreen(); // clear the screen 		
			displayMazeWraith(); // show the ASCII Art 
			
			// 2D graphics counterpart
			postCurrentRoom();
	
			if ( gameBoard.getMonster().getHealth() >12 ) {
				System.out.println("The MAZE WRAITH LAUGHS IN GLEE!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth()) ;
				messageLabel.setText("The MAZE WRAITH LAUGHS IN GLEE!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth());
			}else if ( gameBoard.getMonster().getHealth() < 12 && gameBoard.getMonster().getHealth()> 6 ){
				System.out.println("The MAZE WRAITH SCREAMS IN ANGER!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth()) ;
				messageLabel.setText("The MAZE WRAITH SCREAMS IN ANGER!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth());
			}else if ( gameBoard.getMonster().getHealth() < 6 && gameBoard.getMonster().getHealth()> 0 ){
				System.out.println("The MAZE WRAITH CRYS IN TERROR!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth()) ;
				messageLabel.setText("The MAZE WRAITH CRYS IN TERROR!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth());
			}else if ( gameBoard.getMonster().getHealth()<=0 ){
				System.out.println("The MAZE WRAITH SHREAKS IN PAIN!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth()) ;
				messageLabel.setText("The MAZE WRAITH SHREAKS IN PAIN!!!"+"  Monster HEALTH: " + gameBoard.getMonster().getHealth() );
			}
			
			// if during the fight turn hero dies
			if ( ! gameBoard.getHero().isAlive()){
				gameBoard.deleteHero();
				System.out.println("The Hero has been vanquished ...");
				messageLabel.setText("The Hero has been vanquished ...");
				System.out.println("Thanks for playing THE MAZE.  Better Luck Next Time!");
				messageLabel.setText("Thanks for playing THE MAZE.  Better Luck Next Time!");
				System.exit(0);
			}			
			
			} // end of check if hero is alive and monster is alive
		
		if ( ! gameBoard.getMonster().isAlive() ) {
		    gameBoard.deleteMonster();  // remove the icon 
		    System.out.println("The Maze Wraith has been vanquished ...");
		    messageLabel.setText("The Maze Wraith has been vanquished ...");

			tempHero = gameBoard.getHero();
			tempHero.displayStats();
			tempMonster = gameBoard.getMonster();
			tempMonster.displayStats();
			
			// 2D graphics counterpart
			postCurrentRoom();
			
		}
		
	return;	

	}
	
	//http://java-buddy.blogspot.com/2013/05/draw-scaled-image-on-javafx-canvas-with.html
	 private void initDraw(GraphicsContext gc){
		 
	        double canvasWidth = gc.getCanvas().getWidth();
	        double canvasHeight = gc.getCanvas().getHeight();
	         
	        gc.setFill(Color.LIGHTGRAY);
	        gc.setStroke(Color.BLACK);
	        gc.setLineWidth(5);
	 
	        gc.fill();
	        gc.strokeRect(
	                0,              //x of the upper left corner
	                0,              //y of the upper left corner
	                canvasWidth,    //width of the rectangle
	                canvasHeight);  //height of the rectangle
	 
	        gc.setLineWidth(1);
	      
	        image = new Image("image1.png");
	        
	        
	        gc.drawImage(image, 0, 0, 200, 200);
	        
	    }
	     
	
	
		
/////////////////////////////////////////////////////////////////////////////////////////////////
} // Class Ending Brace

/////////////////////////////////   END OF FILE    ///////////////////////////////////////////////////
