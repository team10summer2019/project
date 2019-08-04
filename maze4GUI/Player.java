//////////////////////////////////////////////
//
// File: Player.java
// Description: Player class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.02
// Revision Date: July 21, 2019
//
///////////////////////////////////////////////

// Player:  Attributes - (x,y) Point location, Health, hasKey, attackStrength
//          Methods- moveLeft(), moveRight(), moveUp(), moveDown(),
//	           searchRoom(), attack(), openDoor() , die() , isAlive()

import java.util.Random;

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
	public Player(){
	position = new Point(0,0);
	health = 35;
	hasKey = false;
	hasMap = false;
	attackStrength = 7;
	}

	// input constructor
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

	public Point getPosition(){
	Point temp = new Point(position);
	return temp;
	}

	public int getHealth(){
	return health;
	}
	
	public boolean getHasKey(){
	return hasKey;
	}
	
	public boolean getHasMap(){
	return hasMap;
	}

	public int getAttackStrength(){
	return attackStrength;
	}

//////////////////////   MUTATORS      /////////////////////////////////////////////
	
	// point input
	public void setPosition(Point p){
	position.setPoint(p);
	return;
	}
	
	/// overload for coordinate pair input
	public void setPosition(int x, int y){
	position.setXCoordinate(x);
	position.setYCoordinate(y);
	return;
	}
	
	
	public void setHealth( int healthIn){
		if (healthIn > 0) {
		health= healthIn;
		}
	return;
	}
	
	// use for eating Gruel
	public void addHealth( int amount){
		if (amount > 0) {
		health+= amount;
		}
	return;
	}
	
	public void setHasKey( boolean val){
	hasKey= val;
	return;
	}
	
	public void setHasMap( boolean val){
	hasMap= val;
	return;
	}

	public void setAttackStrength(int strength){
		if (strength >= 1){
		attackStrength=strength;
		}
	}


	public void takesDamage(int damage){
		if (damage > 0){
		health -= damage;
		}
	return;
	}

///////////////////////   OTHER METHODS /////////////////////////////////////////////

////////////  FIGHTING METHODS ///////////////////////////////////////////////////


	public void attacks(Monster m){
	
	int damageAmount ;
	
	damageAmount = attackStrength + randGen.nextInt(5);  // add a random component to the attack damage 
	
	m.takesDamage(damageAmount);   // maybe make this random from 0 - attackStrentgh*2
	return;
	}

//////////////////////   Motion Methods /////////////////////////////////////////////

	public void moveLeft(){
		if ( position.getXCoordinate() -1 >=0){
		position.setXCoordinate(position.getXCoordinate()-1) ;
		}	
	return;
	}

	public void moveRight(){
	position.setXCoordinate(position.getXCoordinate()+1) ;
	return;
	}

	public void moveUp(){

	if ( position.getYCoordinate() -1 >=0) {
	position.setYCoordinate(position.getYCoordinate() - 1) ;
	}
	return;
	}

	public void moveDown(){
	position.setYCoordinate(position.getYCoordinate() + 1) ;
	return;
	}

	public boolean isAlive(){
		if (health > 0){
		return true;
		} 
	return false;
	}
	
	public void die() {
	health = 0;
	hasKey=false;
	hasMap=false;
	System.out.println("Our Hero Gasps and Screams:");
	System.out.println("My quest is finished! Arrrgghhhh!");
	return ;
	}

///////////////////////////// DISPLAY INFORMATION METHODS ///////////////////////////////////

	public void displayStats(){
	System.out.println("=======PLAYER STATS=======");
	System.out.println("Health = " + health + " "); 
	System.out.println("Attack Strength= " + attackStrength + " ");
	System.out.print("Has Key = " + hasKey +", ");
	System.out.println("Has Map = " + hasMap + " ");
	System.out.println("Position = (" + position.getXCoordinate() + "," + position.getYCoordinate() + ")");  
	
	}

////////////////////////////   METHODS TO IMPLEMENT      //////////////////////////////////	

///////////////////////   OTHER METHODS  ////////////////////////////////////////////
//    searchRoom(),

		
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
