


/**
 * @author Fiona
 *
 */
import java.util.ArrayList;
	
public class Inventory {
	/*
	 * CLASS
	 * INVENTORY
	 * Inventory list should work for the entire game.
	 * Dynamic objects that are viewed will be taken from the room setting and placed/added into the inventory.
	 */
	private ArrayList<String> inventory;
	
	public Inventory() {
		this.inventory = new ArrayList<String>();
	}

	//METHODS
	//view objects(auto pick up if important)
	//adds item to inventory(AS WELL REMOVE FROM ROOM)
	public void viewInventory() {
		if (this.inventory.isEmpty() == false) {
			System.out.println("Here is your inventory.");
			System.out.println(this.inventory);
		} else {
			System.out.println("You have nothing in your inventory.");
			System.out.println(this.inventory);
		}
	}
	
	public void addItemToInventory(String item) {
		this.inventory.add(item);
		System.out.println("item added to inventory");
		
	}
	public void addUniqueItemToInventory(String item) { //only add to inventory if the unique item is not in inventory 
		if (hasItemInInventory(item) == false) { 
			this.inventory.add(item);
		}
	}
	//FOR DEVELOPER
	public void removeItemFromInventory(String item) {
		this.inventory.remove(item);
		System.out.println("item removed from inventory");
		
	}
	//HAS ITEM IN INVENTORY
	public boolean hasItemInInventory(String item) {
		return inventory.contains(item);
	}
	//combine items>static obj>dynamic obj
	//user input for interaction

}
