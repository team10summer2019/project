
/**
 * @author Fiona Yong
 * @version August 8, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class Room1HaineTest_JUnit {
	//constructor passing inventory and floor inventory
	@Test
	public void test_InventoryTransfer_GenericRoomToRoom1Haine() {
		//setup
		GenericRoom gr = new GenericRoom();
		gr.uniqueObject_toInventory("leverPiece1");
		ArrayList<String> expected = gr.playerInventory.getInventory();
		//test
		Room1Haine r1 = new Room1Haine(gr);
		ArrayList<String> output = r1.playerInventory.getInventory();
		
		assertEquals(expected,output);
	}
	
	//constructor passing inventory and floor inventory
	@Test
	public void test_FloorInventoryTransfer_GenericRoomToRoom1Haine() {
		//setup
		GenericRoom gr = new GenericRoom();
		gr.uniqueObject_toInventory("leverPiece1");
		ArrayList<String> expected = gr.roomInventory.getFloorInventory();
		//test
		Room1Haine r1 = new Room1Haine(gr);
		ArrayList<String> output = r1.roomInventory.getFloorInventory();
		
		assertEquals(expected,output);
	}
}
