
//////////////////////////////////////////////
//
// File: Room.java
// Description: Room class for the maze
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.02
// Revision Date: July 21e, 2019
//
///////////////////////////////////////////////

// Room:  Attributes: (x,y) point location, Booleans: leftWall, bottomWall, rightWall, topWall,
//			hasMonster, hasKey, hasDoor, leftDoor, topDoor, rightDoor, bottomDoor
//	Methods:    displaySearch()

package finalText;

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
private boolean hasWolf;
private boolean hasCabbage;
private boolean hasGoat;
private boolean hasLeverOne;
private boolean hasLeverTwo;
private boolean hasHint;

private int doorPosition;

private char [][] roomGrid ; //  char 2D array for playing characters in a room 

private final int roomWidth=6;  // used in drawing routines
private int roomCols=8;  //  width of a room
private int roomRows=4;  // height of a room 

//////////////////////////   CONSTRUCTORS ///////////////////////////////////////////////
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
	 hasWolf =false;
	 hasCabbage = false;
	 hasGoat = false;
	 hasLeverOne = false;
	 hasLeverTwo = false;
	 hasHint = false;

	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
 	
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid  
	
	 populateRoomGrid();
	
	}
	
	// shape input constructor // change other variables with setters 
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
	 hasWolf =false;
	 hasCabbage = false;
	 hasGoat = false;
	 hasLeverOne = false;
	 hasLeverTwo = false;
	 hasHint = false;
	 
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
	 
	
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid  
	 populateRoomGrid();
	 
	 
	}
	
	//input constructor // change other variables with setters 
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
	 hasWolf =false;
	 hasCabbage = false;
	 hasGoat = false;
	 hasLeverOne = false;
	 hasLeverTwo = false;
	 hasHint = false;
	 
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
	
	 roomGrid = new char[roomCols][roomRows];  // construct a room grid   
	 populateRoomGrid();
	 
	}
	
	
	// copy constructor 
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
	 hasWolf = toCopy.hasWolf;
	 hasCabbage = toCopy.hasCabbage;
	 hasGoat = toCopy.hasGoat;
	 hasLeverOne = toCopy.hasLeverOne;
	 hasLeverTwo = toCopy.hasLeverTwo;
	 hasHint = toCopy.hasHint;
	 
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
		
	}
	
/////////////////////////  ACCESSORS //////////////////////////////////////////////////
	public boolean getLeftWall(){
	return leftWall;
	}
	public boolean getRightWall(){
	return rightWall;
	}
	public boolean getTopWall(){
	return topWall;
	}
	public boolean getBottomWall(){
	return bottomWall;
	}
	public boolean getHasPlayer(){
	return hasPlayer;
	}
	public boolean getHasMonster(){
	return hasMonster;
	}
	public boolean getHasKey(){
	return hasKey;
	}
	
	public boolean getHasMap(){
	return hasMap;
	}
	
	public boolean getHasDoor(){
	return hasDoor;
	}
	
	public int getDoorPosition(){
	return doorPosition;
	}
	
	public boolean getHasRiddle(){
	return hasRiddle;
	}
	
	public boolean getHasBooks(){
	return hasBooks;
	}
	
	public boolean getHasComboLock(){
	return hasComboLock;
	}	
	
	public boolean getHasLeverOne() {
	return hasLeverOne;
	}
	
	public boolean getHasLeverTwo() {
	return hasLeverTwo;
	}
	
	public boolean getHasHint() {
	return hasHint;
	}
	
	public boolean getHasWolf() {
	return hasWolf;
	}
	
	public boolean getHasCabbage() {
	return hasCabbage;
	}
	
	public boolean getHasGoat(){
	return hasGoat;
	}
	
	public Point getLocation(){
	Point temp = new Point(location); 
	return temp;	
	}

	public int getRoomWidth(){
	return roomWidth;	
	}
	
	public int getRoomRows(){
	return roomRows;	
	}
	
	public int getRoomCols(){
	return roomCols;	
	}
	

	public char[][] getRoomGrid(){
	/// make a copy holder
	char[][] temp = new char[roomCols][roomRows];
		// copy the current room grid into 
		for (int i = 0 ; i < roomCols ; i++){
			for( int j =0 ; j < roomRows ; j++){
			temp[i][j] = roomGrid[i][j];
			}
		}	
	// return the copy
	return temp;
	} 
	
//////////////////////////   MUTATORS /////////////////////////////////////////////////////
	
	public void setLocation(int x, int y){
	location.setXCoordinate(x);
	location.setYCoordinate(y);
	return;	
	}

	public void setLocation(Point p){
	location.setXCoordinate(p.getXCoordinate());
	location.setYCoordinate(p.getYCoordinate());
	return;	
	}

	public void setLeftWall(boolean value){
	leftWall=value;
	return;
	}
	public void setRightWall(boolean value){
	rightWall=value;
	return;
	}
	public void setTopWall(boolean value){
	topWall=value;
	return;
	}
	public void setBottomWall(boolean value){
	bottomWall=value;
	return;
	}
	
	public void setHasPlayer(boolean value){
	hasPlayer=value;
	return;
	}
	public void setHasMonster(boolean value){
	hasMonster=value;
	return;
	}	
	public void setHasKey(boolean value){
	hasKey = value;
	return;
	}
	
	public void setHasMap(boolean value){
	hasMap = value;
	return;
	}
	
	public void setHasDoor( boolean value){
	hasDoor = value;
	return;
	}
	
	public void setDoorPosition(int value){
		if (value <=4 && value >= 0){
		doorPosition=value;
		}
	return;
	}

	public void setHasRiddle(boolean value){
	hasRiddle = value;
	return;
	}

	public void setHasBooks(boolean value){
	hasBooks = value;
	return;
	}

	public void setHasComboLock(boolean value){
	hasComboLock = value;
	return;
	}
	
	public void setHasLeverOne(boolean value) {
	hasLeverOne = value;
	return;
	}
	
	public void setHasLeverTwo(boolean value) {
	hasLeverTwo = value;
	return;
	}
	
	public void setHasHint(boolean value) {
	hasHint = value;
	return;
	}

	public void setHasWolf(boolean value) {
	hasWolf = value;
	return;
	}
	
	public void setHasCabbage(boolean value) {
	hasCabbage = value;
	return;
	}
		
	public void setHasGoat(boolean value){
	hasGoat = value;
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
	public void drawRoom(){
	
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
		}else if (hasHint) {
		roomGrid[roomCols/2][roomRows/2]='H';
		}else if (hasComboLock){
		roomGrid[roomCols/2][roomRows/2]='L';
		}else if (hasWolf){
		roomGrid[roomCols/2][roomRows/2]='Z';
		}else if (hasCabbage){
		roomGrid[roomCols/2][roomRows/2]='C';
		}else if (hasGoat){
		roomGrid[roomCols/2][roomRows/2]='G';
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
				}else if (hasHint == true  && k == roomWidth/2){
				System.out.print("H");
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
	System.out.print("ComboLock = " + hasComboLock+ " ");
	System.out.println("Wolf = " + hasWolf+ " ");
	System.out.print("Cabbage = " + hasCabbage+ " ");
	System.out.println("Goat = " + hasGoat+ " ");
	}

} // class closing brace
///////////////////////////////   END OF FILE ///////////////////////////////////////////////