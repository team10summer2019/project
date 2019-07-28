//////////////////////////////////////////////
//
// File: Player.java
// Description: Monster class
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


public class Monster {

////////////////////// MEMBER VARIABLES /////////////////////////////////////

private Point position;
private int health;
private boolean hasKey;
private int attackStrength;

//////////////////////  CONSTRUCTORS     //////////////////////////////////////////

	// default constructor
	public Monster(){
	position = new Point(0,3);
	health = 15;
	hasKey = false;
	attackStrength = 3;
	}

	// input constructor
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
		if (healthIn >= 0) {
		health= healthIn;
		}else { health = 0;}
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

	public void takesDamage(int damage){
		if (damage > 0){
		health -= damage;
		}
	return;
	}

///////////////////////   OTHER METHODS /////////////////////////////////////////////

////////////  FIGHTING METHODS ///////////////////////////////////////////////////
	public void attacks(Player p){
	p.takesDamage(attackStrength);
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
	position.setYCoordinate(position.getYCoordinate() - 1) ;
	return;
	}

	public void moveDown(){
		if ( position.getYCoordinate() -1 >=0){
		position.setYCoordinate(position.getYCoordinate() + 1) ;
		}	
	return;
	}

	public boolean isAlive(){
		if (health >= 0){
		return true;
		} 
	return false;
	}
	
	private void die() {
	health = 0;

	System.out.println("Monster Gasps and Screams:");
	System.out.println("Keith Richards Lives On!  Arrrgghhhh!");
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
//    searchRoom(), openDoor() , 

		
} // class definition brace
////////////////////////////// END OF FILE ///////////////////////////////////////////
