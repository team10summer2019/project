package JUnitTests;
import static org.junit.Assert.*;
import FinalGUI.Point;

import org.junit.Test;

public class PointTest {

	
	@Test
	public void test_Constructor_Point() {
		Point p = new Point(0,0);
		assertEquals("Created Point(0,0) - testing x value", 0, p.getXCoordinate());
		assertEquals("Created Point(0,0) - testing y value", 0, p.getYCoordinate());
	}
	
	@Test 
	public void test_Constructor_NegativeX() {
		Point p = new Point(-1,10);
		assertEquals("Created Point(-1,10) - testing x value", 0, p.getXCoordinate());
		assertEquals("Created Point(-1,10) - testing y value", 0, p.getYCoordinate());
	}
	
	@Test
	public void test_Constructor_NegativeY() {
		Point p = new Point(5,-4);
		assertEquals("Created Point(5,-4) - testing x value", 0, p.getXCoordinate());
		assertEquals("Created Point(5,4) - testing y value", 0, p.getYCoordinate());
	}
	
	@Test
	public void test_Constructor_NegativeXandY() {
		Point p = new Point(-2,-11);
		assertEquals("Created Point(-2,-11) - testing x value", 0, p.getXCoordinate());
		assertEquals("Created Point(-2,-11) - testing y value", 0, p.getYCoordinate());
	}

	@Test
	public void test_Constructor_PositiveXandY() {
		Point p = new Point(5,7);
		assertEquals("Created Point(5,7) - testing x value", 5, p.getXCoordinate());
		assertEquals("Created Point(5,7) - testing y value", 7, p.getYCoordinate());
	}

	@Test
	public void test_CopyConstructor() {
		Point p = new Point(5,7);
		Point p2 = new Point(p);
		assertEquals("Created Point(5,7) and copied it.  Testing x value of original.", 5, p.getXCoordinate());
		assertEquals("Created Point(5,7) and copied it.  Testing y value of original.", 7, p.getYCoordinate());
		assertEquals("Created Point(5,7) and copied it.  Testing x value of copy.", 5, p.getXCoordinate());
		assertEquals("Created Point(5,7) and copied it.  Testing y value of copy.", 7, p.getYCoordinate());
	}
	
	
	@Test
	public void test_setPoint() {
		Point p = new Point(3,1);
		p.setPoint(p);
		assertEquals("Set point(3,1) - testing x value", 3, p.getXCoordinate());
		assertEquals("Set point(3,1) - testing y value", 1, p.getYCoordinate());
	}
	
	@Test
	public void test_setPoint_negativeXandY() {
		Point p = new Point(-3,-1);
		p.setPoint(p);
		assertEquals("Set point(-3,-1) - testing x value", 0, p.getXCoordinate());
		assertEquals("Set point(-3,-1) - testing y value", 0, p.getYCoordinate());
	}
	
	@Test
	public void test_setXCoordinate_Negative() {
		Point p = new Point(20,19);
		p.setXCoordinate(-54);
		assertEquals("Created Point(20,19) then set xcoord to -54 - testing x value", 20, p.getXCoordinate());
		assertEquals("Created Point(20,19 then set xcoord to -54 - testing y value", 19, p.getYCoordinate());
	}
	
	@Test
	public void test_setYCoordinate_Negative() {
		Point p = new Point(2,7);
		p.setYCoordinate(-32);
		assertEquals("Created Point(2,7) then set ycoord to -32 - testing x value", 2, p.getXCoordinate());
		assertEquals("Created Point(2,7) then set ycoord to -32 - testing y value", 7, p.getYCoordinate());
	}

	@Test
	public void test_setXCoordinate_Positive() {
		Point p = new Point(3,2);
		p.setXCoordinate(1);
		assertEquals("Created Point(3,2) then set xcoord to 1 - testing x value", 1, p.getXCoordinate());
		assertEquals("Created Point(3,2) then set xcoord to 1 - testing y value", 2, p.getYCoordinate());
	}
	
	@Test
	public void test_setYCoordinate_Positive() {
		Point p = new Point(2,3);
		p.setYCoordinate(9);
		assertEquals("Created Point(2,3) then set ycoord to 9 - testing x value", 2, p.getXCoordinate());
		assertEquals("Created Point(2,3) then set ycoord to 9 - testing y value", 9, p.getYCoordinate());
	}
	
	public void test_toString() {
		Point p = new Point(2,3);
		assertEquals("Created Point(2,3)", "(2,3)", p.toString());
	}
	
	@Test
	public void test_isEquals_X() {
		Point p1 = new Point(2,20);
		boolean same = p1.getXCoordinate() == p1.getXCoordinate();
		assertTrue("Expected variables that reference same object to be equal", same);
	}
	
	@Test
	public void test_isEquals_Y() {
		Point p1 = new Point(2,20);
		boolean same = p1.getYCoordinate() == p1.getYCoordinate();
		assertTrue("Expected variables that reference same object to be equal", same);
	}
}
	
	
