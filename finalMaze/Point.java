package finalMaze;




import java.util.Random;

/**
Class Point creates a point with an xCoordinate and a yCoordinate
@author (Ron) Zorondras Rodriguez
@version 0.02
@since July 20, 2019
*/
public class Point {

/////////////////  MEMBER VARIABLES  ///////////////////////////////////////

private int xCoordinate;
private int yCoordinate;

/////////////////  CONSTRUCTORS /////////////////////////////////////////////

	// default constructor
	/**
	Default constructor sets xCoordinate, and yCoordinate to (0,0)
	*/
	public Point(){
	xCoordinate = 0;
	yCoordinate = 0;
	}
	
	// input constructor
	/**
	Input constructor constructs a point with x and y coordinates both >= 0, default to 0,0 if either input is negative.
	@param x The x-coordinate
	@param y The y-coordinate 
	*/
	public Point(int x, int y){
	
		if (x >= 0 && y >= 0 ){
		xCoordinate = x;
		yCoordinate = y;
		} else {
		xCoordinate = 0;
		yCoordinate = 0;
		}
	}

	// copy constructor 
	/**
	Copy constructor, copies the x and y coordinates from a point into a new point object
	@param p a point of Class Point
	*/
	public Point( Point p){
		if (p.xCoordinate >=0 && p.yCoordinate >= 0 ){
		xCoordinate = p.xCoordinate;
		yCoordinate = p.yCoordinate;
		} else {
		xCoordinate = 0;
		yCoordinate = 0;
		}
	}

////////////////   ACCESSORS //////////////////////////////////////////////////

	/**
	Get Point returns a copy of the point as a new Point object
	@return a Point object with a copy of the x and y coordinates of the original point object 
	*/
	public Point getPoint(){
	Point temp = new Point(xCoordinate, yCoordinate);
	return temp;
	}

	/**
	Getter for the xCoordinate
	@return an integer with the value of the x-coordinate in the point
	*/
	public int getXCoordinate(){
	return xCoordinate;
	}
	/**
	Getter for the yCoordinate
	@return an integer with the value of the y-coordinate in the point
	*/
	public int getYCoordinate(){
	return yCoordinate;
	}

///////////////////////// MUTATORS ////////////////////////////////////////////

	/**
	Sets the x and y coordinates to be the same as the input point values provided that they are >= 0 , set to (0,0) otherwise 
	@param p Point to copy values from 
	*/
	public void setPoint(Point p){
		if (p.xCoordinate >= 0 && p.yCoordinate >= 0 ){
		xCoordinate = p.xCoordinate;
		yCoordinate = p.yCoordinate;
		} else {
		xCoordinate = 0;
		yCoordinate = 0;
		}
	return;
	}


	/**
	Sets the x coordinate of the point to be the same as the input value provided it is  >= 0 , does nothing otherwise 
	@param x integer to use to set value of the x Coordinate of the point  
	*/
	public void setXCoordinate(int x){	
		if (x >= 0 ){
		xCoordinate = x;
		}
	return;
	}
	
	/**
	Sets the y coordinate of the point to be the same as the input value provided it is  >= 0 , does nothing otherwise 
	@param y integer to use to set value of the y Coordinate of the point  
	*/
	public void setYCoordinate(int y){
		if (y >= 0 ){
		yCoordinate = y;
		}
	return;
	}

//////////////////////////   OTHER METHODS     ///////////////////////////////////////

 	/**
	Returns a string representation of the data members in a point object 
	@return a string representation of the point in format (x,y) 
	*/
	public String toString(){
	String temp = "";
	temp = temp + "(" + xCoordinate+ "," + yCoordinate + ")";
	return temp;
	}
	
	
	/**
	Returns whether another point object has the same x and y coordinates at the current object 
	@param p a Point object
	@return a boolean representing whether the object is equal in x and y coordinates to the input test point returns true if both coordinates are equal false otherwise 
	*/
	public boolean isEqual(Point p){
		if ( p.getXCoordinate() == xCoordinate && p.getYCoordinate() == yCoordinate){
		return true;
		}
	return false;
	}
	
	
	/**
	A mutator that sets the point x and y coordinates to be random integers from 0 inclusive up to variable sz exclusive. Uses a random number generator Random().  
	@param sz a positive integer  
	*/
	public void setRandom(int sz){
		if (sz <0){  // disallow or correct negative integers take the positive counterpart 
		sz*=-1;
		}
	Random randGen = new Random();  // make a random number generator 
	
	xCoordinate = randGen.nextInt(sz);
	yCoordinate = randGen.nextInt(sz);
	
	return;
	}
	
		
} // end of class definition
///////////////////////// END OF FILE //////////////////////////////////////////
