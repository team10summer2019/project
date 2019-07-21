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


public class MazeGame {


	public static void main(String[] args){
	
	Maze gameBoard = new Maze(4);  // make a 4x4 room maze 
	
	setBoard(gameBoard);   // construct the maze 

	Player tempHero;  // temporary value to look at Hero stats
	Room tempRoom;    // temporary value to look at a room 
	
	tempRoom = gameBoard.getRoom(0);
	tempRoom.drawRoom();
	//tempRoom.displayRoomStats();

	tempRoom = gameBoard.getRoom(1);
	tempRoom.drawRoom();
	//tempRoom.displayRoomStats();
	
	tempRoom = gameBoard.getRoom(10);
	tempRoom.drawRoom();
	//tempRoom.displayRoomStats();

	tempRoom = gameBoard.getRoom(12);
	tempRoom.drawRoom();
	//tempRoom.displayRoomStats();
	
	tempHero = gameBoard.getHero();
	tempHero.displayStats();
	


	return;
	
	}
	
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
	
	
	
	

} // class ending brace
///////////////////////////////  END OF FILE //////////////////////////////////////////////////