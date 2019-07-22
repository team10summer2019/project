//////////////////////////////////////////////
//
// File: testMaze.java
// Description: MazeGame class with main() function
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 21, 2019
// Version: 0.02
// Revision Date: July 21, 2019
//
///////////////////////////////////////////////

import java.util.Scanner;
import java.util.Random;

public class testMaze {


	public static void main(String[] args){
		
	Maze gameBoard = new Maze(4);  // make a 4x4 room maze 
	setBoard(gameBoard);   // construct the maze 
	Player tempHero;  // temporary value to look at Hero stats
	Room tempRoom;    // temporary value to look at a room 
	String storeInput="";  // storage for user input
	int moveCounter = 0;  // count the number of moves

	gameBoard.setCurrentRoom(0); // reset the current room after setting up the board
	tempRoom = gameBoard.getCurrentRoom();  // set the tempRoom to be the current room at (0,0)
	
	// Main loop to run the Maze Game 
		while ( gameBoard.getDoor().getIsLocked() == true  && moveCounter < 100 && !storeInput.equalsIgnoreCase("quit")  ){
		
		// if user input was "MAP" display map unit until user types return
			if ( storeInput.equalsIgnoreCase("map") ) {
				while (!storeInput.equalsIgnoreCase("Return")) {	
				clearScreen();
				printMap();  // print the map
				storeInput = getUserInput();
				}
		        }
		// if user input was "HELP" display help unit unitl user types return
			if ( storeInput.equalsIgnoreCase("help") ) {
				while (!storeInput.equalsIgnoreCase("Return")) {	
				clearScreen();
				printHelp();  // print the map
				storeInput = getUserInput();
				}
		        }
			
			// if user input was "Next" 	
			if ( storeInput.equalsIgnoreCase("Next")){
			// increment the move counter to change the room
			tempRoom = gameBoard.getRoom(moveCounter % 16);
			moveCounter++;
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
					
		// clear the screen	
		clearScreen();
		
		// update the hero current condition
		tempHero = gameBoard.getHero();
		tempHero.displayStats();
		// set the room to cycle through all rooms in array list 
		
		tempRoom.drawRoom();
	        tempRoom.displayRoomStats();
		
		System.out.println("There have been " + moveCounter + " moves in the maze");
		
			if (!storeInput.equalsIgnoreCase("")){
			System.out.println("Your input was: " + storeInput);
			}
			
		// get user input
		storeInput = getUserInput();
		// pause until press enter
		// pressEnter();
		}  // closing brace for while loop

	return; 
	}// end of main function	
	
		// sets up the walls and items, doors and monsters
	public static void setBoard( Maze m){
	// setRoom( int room , left, right, up, down, key, door, map, monster)
	m.setRoom(0,true,true,true,false,false,false,false,false); // setup the first room 
	m.setRoom(0,true);  // place the player in the first room
	// room (0.1)   
	m.setRoom(1,true,false,true,true,false,true,false,false);
	// room (0,2)
	m.setRoom(2,false,false,true,true,false,false,false,true);
	// room (0,3)
	m.setRoom(3,false,true,true,false,false,false,false,false);
	// room (1,0)
	m.setRoom(4,true,true,false,false,false,false,false,false);
	// room (1,1)
	m.setRoom(5,true,false,true,false,false,false,false,false);
	// room (1,2)
	m.setRoom(6,false,false,true,true,false,false,false,false);
	// room (1,3)
	m.setRoom(7,false,true,false,false,false,false,false,false);
	// room (2,0)
	m.setRoom(8,true,false,false,true,false,false,false,false);
	// room (2,1)
	m.setRoom(9,false,true,false,true,false,false,false,false);
	// room (2,2)
	m.setRoom(10,true,true,true,false,true,false,false,false);
	// room (2,3)
	m.setRoom(11,true,true,false, false,false,false,false,false);
	// room (3,0)
	m.setRoom(12,true,false,true,true,false,false,true,false);
	// room (3,1)
	m.setRoom(13,false,true,false,true,false,false,false,false);
	// room (3,2)
	m.setRoom(14,true,false,false,true,false,false,false,false);
	// room (3,3)
	m.setRoom(15,false,true,false,true,false,false,false,false);	
	
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
	System.out.println("Welcome to the Maze, Commands are case insensitive. Here are the current Commands:");
	System.out.println("__________________________________________________");	
	System.out.println("Help : prints the usage commands");
	System.out.println("Quit : exits the maze");
	System.out.println("Return: if in map or help dialog this returns to the maze from a help window");
	System.out.println("Map: Prints out a static map version of the maze");
	System.out.println("Next: Moves the player to the next room in the list");
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
	System.out.println("<<<<Press Enter>>>>:");
	keyboard.nextLine();
	return;
	}
	
	
	public static void handleInput(String storeInput, Maze gameBoard, int moveCounter){
	
	return;	
	}
	
	
} // class ending brace
///////////////////////////////  END OF FILE //////////////////////////////////////////////////