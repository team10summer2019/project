package LockLeverPuzzle;
/**
 * @author Fiona
 * @version August 9, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class LockLeverTest_JUnit {
	//copy constructor
	@Test
	public void test_LockLever_defaultSettings() {
		//setup
		GenericRoom gr = new GenericRoom();
		boolean expected = gr.lockLeverCheck.combinedLeverStatus();
	
		//test
		LockLever ll = new LockLever(gr);
		boolean output = ll.combinedLeverStatus();
		
		assertEquals(expected,output);
	}
	
	public void test_LockLever_allTrueSettings() {
		//setup
		GenericRoom gr = new GenericRoom();
		gr.uniqueObject_toInventory("leverPiece1");
		gr.uniqueObject_toInventory("leverPiece2");
		gr.lockLeverCheck.combinedLeverStatus();
		boolean expected = gr.lockLeverCheck.getObjLeverKey();
		//test
		LockLever ll = new LockLever(gr);
		ll.combinedLeverStatus();
		boolean output = ll.getObjLeverKey();
		
		assertEquals(expected,output);
	}
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
		boolean has = ll.combinedLeverStatus();
		
		assertEquals(test,has);
	}
	
	@Test
	public void test_combinedLeverPiece_hasOnePiece_Piece1() {
		boolean test = false;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece1(true);
		boolean has = ll.combinedLeverStatus();
		
		assertEquals(test,has);
	}
	
	@Test
	public void test_combinedLeverPiece_hasOnePiece_Piece2() {
		boolean test = false;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece2(true);
		boolean has = ll.combinedLeverStatus();
		
		assertEquals(test,has);
	}
	@Test
	public void test_combinedLeverPiece_hasBothPieces() {
		boolean test = true;
		
		LockLever ll = new LockLever();
		ll.setLeverPiece1(true);
		ll.setLeverPiece2(true);
		boolean has = ll.combinedLeverStatus();
		
		assertEquals(test,has);
	}

}