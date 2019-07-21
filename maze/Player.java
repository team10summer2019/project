//////////////////////////////////////////////
//
// File: Player.java
// Description: Player class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.01
// Revision Date: July 20, 2019
//
///////////////////////////////////////////////

// Player:  Attributes - (x,y) Point location, Health, hasKey, attackStrength
//          Methods- moveLeft(), moveRight(), moveUp(), moveDown(),
//	           searchRoom(), attack(), openDoor() , die() , isAlive()


public class Player {

////////////////////// MEMBER VARIABLES /////////////////////////////////////

private Point position;
private int health;
private boolean hasKey;
private int attackStrength;

//////////////////////  CONSTRUCTORS     //////////////////////////////////////////

	// default constructor
	public Player(){
	position = new Point(0,0);
	health = 30;
	hasKey = false;
	attackStrength = 4;
	}

	// input constructor
	public Player(Point p, int heal, int strength ){
	position = new Point(0,0);
	hasKey = false;
	
		if (heal >5){
		health = heal;
		}
		else { health = 30; }  
	
		if ( strength >=1){
		attackStrength = strength;
		}else { attackStrength = 4;}
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
	
	public void setHasKey( boolean val){
	hasKey= val;
	return;
	}

	public void setAttackStrength(int strength){
		if (strength >= 1){
		attackStrength=strength;
		}
	}

///////////////////////   OTHER METHODS /////////////////////////////////////////////
	
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
	position.setYCoordinate(position.getYCoordinate() + 1) ;
	return;
	}

	public void moveDown(){
		if ( position.getYCoordinate() -1 >=0){
		position.setYCoordinate(position.getYCoordinate() - 1) ;
		}	
	return;
	}

	private boolean isAlive(){
		if (health >= 0){
		return true;
		} 
	return false;
	}
	
	private void die() {
	health = 0;
	return ;
	}

///////////////////////////// DISPLAY INFORMATION METHODS ///////////////////////////////////

	public void displayStats(){
	
	System.out.println("Health = " + health); 
	System.out.println("Attack Strength= " + attackStrength);
	System.out.println("Has key = " + hasKey);
	System.out.println("Position = (" + position.getXCoordinate() + "," + position.getYCoordinate() + ")");  
	
	}

////////////////////////////   METHODS TO IMPLEMENT      //////////////////////////////////	

///////////////////////   OTHER METHODS  ////////////////////////////////////////////
//    searchRoom(), attack(), openDoor() , 

		
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
