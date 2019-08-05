//////////////////////////////////////////////
//
// File: Player.java
// Description: Monster class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.02
// Revision Date: August 05, 2019
//
///////////////////////////////////////////////

// Player:  Attributes - (x,y) Point location, Health, hasKey, attackStrength
//          Methods- moveLeft(), moveRight(), moveUp(), moveDown(),
//	           searchRoom(), attack(), openDoor() , die() , isAlive()



//import java.util.Random;

/**
Class Monster creates a monster object with a Point position, integer health, and booleans for having a key.
A monster object also has integer attackStrength for fighting the player in the maze and a random number generator to give random attack hit points to the player
wraith is a Monster object in the game MazeGame and MazeGameGUI. <P>
 
@author (Ron) Zorondras Rodriguez
@version 0.02
@since July 20, 2019
*/


public class Monster extends Entity {

////////////////////// MEMBER VARIABLES /////////////////////////////////////
//private Random randGen = new Random(1000);  // make a pseudo random number generator 

//////////////////////  CONSTRUCTORS     //////////////////////////////////////////

	// default constructor
	/**
	Default constructor sets the position to Point (0,3), health to 20, attackStrength to 5 and hasKey boolean to false
	*/
	public Monster(){
	super(new Point(0,3),20,5);
	}

	// input constructor
	/**
	Input constructor sets the location by x,y coordinate pair input and initial health to heal, and attackStrength to strength.
	@param p A Point where the monster is located on initialization. 
	@param heal an integer to set the initial health level of the monster. 
	@param strength an integer to set the attack strength of the monster.
	*/
	public Monster(Point p, int heal, int strength ){
	
	super( new Point(0,3), heal,strength);
	}
	
	// copy  constructor
	/**
	Copy constructor copies the location health and attackStrength from another Monster object into the new object being constructed.
	@param m A Monster object to be copy constructed. 
	*/
	public Monster( Monster m ){
	super(m); 		
	}
	
//////////////////////   ACCESSORS     ////////////////////////////////////////////

 // Defined in and Inherited from Entity

//////////////////////   MUTATORS      /////////////////////////////////////////////
	
 // Defined in and Inherited from Entity

///////////////////////   OTHER METHODS /////////////////////////////////////////////

 // Defined in and Inherited from Entity

///////////////////////////  FIGHTING METHODS  ///////////////////////////////////////

 // Defined in and Inherited from Entity 

//////////////////////   Motion Methods /////////////////////////////////////////////

///////////////////////////// DISPLAY INFORMATION METHODS ///////////////////////////////////

	//// OVER-RIDDEN and POLYMORPHIC METHODS extended from entity

	/**
	Accessor displays Monster Statistics in a decorative manner.
	*/
	public void displayStats(){
	System.out.println("=======MONSTER STATS=======");
	System.out.println("Health = " + getHealth()); 
	System.out.println("Attack Strength= " + getAttackStrength());
	System.out.println("Has key = " + getHasKey());
	System.out.println("Position = " + getPosition().toString());  
	
	}
  
  	/**
	Displays Monster death message.
	*/
	public void deathMessage(){
	System.out.println("Monster Gasps and Screams:");
	System.out.println("Keith Richards Lives On!  Arrrgghhhh!");
	return;
	}
  
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
