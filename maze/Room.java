
//////////////////////////////////////////////
//
// File: Room.java
// Description: Room class for the maze
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.01
// Revision Date: July 20, 2019
//
///////////////////////////////////////////////

// Room:  Attributes: (x,y) point location, Booleans: leftWall, bottomWall, rightWall, topWall,
//			hasMonster, hasKey, hasDoor, leftDoor, topDoor, rightDoor, bottomDoor
//	Methods:    displaySearch()

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

private int doorPosition;

//////////////////////////   CONSTRUCTORS ///////////////////////////////////////////////
	public Room(){
	
	 location = new Point();  // floating in space
	 
	 leftWall=true;
	 rightWall=true;
	 topWall=true;
	 bottomWall=true;

	 hasMonster=false;
	 hasKey=false;
	 hasPlayer=false;

	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
 	
	}
	
	// shape input constructor // change other variables with setters 
	public Room (Point locale, boolean left, boolean right, boolean top, boolean bottom){
	 location = new Point (locale);
	
	 leftWall=left;
	 rightWall=right;
	 topWall=top;
	 bottomWall=bottom;

	 hasMonster=false;
	 hasKey=false;
	 hasPlayer=false;
	 
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
	}
	
	//input constructor // change other variables with setters 
	public Room (int x, int y, boolean left, boolean right, boolean top, boolean bottom){
	 location = new Point (x,y);
	 	
	 leftWall=left;
	 rightWall=right;
	 topWall=top;
	 bottomWall=bottom;

	 hasMonster=false;
	 hasKey=false;
	 hasPlayer=false;
	 
	 hasDoor=false;
	 doorPosition=0; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
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
	 hasPlayer=toCopy.hasPlayer;
	 hasDoor=toCopy.hasDoor;
	 doorPosition=toCopy.doorPosition; // 0 for no door 1 for left 2 for right , 3 for top, 4 for bottom
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
	public boolean getHasDoor(){
	return hasDoor;
	}
	public int getDoorPosition(){
	return doorPosition;
	}
	
	public Point getLocation(){
	Point temp = new Point(location); 
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

//////////////////////////  OTHER METHODS /////////////////////////////////////////////////
	public void  displayRoomStats(){
	System.out.println("Location = "+ location.toString());
	System.out.print("leftWall = " + leftWall + " ");	
	System.out.print("RightWall = " + rightWall + " ");
	System.out.print("TopWall = " + topWall + " ");
	System.out.println("BottomWall = " + bottomWall);
	System.out.print("Monster = " + hasMonster+ " ");
	System.out.println("HasKey = " + hasKey+ " ");
	System.out.print("Door = " + hasDoor+ " ");
	System.out.println("DoorPosition = " + doorPosition);
	}
	
	public void drawRoom(){
	
	// prints out one room for display purposes 
	// more robust routine will be defined in drawMaze() method in Maze() class.
	
	int maxWidth = 10;  // number for room cells in a row
	int maxHeight = 10; // number of rows						
	int RoomWidth=6; // padding for each room 
	
	Point corner = getLocation();
	int row = corner.getYCoordinate();
	int col = corner.getXCoordinate();
	
	/// routine to position the room in the array 
		// move to the row
		for (int i=0 ; i < row ; i++){
			for (int j = 0 ; j<4 ; j++){ 
			System.out.println("");
			}
		}
		// move to column
		for ( int i = 0 ; i < col ; i++){
			/// move to the right by a room's width
			for (int k = 0 ; k < RoomWidth ; k ++){
			System.out.print(" ");
			}
		}
	// now you should be at the correct row and column to print out the room
		
		if (topWall == true) {
			for (int k = 0 ; k < RoomWidth+2; k ++){
			System.out.print("_");
			}
		}
		
		returnCursorToRoom(col,RoomWidth);
		
		if (leftWall == true){
		System.out.print("|");
		/// move to the right by a room's width
			for (int k = 0 ; k < RoomWidth ; k ++){
			System.out.print(" ");
			}
		}

		if (rightWall == true){
		System.out.print("|");
		}
		
		returnCursorToRoom(col, RoomWidth);
		
		if (leftWall == true){
		System.out.print("|");
		plotItem(RoomWidth);
		}else{
		
		plotItem(RoomWidth);
		
		}
		
		if (rightWall == true){
		System.out.print("|");
		}
		
		returnCursorToRoom(col,RoomWidth);
		
		if (leftWall == true){
		System.out.print("|");
		
			if ( bottomWall == true){	
			/// Print the bottom wall
				for (int k = 0 ; k < RoomWidth; k ++){
					System.out.print("_");
				}
			}else {
			/// move to the right by a room's width
				for (int k = 0 ; k < RoomWidth ; k ++){
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


////////////////// PRIVATE HELPER FUNCTIONS ///////////////////////////////////////
	private void returnCursorToRoom(int col, int RoomWidth){
	
	System.out.print("\n");  // move to the next line and return to the ce
	// return to room position
		for ( int i = 0 ; i < col ; i++){
		/// move to the right by a room's width
			for (int k = 0 ; k < RoomWidth ; k ++){
			System.out.print(" ");
			}
		}
	return;
	}
	
	private void plotItem(int RoomWidth){
	
				for (int k = 0 ; k < RoomWidth ; k ++){		
				if (hasKey == true  && k == RoomWidth/2){
				System.out.print("K");
				}else if (hasDoor == true  && k == RoomWidth/2){
				System.out.print("D");
				}else if (hasMonster == true  && k == RoomWidth/2){
				System.out.print("M");
				}else if (hasPlayer == true  && k == RoomWidth/2){
				System.out.print("*");
				}else{		
				System.out.print(" ");		
				}
			}
	}
	

} // class closing brace
///////////////////////////////   END OF FILE ///////////////////////////////////////////////