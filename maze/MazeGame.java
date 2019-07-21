//////////////////////////////////////////////
//
// File: MazeGame.java
// Description: MazeGame class with main() function
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.01
// Revision Date: July 20, 2019
//
///////////////////////////////////////////////


public class MazeGame {


	public static void main(String[] args){
	
	
	Maze gameBoard = new Maze();
	
	Player tempHero;
	
	
	tempHero = gameBoard.getHero();
	
	
	tempHero.displayStats();
	
	
	return;
	
	}

}