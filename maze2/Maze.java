package maze2;
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

 // private ArrayList<Room> roomList ; // make an array list of rooms size 16 for a 4x4 maze as specified in the spec

private Room roomList[][] ; // double array of rooms  
									
private Room currentRoom; // storage variable for the current room should point to the room in the list where hero is located 

private int mazeSize = 4;   // set this value to increase the number of rooms in the maze ( leave this as 4 ) 

////////////////////////  CONSTRUCTORS   ////////////////////////////////////////////////
	
	// default constructor 
	public Maze(){
	hero = new Player();
	mazeWraith = new Monster();
	door = new Door(1,0); // place a locked door at Location point (1,0) 
	// roomList = new ArrayList<Room>(mazeSize*mazeSize);
	roomList = new Room[mazeSize][mazeSize];   // make a room list with double arrays 
	/*
	int counter = 0 ;
		for (int k = 0 ; k < mazeSize*mazeSize ; k++){
			if ( k > 0 && k % mazeSize == 0){ counter++ ;}
			roomList.add( new Room(k%mazeSize,counter,true,true,true,true) );
		}
	
	*/
	//currentRoom = new Room(roomList.get(0));  // current room is the room at top of the maze

	// construct the rooms in the double array 
		for (int i = 0; i < mazeSize; i ++ ){
			for (int j = 0; j < mazeSize; j++) {
			roomList[i][j]=new Room( i,j,true,true,true,true) ;   // room at location (i,j) with all walls on	
			}
		}
	currentRoom = roomList[0][0];  // point to the first room in the array
	}

	// input constructor 
	public Maze(int size){
	mazeSize=size;
	hero = new Player();
	mazeWraith = new Monster();
	door = new Door();

	//roomList = new ArrayList<Room>(mazeSize*mazeSize);
	
	roomList = new Room[mazeSize][mazeSize];   // make a room list with double arrays 
	
	
	/*
	int counter = 0 ;
		for (int k = 0 ; k < mazeSize*mazeSize ; k++){
			if ( k > 0 && k % mazeSize == 0){ counter++ ;}
			roomList.add( new Room(k%mazeSize,counter,true,true,true,true) );
		}
		
	currentRoom = new Room(roomList.get(0));  // current room is the room at top of the maze
	*/
		// construct the rooms in the double array 
		for (int i = 0; i < mazeSize; i ++ ){
			for (int j = 0; j < mazeSize; j++) {
			roomList[i][j]=new Room( i,j,true,true,true,true) ;   // room at location (i,j) with all walls on	
			}
		}
	
		currentRoom = roomList[0][0];  // set currentRoom to be the first room at location (0,0)	
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
	
	
	/*
	public Room getRoom( int k){
	Room temp = new Room( roomList.get(k));
	return temp;
	}
	
	public Room getRoom( Point p ){
	
	int index = p.getXCoordinate() + mazeSize*p.getYCoordinate();
	Room temp = new Room ( roomList.get(index) ) ;
	return temp;	
	}
	
	*/
	
	public Room getRoom( Point p ){
		
	Room temp = new Room (currentRoom);  // if point is out of bounds just return the curent room  	
	
		if ( p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() <= mazeSize-1 && p.getXCoordinate() >=0  && p.getYCoordinate() >=0)
		{
		temp = new Room ( roomList[p.getXCoordinate()][p.getYCoordinate()]) ;  // make a copy return to temp and return temp
		} 	
	return temp;
			
	}
	
	// x,y coordinate version for input 
	public Room getRoom( int x , int y ){
		
	Room temp = new Room (currentRoom);  // if point is out of bounds just return the curent room  	
	
		if ( x <= mazeSize-1 && y <= mazeSize-1 && x >=0  && y >=0)
		{
		temp = new Room ( roomList[x][y]) ;  // make a copy return to temp and return temp
		} 	
	return temp;
			
	}
	
	public Room getCurrentRoom(){
	Room temp = new Room( currentRoom);  // copy construct and return the copy 
	return temp;
	}
	
	
///////////////////////    MUTATORS     /////////////////////////////////////////////////
	
	/*
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
	
	// reset the booleans in the array list room 
	public void setRoom(int k , boolean key, boolean door ,boolean map, boolean monster ){
	
	Room temp = roomList.get(k);  // get the pointer to the room in list at index k

	temp.setHasKey(key);
	temp.setHasDoor(door);
	temp.setHasMonster(monster);
	temp.setHasMap(map);
	
	return;
	}	

       */
       
       
       /// point input version 
       public void setRoom(Point p, boolean left, boolean right, boolean up, boolean down, boolean key, boolean door ,boolean map, boolean monster, boolean riddle, boolean hint, boolean goat, boolean comboLock ){
	
	if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
	
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index (p.getYCoordinate(),p.getXCoordinate())
	
		temp.setRightWall(right);
		temp.setLeftWall(left);
		temp.setTopWall(up);
		temp.setBottomWall(down);
	
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMonster(monster);
		temp.setHasMap(map);
		temp.setHasRiddle(riddle);
		temp.setHasHint(hint);
		temp.setHasGoat(goat);
		temp.setHasComboLock(comboLock);
       
		}
	
	return;
	}
       
       
       // coordinate pair input version 
       	public void setRoom(int x,int y, boolean left, boolean right, boolean up, boolean down, boolean key, boolean door ,boolean map, boolean monster, boolean riddle, boolean hint, boolean goat, boolean comboLock ){
	
	if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
	
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
	
		temp.setRightWall(right);
		temp.setLeftWall(left);
		temp.setTopWall(up);
		temp.setBottomWall(down);
	
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMonster(monster);
		temp.setHasMap(map);
		temp.setHasRiddle(riddle);
		temp.setHasHint(hint);
        temp.setHasGoat(goat);
        temp.setHasComboLock(comboLock);
		}
	
	return;
	}
       
       
       	// control variable room conditions
	public void setCurrentRoom(boolean key, boolean map, boolean monster, boolean riddle, boolean hint, boolean goat, boolean comboLock){
	currentRoom.setHasKey(key);
	currentRoom.setHasMonster(monster);
	currentRoom.setHasMap(map);
	currentRoom.setHasRiddle(riddle);
	currentRoom.setHasHint(hint);
	currentRoom.setHasGoat(goat);
	currentRoom.setHasComboLock(comboLock);
	return;
	}


	public void setCurrentRoom(Point p){
	
	if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
        currentRoom = roomList[p.getXCoordinate()][p.getYCoordinate()];
	}
	
	return;
	}
	public void setCurrentRoom(int x, int y){
	
	if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
        currentRoom = roomList[x][y];
	}
	
	return;
	}

	// coordinate pair input version of set room 
	public void setRoom(int x, int y , boolean inRoom){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		temp.setHasPlayer(inRoom); // set the player in the room
		}
	return;
	}
         
	// point input version of set room  
	public void setRoom(Point p , boolean inRoom){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		temp.setHasPlayer(inRoom); // set the player in the room
		}	
	return;
	}

	// reset the booleans in the array list room 
	public void setRoom(int x , int y,  boolean key, boolean door ,boolean map, boolean monster, boolean riddle, boolean hint, boolean goat, boolean comboLock ){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMonster(monster);
		temp.setHasMap(map);
		temp.setHasRiddle(riddle);
		temp.setHasHint(hint);
		temp.setHasGoat(goat);
		temp.setHasComboLock(comboLock);
		
		}
	
	return;
	}	

	// reset the booleans in the array list room 
	public void setRoom(Point p , boolean key, boolean door ,boolean map, boolean monster, boolean riddle, boolean hint, boolean goat, boolean comboLock){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMonster(monster);
		temp.setHasMap(map);
		temp.setHasRiddle(riddle);
		temp.setHasHint(hint);
		temp.setHasGoat(goat);
		temp.setHasComboLock(comboLock);
		
		}
	
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
		// if the room has a map but the player doesn't
		if (currentRoom.getHasMap() && !hero.getHasMap()){
		// give the player a map
		hero.setHasMap(true);
		// reset the room to not have a map 
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
	 
	
	public void playRiddle(){													//HAINE KIM
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	Point firstRiddle = new Point(0,2);
	Point secondRiddle = new Point(2,3);
	boolean solved = false;
		// if the room has a riddle 
		if (currentRoom.getHasRiddle() && currentPosition.isEqual(firstRiddle)) {
		// give the player a riddle
			TestHaineRiddle rid = new TestHaineRiddle();
			solved = rid.riddleOne();
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			if (solved == true) {			//If the riddle has been solved
				currentRoom.setHasRiddle(false);
				System.out.println("The right wall disappeared to reveal a path..\n");
			}
			else {							//If riddle has not been solved
				currentRoom.setHasRiddle(true); // remove the key from the room	
			}
		}
		if (currentRoom.getHasRiddle() && currentPosition.isEqual(secondRiddle)) {
			// give the player a riddle
			TestHaineRiddle rid = new TestHaineRiddle();
			solved = rid.riddleTwo();
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			if (solved == true) {			//If the riddle has been solved
				currentRoom.setHasRiddle(false);
				System.out.println("The wall in front of you disappeared. You see a key in the distance...\n");
			}
			else {							//If riddle has not been solved
				currentRoom.setHasRiddle(true); // remove the key from the room	
			}
		}
		if (currentPosition.isEqual(firstRiddle)) {
			currentRoom.setRightWall(!solved);
		}
		if (currentPosition.isEqual(secondRiddle)) {
			currentRoom.setTopWall(!solved);
		}
		// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
		
	public void playTheRiverPuzzle() {
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a puzzle 
		if (currentRoom.getHasGoat() && !hero.getHasGoat()){
		RiverPuzzle play = new RiverPuzzle();
		boolean solved = play.playRiverPuzzle();
		// reset the room to not have a puzzle if it is solved
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		if (solved == true) {			//If the puzzle has been solved
		currentRoom.setHasGoat(false);
		System.out.println("\nThe wall to your left has vanished.\n");
		}
		else {							//If puzzle not solved
		currentRoom.setHasGoat(true); // keep the puzzle in the room	
		}
		currentRoom.setLeftWall(!solved);
		}
		// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}

	public void searchRoom() {
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );
	Point firstHints = new Point(0,1);
	Point secondHints = new Point(2,1);
	boolean leverOne = false;
	boolean leverTwo = false;
	// if room has hint(s)
	if (currentRoom.getHasHint() && currentPosition.isEqual(firstHints)) {	//If in first hint room
		Start hint = new Start();
		leverOne = hint.gameMenuOne();
		setCurrentRoom(currentPosition);	
	}
	if (leverOne == true) {
		hero.setHasLeverOne(leverOne);
	}
	if (currentRoom.getHasHint() && currentPosition.isEqual(secondHints)) {
		Start hint = new Start();
		leverTwo = hint.gameMenuTwo();
		setCurrentRoom(currentPosition);	
	}
	if (leverTwo == true) {
		hero.setHasLeverTwo(leverTwo);
	}
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	public void tryCombo() {
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );
		boolean allowProgress = hero.getHasLeverOne() && hero.getHasLeverTwo();
		boolean unlockedCombo = false;
		
		if (currentRoom.getHasComboLock()) {	//If in first hint room
			ComboLock lock = new ComboLock("7","2","8");
			lock.tryUnlock();
			unlockedCombo = lock.checkCombo();
			setCurrentRoom(currentPosition);	
		} 
		if (unlockedCombo == true && allowProgress == true) {
			System.out.println("You put together the two metal rods. It combines into a trusty lever.\nYou stick the lever into the hole in the wall, and it fits perfectly.");
			System.out.println("The wall vanishes once you pull the lever. You see a door far in the distance..");
			currentRoom.setHasComboLock(!allowProgress);
			currentRoom.setLeftWall(!allowProgress);
		}
	}	
		

	
///////////////////////    OTHER METHODS ///////////////////////////////////////////////////


} // end of class brace
////////////////////////////////   END OF FILE ////////////////////////////////////////////////
