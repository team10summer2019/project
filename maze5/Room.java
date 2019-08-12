
//////////////////////////////////////////////
//
// File: Room.java
// Description: Room class for the maze
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.03
// Revision Date: August 05, 2019
//
///////////////////////////////////////////////

// Room:  Attributes: (x,y) point location, Booleans: leftWall, bottomWall, rightWall, topWall,
//			hasMonster, hasKey, hasDoor, leftDoor, topDoor, rightDoor, bottomDoor
//	Methods:    displaySearch()



/**
Class Room creates a Room with a Point location, health, and booleans having left,right,topm, and bottom walls.  
A room also contains booleans for the presence or absence of a Monster,Player,Key,Door,Map,Food,Riddle,Books,ComboLock,Goat.
it gives a integer 0-4 for door position inside a room (currently not used), a RoomGrid 2D char array to store a text based character representation or the room,
and constants for the printing widith of a room, and the number of rows and columns in a room grid.  This class is used in a 2D Room array in the class Maze.java. 
 
@author (Ron) Zorondras Rodriguez
@version 0.03
@since July 20, 2019
*/
public class Room {

/////////////////////////// MEMBER VARIABLES ///////////////////////////////////////////

private Point location; 

private boolean leftWall;
private boolean rightWall;
private boolean topWall;
private boolean bottomWall;

private boolean hasMonster;
private boolean hasKey;
private boolean hasDoor;
private boolean hasPlayer;
private boolean hasMap;
private boolean hasRiddle;
private boolean hasBooks;
private boolean hasComboLock;
private boolean hasGoat;
private boolean hasFood;

private int doorPosition;

private char [][] roomGrid ; //  char 2D array for playing characters in a room 

private final int roomWidth=6;  // used in drawing routines

private int roomCols=8;  //  width of a room
private int roomRows=6;  // height of a room 

//////////////////////////   CONSTRUCTORS ///////////////////////////////////////////////
	
	
	// default constructor
	/**
	Default constructor sets the location to Point (0,0), all walls on, and no items, with door position at 0.
	Additionally a new empty room grid is populated with characters representing the wall and item status.
	*/
	public Room(){
	
	 location = new Point();  // floating in space
	 
	 leftWall=true;
	 rightWall=true;
	 topWall=true;
	 bottomWall=true;

	 hasMap = false;
	 hasMonster=false;
	 hasKey=false;
	 hasPlayer=false;
	 hasRiddle = false;
	 hasBooks = false;
	 hasComboLock =false;
	 hasGoat = false;
	 hasFood = false;
	 
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
 	
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid  
	
	 populateRoomGrid();
	
	}
	
	// shape input constructor // change other variables with setters 
	/**
	Point and wall input constructor sets the location to Point local, and with input arguments for each wall.
	Additionally a new empty room grid is populated with characters representing the wall and item status.
	All other itmes are defaulted to false, and door position to 0. RoomGrid is populated.
	@param locale a Point location for the room
	@param left a boolean for the left wall, true if left wall is in place,
	@param right a boolean for the right wall,
	@param top a boolean for the top wall
	@param bottom a boolean for the bottom wall
	*/
	public Room (Point locale, boolean left, boolean right, boolean top, boolean bottom){
	 location = new Point (locale);
	
	 leftWall=left; 
	 rightWall=right;
	 topWall=top;
	 bottomWall=bottom;

	 hasMap = false;
	 hasMonster=false;
	 hasKey=false;
	 hasPlayer=false;
	 hasRiddle = false;
	 hasBooks = false;
	 hasComboLock =false;
	 hasGoat = false;
	 hasFood = false; 
	
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
	 
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid  
	 populateRoomGrid();
	 
	 
	}
	
	//input constructor // change other variables with setters 
	/**
	coordinate x, and y location and wall input constructor sets the location to Point local, and with input arguments for each wall.
	Additionally a new empty room grid is populated with characters representing the wall and item status.
	All other itmes are defaulted to false, and door position to 0. RoomGrid is populated.
	@param x an integer x-coordinate for the Room
	@param y an integer y-coordinate for the Room 
	@param left a boolean for the left wall, true if left wall is in place,
	@param right a boolean for the right wall,
	@param top a boolean for the top wall
	@param bottom a boolean for the bottom wall
	*/
	public Room (int x, int y, boolean left, boolean right, boolean top, boolean bottom){
	 location = new Point (x,y);
	 	
	 leftWall=left;
	 rightWall=right;
	 topWall=top;
	 bottomWall=bottom;

	 hasMap = false;
	 hasMonster=false;
	 hasKey=false;
	 hasPlayer=false;
	 hasRiddle = false;
	 hasBooks = false;
	 hasComboLock =false;
	 hasGoat = false;
	 hasFood = false;
	 
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
	
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid   
	 populateRoomGrid();
	 
	}
	
	
	// copy constructor 
	/**
	Copy Constructor with Room input toCopy, deep copies all Room variables over to new instance.
	Additionally the RoomGrid is re-populated after copy due to some bug.
	@param toCopy a Room variable to copy into the curent instance member wise. (Deep Copy).
	*/
	public Room ( Room toCopy){
	
	 location = new Point ( toCopy.location);
	
	 leftWall=toCopy.leftWall;
	 rightWall=toCopy.rightWall;
	 topWall=toCopy.topWall;
	 bottomWall=toCopy.bottomWall;
	 hasMonster=toCopy.hasMonster;
	 hasKey=toCopy.hasKey;
	 hasMap=toCopy.hasMap;
	 hasPlayer=toCopy.hasPlayer;
	 hasDoor=toCopy.hasDoor;
	 hasRiddle=toCopy.hasRiddle;
	 hasBooks =toCopy.hasBooks;
	 hasComboLock = toCopy.hasComboLock;
	 hasGoat = toCopy.hasGoat;
	 hasFood = toCopy.hasFood;
	 doorPosition=toCopy.doorPosition; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
	 
	 roomCols = toCopy.roomCols;
	 roomRows = toCopy.roomRows ;
	
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid  
		// copy the elements of the room over 
		for (int i = 0 ; i < roomCols ; i++){
			for( int j =0 ; j < roomRows; j++){
			roomGrid[i][j] = toCopy.roomGrid[i][j];
			}
		}
	 
	 populateRoomGrid();  // don't trust the copy, repopulate the grid // not having this caused a hard to find/ fix bug.
	 
	}
	
/////////////////////////  ACCESSORS //////////////////////////////////////////////////
	
	/**
	Accessor to get the status of the left wall. Returns true if leftWall is on false otherwise.
	@return a boolean representing the state of the left wall. 
	*/
	public boolean getLeftWall(){
	return leftWall;
	}
	/**
	Accessor to get the status of the right wall. Returns true if rightWall is on false otherwise.
	@return a boolean representing the state of the right wall. 
	*/
	public boolean getRightWall(){
	return rightWall;
	}
	/**
	Accessor to get the status of the Top wall. Returns true if topWall is on false otherwise.
	@return a boolean representing the state of the Top wall. 
	*/
	public boolean getTopWall(){
	return topWall;
	}
	/**
	Accessor to get the status of the Bottom wall. Returns true if bottomWall is on false otherwise.
	@return a boolean representing the state of the Bottom wall. 
	*/
	public boolean getBottomWall(){
	return bottomWall;
	}
	/**
	Accessor to get the status of the hasPlayer indicating the presence of the Player object in the room. 
	Returns true if the room has the player in it and false otherwise.
	@return a boolean representing the state of whether the player is in the room or not. 
	*/
	public boolean getHasPlayer(){
	return hasPlayer;
	}
	/**
	Accessor to get the status of the hasMonster indicating the presence of the Monster object in the room. 
	Returns true if the room has the Monster in it and false otherwise.
	@return a boolean representing the state of whether the Monster is in the room or not. 
	*/
	public boolean getHasMonster(){
	return hasMonster;
	}
	
	/**
	Accessor to get the status of the hasKey indicating the presence of the Key item in the room. 
	Returns true if the room has the key in it and false otherwise.
	@return a boolean representing the state of whether the Key is in the room or not. 
	*/
	public boolean getHasKey(){
	return hasKey;
	}
	
	/**
	Accessor to get the status of the hasMap indicating the presence of the Map item in the room. 
	Returns true if the room has the Map in it and false otherwise.
	@return a boolean representing the state of whether the Map is in the room or not. 
	*/
	public boolean getHasMap(){
	return hasMap;
	}
	
	/**
	Accessor to get the status of the hasFood indicating the presence of the Food item in the room. 
	Returns true if the room has the Food item in it and false otherwise.
	@return a boolean representing the state of whether the Food item is in the room or not. 
	*/
	public boolean getHasFood(){
	return hasFood;
	}
	
	/**
	Accessor to get the status of the hasDoor indicating the presence of the Door item in the room. 
	Returns true if the room has the Door object in it and false otherwise.
	@return a boolean representing the state of whether the Door object is in the room or not. 
	*/
	public boolean getHasDoor(){
	return hasDoor;
	}
	
	/**
	Accessor to get the status of the Door Position integer indicating the placement of the Door in the room.
	Will be used to plot the door in different spots inside of a room. Not currently used.  
	Returns an integer 0-4 representing Door placement 0 in center, 1 left, 2 right, 3 top, 4 bottom.
	@return An integer 0-4 representing Door placement 0 in center, 1 left, 2 right, 3 top, 4 bottom. 
	*/
	public int getDoorPosition(){
	return doorPosition;
	}
	
	/**
	Accessor to get the status of the hasRiddle boolean indicating the presence of a Riddle object in the Room. 
	Returns true if the room has the Riddle object in it and false otherwise.
	@return a boolean representing the state of whether the Riddle object is in the room or not. 
	*/
	public boolean getHasRiddle(){
	return hasRiddle;
	}
	
	/**
	Accessor to get the status of the hasBooks boolean indicating the presence of a Book (Anagram Game) object in the Room. 
	Returns true if the room has the Book object in it and false otherwise.
	@return a boolean representing the state of whether the Book object is in the room or not. 
	*/
	public boolean getHasBooks(){
	return hasBooks;
	}
	
	/**
	Accessor to get the status of the hasComboLock boolean indicating the presence of a ComboLock object in the Room. 
	Returns true if the room has the ComboLock object in it and false otherwise.
	@return a boolean representing the state of whether the ComboLock object is in the room or not. 
	*/
	public boolean getHasComboLock(){
	return hasComboLock;
	}	
	
	/**
	Accessor to get the status of the hasGoat boolean indicating the presence of a Goat object (RiverPuzzle) in the Room. 
	Returns true if the Room has the Goat object in it and false otherwise.
	@return a boolean representing the state of whether the Goat object is in the room or not. 
	*/
	public boolean getHasGoat(){
	return hasBooks;
	}
	
	
	/**
	Accessor to get a Point location of the Room. Returns a copy of the room location point. 
	@return A Point containing a copy of the Room Location point. 
	*/
	public Point getLocation(){
	Point temp = location.getPoint(); 
	return temp;	
	}

	/**
	Accessor to get the iteger value of RoomWidth, which is set as a constant. 
	@return An integer representing the RoomWidth print spacing constant. 
	*/
	public int getRoomWidth(){
	return roomWidth;	
	}
	
	/**
	Accessor to get the number of Rows in a RoomGrid 2D char array. 
	@return An integer representing the number of Rows in a RoomGrid 2D char array used for storing wall and item characters for print out.
	*/
	public int getRoomRows(){
	return roomRows;	
	}
	
	/**
	Accessor to get the number of Columns in a RoomGrid 2D char array. 
	@return An integer representing the number of Columns in a RoomGrid 2D char array used for storing wall and item characters for print out.
	*/
	public int getRoomCols(){
	return roomCols;	
	}
	
	/**
	Accessor to get a copy of the RoomGrid 2D char array.  
	@return A copy of the 2D char array representd by RoomGrid, containing characters representing the wall and items for print out.
	*/
	public char[][] getRoomGrid(){
	/// make a copy holder
	populateRoomGrid(); // make sure the room grid is populated before you return it
	
	char[][] temp = new char[roomCols][roomRows];
		// copy the current room grid into 
		for (int i = 0 ; i < roomCols ; i++){
			for( int j =0 ; j < roomRows ; j++){
			temp[i][j] = roomGrid[i][j];
			}
		}	
	// return the reference to the copy
	return temp;
	} 
	
//////////////////////////   MUTATORS /////////////////////////////////////////////////////
	
	/**
	Mutator to set the location of a Room on x,y integer coordinate input.  
	@param x An integer x-coordinate for the Room location.
	@param y An integer y-coordinate for the Room location.
	*/
	public void setLocation(int x, int y){
	location.setXCoordinate(x);
	location.setYCoordinate(y);
	return;	
	}
	/**
	Mutator to set the location of a Room on Point (x,y) coordinate input.  
	@param p A point location for the Room location.
	*/
	public void setLocation(Point p){
	location.setXCoordinate(p.getXCoordinate());
	location.setYCoordinate(p.getYCoordinate());
	return;	
	}
	/**
	Mutator to set the state of the leftWall boolean.  
	@param value a boolean setting the state of the leftWall, true for left wall on, false for off.
	*/
	public void setLeftWall(boolean value){
	leftWall=value;
	return;
	}
	/**
	Mutator to set the state of the rightWall boolean.  
	@param value a boolean setting the state of the rightWall, true for right wall on, false for off.
	*/
	public void setRightWall(boolean value){
	rightWall=value;
	return;
	}
	
	/**
	Mutator to set the state of the topWall boolean.  
	@param value a boolean setting the state of the topWall, true for Top wall on, false for off.
	*/
	public void setTopWall(boolean value){
	topWall=value;
	return;
	}
	
	/**
	Mutator to set the state of the bottomWall boolean.  
	@param value a boolean setting the state of the bottomWall, true for Top wall on, false for off.
	*/
	public void setBottomWall(boolean value){
	bottomWall=value;
	return;
	}
	
	/**
	Mutator to set the state of the hasPlayer boolean.  
	@param value a boolean setting the state of the bottomWall, true if the room has a player, false for no player in the room.
	*/
	public void setHasPlayer(boolean value){
	hasPlayer=value;
	return;
	}
	
	/**
	Mutator to set the state of the hasMonster boolean.  
	@param value a boolean setting the state of the hasMonster, true if the room has a Monster , false if not.
	*/
	public void setHasMonster(boolean value){
	hasMonster=value;
	return;
	}	
	
	/**
	Mutator to set the state of the hasKey boolean.  
	@param value a boolean setting the state of the hasKey, true if the room has a Key item, false if not.
	*/
	public void setHasKey(boolean value){
	hasKey = value;
	return;
	}
	
	/**
	Mutator to set the state of the hasMap boolean.  
	@param value a boolean setting the state of the hasMap, true if the room has a Map item, false if not.
	*/
	public void setHasMap(boolean value){
	hasMap = value;
	return;
	}
	
	/**
	Mutator to set the state of the hasDoor boolean.  
	@param value a boolean setting the state of the hasDoor, true if the room has a Door item, false if not.
	*/
	public void setHasDoor( boolean value){
	hasDoor = value;
	return;
	}
		
	/**
	Mutator to set the doorPosition integer variable, 0 center, 1 right, 2 left, 3 top, 4 bottom.  
	@param value to set the doorPosition integer variable, 0 center, 1 right, 2 left, 3 top, 4 bottom.  
	*/
	public void setDoorPosition(int value){
		if (value <=4 && value >= 0){
		doorPosition=value;
		}
	return;
	}

	/**
	Mutator to set the state of the hasRiddle boolean.  
	@param value a boolean setting the state of the hasRiddle, true if the room has a Riddle item, false if not.
	*/
	public void setHasRiddle(boolean value){
	hasRiddle = value;
	return;
	}

	/**
	Mutator to set the state of the hasBooks boolean.  
	@param value a boolean setting the state of the hasBooks, true if the room has a Book item, false if not.
	*/
	public void setHasBooks(boolean value){
	hasBooks = value;
	return;
	}

	/**
	Mutator to set the state of the hasComboLock boolean.  
	@param value a boolean setting the state of the hasComboLock, true if the room has a ComboLock item and Object, false if not.
	*/
	public void setHasComboLock(boolean value){
	hasComboLock = value;
	return;
	}

	/**
	Mutator to set the state of the hasGoat boolean.  
	@param value a boolean setting the state of the hasGoat, true if the room has a Goat item and Object, false if not.
	*/
	public void setHasGoat(boolean value){
	hasGoat = value;
	return;
	}

	/**
	Mutator to set the state of the hasFood boolean.  
	@param value a boolean setting the state of the hasFoold, true if the room has a Food item, false if not.
	*/
	public void setHasFood(boolean value){
	hasFood = value;
	return;
	}

	/*

	public void setRoomWidth(int width){
	roomWidth = width;
	return ;
	}

	public void setRoomHeight(int height){
	roomHeight = height;
	return ;
	}
	
	*/

//////////////////////////  OTHER METHODS /////////////////////////////////////////////////
	
	// LEGACY METHOD , now using drawRoomGrid() 
	/**
	Deprecated Room Drawing Method, manually draws out a fixed width room. superseded by roomGrid 2D char array method.
	@deprecated Replaced by drawRoomGrid()
	*/
	@Deprecated public void drawRoom(){
	
	// prints out one room for display purposes 
	// more robust routine will be defined in drawMaze() method in Maze() class.
	
	int maxWidth = 10;  // number for room cells in a row
	int maxHeight = 10; // number of rows						
	//int roomWidth=6; // padding for each room 
	
	
	/// move to the correct row and column
	
	Point corner = getLocation();
	int row = corner.getYCoordinate();
	int col = corner.getXCoordinate();

	
	/// routine to position the room in the array 
	moveIntoPlace(row,col,roomWidth);
        /// you should now be at the correct row and column to print out the room
			
		if (topWall == true) {
			for (int k = 0 ; k < roomWidth+2; k ++){
			System.out.print("_");
			}
		}
		
		returnCursorToRoom(col,roomWidth);
		
		if (leftWall == true){
		System.out.print("|");
		printSpaceRight(roomWidth);
		} else { printSpaceRight(roomWidth+1);}
		
		if (rightWall == true){
		System.out.print("|");
		}
		
		returnCursorToRoom(col, roomWidth);
		
		if (leftWall == true){
		System.out.print("|");
		plotItem(roomWidth);
		}else{
		plotItem(roomWidth+1);
		}
		
		if (rightWall == true){
		System.out.print("|");
		}
		
		returnCursorToRoom(col,roomWidth);
		
		if (leftWall == true){
		System.out.print("|");
		
			if ( bottomWall == true){
			
			/// Print the bottom wall
				if (rightWall == true) {
				for (int k = 0 ; k < roomWidth; k ++){
					System.out.print("_");
					}
				}else {	
					for (int k = 0 ; k < roomWidth+1; k ++){
					System.out.print("_");
					}
				}
				
			}else {
			/// move to the right by a room's width
				for (int k = 0 ; k < roomWidth ; k ++){
				System.out.print(" ");
				}
			}
		}else {
			if ( bottomWall == true){	
			/// Print the bottom wall
				if (rightWall == true) {
				for (int k = 0 ; k < roomWidth+1; k ++){
					System.out.print("_");
					}
				}else {	
					for (int k = 0 ; k < roomWidth+2; k ++){
					System.out.print("_");
					}
				}
			} else {
			/// move to the right by a room's width
				for (int k = 0 ; k < roomWidth+1 ; k ++){
				System.out.print(" ");
				}
			}
		}

		if (rightWall == true){
		System.out.print("|");
		}
			
	// returnCursorToRoom(col,RoomWidth);	
	System.out.print("\n");	
	System.out.println("");	
	}  // close brace for drawRoom()


	/// maybe make this private and call as a helper function in setters and getters / mutator methods 
	
	/**
	Mutator to populate the 2D char array RoomGrid, with character symbols representing the state of the Room booleans.  
	*/
	public void populateRoomGrid(){
	
		// clear the grid and initialize to empty char 
		for (int i =0 ; i < roomCols; i ++){
			for (int j =0 ; j < roomRows; j++){
			roomGrid[i][j]=' ';    // blank space
			}
		}

		if (topWall) {
			for( int k = 0 ; k < roomCols ; k++){
			roomGrid[k][0]='_';
			} 
		}		
		
		if (bottomWall){
			for ( int k =0 ; k < roomCols; k ++){
			roomGrid[k][roomRows-1]='_'; 
			}
		}
		
		if (leftWall){
			for (int k=1; k< roomRows; k++){
			roomGrid[0][k]='|';
			}
		}
		
		if (rightWall){
			for (int k=1; k< roomRows; k++){
			roomGrid[roomCols-1][k]='|';
			}
		}
		
		// fix glitches in wall presentation
		if (rightWall && !topWall) {
			roomGrid[roomCols-1][0]='|';	
		}
		if (leftWall && !topWall) {
			roomGrid[0][0]='|';	
		}
		if (leftWall && !bottomWall) {
			roomGrid[0][roomRows-1]='|';	
		}
		if (rightWall && !bottomWall) {
			roomGrid[roomCols-1][roomRows-1]='|';	
		}
		
		
		// player placement (might not be necessary)
		if (hasPlayer){
		roomGrid[roomCols/2-1][roomRows/2]='*';
		} else {
		roomGrid[roomCols/2-1][roomRows/2]=' ';
		}
		
		// Item placement
		if (hasMap){
		roomGrid[roomCols/2][roomRows/2]='M';
		}else if (hasKey){
		roomGrid[roomCols/2][roomRows/2]='K';
		}else if (hasMonster){
		roomGrid[roomCols/2][roomRows/2]='W';
		}else if (hasRiddle){
		roomGrid[roomCols/2][roomRows/2]='R';
		}else if (hasBooks){
		roomGrid[roomCols/2][roomRows/2]='B';
		}else if (hasComboLock){
		roomGrid[roomCols/2][roomRows/2]='L';
		}else if (hasGoat){
		roomGrid[roomCols/2][roomRows/2]='G';
		}else if (hasFood){
		roomGrid[roomCols/2][roomRows/2]='F';
		}else {
		roomGrid[roomCols/2][roomRows/2]=' ';
		} 
		
		//// Door placement depends on doorPosition integer 
		if (hasDoor) {
			if(doorPosition ==0){
			roomGrid[roomCols/2][roomRows/2]='D';
			} else if (doorPosition ==1){
			roomGrid[roomCols/2][1] = 'D';
			} else if (doorPosition ==2){
			roomGrid[roomCols-2][roomRows/2] = 'D';
			} else if (doorPosition ==3){
			roomGrid[roomCols/2][roomRows-2] = 'D';
			} else if (doorPosition ==4){
			roomGrid[1][roomRows/2] = 'D';
			}	
		}

	}
	
	/**
	Mutator to print out the 2D char array RoomGrid, with character symbols representing the state of the Room booleans.
	This method positions the room in its approximate Location in a 2D array of rooms at location corner = room.getLocation()   
	*/
	public void drawRoomGrid() {
	populateRoomGrid(); // load the information and characters currently set for the room into the roomGrid
	
	Point corner = getLocation();
	int row = corner.getYCoordinate();
	int col = corner.getXCoordinate();
	moveIntoPlace(row,col,roomCols);
	
		for (int j =0; j< roomRows; j ++){		
			for (int i = 0; i< roomCols; i++){
			System.out.print(roomGrid[i][j]); //print a row
			}
		returnCursorToRoom(col,roomCols);
		}
	System.out.println();
	}
	
	

////////////////// PRIVATE HELPER FUNCTIONS ///////////////////////////////////////
	private void returnCursorToRoom(int col, int roomWidth){
	
	System.out.print("\n");  // move to the next line and return to the ce
	// return to room position
		for ( int i = 0 ; i < col ; i++){
		/// move to the right by a room's width
			for (int k = 0 ; k < roomWidth ; k ++){
			System.out.print(" ");
			}
		}
	return;
	}
	
	private void plotItem(int roomWidth){
	
				for (int k = 0 ; k < roomWidth ; k ++){		
				if (hasKey == true  && k == roomWidth/2){
				System.out.print("K");
				}else if (hasDoor == true  && k == roomWidth/2){
				System.out.print("D");
				}else if (hasMonster == true  && k == roomWidth/2){
				System.out.print("W");
				}else if (hasMap == true  && k == roomWidth/2){
				System.out.print("M");
				}else if (hasRiddle == true  && k == roomWidth/2){
				System.out.print("R");
				}else if (hasBooks == true  && k == roomWidth/2){
				System.out.print("B");
				}else if (hasComboLock == true  && k == roomWidth/2){
				System.out.print("L");
				}else if (hasGoat == true  && k == roomWidth/2){
				System.out.print("G");
				}else if (hasFood == true  && k == roomWidth/2){
				System.out.print("F");
				}else if (hasPlayer == true  && k == roomWidth/2){
				System.out.print("*");
				}else{		
				System.out.print(" ");		
				}
			}
	}
	private void printSpaceRight(int roomWidth){
		/// move to the right by a room's width
			for (int k = 0 ; k < roomWidth ; k ++){
			System.out.print(" ");
			}
	}
	
	
	private void moveIntoPlace(int row, int col, int roomWidth) {
		
	/// routine to position the room in the array 
		// move to the row
		for (int i=0 ; i < row ; i++){
			for (int j = 0 ; j<4 ; j++){ 
			System.out.println("");
			}
		}
		
		// move to column
		for ( int i = 0 ; i < col ; i++){
			printSpaceRight(roomWidth);
		}
	// now you should be at the correct row and column to print out the room
	}
	
	/**
	Accessor method to print out the location and booleans present in a particualr room to the console in text mode.  
	*/
	public void  displayRoomStats(){
	System.out.println("============ROOM STATS==============");
	System.out.println("Location = "+ location.toString());
	System.out.print("leftWall = " + leftWall + " ");	
	System.out.print("RightWall = " + rightWall + " ");
	System.out.print("TopWall = " + topWall + " ");
	System.out.println("BottomWall = " + bottomWall);
	System.out.print("Monster = " + hasMonster+ " ");
	System.out.print("HasKey = " + hasKey + " ");
	System.out.print("HasMap = " + hasMap + " ");
	System.out.print("Door = " + hasDoor+ " ");
	System.out.println("DoorPosition = " + doorPosition);
	System.out.print("Riddle = " + hasRiddle+ " ");
	System.out.print("Books = " + hasBooks+ " ");
	System.out.print("ComboLock = " + hasComboLock+ " ");
	System.out.println("Goat = " + hasGoat+ " ");
	}

} // class closing brace
///////////////////////////////   END OF FILE ///////////////////////////////////////////////