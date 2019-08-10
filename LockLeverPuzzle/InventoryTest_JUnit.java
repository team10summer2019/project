
/**
 * @author Fiona
 *
 * Version updated: August 8, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class InventoryTest_JUnit {
		//Constructor
		//copy constructor
		@Test
		public void test_Inventory_toCopy() {
			//setup
			Inventory a = new Inventory();
			a.addItemToInventory("apple");
			a.addItemToInventory("orange");
			a.addItemToInventory("pear");
			String copyingFrom = a.viewInventory();
			
			//test
			Inventory i = new Inventory(a);
			String output = i.viewInventory();
			
			assertEquals(copyingFrom,output);
		}
		//Methods
		//getInventory(isolated)
		@Test 
		public void test_getInventory_emptyInventory() {
			ArrayList<String> empty = new ArrayList<String>();
			
			Inventory i = new Inventory();
			ArrayList<String> output = i.getInventory();
			assertEquals(empty,output);
		}
		//addItemtoInventory
		@Test
		public void test_addItemToInventory_oneItem() {
			ArrayList<String> one = new ArrayList<String>();
			one.add("apple");
			
			Inventory i = new Inventory();
			i.addItemToInventory("apple");
			ArrayList<String> output = i.getInventory();
			assertEquals(one,output);
		}
		//addUniqueItemToInventory
		@Test
		public void test_addUniqueItemToInventory_duplicateItem() {
			ArrayList<String> one = new ArrayList<String>();
			one.add("apple");
			
			Inventory i = new Inventory();
			i.addUniqueItemToInventory("apple");
			i.addUniqueItemToInventory("apple");
			ArrayList<String> output = i.getInventory();
			assertEquals(one,output);
		}
		//removing normal item(with duplicates) from removeItemFromInventory
		@Test
		public void test_removeItemFromInventory_normalItem() {
			//setup
			ArrayList<String> one = new ArrayList<String>();
			one.add("pear");
			one.add("orange");
			one.add("pear");
			
			Inventory i = new Inventory();
			i.addItemToInventory("pear");
			i.addItemToInventory("orange");
			i.addItemToInventory("pear");
			//removal
			one.remove("pear");
			i.removeItemFromInventory("pear");
			
			ArrayList<String> output = i.getInventory();
			assertEquals(one,output);
		}
		//removing uniqueItem(no duplicates) from removeItemFromInventory
		@Test
		public void test_removeItemFromInventory_uniqueItem() {
			//setup
			ArrayList<String> normalItem = new ArrayList<String>();
			normalItem.add("orange");

			
			Inventory i = new Inventory();
			i.addUniqueItemToInventory("apple");
			i.addItemToInventory("orange");
			i.addUniqueItemToInventory("apple"); //add duplicate test
			
			//removal
			i.removeItemFromInventory("apple");
			
			ArrayList<String> output = i.getInventory();
			assertEquals(normalItem,output);
		}
		//has no item Inventory
		@Test
		public void test_hasItemInInventory_noItem() {
			//setup
			ArrayList<String> none = new ArrayList<String>();
			boolean hasNone = none.contains("orange");
			//test
			Inventory i = new Inventory();
			boolean output = i.hasItemInInventory("orange");
			
			assertEquals(hasNone,output);
		}
		//has no item in an Inventory with items
		@Test
		public void test_hasItemInInventory_multipleItemInventory() {
			//setup
			ArrayList<String> some = new ArrayList<String>();
			some.add("apple");
			some.add("pear");
			boolean hasOrange = some.contains("orange");
			//test
			Inventory i = new Inventory();
			i.addItemToInventory("apple");
			i.addItemToInventory("pear");
			boolean output = i.hasItemInInventory("orange");
			
			assertEquals(hasOrange,output);
		}
		//has item in an Inventory
		@Test
		public void test_hasItemInInventory_itemInInventory() {
			//setup
			ArrayList<String> some = new ArrayList<String>();
			some.add("apple");
			some.add("pear");
			boolean hasOrange = some.contains("pear");
			//test
			Inventory i = new Inventory();
			i.addItemToInventory("apple");
			i.addItemToInventory("pear");
			boolean output = i.hasItemInInventory("pear");
			
			assertEquals(hasOrange,output);
		}
		//viewInventory empty inventory
		@Test
		public void test_viewInventory_emptyInventory() {
			//setup
			ArrayList<String> empty = new ArrayList<String>();
			String emptyStr = ""+empty;
			//test
			Inventory i = new Inventory();
			String output = i.viewInventory();
			
			assertEquals(emptyStr,output);
		}
		//viewInventory inventory with items
		@Test
		public void test_viewInventory_itemsInInventory() {
			//setup
			ArrayList<String> list = new ArrayList<String>();
			list.add("apple");
			list.add("orange");
			list.add("pear");
			String list_Str = ""+list;
			
			//test
			Inventory i = new Inventory();
			i.addItemToInventory("apple");
			i.addItemToInventory("orange");
			i.addItemToInventory("pear");
			String output = i.viewInventory();
			
			assertEquals(list_Str,output);
		}
}
