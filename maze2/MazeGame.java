//////////////////////////////////////////////
//
// File: testMaze.java
// Description: MazeGame class with main() function
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 21, 2019
// Version: 0.03
// Revision Date: July 21, 2019
//
///////////////////////////////////////////////

import java.util.Scanner;
import java.util.Random;

public class MazeGame {


	public static void main(String[] args){
		
	Maze gameBoard = new Maze(4);  // make a 4x4 room maze 
	setBoard(gameBoard);   // construct the maze 
	Player tempHero;  // temporary value to look at Hero stats
	Room tempRoom;    // temporary value to look at a room 
	String storeInput="";  // storage for user input
	int moveCounter = 0;  // count the number of moves
        boolean victory=false;
	 
	gameBoard.setCurrentRoom(0,0); // reset the current room after setting up the board
	tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
	
	// clear the screen	
	clearScreen();
		
	// update the hero current condition
	tempHero = gameBoard.getHero();
	tempHero.displayStats();
	// set the room to cycle through all rooms in array list 
		
	tempRoom.drawRoom();
	//tempRoom.displayRoomStats();
	
	System.out.println("");
	
	printHelp();
	pressEnter();
	
	// Main loop to run the Maze Game 
		
		while ( moveCounter < 200 && !storeInput.equalsIgnoreCase("quit")  ){
		
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
				victory=true;  // switch victory flag
				break; // break the while loop you are free
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
				}else{
				System.out.println("There is nothing in the room to take...");
				pressEnter();
				}
			// update the room 
			tempRoom = gameBoard.getCurrentRoom();
			}
			
			/// DEBUG METHOD to view map cell by cell	
		/*	
			// if user input was "Next" 	
			if ( storeInput.equalsIgnoreCase("Next")){
			// increment the move counter to change the room
			tempRoom = gameBoard.getRoom(moveCounter % 16);
			moveCounter++;
			}
		*/	
					
		// clear the screen	
		clearScreen();
		
		// update the hero current condition and display hero stats
		tempHero = gameBoard.getHero();
		tempHero.displayStats();
		
		//draw the current room and display the room stats 
		tempRoom.drawRoom();
	        tempRoom.displayRoomStats();
		
		System.out.println("There have been " + moveCounter + " moves in the maze");
		
			// Print out the user input from the previous turn  
			if (!storeInput.equalsIgnoreCase("")){
			System.out.println("Your input was: " + storeInput);
			}		
			
		// get user input
		storeInput = getUserInput();
		// pause until press enter
		// pressEnter();
		}  // closing brace for while loop
		
		
		/// closing message to user
		if ( !gameBoard.getDoor().getIsLocked() && victory ){
		System.out.println("Congratulations! You are free from THE MAZE!");
		}else{
		System.out.println("Thanks for playing THE MAZE.  Better Luck Next Time!");
		}
	
	return; 
	}// end of main function	
	
	// sets up the walls and items, doors and monsters
	public static void setBoard( Maze m){
	// setRoom(x,y,left,right,up,down,key,door,map,monster)
	m.setRoom(0,0,true,true,true,false,false,false,false,false); // setup the first room 
	m.setRoom(0,0,true);  // place the player in the first room
	// room (1.0)   
	m.setRoom(1,0,true,false,true,true,false,true,false,false);
	// room (2,0)
	m.setRoom(2,0,false,false,true,true,false,false,false,true);
	// room (0,3)
	m.setRoom(3,0,false,true,true,false,false,false,false,false);
	// room (1,0)
	// setRoom(x,y,left,right,up,down,key,door,map,monster)
	m.setRoom(0,1,true,true,false,false,false,false,false,false);
	// room (1,1)
	m.setRoom(1,1,true,false,true,false,false,false,false,false);
	// room (2,1)
	m.setRoom(2,1,false,false,true,true,false,false,false,false);
	// room (3,1)
	m.setRoom(3,1,false,true,false,false,false,false,false,false);
	// room (0,2)
	m.setRoom(0,2,true,false,false,true,false,false,false,false);
	// setRoom(x,y,left,right,up,down,key,door,map,monster)
	// room (1,2)
	m.setRoom(1,2,false,true,false,false,false,false,false,false);
	// room (2,2)
	m.setRoom(2,2,true,true,true,false,true,false,false,false);
	// room (3,2)
	m.setRoom(3,2,true,true,false, false,false,false,false,false);
	// room (0,3)
	// setRoom(x,y,left,right,up,down,key,door,map,monster)
	m.setRoom(0,3,true,false,true,true,false,false,true,false);
	// room (1,3)
	m.setRoom(1,3,false,true,false,true,false,false,false,false);
	// room (3,2)
	m.setRoom(2,3,true,false,false,true,false,false,false,false);
	// room (3,3)
	m.setRoom(3,3,false,true,false,true,false,false,false,false);	
	
	return;
	}
	
	public static void printMap(){
	System.out.println("You unfold the map from your pocket and take a look:");
	System.out.println("");	
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
	return;
	}
	
	public static void printHelp(){
	System.out.println("Welcome to THE MAZE, Commands are case insensitive. Here are the current Commands:");
	System.out.println("__________________________________________________");	
	System.out.println("Help : prints the usage commands");
	System.out.println("Quit : exits the maze");
	System.out.println("Return: if in map or help dialog this returns to the maze from a help window");
	System.out.println("Map: Prints out a static map version of the maze");
	//System.out.println("Next: Moves the displayed room to the next room in the list");
	System.out.println("Right: Moves the player to the right of current room if no wall");
	System.out.println("Left: Moves the player to the left of current room if no wall");
	System.out.println("Down: Moves the player to Room below the current room if no wall");
	System.out.println("Up: Moves the player to Room above the current room if no wall");
	System.out.println("Take: Takes either a key or map from the room and places it in the player inventory");
	System.out.println("Open: Opens the Door if you Have a Key");
	System.out.println("Escape: Escape the Maze if the Door is Open");
	System.out.println("__________________________________________________");
	System.out.println("");
	System.out.println("Type \"Return\" and press Enter to return to the Maze");
	return;
	}
		
	// Use this to clear the screen taken from source: 	
	//  https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {  
	 System.out.print("\033[H\033[2J");  
	 System.out.flush();  
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
		
	public static void handleInput(String storeInput, Maze gameBoard, int moveCounter){
	
	return;	
	}
	
	
} // class ending brace
///////////////////////////////  END OF FILE //////////////////////////////////////////////////