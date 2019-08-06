package GUIWithPuzzles;
//////////////////////////////////////////////
//
// File: Player.java
// Description: Player class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.04
// Revision Date: August 5, 2019
//
///////////////////////////////////////////////

// Player:  Attributes - (x,y) Point location, Health, hasKey, attackStrength
//          Methods- moveLeft(), moveRight(), moveUp(), moveDown(),
//	           searchRoom(), attack(), openDoor() , die() , isAlive()

//import java.util.Random;

/**
Class Player creates a player with a Point position, integer health, and booleans for having a map and a key.
A player also has integer attackStrength for fighting monsters in the maze and a random number generator to give random attack hit points to monsters
hero is the Player object in the game MazeGame and MazeGameGUI. <P>

@author (Ron) Zorondras Rodriguez
@version 0.04
@since July 20, 2019
*/
public class Player extends Entity {

////////////////////// MEMBER VARIABLES /////////////////////////////////////
private boolean hasRiddle;
private boolean hasHint;
private boolean hasLeverOne;
private boolean hasLeverTwo;
private boolean hasMap;    // extra to Entity
//private Random randGen = new Random(1000);  // make a pseudo random number generator 
//////////////////////  CONSTRUCTORS     //////////////////////////////////////////

	// default constructor
	/**
	Default constructor sets the position to Point (0,0), health to 35, attackStrength to 7 and hasKey and hasMap booleans to false
	*/
	public Player(){
	super(new Point(0,0),30,7);  // start at (0,0) health 30, attack strength 7
	hasRiddle = false;
	hasHint = false;
	hasLeverOne = false;
	hasLeverTwo = false;
	hasMap = false;
	}

	// input constructor
	/**
	Input constructor sets the location by x,y coordinate pair input and initial health to heal, and attackStrength to strength.
	@param p A Point where the player is located on initialization. 
	@param heal an integer to set the initial health level of the player. 
	@param strength an integer to set the attack strength of the player
	*/
	public Player(Point p, int heal, int strength ){
	super(p,heal,strength);
	hasRiddle = false;
	hasHint = false;
	hasLeverOne = false;
	hasLeverTwo = false;
	hasMap = false;
	}
	
	// copy constructor
	/**
	Copy constructor copies the location health and attackStrength from another player object into the new object being constructed.
	@param p A Player object to be copy constructed. 
	*/
	public Player( Player p){
	super(p);
	hasRiddle = p.hasRiddle;
	hasRiddle = p.hasHint;
	hasLeverOne=p.hasLeverOne;
	hasLeverTwo=p.hasLeverTwo;
	hasMap = p.hasMap;
	}


//////////////////////   ACCESSORS     ////////////////////////////////////////////

	// Other methods inherited from entity 

        ////////////////// SPECIFIC TO PLAYER /////////////////////////////////
	/**
	Accessor to get the boolean value of hasMap 
	@return a boolean representing the state of hasMap, true if player has the map. 
	*/
	public boolean getHasRiddle(){
	return hasRiddle;
	}
		
	public boolean getHasHint(){
	return hasHint;
	}
		
	public boolean getHasLeverOne(){
	return hasLeverOne;
	}
		
	public boolean getHasLeverTwo(){
	return hasLeverTwo;
	}
	
	public boolean getHasMap(){
	return hasMap;
	}

//////////////////////   MUTATORS      /////////////////////////////////////////////
	
	// Other methods inherited from entity 
	
	////////////////// SPECIFIC TO PLAYER /////////////////////////
	// use for eating Gruel in game 
	/**
	Mutator to increase the health of a player by a positive amount.  Does nothing if input amount is negative. 
	@param amount a positive integer amount to increase player health by. 
	*/
	public void addHealth( int amount){
		if (amount > 0) {
		setHealth(getHealth()+amount);
		}
	return;
	}
	
	/**
	Mutator to set the status of whether the player has the map.  
	@param val a boolean to set the status of hasMap, input true if player has the map, false to set that they don't have the map. 
	*/
	public void setHasRiddle( boolean val){
	hasRiddle= val;
	return;
	}
		
	public void setHasHint( boolean val){
	hasHint= val;
	return;
	}
		
	public void setHasLeverOne( boolean val){
	hasLeverOne= val;
	return;
	}
		
	public void setHasLeverTwo( boolean val){
	hasLeverTwo= val;
	return;
	}
	
	public void setHasMap( boolean val){
	hasMap= val;
	return;
	}

///////////////////////   OTHER METHODS /////////////////////////////////////////////

////////////  FIGHTING METHODS ///////////////////////////////////////////////////

	//inherited from entity  
	
	/**
	Mutator to inflict damage upon a monster object.  
	@param m a Monster object to attack. 
	*/
	/*
	public void attacks(Monster m){
	int damageAmount ;
	damageAmount = getAttackStrength()/2 + randGen.nextInt(getAttackStrength());  // add a random component to the attack damage 
	m.takesDamage(damageAmount);   // maybe make this random from 0 - attackStrentgh*2
	return;
	}
	*/
	
//////////////////////   Motion Methods /////////////////////////////////////////////

	// Override method in parrent class 
	/**
	Mutator sets Player health to zero, removes items Key and Map, and outputs a death message. 
	*/
	public void die() {
	super.die();
	hasMap=false;
	return ;
	}

///////////////////////////// DISPLAY INFORMATION METHODS ///////////////////////////////////

	//// OVER-RIDDEN and POLYMORPHIC METHODS extended from entity
	/**
	Accessor displays Player Statistics in a decorative manner. (Polymorphic Call)
	*/
	public void displayStats(){
	System.out.println("=======PLAYER STATS=======");
	System.out.println("Health = " + getHealth() + " "); 
	System.out.println("Attack Strength= " + getAttackStrength() + " ");
	System.out.print("Has Key = " + getHasKey() +", ");
	System.out.println("Has Map = " + getHasMap() + " ");
	System.out.println("Position = " + getPosition().toString() );  
	}

	/**
	Displays custom Player death message (Polymorphic call).
	*/
	public void deathMessage(){
	System.out.println("Our Hero Gasps and Screams:");
	System.out.println("My quest is finished! Arrrgghhhh!");
	}

///////   METHODS TO IMPLEMENT      //////////////////////////////////	

		
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
