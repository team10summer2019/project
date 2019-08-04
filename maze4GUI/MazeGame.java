//////////////////////////////////////////////
//
// File: MazeGame.java
// Description: MazeGame class with main() function
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 21, 2019
// Version: 0.05
// Revision Date: July 28, 2019
//
///////////////////////////////////////////////

import java.util.Scanner;
import java.util.Random;

public class MazeGame {

////////////////////////// INSTANCE VARIABLES ///////////////////////////////////

	static int level = 1 ;   // set the level to increase through 4 levels

////////////////////////  METHODS //////////////////////////////////////////////

	public static int getLevel(){
	return level;
	}
	
	public static void setLevel(int input) {
		if (input >=1 && input < 5){
		level = input;
		}
	}	
	
///////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args){
	playGame();
	return; 
	}// end of main function	
	
	public static void playGame() {
		
		int mazeSize=4;	 // initalize with 4x4 maze for level 1 
		int currentLevel=level;
		Player tempHero;  // temporary value to look at Hero stats
		Room tempRoom;    // temporary value to look at a room 
		Monster tempMonster; // temporary value to look at Monster stats
		String storeInput="";  // storage for user input
		int moveCounter = 0;  // count the number of moves
	        boolean victory=false;
		
		
		/// bug fix for manually switching the level number for testing (causes maze breakage)
		if (level == 1 )	{
		mazeSize=4;
		}else if (level ==2){
		mazeSize=6;
		}else if (level==3){
		mazeSize=8;
		}
		
		Maze gameBoard = new Maze(mazeSize);  // make a 4x4 room maze 
		setBoard(gameBoard);   // construct the maze 
		
		Random randGen = new Random(100);
			 
		gameBoard.setCurrentRoom(0,0); // reset the current room after setting up the board
		tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
		
		// clear the screen	
		clearScreen();
			
		// update the hero current condition
		tempHero = gameBoard.getHero();
		tempHero.displayStats();
		// set the room to cycle through all rooms in array list 
			
		tempRoom.drawRoomGrid();
		//tempRoom.displayRoomStats();
		
		System.out.println("");
		
		printHelp();
		pressEnter();
		
		// Main loop to run the Maze Game 
			
			while ( moveCounter < 300 && !storeInput.equalsIgnoreCase("quit")  && gameBoard.getHero().isAlive()  ){
			
				// if user input was "MAP" display map unit until user types return
				if ( storeInput.equalsIgnoreCase("map") ) {
				
					if (gameBoard.getHero().getHasMap() ) {
				
						while (!storeInput.equalsIgnoreCase("Return")) {	
						clearScreen();
						printMap();  // print the map
						storeInput = getUserInput();
						}
					} else {
					
					System.out.println("You don't have a Map...");
					pressEnter();
					
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
					System.out.println("The Door is now Open, you may now Escape...");
					pressEnter();
					} else {
					System.out.println("You don't have a Key, or You're not at the Door...");
					pressEnter();
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
							break; // break the while loop you are free
						}
						gameBoard.lockDoor(); // lock the exit door for the next level 
						// increment to the next level 	
						
					} else {
					System.out.println("Either the door isn't opened, or You're not at the Door...");
					pressEnter();
					}
			        }	
							
				// if user input was "HELP" display help unit unitl user types return
				if ( storeInput.equalsIgnoreCase("help") ) {
					while (!storeInput.equalsIgnoreCase("Return")) {	
					clearScreen();
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
					moveCounter++;
					}else if (tempRoom.getHasMap()){
					gameBoard.takeMap();
					System.out.println("You took the Map!");
					moveCounter++;
					}else if (tempRoom.getHasFood()){
					gameBoard.takeFood();
					System.out.println("You took the Food!");
					moveCounter++;
					}else{
					System.out.println("There is nothing in the room to take...");
					pressEnter();
					}
				// update the room 
				tempRoom = gameBoard.getCurrentRoom();
				}
				
				
				// routine for beating a level and setting up the next level 
				if (currentLevel == level -1) {	
					if (level==2){
					mazeSize=6; // 36 rooms 
					
					} else if (level == 3) {
					mazeSize=8; // 64 rooms
					}
				gameBoard = new Maze(mazeSize);  // make a mazeSize x mazeSize room maze 
		
				gameBoard.copyHero(tempHero);	// copy over the current character 
				
				gameBoard.setPlayerLocation(0,0) ; // return to the initial location for next level 
				gameBoard.resetPlayerItems(); // remove the key and the map from the player
				
				setBoard(gameBoard);   // construct the maze 
				gameBoard.setCurrentRoom(0,0); // reset the current room after setting up the board
				tempRoom = gameBoard.getCurrentRoom();  // update the tempRoom 
				currentLevel++; // track the current level
				}
				
			// clear the screen	
			clearScreen();
			
			// update the hero current condition and display Hero stats
			tempHero = gameBoard.getHero();
			tempHero.displayStats();
			
			//draw the current room and display the room stats 
			tempRoom.drawRoomGrid();
		        tempRoom.displayRoomStats();
			
			// update the monster's current condition and display Monster stats
			tempMonster = gameBoard.getMonster();
			tempMonster.displayStats();
			
			System.out.println("=======================  MAZE LEVEL STATS  ==========================");
			System.out.println("There have been " + moveCounter + " moves in the maze, you are on Level " + level);
			
				// Print out the user input from the previous turn  
				if (!storeInput.equalsIgnoreCase("")){
				System.out.println("Your input was: " + storeInput);
				}		
				
			// get user input
			storeInput = getUserInput();
			// pause until press enter
			// pressEnter();
			
			// if user input is "Fight"	
				if ( storeInput.equalsIgnoreCase("Fight")){
				
				tempRoom = gameBoard.getCurrentRoom();
				tempHero = gameBoard.getHero();
				tempMonster = gameBoard.getMonster();
				
					if (tempRoom.getHasMonster() && tempMonster.isAlive() && tempMonster.getPosition().isEqual(tempHero.getPosition()) ){
					fightMonster(gameBoard);
					} else {
					System.out.println("There is nobody in the room to fight...");
					pressEnter();
					}
				// update the room 
				tempRoom = gameBoard.getCurrentRoom();
				}			
				
			
				// move the monster if alive
				if (gameBoard.getMonster().isAlive() && !storeInput.equalsIgnoreCase("Fight")){
				monsterWalk(randGen, gameBoard);
				//monsterWalk(randGen, gameBoard);
				}
		
			}  // closing brace for while loop
			
			
			/// closing message to user
			if ( !gameBoard.getDoor().getIsLocked() && victory ){
			System.out.println("Congratulations! You are free from THE MAZE!");
			}else{
			System.out.println("Thanks for playing THE MAZE.  Better Luck Next Time!");
			}
		
		return;
	}
	
	
	// sets up the walls and items, doors and monsters
	public static void setBoard( Maze m){
	
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
		//m.setRoomItems(2,3,false,false,false,false,true); //place the riddle in the room below the key
		// room (3,3)
		m.setRoomWalls(3,3,false,true,false,true);
		
		
		// get a random location within the map 
		Point randPoint = new Point();
		randPoint.setRandom(m.getMazeSize());
		Room tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		// set the monster to be at the location 
		m.setMonsterLocation(randPoint);  
		// randomize monster start location but don't overwrite previous conditions except monster variable 
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasFood());  // Working
		
		//place the Food Randomly
		randPoint.setRandom(m.getMazeSize());
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),tempRoom.getHasMonster(),true);
		
		
		
		
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
		
		// place the Food in a specific location in front of the key
		//m.setRoomItems(4,0,false,false,false,false,true);
		
		
		// get a random location within the map 
		Point randPoint = new Point();
		randPoint.setRandom(m.getMazeSize());
		Room tempRoom = new Room();
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		// set the monster to be at the location 
		m.setMonsterLocation(randPoint);  
		// randomize monster start location but don't overwrite previous conditions except monster variable 
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasFood());  // Working
		
		
		//place the Food Randomly
		randPoint.setRandom(m.getMazeSize());
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),tempRoom.getHasMonster(),true);
		
		
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
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),true,tempRoom.getHasFood());  // Working
		
		
		// get a new random location within the maze
		randPoint.setRandom(mazeSize);	// get a new random point
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		
		// set MAP location preserving prior booleans 
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),true,tempRoom.getHasMonster(),tempRoom.getHasFood()); // Place the map 

		randPoint.setRandom(mazeSize);	
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		// place door
	
		m.setRoomItems(randPoint,tempRoom.getHasKey(),true,tempRoom.getHasMap(),tempRoom.getHasMonster(),tempRoom.getHasFood());
		m.setDoorLocation(randPoint);  // change the door location 
		
		randPoint.setRandom(mazeSize); // get a new random point
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		// place the key 
		m.setRoomItems(randPoint,true,tempRoom.getHasDoor(),tempRoom.getHasMap(),tempRoom.getHasMonster(),tempRoom.getHasFood());
		
		//place the Food
		randPoint.setRandom(mazeSize);
		tempRoom = m.getRoom(randPoint);  // get a copy of the room at randLocation
		m.setRoomItems(randPoint,tempRoom.getHasKey(),tempRoom.getHasDoor(),tempRoom.getHasMap(),tempRoom.getHasMonster(),true);	
					
		}
	
	
	return;
	}
	
	public static void printMap(){
	
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
	
	public static void printHelp(){
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
		

	
	public static String getUserInput(){
	String input;
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter a command:");
	input = new String(keyboard.nextLine());
	return input;
	}
	
	public static void pressEnter(){
	String input;
	Scanner keyboard = new Scanner(System.in);
	System.out.println("<<<<Press Enter>>>>");
	keyboard.nextLine();
	return;
	}
	
	
	public static void monsterWalk(Random randGen, Maze gameBoard){
	
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
	System.out.println("........................          ..........................");
	System.out.println(".........................        ...........................");
	System.out.println(".........................        ...........................");
	System.out.println(".........................        ...........................");
	System.out.println("...........................     ............................");
	System.out.println("...........................   ..............................");
	System.out.println("............................  ..............................");
	System.out.println("............................. ..............................");
	System.out.println("............................. ..............................");
	System.out.println(" ");
	}
		

	public static void fightMonster(Maze gameBoard){	
	
	clearScreen(); // clear the screen 
	displayMazeWraith(); // show the ASCII Art 
	System.out.println("A MAZE WRAITH APPEARS") ;
	gameBoard.getHero().displayStats();
	gameBoard.getMonster().displayStats();	
	String userCommand  = getUserInput();

		while ( !userCommand.equalsIgnoreCase("Run") && gameBoard.getMonster().isAlive() && gameBoard.getHero().isAlive() ){
		
			if (userCommand.equalsIgnoreCase("Attack") || userCommand.equalsIgnoreCase("Fight") ) {
				gameBoard.fightTurn();
				} 
				
			if (userCommand.equalsIgnoreCase("Run") ) {
				break;
				} 
		
		
			clearScreen(); // clear the screen 		
			displayMazeWraith(); // show the ASCII Art 
			
			if ( gameBoard.getMonster().getHealth() >12 ) {
			System.out.println("The MAZE WRAITH LAUGHS IN GLEE!!!") ;
			}else if ( gameBoard.getMonster().getHealth() < 12 && gameBoard.getMonster().getHealth()> 6 ){
			System.out.println("The MAZE WRAITH SCREAMS IN ANGER!!!") ;
			}else if ( gameBoard.getMonster().getHealth() < 6 && gameBoard.getMonster().getHealth()> 0 ){
			System.out.println("The MAZE WRAITH CRYS IN TERROR!!!") ;
			}else if ( gameBoard.getMonster().getHealth()<=0 ){
			System.out.println("The MAZE WRAITH SHREAKS IN PAIN!!!" ) ;
			gameBoard.getHero().displayStats();  // display player stats
			gameBoard.getMonster().displayStats(); // display monster stats
			break;
			}
			gameBoard.getHero().displayStats();  // display player stats
			gameBoard.getMonster().displayStats(); // display monster stats
			
			if ( ! gameBoard.getHero().isAlive()){
			gameBoard.deleteHero();
			System.out.println("The Hero has been vanquished ...");
			pressEnter();
			break;
			}			
			
			userCommand  = getUserInput();  // get user input 
			
	
	
			
			}
		
		if ( ! gameBoard.getMonster().isAlive() ) {
		    gameBoard.deleteMonster();  // remove the icon 
		    System.out.println("The Maze Wraith has been vanquished ...");
		    pressEnter();
		}
		
	return;	

	}


	public static void handleInput(Maze gameBoard){
	
	return;	
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
			
	// Use this to clear the screen taken from source: 	
	//  https://stackoverflow.com/questions/2979383/java-clear-the-console
	//public static void clearScreen() {  
	// System.out.print("\033[H\033[2J");  
	// System.out.flush();  
	//}  
			
			
			
			
			
	
} // class ending brace
///////////////////////////////  END OF FILE //////////////////////////////////////////////////