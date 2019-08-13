

/**
 * @author Fiona
 * @version August 9, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class DynamicObjectsTest_JUnit {

	@Test
	public void test_changeStatus_dynObj_default() {
		GenericRoom gr = new GenericRoom();

		boolean output = gr.lockLeverCheck.getLeverPiece1();
		assertEquals(false, output);
	}

	@Test
	public void test_changeStatus_dynObj_changeleverP1Stat() {
		GenericRoom gr = new GenericRoom();
		gr.uniqueObject_toInventory("leverPiece1");

		boolean output = gr.lockLeverCheck.getLeverPiece1();
		assertEquals(true, output);
	}

	@Test
	public void test_changeStatus_dynObj_passThroughClasses() {
		GenericRoom gr = new GenericRoom();
		gr.uniqueObject_toInventory("leverPiece1");
		Room4 r = new Room4(gr);
		boolean output = r.lockLeverCheck.getLeverPiece1();

		assertEquals(true, output);
	}

	@Test
	public void test_changeStatus_dynObj_addedThroughSubclasses() {
		GenericRoom gr = new GenericRoom();
		Room4 r = new Room4(gr);
		r.uniqueObject_toInventory("leverPiece1");
		boolean output = r.lockLeverCheck.getLeverPiece1();

		assertEquals(true, output);
	}
}

/*
 * public static void main(String[] args) { DynamicObjects lever_keys = new
 * DynamicObjects();
 * 
 * //Finding first dynamic object
 * lever_keys.changeStatus_dynObj(lever_keys.leverP1);
 * lever_keys.addItemToInventory(lever_keys.leverP1);
 * lever_keys.viewInventory();
 * 
 * //Finding second dynamic object
 * lever_keys.changeStatus_dynObj(lever_keys.leverP2);
 * lever_keys.addItemToInventory(lever_keys.leverP2);
 * lever_keys.viewInventory();
 * 
 * lever_keys.removeItemFromInventory("leverPiece1");
 * lever_keys.viewInventory();
 * 
 * ////////////////////////////////
 * 
 * } }
 */
