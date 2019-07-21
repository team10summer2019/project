//////////////////////////////////////////////
//
// File: Point.java
// Description: Point class
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 20, 2019
// Version: 0.01
// Revision Date: July 20, 2019
//
///////////////////////////////////////////////

public class Point {

/////////////////  MEMBER VARIABLES  ///////////////////////////////////////

private int xCoordinate;
private int yCoordinate;


/////////////////  CONSTRUCTORS /////////////////////////////////////////////

	// copy constructor
	public Point(){
	xCoordinate = 0;
	yCoordinate = 0;
	}
	
	// input constructor
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

	public Point getPoint(){
	Point temp = new Point(xCoordinate, yCoordinate);
	return temp;
	}

	public int getXCoordinate(){
	return xCoordinate;
	}

	public int getYCoordinate(){
	return yCoordinate;
	}

///////////////////////// MUTATORS ////////////////////////////////////////////

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

	public void setXCoordinate(int x){	
		if (x >= 0 ){
		xCoordinate = x;
		}
	return;
	}
	public void setYCoordinate(int y){
		if (y >= 0 ){
		yCoordinate = y;
		}
	return;
	}

//////////////////////////   OTHER METHODS     ///////////////////////////////////////

} // end of class definition
///////////////////////// END OF FILE //////////////////////////////////////////
