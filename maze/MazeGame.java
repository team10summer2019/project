//////////////////////////////////////////////
//
// File: MazeGame.java
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

public class MazeGame {


	public static void main(String[] args){
		
	Maze gameBoard = new Maze(4);  // make a 4x4 room maze 
	setBoard(gameBoard);   // construct the maze 
	Player tempHero;  // temporary value to look at Hero stats
	Room tempRoom;    // temporary value to look at a room 
	String storeInput="";  // storage for user input
	int moveCounter = 0;  // count the number of moves


	// Main loop to run the Maze Game 
	
		while ( gameBoard.getDoor().getIsLocked() == true  && moveCounter < 50 && !storeInput.equalsIgnoreCase("quit")  ){
		clearScreen();
		
			if ( storeInput.equalsIgnoreCase("map") ) {
			printMap();  // print the map  
			}
		
		// update the hero current condition
		tempHero = gameBoard.getHero();
		tempHero.displayStats();
		// set the room to cycle through all rooms in array list 
		tempRoom = gameBoard.getRoom(moveCounter % 16);
		tempRoom.drawRoom();
	        tempRoom.displayRoomStats();
		moveCounter++;	
		System.out.println("There have been " + moveCounter + " moves in the maze");
		System.out.println("Your input was: " + storeInput);
		storeInput=getUserInput();
		}


	return; 
	}// end of main function	
	
		// sets up the walls and items, doors and monsters
	public static void setBoard( Maze m){
	// setRoom(int k , boolean left, boolean right, boolean up, boolean down, boolean key, boolean door , boolean monster)
	m.setRoom(0,true, true , true, false, false, false,false); // setup the first room 
	m.setRoom(0,true);  // place the player in the first room
	// room (0.1)   
	m.setRoom(1,true,false, true, true,false,true, false);
	// room (0,2)
	m.setRoom(2, false, false,true,true, false, false,false);
	// room (0,3)
	m.setRoom(3, false, true ,true,false, false, false,false);
	// room (1,0)
	m.setRoom(4, true, true ,false,false, false, false,false);
	// room (1,1)
	m.setRoom(5, true, false ,true,false, false, false,false);
	// room (1,2)
	m.setRoom(6, false, false ,true,true, false, false,false);
	// room (1,3)
	m.setRoom(7, false, true ,false,false, false, false,false);
	// room (2,0)
	m.setRoom(8, true, false ,false,true, false, false,false);
	// room (2,1)
	m.setRoom(9, false, true ,false,true, false, false,false);
	// room (2,2)
	m.setRoom(10, true, true ,true, false, true, false,false);
	// room (2,3)
	m.setRoom(11, true, true ,false, false,false, false,false);
	// room (3,0)
	m.setRoom(12, true, false ,true, true ,false, false,true);
	// room (3,1)
	m.setRoom(13, false, true , false, true ,false, false,false);
	// room (3,2)
	m.setRoom(14, true, false , false, true ,false, false,false);
	// room (3,3)
	m.setRoom(15, false, true , false, true ,false, false,false);	
	
	return;
	}
	
	public static void printMap(){
	System.out.println("You unfold the map from your pocket and take a look:");
	System.out.println("");	
	System.out.println("_____________________________");
	System.out.println("|      |      |      |      |");
	System.out.println("|  *   |  D                 |");
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
	//System.out.println("Press r and Enter to return to the Maze");
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
	
	
} // class ending brace
///////////////////////////////  END OF FILE //////////////////////////////////////////////////