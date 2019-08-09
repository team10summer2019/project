package finalMaze;


/**
Class Door creates a Door that has a Point location and a boolean isLocked
@author (Ron) Zorondras Rodriguez
@version 0.02
@since July 21, 2019
*/
public class Door {

/////////////////// Member Variables ///////////////////////////////

private boolean isLocked;
private Point location;

//////////////////// CONSTRUCTORS /////////////////////////////////////

	// default constructor
	/**
	Default constructor sets default location to (1,0) , and isLocked to true, a locked door
	*/
	public Door(){
	isLocked=true;
	location= new Point(1,0); 
	}
	
	// input constructor
	/**
	Input constructor sets the location by x,y coordinate pair input and isLocked to the boolean value of locked.
	@param x the x-coordinate of the door location 
	@param y the y-coordinate of the door location 
	@param locked boolean that decleares the door locked if true open if false
	*/
	public Door(int x, int y,boolean locked){
	isLocked=locked;
	location= new Point(x,y); 
	}

	// input constructor
	/**
	Input constructor sets the location by x,y coordinate pair input and isLocked is defaulted to true, a locked door
	@param x the x-coordinate of the door location 
	@param y the y-coordinate of the door location 
	*/
	public Door(int x, int y){
	isLocked=true;
	location= new Point(x,y); 
	}

	// Point input constructor
	/**
	Point Input constructor sets the location of the door with a Point p and boolean isLocked set to input value locked
	@param p A point location for the door 
	@param locked a boolean value for whether the door is locked or open locked if true, open if false 
	*/
	public Door(Point p, boolean locked){
	isLocked=locked;
	location= new Point(p);
	}
	
	// Point input constructor
	/**
	Point Input constructor sets the location of the door with a Point p and boolean isLocked set to a default value of true
	@param p A point location for the door 
	*/
	public Door(Point p){
	isLocked=true;
	location= new Point(p);
	}
		
	// Copy constructor
	/**
	Copy constructor sets the location of the door to be the same as Door d, with the same locked boolean status.
	@param d A Door class object 
	*/
	public Door(Door d){
	isLocked=d.isLocked;
	location= new Point(d.location);
	}

/////////////////////   ACCESSORS //////////////////////////////////////////
	
	/**
	Accessor gets the boolean value of isLocked variable
	@return returns the boolean value of isLocked the state of the door true if locked false if open 
	*/
	public boolean getIsLocked(){
	return isLocked;
	}
	/**
	Accessor returns a Point with the location of the door
	@return returns a Point with the location of the door, this is a copy/clone variable returned. 
	*/
	public Point getLocation(){
	Point temp = new Point(location); // copy construct
	return temp;
	}
///////////////////////  MUTATORS //////////////////////////////////////////

	/**
	Mutator sets the isLocked boolean to value
	@param value the boolean value to set isLocked to true if locked false if open. 
	*/
	public void setIsLocked(boolean value){
	isLocked=value;
	return;
	}
	/**
	Mutator sets the door location to be the same x,y coordinates as point p
	@param p a Point location of where to place the door. 
	*/
	public void setLocation(Point p){
	location.setPoint(p); // use the input validation method from point
	return;
	}
	/**
	Mutator sets the door location to be the same x,y coordinates as the input coordinates x and y
	@param x an integer x-coordinate to place the door. 
	@param y an integer y-coordinate to place the door. 
	*/
	public void setLocation(int x, int y){
	location.setXCoordinate(x);  // take advantage of input validation in Point class 
	location.setYCoordinate(y);
	return;
	}

} // end of class definition
/////////////////////////////// END OF FILE //////////////////////////////////////////