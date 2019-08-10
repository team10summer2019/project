/**
 * @author Fiona
 *
 * Version updated: August 8, 2019
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest_JUnit {
	@Test
	public void test_Player() {
		//setup
		ArrayList<String> expected = new ArrayList<String>();
		//test
		Player p1 = new Player();
		ArrayList<String> output = p1.getPlayerInventory();
		
		assertEquals(expected,output);
	}
	
	@Test
	public void test_Player_toCopy() {
		//setup
		Inventory i = new Inventory();
		i.addUniqueItemToInventory("apple");
		i.addUniqueItemToInventory("pear");
		ArrayList<String> expected = i.getInventory();
		//test
		Player p1 = new Player(i);
		ArrayList<String> output = p1.getPlayerInventory();
		
		assertEquals("Expected same ArrayList<String> returned.", expected, output);
	}
	
	@Test
	public void test_getPlayerInventory_emptyInv() {
		//setup
		ArrayList<String> expected = new ArrayList<String>();
		//test
		Player p1 = new Player();
		ArrayList<String> output = p1.getPlayerInventory();
		
		assertEquals("Expected empty ArrayList<String>.",expected, output);
	}
	
	@Test
	public void test_getPlayerInventory_invWithItems() {
		//setup
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("apple");
		expected.add("orange");
		expected.add("pear");
		//test
		Player p1 = new Player();
		p1.setPlayerInventory(expected);
		ArrayList<String> output = p1.getPlayerInventory();
		
		assertEquals("Expected ArrayList<String>.",expected, output);
	}
}
