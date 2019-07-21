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


test.setLocation(5,5);

test.setRightWall(true);
test.setBottomWall(true);

test.setHasKey(true);


test.displayRoomStats();
test.drawRoom();

test.setLocation(0,3);

test.displayRoomStats();
test.drawRoom();



}


}