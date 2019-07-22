//////////////////////////////////////////////
//
// File: Maze.java
// Description: Char Manager
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.02
// Revision Date: July 21, 2019
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
												
private Room currentRoom; // storage variable for the current room should point to the room in the list where hero is located 

private int mazeSize = 4;   // set this value to increase the number of rooms in the maze ( leave this as 4 ) 

////////////////////////  CONSTRUCTORS   ////////////////////////////////////////////////
	
	// default constructor 
	public Maze(){
	hero = new Player();
	mazeWraith = new Monster();
	door = new Door(1,0); // place a locked door at Location point (1,0) 
	roomList = new ArrayList<Room>(mazeSize*mazeSize);
	
	int counter = 0 ;
		for (int k = 0 ; k < mazeSize*mazeSize ; k++){
			if ( k > 0 && k % mazeSize == 0){ counter++ ;}
			roomList.add( new Room(k%mazeSize,counter,true,true,true,true) );
		}
	
	currentRoom = new Room(roomList.get(0));  // current room is the room at top of the maze
	
	
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
		
	currentRoom = new Room(roomList.get(0));  // current room is the room at top of the maze	
		
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
	
	public Room getRoom( Point p ){
	
	int index = p.getXCoordinate() + mazeSize*p.getYCoordinate();
	Room temp = new Room ( roomList.get(index) ) ;
	return temp;	
	}
	
	public Room getCurrentRoom(){
	Room temp = new Room( currentRoom);
	return temp;
	}
	
	
///////////////////////    MUTATORS     /////////////////////////////////////////////////
	
	public void setRoom(int k , boolean left, boolean right, boolean up, boolean down, boolean key, boolean door ,boolean map, boolean monster ){
	
	Room temp = roomList.get(k);  // get the pointer to the room in list at index k
	
	temp.setRightWall(right);
	temp.setLeftWall(left);
	temp.setTopWall(up);
	temp.setBottomWall(down);
	
	temp.setHasKey(key);
	temp.setHasDoor(door);
	temp.setHasMonster(monster);
	temp.setHasMap(map);
	
	return;
	}
	

	public void setRoom(int k , boolean inRoom){
	Room temp = roomList.get(k);  // get the pointer to the room in list at index k
	temp.setHasPlayer(inRoom); // set the player in the room
	return;
	}


	public void setCurrentRoom(int k ){
	currentRoom = roomList.get(k);  // get the pointer to the room in list at index k
	return;
	}
	
	public void setCurrentRoom(Point p){
	
	int index = p.getXCoordinate() + mazeSize*p.getYCoordinate();
	currentRoom = roomList.get(index);
	
	return;
	}
	
	// control variable room conditions
	public void setCurrentRoom(boolean key, boolean map, boolean monster){
	currentRoom.setHasKey(key);
	currentRoom.setHasMonster(monster);
	currentRoom.setHasMap(map);
	
	return;
	}

	// reset the booleans in the array list room 
	
	public void setRoom(int k , boolean key, boolean door ,boolean map, boolean monster ){
	
	Room temp = roomList.get(k);  // get the pointer to the room in list at index k

	temp.setHasKey(key);
	temp.setHasDoor(door);
	temp.setHasMonster(monster);
	temp.setHasMap(map);
	
	return;
	}	



/////////////////////     Motion Operations  ////////////////////////////////////////////

	/// NEED TO ADD INPUT VALIDATION to prevent over indexing past mazeSize = 4 (walls should stop it but still)

	public void moveLeft(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the left of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getLeftWall()){
		// update the hero's position
		hero.moveLeft();
		currentPosition = hero.getPosition();   // get hero's position
		setCurrentRoom(currentPosition);   // set the current room to be the hero's position
		} else {
		System.out.println("You can't go that way, there is a wall blocking your path");
		}
	return;	
	}
		
	public void moveRight(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = new Room(getRoom( currentPosition ));	
	// if there isn't a wall to the right of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getRightWall() ){
		// update the hero's position
		hero.moveRight();
		currentPosition = hero.getPosition();  
		setCurrentRoom(currentPosition);   // set the current room to be the hero's position
		} else {
		System.out.println("You can't go that way, there is a wall blocking your path");
		}
	return;	
	}
	
	public void moveUp(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the top of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getTopWall() ){
		// update the hero's position
		hero.moveUp();
		currentPosition = hero.getPosition();  
		setCurrentRoom(currentPosition);   // set the current room to be the hero's position
		} else {
		System.out.println("You can't go that way, there is a wall blocking your path");
		}
	return;	
	}
	
	public void moveDown(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the base of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getBottomWall() ){
		// update the hero's position
		hero.moveDown();
		currentPosition = hero.getPosition();  
		System.out.println(currentPosition.toString() );
		setCurrentRoom(currentPosition);   // set the current room to be the hero's position
		} else {
		System.out.println("You can't go that way, there is a wall blocking your path");
		}
	return;	
	}
	
/////////////////////     Item Operations  ////////////////////////////////////////////	
	
	public void takeKey(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a key but the player doesn't
		if (currentRoom.getHasKey() && !hero.getHasKey()){
		// give the player a key
		hero.setHasKey(true);
		// reset the room to not have a key
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasKey(false); // remove the key from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	public void takeMap(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a key but the player doesn't
		if (currentRoom.getHasMap() && !hero.getHasMap()){
		// give the player a key
		hero.setHasMap(true);
		// reset the room to not have a key
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasMap(false); // remove the key from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	public void unlockDoor(){

		if (hero.getHasKey()){
		door.setIsLocked(false);   // Unlock the door
		//setCurrentRoom(hero.getLocation());  // set currentRoom to point to the room with the door at current Location (checked in MazeGame) 
		// currentRoom.setHasDoor(false); // remove the door  ... maybe leave the door there   
		}
	
	return;
	}

	
///////////////////////    OTHER METHODS ///////////////////////////////////////////////////

      /*
	// look at drawRoom for inspiration
	public void drawMaze() {
	return;
	}
      */


} // end of class brace
////////////////////////////////   END OF FILE ////////////////////////////////////////////////
