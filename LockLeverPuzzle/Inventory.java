
/**
 * @author Fiona
 *
 * Version updated: August 5, 2019
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

	public Inventory(Inventory toCopy) {
		this.inventory = toCopy.inventory;
	}
	//METHODS
	//view objects(auto pick up if important)
	//adds item to inventory(AS WELL REMOVE FROM ROOM)
	public String viewInventory() {
		if (this.inventory.isEmpty() == false) {
			System.out.println("Here is your inventory.");
			System.out.println(this.inventory);
			return ""+this.inventory;
		} else {
			System.out.println("You have nothing in your inventory.");
			System.out.println(this.inventory);
			return ""+this.inventory;
		}
	}
	
	//UNUSED- would be useful for items that can have copies of itself
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
	
	//GET INVENTORY
	public ArrayList<String> getInventory(){
		return this.inventory;
	}
	//combine items>static obj>dynamic obj
	//user input for interaction

}
