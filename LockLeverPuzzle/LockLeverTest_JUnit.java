package LockLeverPuzzle;
/**
 * @author Fiona
 *
 * Version updated: August 7, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class LockLeverTest_JUnit {
	//setLeverPiece1
	@Test
	public void test_setLeverPiece1_hasPiece() {
		boolean test = true;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece1(true);
		boolean has = ll.getLeverPiece1();
		
		assertEquals(test,has);
	}
	//setLeverPiece2
	@Test
	public void test_setLeverPiece2_hasPiece() {
		boolean test = true;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece2(true);
		boolean has = ll.getLeverPiece2();
		
		assertEquals(test,has);
	}
	//combinedLeverPiece
	@Test
	public void test_combinedLeverPiece_hasNoPieces() {
		boolean test = false;
		
		LockLever ll = new LockLever();
		boolean has = ll.combinedLever();
		
		assertEquals(test,has);
	}
	
	@Test
	public void test_combinedLeverPiece_hasOnePiece_Piece1() {
		boolean test = false;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece1(true);
		boolean has = ll.combinedLever();
		
		assertEquals(test,has);
	}
	
	@Test
	public void test_combinedLeverPiece_hasOnePiece_Piece2() {
		boolean test = false;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece2(true);
		boolean has = ll.combinedLever();
		
		assertEquals(test,has);
	}
	@Test
	public void test_combinedLeverPiece_hasBothPieces() {
		boolean test = true;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece1(true);
		ll.setLeverPiece2(true);
		boolean has = ll.combinedLever();
		
		assertEquals(test,has);
	}

}