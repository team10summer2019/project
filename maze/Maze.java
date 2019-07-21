//////////////////////////////////////////////
//
// File: Maze.java
// Description: Char Manager
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.01
// Revision Date: July 20, 2019
//
///////////////////////////////////////////////

import java.util.Random;
import java.util.ArrayList;

public class Maze {

////////////////////////////////// MEMBER VARIABLES ////////////////////////////////////////

private Player hero;
private Monster mazeWraith;
private Door door;

private ArrayList<Room> roomList ; // make an array list of rooms size 16 for a 4x4 maze as specified in the spec

private int mazeSize = 4;   // set this value to increase the number of rooms in the maze ( leave this as 4 ) 

////////////////////////  CONSTRUCTORS   ////////////////////////////////////////////////
	
	// default constructor 
	public Maze(){
	hero = new Player();
	mazeWraith = new Monster();
	door = new Door();
	roomList = new ArrayList<Room>(mazeSize*mazeSize);
	
	int counter = 0 ;
		for (int k = 0 ; k < mazeSize*mazeSize ; k++){
			if ( k > 0 && k % mazeSize == 0){ counter++ ;}
			roomList.add( new Room(k%mazeSize,counter,true,true,true,true) );
		}
	}

	// input constructor 
	public Maze(int size){
	mazeSize=size;
	hero = new Player();
	mazeWraith = new Monster();
	door = new Door();
	roomList = new ArrayList<Room>(mazeSize*mazeSize);
	
	int counter = 0 ;
		for (int k = 0 ; k < mazeSize*mazeSize ; k++){
			if ( k > 0 && k % mazeSize == 0){ counter++ ;}
			roomList.add( new Room(k%mazeSize,counter,true,true,true,true) );
		}
	}

///////////////////////   ACCESSORS     /////////////////////////////////////////////////

	public Player getHero(){
	Player temp = new Player(hero);
	return temp;
	}

	public Monster getMonster(){
	Monster temp = new Monster(mazeWraith) ;
	return temp;
	}
	
	public Door getDoor(){
	Door temp = new Door(door);
	return temp;
	}
	
	public Room getRoom( int k){
	Room temp = new Room( roomList.get(k));
	return temp;
	
	}
	
	
///////////////////////    MUTATORS     /////////////////////////////////////////////////
	
	public void setRoom(int k , boolean left, boolean right, boolean up, boolean down, boolean key, boolean door , boolean monster){
	
	Room temp = roomList.get(k);  // get the pointer to the room in list at index k
	
	temp.setRightWall(right);
	temp.setLeftWall(left);
	temp.setTopWall(up);
	temp.setBottomWall(down);
	
	temp.setHasKey(key);
	temp.setHasDoor(door);
	temp.setHasMonster(monster);
	
	}

	public void setRoom(int k , boolean inRoom){
	Room temp = roomList.get(k);  // get the pointer to the room in list at index k
	temp.setHasPlayer(inRoom);
	}


/////////////////////// CONSTRUCT MAZE //////////////////////////////////////////////////
	// do this in the game class 
	// use the setters and getters from maze to setup the maze 

///////////////////////    OTHER METHODS ///////////////////////////////////////////////////

//   
	// look at drawRoom for inspiration
	public void drawMaze() {
	
	
	
	return;
	
	}




// Use this to clear the screen taken from source: 	
//  https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {  
	 System.out.print("\033[H\033[2J");  
	 System.out.flush();  
	}  

} // end of class brace
////////////////////////////////   END OF FILE ////////////////////////////////////////////////
