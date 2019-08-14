//////////////////////////////////////////////
//
// File: Door.java
// Description: Door Class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 21, 2019
// Version: 0.01
// Revision Date: July 21, 2019
//
///////////////////////////////////////////////
 
package FinalText;

public class Door {

/////////////////// Member Variables ///////////////////////////////

private boolean isLocked;
private Point location;

//////////////////// CONSTRUCTORS /////////////////////////////////////

	//default constructor
	public Door(){
	isLocked=true;
	location= new Point(1,0); 
	}
	
	// input constructor
	public Door(int x, int y,boolean locked){
	isLocked=locked;
	location= new Point(x,y); 
	}

	public Door(int x, int y){
	isLocked=true;
	location= new Point(x,y); 
	}

	// Point input constructor
	public Door(Point p, boolean locked){
	isLocked=locked;
	location= new Point(p);
	}
	
	// Point input constructor
	public Door(Door d){
	isLocked=d.isLocked;
	location= new Point(d.location);
	}

/////////////////////   ACCESSORS //////////////////////////////////////////

	public boolean getIsLocked(){
	return isLocked;
	}
	public Point getLocation(){
	Point temp = new Point(location); // copy construct
	return temp;
	}
///////////////////////  MUTATORS //////////////////////////////////////////

	public void setIsLocked(boolean value){
	isLocked=value;
	return;
	}
	
	public void setLocation(Point p){
	location = new Point(p); // copy construct
	return;
	}
	public void setLocation(int x, int y){
	location = new Point(x,y); // copy construct
	return;
	}

} // end of class definition
/////////////////////////////// END OF FILE //////////////////////////////////////////