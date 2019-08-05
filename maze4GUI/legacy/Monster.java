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

import java.util.Random;

/**
Class Monster creates a monster object with a Point position, integer health, and booleans for having a key.
A monster object also has integer attackStrength for fighting the player in the maze and a random number generator to give random attack hit points to the player
wraith is a Monster object in the game MazeGame and MazeGameGUI. <P>
 
@author (Ron) Zorondras Rodriguez
@version 0.02
@since July 20, 2019
*/
public class Monster {

////////////////////// MEMBER VARIABLES /////////////////////////////////////

private Point position;
private int health;
private boolean hasKey;
private int attackStrength;
private Random randGen = new Random(1000);  // make a pseudo random number generator 
//////////////////////  CONSTRUCTORS     //////////////////////////////////////////

	// default constructor
	/**
	Default constructor sets the position to Point (0,3), health to 20, attackStrength to 5 and hasKey boolean to false
	*/
	public Monster(){
	position = new Point(0,3);
	health = 20;
	hasKey = false;
	attackStrength = 5;
	}

	// input constructor
	/**
	Input constructor sets the location by x,y coordinate pair input and initial health to heal, and attackStrength to strength.
	@param p A Point where the monster is located on initialization. 
	@param heal an integer to set the initial health level of the monster. 
	@param strength an integer to set the attack strength of the monster.
	*/
	public Monster(Point p, int heal, int strength ){
	position = new Point(0,3);
	hasKey = false;
	
		if (heal >5){
		health = heal;
		}
		else { health = 15; }  
	
		if ( strength >=1){
		attackStrength = strength;
		}else { attackStrength = 3;}
	}
	
	// copy  constructor
	/**
	Copy constructor copies the location health and attackStrength from another Monster object into the new object being constructed.
	@param m A Monster object to be copy constructed. 
	*/
	public Monster( Monster m ){
	position = new Point(m.position);
	hasKey = m.hasKey;
	
		if (m.health >=0){
		health = m.health;
		} 
		if ( m.attackStrength >=1){
		attackStrength = m.attackStrength;
		}
	}
	


//////////////////////   ACCESSORS     ////////////////////////////////////////////


	/**
	Accessor to get the position of the Monster as a Point object.
	@return a Point with the position of the Monster object. 
	*/
	public Point getPosition(){
	Point temp = new Point(position);
	return temp;
	}

	/**
	Accessor to get the health of a player as.
	@return an integer representing the health of the monster. 
	*/
	public int getHealth(){
	return health;
	}
	
	/**
	Accessor to get the boolean value of hasKey 
	@return a boolean representing the state of hasKey, true if the Monster has the key. 
	*/
	public boolean getHasKey(){
	return hasKey;
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
	Mutator to set the position of the Monster to input Point p. 
	@param p a Point representing the new position of a Monster object. 
	*/
	public void setPosition(Point p){
	position.setPoint(p);
	return;
	}
	
	/// overload for coordinate pair input
	/**
	Mutator to set the position of a Monster object given input integer coordinates x and y. 
	@param x an integer representing the x-coordinate.
	@param y an integer representing the y-coordinate.
	*/	
	public void setPosition(int x, int y){
	position.setXCoordinate(x);
	position.setYCoordinate(y);
	return;
	}
	
	/**
	Mutator to set the health of a monster to input healthIn if a positive integer otherwise do nothing. 
	@param healthIn an integer representing the new player health. 
	*/
	public void setHealth( int healthIn){
		if (healthIn >= 0) {
		health= healthIn;
		}else { health = 0;}
	return;
	}
	
	/**
	Mutator to set the status of whether the Monster has the key.  
	@param val a boolean to set the status of hasKey, input true if Monster has the key, false to set that they don't have the key. 
	*/
	public void setHasKey( boolean val){
	hasKey= val;
	return;
	}

	/**
	Mutator to set the Monster Attack Strength.  
	@param strength an integer value representing the player attack strength. 
	*/
	public void setAttackStrength(int strength){
		if (strength >= 1){
		attackStrength=strength;
		}
	}

	/**
	Mutator to set the amount of damage the Monster recieives from the player.
	@param damage a positive integer value representing the damage to a player inflicted by a monster.  If negative does nothing.
	*/
	public void takesDamage(int damage){
		if (damage > 0){
		health -= damage;
		} else {
		
		
		}
	return;
	}

///////////////////////   OTHER METHODS /////////////////////////////////////////////

////////////  FIGHTING METHODS ///////////////////////////////////////////////////

	/**
	Mutator to inflict damage upon a player object.  
	@param p a Player object to attack. 
	*/
	public void attacks(Player p){
	
	int damageAmount ;
	damageAmount = attackStrength + randGen.nextInt(8);  // add a random component to the attack damage 
	p.takesDamage(damageAmount);   // maybe make this random from 0 - attackStrentgh*2
	return;
	}

//////////////////////   Motion Methods /////////////////////////////////////////////

	/**
	Mutator to move the Monster position to the left by one spot. 
	*/
	public void moveLeft(){
		if ( position.getXCoordinate() -1 >=0){
		position.setXCoordinate(position.getXCoordinate()-1) ;
		}	
	return;
	}

	/**
	Mutator to move the Monster position to the right by one spot. 
	*/
	public void moveRight(){
	position.setXCoordinate(position.getXCoordinate()+1) ;
	return;
	}

	/**
	Mutator to move the Monster position up by one spot. 
	*/
	public void moveUp(){

	if ( position.getYCoordinate() -1 >=0) {
	position.setYCoordinate(position.getYCoordinate() - 1) ;
	}
	return;
	}

	/**
	Mutator to move the Monster position down by one spot. 
	*/
	public void moveDown(){
	position.setYCoordinate(position.getYCoordinate() + 1) ;
	return;
	}
	
	/**
	Accessor returns a boolean value as to whether the Monster is alive, namely their health >0.
	@return returns a boolean, true if Monster is alive with health > 0 , false if Monster has health <=0. 
	*/
	public boolean isAlive(){
		if (health > 0){
		return true;
		} 
	return false;
	}
	
	/**
	Mutator sets Monster health to zero, removes items Key, and outputs a death message.
	*/
	public void die() {
	health = 0;
	hasKey=false;
	deathMessage();
	return ;
	}

///////////////////////////// DISPLAY INFORMATION METHODS ///////////////////////////////////

	//// OVER-RIDDEN and POLYMORPHIC METHODS extended from entity

	/**
	Accessor displays Monster Statistics in a decorative manner.
	*/
	public void displayStats(){
	System.out.println("=======MONSTER STATS=======");
	System.out.println("Health = " + health); 
	System.out.println("Attack Strength= " + attackStrength);
	System.out.println("Has key = " + hasKey);
	System.out.println("Position = " + position.toString());  
	
	}
 
 
	public void deathMessage(){
	System.out.println("Monster Gasps and Screams:");
	System.out.println("Keith Richards Lives On!  Arrrgghhhh!");
	return;
	}
 
 
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
