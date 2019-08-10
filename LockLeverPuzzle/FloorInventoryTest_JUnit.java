package LockLeverPuzzle;


/**
 * @author Fiona
 *
 * Version updated: August 7, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class FloorInventoryTest_JUnit {
		//Constructor
		@Test
		public void test_FloorInventory_newInstance() {
			//setup
			ArrayList<String> test = new ArrayList<String>();
			test.add("leverPiece1");
			test.add("leverPiece2");
			test.add("cabinetKey");
			String expect = ""+test;
			//test
			FloorInventory fi = new FloorInventory();
			String output = fi.viewFloorInventory();
			
			assertEquals(expect,output);
			
		}
		//Methods
		//add item to add_unique_flrInv
		@Test
		public void test_add_unique_flrInv_oneItem() {
			ArrayList<String> test = new ArrayList<String>();
			test.add("leverPiece1");
			test.add("leverPiece2");
			test.add("cabinetKey");
			test.add("apple");
			String expect = ""+test;
			
			FloorInventory fi = new FloorInventory();
			fi.add_unique_flrInv("apple");
			String output = fi.viewFloorInventory();
			assertEquals(expect,output);
		}
		//removing item from remove_flrInv
		@Test
		public void test_remove_flrInv() {
			ArrayList<String> test = new ArrayList<String>();
			test.add("leverPiece1");
			test.add("leverPiece2");
			test.add("cabinetKey");
			test.remove("leverPiece1");
			String expect = ""+test;
			
			FloorInventory fi = new FloorInventory();
			fi.remove_flrInv("leverPiece1");
			String output = fi.viewFloorInventory();
			assertEquals(expect,output);
		}
		//view floor inventory, empty floor inventory
		@Test
		public void test_viewFloorInventory_emptyInventory() {
			//setup
			ArrayList<String> empty = new ArrayList<String>();
			String emptyStr = ""+empty;
			//test
			FloorInventory fi = new FloorInventory();
			fi.remove_flrInv("leverPiece1");
			fi.remove_flrInv("leverPiece2");
			fi.remove_flrInv("cabinetKey");
			String output = fi.viewFloorInventory();
			assertEquals(emptyStr,output);
		}
		//view floor inventory, floor inventory with items
		@Test
		public void test_viewInventory_itemsInInventory() {
			//setup
			ArrayList<String> list = new ArrayList<String>();
			list.add("leverPiece1");
			list.add("leverPiece2");
			list.add("cabinetKey");
			String listStr = ""+list;
			//test
			FloorInventory fi = new FloorInventory();
			String output = fi.viewFloorInventory();
			assertEquals(listStr,output);
		}
}
