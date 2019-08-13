package finalMaze;


import java.util.Random;
import java.util.ArrayList;

/**
Class Maze creates a Maze containing a hero of type Player, a wraith of type Monster, a door of type Door, a roomList a 2D Room Array of type Room.
The maze also contains a Room currentRoom to point to the current Room in the roomList, and an integer mazeSize defaulted to a 4x4 room maze.  

@author (Ron) Zorondras Rodriguez
@version 0.05
@since July 20, 2019
*/
public class Maze {

////////////////////////////////// MEMBER VARIABLES ////////////////////////////////////////

private Player hero;
private Monster wraith;
private Door door;

private Room roomList[][] ; // double array of rooms  								
private Room currentRoom; // storage variable for the current room should point to the room in the list where hero is located 
private int mazeSize = 4;   // set this value to increase the number of rooms in the maze ( leave this as 4 ) 

////////////////////////  CONSTRUCTORS   ////////////////////////////////////////////////
	
	// default constructor 
	/**
	Default constructor creates a hero,wraith,locked door, and a roomList of size mazeSize*mazeSize each with a Room with all walls on and no items.
	Additionally the currentRoom is set to the Room at location (0,0) or roomList[0][0].
	*/
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
	/**
	Input constructor takes input size as the maze size, creates a hero,wraith,locked door, and a roomList of size size*size each with a Room with all walls on and no items.
	Additionally the currentRoom is set to the Room at location (0,0) or roomList[0][0].
	@param size An integer specifying the size of the 2D array of Rooms, roomList will be size*size elements in a 2D array.
	*/
	public Maze(int size){
	mazeSize=size;
	hero = new Player();
	wraith = new Monster();
	door = new Door();

	roomList = new Room[mazeSize][mazeSize];   // make a room list with double arrays 
	
		// construct the rooms in the double array 
		for (int i = 0; i < mazeSize; i ++ ){
			for (int j = 0; j < mazeSize; j++) {
			roomList[i][j]=new Room( i,j,true,true,true,true) ;   // room at location (i,j) with all walls on	
			}
		}
	currentRoom = roomList[0][0];  // set currentRoom to be the first room at location (0,0)	
	}

	// Copy constructor 
	/**
	Copy constructor takes an input Maze toCopy and deep copies all members into the new Maze object.
	@param toCopy a Maze object to copy. 
	*/
	public Maze(Maze toCopy){
	mazeSize=toCopy.mazeSize;
	hero = new Player(toCopy.hero); // copy construct the hero from toCopy
	wraith = new Monster(toCopy.wraith); // copy construct the monster from toCopy
	door = new Door(toCopy.door); // copy construct the door from toCopy

	roomList = new Room[mazeSize][mazeSize];   // make a room list with double arrays of size mazeSize 
	
		// construct the rooms in the double array by copying the rooms from toCopy and copy constructing
		for (int i = 0; i < mazeSize; i ++ ){
			for (int j = 0; j < mazeSize; j++) {
			roomList[i][j]=new Room( toCopy.roomList[i][j]) ;   // room at location (i,j) with all walls on	
			}
		}
	// set currentRoom to be the same room that toCopy.currentRoom was pointing at.
	currentRoom = roomList[toCopy.currentRoom.getLocation().getXCoordinate()][toCopy.currentRoom.getLocation().getYCoordinate()] ;  
	}

///////////////////////   ACCESSORS     /////////////////////////////////////////////////


	/**
	Accessor to get a copy of the Player hero, returns a copy. 
	@return a copy of the hero object of type Player by copy construction. 
	*/
	public Player getHero(){
	Player temp = new Player(hero);
	return temp;
	}
	/**
	Accessor to get a copy of the Monster wraith, returns a copy. 
	@return a copy of the wraith object of type Monster by copy construction. 
	*/
	public Monster getMonster(){
	Monster temp = new Monster(wraith) ;
	return temp;
	}
	/**
	Accessor to get a copy of the Door object door, returns a copy. 
	@return a copy of the door object of type Door by copy construction. 
	*/
	public Door getDoor(){
	Door temp = new Door(door);
	return temp;
	}
	
	/**
	Accessor to get a copy of a Room in roomList at a particular point (x,y) location given an input Point p, returns a copy. 
	@param p A Point (x,y) location of type Point representing a Room in roomList at location (x,y)
	@return a copy of the Room object of located at Point p in the roomList by copy construction. 
	*/
	public Room getRoom( Point p ){
		
	Room temp = new Room (currentRoom);  // if point is out of bounds just return the current room  	
	
		if ( p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() <= mazeSize-1 && p.getXCoordinate() >=0  && p.getYCoordinate() >=0)
		{
		temp = new Room ( roomList[p.getXCoordinate()][p.getYCoordinate()]) ;  // make a copy return to temp and return temp
		} 	
	return temp;
			
	}
	
	// x,y coordinate version for input 
	/**
	Accessor to get a copy of a Room in roomList at a particular point (x,y) location given an input x and y in integer coordinate pair format, returns a copy. 
	@param x An integer x-coordinate of the Room in roomList at point (x,y)
	@param y An integer y-coordinate of the Room in roomList at point (x,y)
	@return a copy of the Room object of located at Point p in the roomList by copy construction. 
	*/
	public Room getRoom( int x , int y ){
		
	Room temp = new Room (currentRoom);  // if point is out of bounds just return the current room  	
	
		if ( x <= mazeSize-1 && y <= mazeSize-1 && x >=0  && y >=0)
		{
		temp = new Room ( roomList[x][y]) ;  // make a copy return to temp and return temp
		} 	
	return temp;
			
	}
	
	/**
	Accessor to get a copy of the Room in roomList that the Room pointer currentRoom is pointing too. Returns a copy. 
	@return a copy of the Room object in the roomList that currentRoom is pointing to using getRoom(). currentRoom should point to the location of the hero object.  
	*/
	public Room getCurrentRoom(){
	
	currentRoom = getRoom(getHero().getPosition());
	Room temp = getRoom(getHero().getPosition());;  // copy construct and return the copy 
	return temp;
	}
	
	public Room getPuzzleRoom(){
		currentRoom = getRoom(1,5);
		Room temp = getRoom(1,5);  // copy construct and return the copy 
		return temp;
		}
		
		public Room getFarmerRoom(){
			currentRoom = getRoom(1,3);
			Room temp = getRoom(1,3);  // copy construct and return the copy 
			return temp;
			}
		
	/**
	Accessor to get the integer size of the maze. returns mazeSize. 
	@return the integer value of mazeSize the size of the maze.  
	*/
	public int getMazeSize(){
	return mazeSize;
	}
	
///////////////////////    MUTATORS     /////////////////////////////////////////////////
	 
       /// point input version 
       	/**
	Mutator to set the walls and key items in a room. 
	@param p A Point location of the room to set up.
	@param left The value of the leftWall boolean in a Room.
	@param right The value of the rightWall boolean in a Room.
	@param up The value of the topWall boolean in a Room.
	@param down The value of the bottomWall boolean in a Room.
	@param key The value of the hasKey Key item boolean in a Room.
	@param map The value of the hasMap Map item boolean in a Room.
	@param monster The value of the hasMonster Monster object boolean in a Room.
	*/
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
        /**
	Mutator to set the walls and key items in a room. 
	@param x An integer x-coordinate location of the room to set up.
	@param y An integer y-coordinate location of the room to set up.
	@param left The value of the leftWall boolean in a Room.
	@param right The value of the rightWall boolean in a Room.
	@param up The value of the topWall boolean in a Room.
	@param down The value of the bottomWall boolean in a Room.
	@param key The value of the hasKey Key item boolean in a Room.
	@param door The value of the hasDoor dooritem boolean in a Room.
	@param map The value of the hasMap Map item boolean in a Room.
	@param monster The value of the hasMonster Monster object boolean in a Room.
	*/
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
	/**
	Mutator to set key items in the current Room. Seting Key,Map and Monster
	@param key The value of the hasKey Key item boolean in a Room.
	@param map The value of the hasMap Map item boolean in a Room.
	@param monster The value of the hasMonster Monster object boolean in a Room.
	*/
	public void setCurrentRoom(boolean key, boolean map, boolean monster){
	currentRoom.setHasKey(key);
	currentRoom.setHasMonster(monster);
	currentRoom.setHasMap(map);
	
	return;
	}

	// Point input to set the current room   Overloaded method 
	
	/**
	Mutator to set the room the currentRoom points to using Point p as location input.
	@param p A Point location of the Room to point currentRoom at
	*/
	public void setCurrentRoom(Point p){
	
	if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
        currentRoom = roomList[p.getXCoordinate()][p.getYCoordinate()];
	}
	
	return;
	}
	
	// Coordinate pair input to set the current room Overloaded method 
	/**
	Mutator to set the room the currentRoom points to using (x,y) integer inputs as location inputs.
	@param x An integer x-coordinate location of the Room to point currentRoom at.
	@param y An integer y-coordinate location of the Room to point currentRoom at.
	*/
	public void setCurrentRoom(int x, int y){
	
	if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
        currentRoom = roomList[x][y];
	}
	
	return;
	}

	// coordinate pair input version of setRoomPlayer 
	/**
	Mutator to set the Room at location (x,y) to have the hasPlayer room switched to value inRoom.  
	Set inRoom to true to put the player in the Room, false to remove player from Room.
	@param x An integer x-coordinate location of the Room to point currentRoom at.
	@param y An integer y-coordinate location of the Room to point currentRoom at.
	@param inRoom A boolean to indicate the presence of the hero in the room, true to place player in room, false to remove hero from room.
	*/
	public void setRoomPlayer(int x, int y , boolean inRoom){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		temp.setHasPlayer(inRoom); // set the player in the room
		}
	return;
	}
         
	// point input version of setRoomPlayer  
	/**
	Mutator to set the Room at location Point p to have the hasPlayer Room boolean switched to value inRoom.  
	Set inRoom to true to put the player in the Room, false to remove player from Room.
	@param p A Point location of the room to modify.
	@param inRoom A boolean to indicate the presence of the hero in the room, true to place player in room, false to remove hero from room.
	*/
	public void setRoomPlayer(Point p , boolean inRoom){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		temp.setHasPlayer(inRoom); // set the player in the room
		}	
	return;
	}

	// coordinate pair input version of setRoomMonster 
	/**
	Mutator to set the Room at location (x,y) to have the hasMonster Room boolean switched to value inRoom.  
	Set inRoom to true to put the wraith Monster in the Room, false to remove the wraith Monster from Room.
	@param x An integer x-coordinate location of the Room to point currentRoom at.
	@param y An integer y-coordinate location of the Room to point currentRoom at.
	@param inRoom A boolean to indicate the presence of the wraith Monster in the room, true to place the wraith Monster in room, false to remove the wraith from room.
	*/
	public void setRoomMonster(int x, int y , boolean inRoom){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		temp.setHasMonster(inRoom); // set the player in the room
		}
	return;
	}
         
	// point input version of setRoomMonster  
	/**
	Mutator to set the Room at location Point p to have the hasMonster room boolean switched to value inRoom.  
	Set inRoom to true to put the wraith Monster in the Room, false to remove the wraith Monster from Room.
	@param p A Point location of the room to modify.
	@param inRoom A boolean to indicate the presence of the wraith Monster in the room, true to place wraith Monster in room, false to remove the wraith Monster from room.
	*/
	public void setRoomMonster(Point p , boolean inRoom){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
		Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
		temp.setHasMonster(inRoom); // set the player in the room
		}	
	return;
	}
	

	// reset the booleans in the array list room 
	/**
	Mutator to set the room items Key,Door,Map,Monster,Food at an (x,y) room location in roomList.  
	@param x An integer x-coordinate location of the Room in roomList to set.
	@param y An integer y-coordinate location of the Room in roomList to set. 
	@param key A boolean representing the state of the hasKey Room boolean for the room at location (x,y)
	@param door A boolean representing the state of the hasDoor Room boolean for the room at location (x,y)
	@param map A boolean representing the state of the hasMap Room boolean for the room at location (x,y)
	@param monster A boolean representing the state of the hasMonster Room boolean for the room at location (x,y)
	@param food A boolean representing the state of the hasFood Room boolean for the room at location (x,y)
	@param riddle A boolean representing the state of the hasRiddle Room boolean for the room at location (x,y)
	@param hint A boolean representing the state of the hasHint Room boolean for the room at location (x,y)
	@param comboLock A boolean representing the state of the hasComboLock Room boolean for the room at location (x,y)
	*/
	public void setRoomItems(int x , int y,  boolean key, boolean door ,boolean map, boolean monster, boolean food, boolean riddle, boolean hint, boolean comboLock, boolean goat, boolean wolf, boolean cabbage ){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y <= mazeSize-1) {
		Room temp = roomList[x][y];  // get the pointer to the room in list at index k
		
		temp.setHasKey(key);
		temp.setHasDoor(door);
		temp.setHasMap(map);
		temp.setHasMonster(monster);
		temp.setHasFood(food);
		temp.setHasRiddle(riddle);
		temp.setHasHint(hint);
		temp.setHasComboLock(comboLock);
		temp.setHasGoat(goat);
		temp.setHasWolf(wolf);
		temp.setHasCabbage(cabbage);
		
		}
	
	return;
	}	

	// reset the booleans in the array list room 
		/**
		Mutator to set the room items Key,Door,Map,Monster,Food at a a Point p representing a room location in roomList.  
		@param p A Point coordinater location of the Room in roomList to set.
		@param key A boolean representing the state of the hasKey Room boolean for the room at location (x,y)
		@param door A boolean representing the state of the hasDoor Room boolean for the room at location (x,y)
		@param map A boolean representing the state of the hasMap Room boolean for the room at location (x,y)
		@param monster A boolean representing the state of the hasMonster Room boolean for the room at location (x,y)
		@param food A boolean representing the state of the hasFood Room boolean for the room at location (x,y)
		@param food A boolean representing the state of the hasFood Room boolean for the room at location (x,y)
		@param riddle A boolean representing the state of the hasRiddle Room boolean for the room at location (x,y)
		@param hint A boolean representing the state of the hasHint Room boolean for the room at location (x,y)
		@param comboLock A boolean representing the state of the hasComboLock Room boolean for the room at location (x,y)
		*/
		public void setRoomItems(Point p , boolean key, boolean door ,boolean map, boolean monster, boolean food, boolean riddle, boolean hint, boolean comboLock, boolean goat, boolean wolf, boolean cabbage ){
			if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <= mazeSize-1) {
			Room temp = roomList[p.getXCoordinate()][p.getYCoordinate()];  // get the pointer to the room in list at index k
			
			temp.setHasKey(key);
			temp.setHasDoor(door);
			temp.setHasMonster(monster);
			temp.setHasMap(map);
			temp.setHasFood(food);
			temp.setHasHint(hint);
			temp.setHasRiddle(riddle);
			temp.setHasComboLock(comboLock);
			temp.setHasGoat(goat);
			temp.setHasWolf(wolf);
			temp.setHasCabbage(cabbage);
			}
		
		return;
		}	
	
	
	
	
	// reset the booleans in the array list room 
	/**
	Mutator to set the room items Key,Door,Map,Monster,Food at a a Point p representing a room location in roomList.  
	@param p A Point coordinater location of the Room in roomList to set.
	@param key A boolean representing the state of the hasKey Room boolean for the room at location (x,y)
	@param door A boolean representing the state of the hasDoor Room boolean for the room at location (x,y)
	@param map A boolean representing the state of the hasMap Room boolean for the room at location (x,y)
	@param monster A boolean representing the state of the hasMonster Room boolean for the room at location (x,y)
	@param food A boolean representing the state of the hasFood Room boolean for the room at location (x,y)
	*/
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
	

	/**
	Mutator to set the room wall booleans leftWall,rightWall,topWall,bottomWall given an input coordinate pair (x,y) room location in roomList.  
	@param x An integer x-coordinate location of the Room in roomList to set.
	@param y An integer y-coordinate location of the Room in roomList to set. 
	@param left A boolean representing the state of the hasLeftWall Room boolean for the room at location (x,y)
	@param right A boolean representing the state of the hasRightWall Room boolean for the room at location (x,y)
	@param up A boolean representing the state of the hasTopWall Room boolean for the room at location (x,y)
	@param down A boolean representing the state of the hasBottomWall Room boolean for the room at location (x,y)
	*/
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
	
	/**
	Mutator to set the room wall booleans leftWall,rightWall,topWall,bottomWall given a Point location p in roomList.  
	@param p A Point coordinater location of the Room in roomList to set.
	@param left A boolean representing the state of the hasLeftWall Room boolean for the room at location (x,y)
	@param right A boolean representing the state of the hasRightWall Room boolean for the room at location (x,y)
	@param up A boolean representing the state of the hasTopWall Room boolean for the room at location (x,y)
	@param down A boolean representing the state of the hasBottomWall Room boolean for the room at location (x,y)
	*/
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
	
		
	/**
	Mutator to point the hero object in the maze to a copy of another input Player object.
	Used to copy over the previous player into the new level with the same player stats..  
	@param h A Player object to copy.
	*/
	public void copyHero(Player h){
	hero = new Player(h);
	return;
	}
	
	/**
	Mutator to set the Player object hero location given input integers x,y as a coordinate input pair.
	Used to reset player to a new starting location (maybe use to start in a random location in the maze each time).  
	@param x An integer x-coordinate.
	@param y An integer y-coordinate.	
	*/
	public void setPlayerLocation(int x , int y){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		hero.setPosition(x,y);
		}
	return;	
	}
	
	/**
	Mutator to set the Player object hero location given input Point p as a coordinate.
	Used to reset player to a new starting location (maybe use to start in a random location in the maze each time).  
	@param p A Point location to set the hero object location to.	
	*/
	public void setPlayerLocation(Point p){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <=mazeSize-1) {
		hero.setPosition(p);
		}
	return;	
	}
	
	/**
	Mutator to set the Monster object wraith location given input integers x,y as a coordinate input pair.
	Used to reset Monster to a new starting location (maybe use to start in a random location in the maze each time).  
	@param x An integer x-coordinate.
	@param y An integer y-coordinate.	
	*/
	public void setMonsterLocation( int x, int y){
		if ( x >= 0 && x <= mazeSize-1 && y >=0 && y<=mazeSize-1) {
		wraith.setPosition(x,y);
		}
	return;
	}
	
	/**
	Mutator to set the Monster object wraith location given input Point p as a coordinate.
	Used to reset Monster to a new starting location (maybe use to start in a random location in the maze each time).  
	@param p A Point location to set the Monster object location to.	
	*/
	public void setMonsterLocation( Point p){
		if ( p.getXCoordinate() >= 0 && p.getXCoordinate() <= mazeSize-1 && p.getYCoordinate() >=0 && p.getYCoordinate() <=mazeSize-1) {
		wraith.setPosition(p);
		}
	return;
	}

	/**
	Mutator to reset the Player object hero item Booleans for Map and Key, at the start of a new level.	
	*/
	public void resetPlayerItems() {
	
	hero.setHasMap(false);
	hero.setHasKey(false);
	hero.setHasLeverOne(false);
	hero.setHasLeverTwo(false);
	hero.setHasGoat(false);
	hero.setHasWolf(false);
	hero.setHasCabbage(false);
	
	}
	
	/**
	Mutator to reset the Player object hero item Booleans for Map and Key, at the start of a new level.	
	*/
	public void resetLevelTwoItems() {
	
	hero.setHasGoat(false);
	hero.setHasWolf(false);
	hero.setHasCabbage(false);
	
	}
	
	/**
	Mutator to set the Door object door location given input Point p as a coordinate.
	Used to set the Door to a new starting location (maybe use to start in a random location in the maze each time).  
	@param x An integer x-coordinate location to set the Door object location to.	
	@param y An integer y-coordinate location to set the Door object location to.
	*/
	public void setDoorLocation(int x , int y){
		if (x >=0 && x < mazeSize && y >=0 && y < mazeSize) {
		door.setLocation(x,y);
		}
	}
	
	/**
	Mutator to set the Door object door location given input Point p as a coordinate.
	Used to set the Door to a new starting location (maybe use to start in a random location in the maze each time).  
	@param p A Point location to set the Door object location to.	
	*/
	public void setDoorLocation(Point p) {
		if (p.getXCoordinate() >=0 && p.getXCoordinate() < mazeSize && p.getYCoordinate() >=0 && p.getYCoordinate() < mazeSize) {
		door.setLocation(p.getXCoordinate(),p.getYCoordinate());
		}
	}

	/**
	Mutator to set one character in a roomGrid in the current room. input is validated against the size of a roomGrid
	Use this method to reposition items in a room.   
	@param col  a column value in the room grid, must be < RoomCols.
	@param row  a row value in the room grid, must be < RoomRows.
	@param ch  a char character to change the value at (c,r) to in the roomGrid.
	*/
	public void setCurrentRoomGrid(int col , int row, char ch) {
		currentRoom.setRoomGrid(col,row,ch);	
		return;
	}
	
	
/////////////////////    Player Motion Operations  ////////////////////////////////////////////

	/**
	Mutator to move the Player object hero one room to the left if there is no wall.	
	*/
	public void moveLeft(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the left of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getLeftWall() && currentPosition.getXCoordinate() !=0 ){
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
		
	/**
	Mutator to move the Player object hero one room to the right if there is no wall.	
	*/
	public void moveRight(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = new Room(getRoom( currentPosition ));	
	// if there isn't a wall to the right of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getRightWall() && currentPosition.getXCoordinate() != mazeSize ){
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
	
	/**
	Mutator to move the Player object hero one room upwards if there is no wall.	
	*/
	public void moveUp(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the top of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getTopWall() && currentPosition.getYCoordinate() !=0 ){
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
	
	/**
	Mutator to move the Player object hero one room downwards if there is no wall.	
	*/
	public void moveDown(){
	
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
	// if there isn't a wall to the base of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !currentRoom.getBottomWall() && currentPosition.getYCoordinate() !=mazeSize ){
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


	/**
	Mutator to move the Monster object wraith one room to the left if there is no wall.	
	*/
	public void moveMonsterLeft(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);	
	// if there isn't a wall to the left of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getLeftWall() && monsterPosition.getXCoordinate() !=0 ){
		// update the monster's position
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveLeft();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
		
	return;	
	}
	
	/**
	Mutator to move the Monster object wraith one room to the right if there is no wall.	
	*/	
	public void moveMonsterRight(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);	
	// if there isn't a wall to the right of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getRightWall() && monsterPosition.getXCoordinate() !=mazeSize   ){
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveRight();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
	return;	
	}
	
	/**
	Mutator to move the Monster object wraith one room upwards if there is no wall.	
	*/	
	public void moveMonsterUp(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);	
	// if there isn't a wall to the top of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getTopWall() && monsterPosition.getYCoordinate() !=0 ){
		// update the hero's position
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveUp();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
	return;	
	}
	
	/**
	Mutator to move the Monster object wraith one room downwards if there is no wall.	
	*/	
	public void moveMonsterDown(){
	
	Point monsterPosition = wraith.getPosition();
	Room monsterRoom = getRoom(monsterPosition);		
	// if there isn't a wall to the base of the current room
	// get the hero's position and use it to set the currentRoom
		if ( !monsterRoom.getBottomWall() && monsterPosition.getYCoordinate() !=mazeSize  ){
		// update the hero's position
		setRoomMonster(monsterPosition,false);  // remove the monster from the current room
		wraith.moveDown();  // monster updates it's location by moving left 
		monsterPosition = wraith.getPosition();   // get monster's new position
		setRoomMonster(monsterPosition,true);   // set the current room to be the hero's position
		} 
	return;	
	}
	
	
	/**
	Mutator to kill the monster and delete it from the maze, setting the Room boolean HasMonster to false.	
	*/	
	public void deleteMonster(){
	
	Point monsterPosition = wraith.getPosition(); // get the current position of the monster
	setRoomMonster(monsterPosition,false);  // remove the monster from the current room
	wraith.die();  // kill the wraith
	
	return;
	}
	
	/**
	Mutator to kill the hero.  Indirect access since hero is private.	
	*/
	public void deleteHero(){
	hero.die();  // kill the hero
	return;
	}
	
	
	
/////////////////////     Item Operations  ////////////////////////////////////////////	
	
	
	/**
	Mutator to place the Key from a room with the hero and remove the Key from the current room.	
	*/
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
	
	/**
	Mutator to place the Key from a room with the hero and remove the Key from the current room.	
	*/
	public void takeLeverOne(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a key but the player doesn't
		if (!hero.getHasLeverOne()){
		// give the player a key
		hero.setHasLeverOne(true);
		// reset the room to not have a key
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	public void takeLeverTwo(){
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );	
			// if the room has a key but the player doesn't
			if (!hero.getHasLeverTwo()){
			// give the player a key
			hero.setHasLeverTwo(true);
			// reset the room to not have a key
			}
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/**
	Mutator to place the Goat from a room with the hero and remove the Goat from the current room.	
	*/
	public void takeGoat(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a Goat but the player doesn't
		if (!hero.getHasGoat()){
		// give the player a Goat
		hero.setHasGoat(true);
		// reset the room to not have a Goat 
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasGoat(false); // remove the Goat from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	/**
	Mutator to place the Wolf from a room with the hero and remove the Wolf from the current room.	
	*/
	public void takeWolf(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a Wolf but the player doesn't
		if (!hero.getHasWolf()){
		// give the player a Wolf
		hero.setHasWolf(true);
		// reset the room to not have a Wolf 
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasWolf(false); // remove the Wolf from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	/**
	Mutator to place the Cabbage from a room with the hero and remove the Cabbage from the current room.	
	*/
	public void takeCabbage(){
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a Cabbage but the player doesn't
		if (!hero.getHasCabbage()){
		// give the player a Cabbage
		hero.setHasCabbage(true);
		// reset the room to not have a Cabbage 
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasCabbage(false); // remove the Cabbage from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	/**
	Mutator to take another object and place the Goat that the player has back into the room.
	*/
	public void putGoat(){
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );	
			// if the player has a goat
			if (hero.getHasGoat()){
			// take away the goat
			hero.setHasGoat(false);
			// change the goat with another item in the room
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			currentRoom.setHasGoat(true); // put the goat into the room
			}
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/**
	Mutator to take another object and place the Wolf that the player has back into the room.
	*/
	public void putWolf(){
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );	
			// if the player has a wolf
			if (hero.getHasWolf()){
			// put down the wolf
			hero.setHasWolf(false);
			// reset the room to have a wolf
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			currentRoom.setHasWolf(true); // remove the Wolf from the room	
			}
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/**
	Mutator to take another object and place the Cabbage that the player has back into the room.
	*/
	public void putCabbage(){
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );	
			// if the hero has a cabbage
			if (hero.getHasCabbage()){ 
			// put down the cabbage
			hero.setHasCabbage(false);
			// reset the room to have cabbage
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			currentRoom.setHasCabbage(true); // place the cabbage into to room
			}
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/**
	Mutator to reset all.
	*/
	public void resetAll(){
		Point currentPosition = hero.getPosition();
		moveUp();
		moveUp();
		moveUp();
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasGoat(false); // remove the Goat from the room	
		setCurrentRoom(currentPosition);
		currentRoom.setHasWolf(false);
		setCurrentRoom(currentPosition);
		currentRoom.setHasCabbage(false);
		moveDown();
		moveDown();
		moveDown();	
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/** 
	Mutator to reset the Wolf, cabbage, goat.
	*/
	public void resetPuzzle(){
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );	
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasWolf(true); // put the Wolf into the room
		currentRoom.setHasGoat(true); // put the goat into the room
		currentRoom.setHasCabbage(true); // put the Cabbage into the room
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/**
	Mutator to take drop either goat, wolf or cabbage that is in the player inventory.
	*/
	public void dropObject(){
		Point currentPosition = hero.getPosition();
		currentRoom = getRoom( currentPosition );	
			// if the hero has a cabbage
			if (hero.getHasCabbage()){ 
			// put down the cabbage
			hero.setHasCabbage(false);
			// reset the room to have cabbage
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			currentRoom.setHasCabbage(true); // place the cabbage into to room
			}
			// if the player has a wolf
			else if (hero.getHasWolf()){
			// put down the wolf
			hero.setHasWolf(false);
			// reset the room to have a wolf
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			currentRoom.setHasWolf(true); // remove the Wolf from the room	
			}
			// if the player has a goat
			else if (hero.getHasGoat()){
			// take away the goat
			hero.setHasGoat(false);
			// change the goat with another item in the room
			setCurrentRoom(currentPosition); // point current room to the room in roomList 
			currentRoom.setHasGoat(true); // put the goat into the room
			}
		// restore the pointer away from the roomList;
		currentRoom = getRoom( currentPosition );
		return;
		}
	
	/**
	Mutator to place the Map from a room with the hero and remove the Map from the current room.	
	*/
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
	
	
	/**
	Mutator to consume the Food from the current Room and remove the Food from the current room.	
	*/
	public void takeFood(){
	
	int foodPoints=20;
	Point currentPosition = hero.getPosition();
	currentRoom = getRoom( currentPosition );	
		// if the room has a map but the player doesn't
		if (currentRoom.getHasFood()){
		// Eat the food
		hero.addHealth(foodPoints); // add 20 health points
		// reset the room to not have a food item
		setCurrentRoom(currentPosition); // point current room to the room in roomList 
		currentRoom.setHasFood(false); // remove the key from the room	
		}
	// restore the pointer away from the roomList;
	currentRoom = getRoom( currentPosition );
	return;
	}
	
	
	
	/**
	Mutator to unlock the Door boolean in the Door object door.	
	*/
	public void unlockDoor(){

		if (hero.getHasKey()){
		door.setIsLocked(false);   // Unlock the door
		//setCurrentRoom(hero.getLocation());  // set currentRoom to point to the room with the door at current Location (checked in MazeGame) 
		}
	
	return;
	}
	/**
	Mutator to lock the Door boolean in the Door object door.	
	*/
	public void lockDoor(){
	door.setIsLocked(true);
	return;
	}
///////////////////////    OTHER METHODS ///////////////////////////////////////////////////

	// One turn of a fight with the player and the monster
	/**
	Method to have the hero attack the monster and the monster attack the hero in a Fight Turn.	
	*/
	public void fightTurn() {	
		hero.attacks(wraith); // hero damages the wraith
		wraith.attacks(hero); // wraith damages the hero
	 return;
	}	


} // end of class brace
////////////////////////////////   END OF FILE ////////////////////////////////////////////////
