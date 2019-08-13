

/**
 * @author Fiona
 *
 * Version updated: August 8, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class GenericRoom_JUnit {
	// default constructor
	/*
	 * make sure inventory is empty
	 */
	@Test
	public void test_GenericRoom_checkStartupInv() {
		// setup
		ArrayList<String> expected = new ArrayList<String>();
		GenericRoom gr = new GenericRoom();
		ArrayList<String> output = gr.playerInventory.getInventory();

		assertEquals(expected, output);
	}

	// default constructor
	/*
	 * make sure floor inventory is not empty
	 */
	@Test
	public void test_GenericRoom_checkStartupFloorInv() {
		// setup
		ArrayList<String> expected = new ArrayList<String>();
		GenericRoom gr = new GenericRoom();
		ArrayList<String> output = gr.roomInventory.getFloorInventory();
		assertNotEquals(expected, output);
	}
}
