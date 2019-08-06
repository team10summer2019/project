package GUIWithPuzzles;
//////////////////////////////////////////////
//
// File: Maze.java
// Description: Maze Class for maze game
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.04
// Revision Date: July 28, 2019
//
///////////////////////////////////////////////

import java.util.Random;
/*
import maze2.ComboLock;
import maze2.Point;
import maze2.Start;
*/
import java.util.ArrayList;

public class Maze {

////////////////////////////////// MEMBER VARIABLES ////////////////////////////////////////

private Player hero;
private Monster wraith;
private Door door;

 // private ArrayList<Room> roomList ; // make an array list of rooms size 16 for a 4x4 maze as specified in the spec

private Room roomList[][] ; // double array of rooms  
									
private Room currentRoom; // storage variable for the current room should point to the room in the list where hero is located 

private int mazeSize = 4;   // set this value to increase the number of rooms in the maze ( leave this as 4 ) 

////////////////////////  CONSTRUCTORS   ////////////////////////////////////////////////
	
	// default constructor 
	public Maze(){
	hero = new Player();
	wraith = new Monster();
	door = new Door(1,0); // place a locked door at Location point (1,0) 
	// roomList = new ArrayList<Room>(mazeSize*mazeSize);
	roomList = new Room[mazeSize][mazeSize];   // make a room list with double arrays 

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
	wraith = new Monster();
	door = new Door();

	//roomList = new ArrayList<Room>(mazeSize*mazeSize);
	
	roomList = new Room[mazeSize][mazeSize];   // make a room list with double arrays 
	
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
	Monster temp = new Monster(wraith) ;
	return temp;
	}
	
	public Door getDoor(){
	Door temp = new Door(door);
	return temp;
	}
	
	public Room getRoom( Point p ){
		
	Room temp = new Room (currentRoom);  // if point is out of bounds just return the current room  	
	
		if ( p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() <= mazeSize-1 && p.getXCoordinate() >=0  && p.getYCoordinate() >=0)
		{
		temp = new Room ( roomList[p.getXCoordinate()][p.getYCoordinate()]) ;  // make a copy return to temp and return temp
		} 	
	return temp;
			
	}
	
	// x,y coordinate version for input 
	public Room getRoom( int x , int y ){
		
	Room temp = new Room (currentRoom);  // if point is out of bounds just return the current room  	
	
		if ( x <= mazeSize-1 && y <= mazeSize-1 && x >=0  && y >=0)
		{
		temp = new Room ( roomList[x][y]) ;  // make a copy return to temp and return temp
		} 	
	return temp;
			
	}
	
	public Room getCurrentRoom(){
	
	currentRoom = getRoom(getHero().getPosition());
	Room temp = getRoom(getHero().getPosition());;  // copy construct and return the copy 
	return temp;
	}
	
	public int getMazeSize(){
	return mazeSize;
	}
	
///////////////////////    MUTATORS     /////////////////////////////////////////////////
	 
       /// point input version 
       public void setRoom(Point p, boolean left, boolean right, boolean up, boolean down, boolean key, boolean door ,boolean map, boolean monster ){
	
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
       
		}
	
	return;
	}
       
       
       // coordinate pair input version 
       	public void setRoom(int x,int y, boolean left, boolean right, boolean up, boolean down, boolean key, boolean door ,boolean map, boolean monster ){
	
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
       
		}
	
	return;
	}
       
       
       	// control variable room conditions
	public void setCurrentRoom(boolean key, boolean map, boolean monster){
	currentRoom.setHasKey(key);
	currentRoom.setHasMonster(monster);
	currentRoom.setHasMap(map);
	
	return;
	}

	// Point input to set the current room 
	public void setCurrentRoom(Point p){
	
	if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
        currentRoom = roomList[p.getXCoordinate()][p.getYCoordinate()];
	}
	
	return;
	}
	
	// Coordinate pair input to set the current room 
	public void setCurrentRoom(int x, int y){
	
	if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
        currentRoom = roomList[x][y];
	}
	
	return;
	}

	// coordinate pair input version of setRoomPlayer 
	public void setRoomPlayer(int x, int y , boolean inRoom){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		temp.setHasPlayer(inRoom); // set the player in the room
		}
	return;
	}
         
	// point input version of setRoomPlayer  
	public void setRoomPlayer(Point p , boolean inRoom){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		temp.setHasPlayer(inRoom); // set the player in the room
		}	
	return;
	}

	// coordinate pair input version of setRoomMonster 
	public void setRoomMonster(int x, int y , boolean inRoom){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		temp.setHasMonster(inRoom); // set the player in the room
		}
	return;
	}
         
	// point input version of setRoomMonster  
	public void setRoomMonster(Point p , boolean inRoom){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		temp.setHasMonster(inRoom); // set the player in the room
		}	
	return;
	}
	

	// reset the booleans in the array list room 
	public void setRoomItems(int x , int y,  boolean key, boolean door ,boolean map, boolean monster, boolean food, boolean riddle, boolean comboLock, boolean hint ){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y <= mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMap(map);
		temp.setHasMonster(monster);
		temp.setHasFood(food);
		temp.setHasRiddle(riddle);
		temp.setHasComboLock(comboLock);
		temp.setHasHint(hint);
		
		}
	
	return;
	}	

	// reset the booleans in the array list room 
	public void setRoomItems(Point p , boolean key, boolean door ,boolean map, boolean monster, boolean food ){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMonster(monster);
		temp.setHasMap(map);
		temp.setHasFood(food);
		
		}
	
	return;
	}	
	
	
	public void setRoomWalls(int x,int y, boolean left, boolean right, boolean up, boolean down){
	
	if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
	
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
       
		temp.setRightWall(right);
		temp.setLeftWall(left);
		temp.setTopWall(up);
		temp.setBottomWall(down);
		}
	
	return;
	}
	
	public void setRoomWalls(Point p, boolean left, boolean right, boolean up, boolean down){
	
	if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <=mazeSize-1) {
	
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
	
		temp.setRightWall(right);
		temp.setLeftWall(left);
		temp.setTopWall(up);
		temp.setBottomWall(down);

		}
	
	return;
	}
	
	
	public void copyHero(Player h){
	hero = new Player(h);
	return;
	}

	public void setPlayerLocation(int x , int y){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		hero.setPosition(x,y);
		}
	return;	
	}
	
	public void setPlayerLocation(Point p){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <=mazeSize-1) {
		hero.setPosition(p);
		}
	return;	
	}
	
	
	public void setMonsterLocation( int x, int y){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		wraith.setPosition(x,y);
		}
	return;
	}
	
	public void setMonsterLocation( Point p){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <=mazeSize-1) {
		wraith.setPosition(p);
		}
	return;
	}
	
	
	public void resetPlayerItems() {
	
	hero.setHasMap(false);
	hero.setHasKey(false);
	
	}
	
	public void setDoorLocation(int x , int y){
		if (x >=0 && x < mazeSize && y >=0 && y < mazeSize) {
		door.setLocation(x,y);
		}
	}
		
	public void setDoorLocation(Point p) {
		if (p.getXCoordinate() >=0 && p.getXCoordinate() < mazeSize && p.getYCoordinate() >=0 && p.getYCoordinate() < mazeSize) {
		door.setLocation(p.getXCoordinate(),p.getYCoordinate());
		}
	}


/////////////////////    Player Motion Operations  ////////////////////////////////////////////

	/// NEED TO ADD INPUT VALIDATION to prevent over indexing past mazeSize = 4 (walls should stop it but still)

	public void moveLeft(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the left of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getLeftWall()){
		// update the hero's position
		setRoomPlayer(currentPosition,false);
		hero.moveLeft();
		currentPosition = hero.getPosition();   // get hero's position
		setRoomPlayer(currentPosition,true);
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
		setRoomPlayer(currentPosition,false);
		hero.moveRight();
		currentPosition = hero.getPosition();  
		setRoomPlayer(currentPosition,true);
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
		setRoomPlayer(currentPosition,false);
		// update the hero's position
		hero.moveUp();
		currentPosition = hero.getPosition();  
		setRoomPlayer(currentPosition,true);
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
		setRoomPlayer(currentPosition,false);
		hero.moveDown();
		currentPosition = hero.getPosition();  
		System.out.println(currentPosition.toString() );
		setRoomPlayer(currentPosition,true);
		setCurrentRoom(currentPosition);   // set the current room to be the hero's position
		} else {
		System.out.println("You can't go that way, there is a wall blocking your path");
		}
	return;	
	}
	
	
/////////////////////    Monster Motion Operations  //////////////////////////////////////////////
	
	// NEED TO ADD INPUT VALIDATION to prevent over indexing past mazeSize (walls should stop it but still)

	public void moveMonsterLeft(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);	
	// if there isn't a wall to the left of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getLeftWall()){
		// update the monster's position
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveLeft();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
		
	return;	
	}
		
	public void moveMonsterRight(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);	
	// if there isn't a wall to the right of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getRightWall()  ){
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveRight();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
	return;	
	}
	
	public void moveMonsterUp(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);	
	// if there isn't a wall to the top of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getTopWall() ){
		// update the hero's position
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveUp();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
	return;	
	}
	
	public void moveMonsterDown(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);		
	// if there isn't a wall to the base of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getBottomWall() ){
		// update the hero's position
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveDown();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
	return;	
	}
	
	public void deleteMonster(){
	
	Point monsterPosition = wraith.getPosition(); // get the current position of the monster
	setRoomMonster(monsterPosition,false);  // remove the monster from the current room
	wraith.die();  // kill the wraith
	
	return;
	}
	
	
	public void deleteHero(){
	hero.die();  // kill the hero
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
	
	public void takeFood(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a map but the player doesn't
		if (currentRoom.getHasFood()){
		// Eat the food
		hero.addHealth(20); // add 20 health points
		// reset the room to not have a food item
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasFood(false); // remove the key from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	
	
	
	public void unlockDoor(){

		if (hero.getHasKey()){
		door.setIsLocked(false);   // Unlock the door
		//setCurrentRoom(hero.getLocation());  // set currentRoom to point to the room with the door at current Location (checked in MazeGame) 
		}
	
	return;
	}

	public void lockDoor(){
	door.setIsLocked(true);
	return;
	}
///////////////////////    OTHER METHODS ///////////////////////////////////////////////////

	// One turn of a fight with the player and the monster
	public void fightTurn() {	
		hero.attacks(wraith); // hero damages the wraith
		wraith.attacks(hero); // wraith damages the hero
	 return;
	}	
	// public void fightDialogue()
	//


} // end of class brace
////////////////////////////////   END OF FILE ////////////////////////////////////////////////
