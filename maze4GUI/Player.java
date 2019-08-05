//////////////////////////////////////////////
//
// File: Player.java
// Description: Player class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.03
// Revision Date: August 5, 2019
//
///////////////////////////////////////////////

// Player:  Attributes - (x,y) Point location, Health, hasKey, attackStrength
//          Methods- moveLeft(), moveRight(), moveUp(), moveDown(),
//	           searchRoom(), attack(), openDoor() , die() , isAlive()

import java.util.Random;

/**
Class Player creates a player with a Point position, integer health, and booleans for having a map and a key.
A player also has integer attackStrength for fighting monsters in the maze and a random number generator to give random attack hit points to monsters
Player is the hero object in the game MazeGame and MazeGameGUI 
@author (Ron) Zorondras Rodriguez
@version 0.02
@since July 20, 2019
*/
public class Player {

////////////////////// MEMBER VARIABLES /////////////////////////////////////
private Point position;
private int health;
private boolean hasKey;
private boolean hasMap;    // extra to monster
private int attackStrength;
private Random randGen = new Random(1000);  // make a pseudo random number generator 
//////////////////////  CONSTRUCTORS     //////////////////////////////////////////

	// default constructor
	/**
	Default constructor sets the position to Point (0,0), health to 35, attackStrength to 7 and hasKey and hasMap booleans to false
	*/
	public Player(){
	position = new Point(0,0);
	health = 35;
	hasKey = false;
	hasMap = false;
	attackStrength = 7;
	}

	// input constructor
	/**
	Input constructor sets the location by x,y coordinate pair input and initial health to heal, and attackStrength to strength.
	@param p A Point where the player is located on initialization. 
	@param heal an integer to set the initial health level of the player. 
	@param strength an integer to set the attack strength of the player
	*/
	public Player(Point p, int heal, int strength ){
	position = new Point(p);
	hasKey = false;
	hasMap = false;
		if (heal >5){
		health = heal;
		}
		else { health = 35; }  
	
		if ( strength >=1){
		attackStrength = strength;
		}else { attackStrength = 7 ; }
	}
	
	// copy constructor
	/**
	Copy constructor copies the location health and attackStrength from another player object into the new object being constructed.
	@param p A Player object to be copy constructed. 
	*/
	public Player( Player p){
	position = new Point(p.position);
	hasKey = p.hasKey;
	hasMap = p.hasMap;
	
		if (p.health >0){
		health = p.health;
		}
		else { health = 0; }  
	
		if ( p.attackStrength >=1){
		attackStrength = p.attackStrength;
		}else { attackStrength = 7 ; }
	}


//////////////////////   ACCESSORS     ////////////////////////////////////////////

	/**
	Accessor to get the position of the player as a Point object.
	@return a Point with the position of the player object. 
	*/
	public Point getPosition(){
	Point temp = new Point(position);
	return temp;
	}

	/**
	Accessor to get the health of a player as.
	@return an integer representing the health of the player. 
	*/
	public int getHealth(){
	return health;
	}
	
	/**
	Accessor to get the boolean value of hasKey 
	@return a boolean representing the state of hasKey, true if player has the key. 
	*/
	public boolean getHasKey(){
	return hasKey;
	}
	
	/**
	Accessor to get the boolean value of hasMap 
	@return a boolean representing the state of hasMap, true if player has the map. 
	*/
	public boolean getHasMap(){
	return hasMap;
	}

	/**
	Accessor to get the attack strength of the player. 
	@return an integer representing the attack strength of the player. 
	*/
	public int getAttackStrength(){
	return attackStrength;
	}

//////////////////////   MUTATORS      /////////////////////////////////////////////
	
	// point input
	/**
	Mutator to set the position of the player to input Point p. 
	@param p a Point representing the new position of a player object. 
	*/
	public void setPosition(Point p){
		if (p.getXCoordinate() >=0 && p.getYCoordinate() >=0){
		position.setPoint(p);
		}

	return;
	}
	
	// overload for coordinate pair input
	/**
	Mutator to set the position of a player object given input integer coordinates x and y. 
	@param x an integer representing the x-coordinate.
	@param y an integer representing the y-coordinate.
	*/	
	public void setPosition(int x, int y){
		if (x >=0 && y >=0){
		position.setXCoordinate(x);
		position.setYCoordinate(y);
		}
	return;
	}
	
	/**
	Mutator to set the health of a player to input healthIn if a positive integer otherwise do nothing. 
	@param healthIn an integer representing the new player health. 
	*/
	public void setHealth( int healthIn){
		if (healthIn > 0) {
		health= healthIn;
		}
	return;
	}
	
	// use for eating Gruel in game 
	/**
	Mutator to increase the health of a player by a positive amount.  Does nothing if input amount is negative. 
	@param amount a positive integer amount to increase player health by. 
	*/
	public void addHealth( int amount){
		if (amount > 0) {
		health+= amount;
		}
	return;
	}
	
	/**
	Mutator to set the status of whether the player has the key.  
	@param val a boolean to set the status of hasKey, input true if player has the key, false to set that they don't have the key. 
	*/
	public void setHasKey( boolean val){
	hasKey= val;
	return;
	}
	
	/**
	Mutator to set the status of whether the player has the map.  
	@param val a boolean to set the status of hasMap, input true if player has the map, false to set that they don't have the map. 
	*/
	public void setHasMap( boolean val){
	hasMap= val;
	return;
	}

	/**
	Mutator to set the player Attack Strength.  
	@param strength an integer value representing the player attack strength. 
	*/
	public void setAttackStrength(int strength){
		if (strength >= 1){
		attackStrength=strength;
		}
	}

	/**
	Mutator to set the amount of damage the player recieives from an enemy or monster
	@param damage a positive integer value representing the damage to a player inflicted by a monster.  If negative does nothing.
	*/
	public void takesDamage(int damage){
		if (damage > 0){
		health -= damage;
		}
	return;
	}

///////////////////////   OTHER METHODS /////////////////////////////////////////////

////////////  FIGHTING METHODS ///////////////////////////////////////////////////

	/**
	Mutator to inflict damage upon a monster object.  
	@param m a Monster object to attack. 
	*/
	public void attacks(Monster m){
	
	int damageAmount ;
	
	damageAmount = attackStrength + randGen.nextInt(5);  // add a random component to the attack damage 
	
	m.takesDamage(damageAmount);   // maybe make this random from 0 - attackStrentgh*2
	return;
	}

//////////////////////   Motion Methods /////////////////////////////////////////////

	/**
	Mutator to move the player position to the left by one spot. 
	*/

	public void moveLeft(){
		if ( position.getXCoordinate() -1 >=0){
		position.setXCoordinate(position.getXCoordinate()-1) ;
		}	
	return;
	}

	/**
	Mutator to move the player position to the right by one spot. 
	*/
	public void moveRight(){
	position.setXCoordinate(position.getXCoordinate()+1) ;
	return;
	}

	/**
	Mutator to move the player position up by one spot. 
	*/
	public void moveUp(){

	if ( position.getYCoordinate() -1 >=0) {
	position.setYCoordinate(position.getYCoordinate() - 1) ;
	}
	return;
	}

	/**
	Mutator to move the player position down by one spot. 
	*/
	public void moveDown(){
	position.setYCoordinate(position.getYCoordinate() + 1) ;
	return;
	}

	/**
	Accessor returns a boolean value as to whether the player is alive, namely their health >0.
	@return returns a boolean, true if player is alive with health > 0 , false if player has health <=0. 
	*/
	public boolean isAlive(){
		if (health > 0){
		return true;
		} 
	return false;
	}
	
	/**
	Mutator sets Player health to zero, removes items Key and Map, and outputs a death message.
	*/
	public void die() {
	health = 0;
	hasKey=false;
	hasMap=false;
	System.out.println("Our Hero Gasps and Screams:");
	System.out.println("My quest is finished! Arrrgghhhh!");
	return ;
	}

///////////////////////////// DISPLAY INFORMATION METHODS ///////////////////////////////////


	/**
	Accessor displays Player Statistics in a decorative manner.
	*/
	public void displayStats(){
	System.out.println("=======PLAYER STATS=======");
	System.out.println("Health = " + health + " "); 
	System.out.println("Attack Strength= " + attackStrength + " ");
	System.out.print("Has Key = " + hasKey +", ");
	System.out.println("Has Map = " + hasMap + " ");
	System.out.println("Position = " + position.toString() );  
	
	}

////////////////////////////   METHODS TO IMPLEMENT      //////////////////////////////////	

		
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
