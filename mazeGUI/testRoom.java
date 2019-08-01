//////////////////////////////////////////////
//
// File: testRoom.java
// Description: test for the Room class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.01
// Revision Date: July 20, 2019
//
///////////////////////////////////////////////

public class testRoom {

	public static void main(String[] args){

	Room test = new Room();

	test.displayRoomStats();
	test.drawRoom();
	
	test.setLocation(0,0);
	test.setRightWall(true);
	test.setLeftWall(true);
	test.setTopWall(true);
	test.setBottomWall(false);
	test.setHasPlayer(true);
	test.drawRoom();
	test.displayRoomStats();

	test.setLocation(2,2);
	test.setHasPlayer(false);
	test.setHasKey(true);
	test.setBottomWall(false);
	test.drawRoom();
	test.displayRoomStats();

	test.setLocation(1,0);
	test.setHasKey(false);
	test.setHasDoor(true);
	test.setBottomWall(true);
	test.setRightWall(false);
	test.displayRoomStats();
	test.drawRoom();

	test.setLocation(0,3);
	test.setRightWall(false);
	test.setBottomWall(true);
	test.setHasDoor(false );
	test.setHasMonster(true );
	test.displayRoomStats();
	test.drawRoom();

	System.out.println("RoomGrid Test");
	test.drawRoomGrid();

	}
}