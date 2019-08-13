
/**
 * @author Fiona Yong
 * @version August 7, 2019
 * 
 * CLASS
 * INVENTORY
 * These are items from DynamicObjects class that are present in the with the player as the game is played. 
 * If the item is taken from the room, the Floor Inventory will not have the item and the Inventory Class will.
 */
import java.util.ArrayList;

public class Inventory {

	private ArrayList<String> inventory;

////////////////////Constructors//////////////////////
	/**
	 * Constructor with new instance of ArrayList inventory
	 */
	public Inventory() {
		this.inventory = new ArrayList<String>();
	}

	/**
	 * Copy constructor.
	 * 
	 * @param toCopy
	 */
	public Inventory(Inventory toCopy) {
		this.inventory = toCopy.inventory;
	}

////////////////////Methods//////////////////////
	/**
	 * Return ArrayList inventory to user Items with importance will be
	 * automatically added to inventory when viewed.
	 * 
	 * @return String version of ArrayList inventory
	 */
	public String viewInventory() {
		if (this.inventory.isEmpty() == false) {
			System.out.println("Here is your inventory.");
			System.out.println(this.inventory);
			return "" + this.inventory;
		} else {
			System.out.println("You have nothing in your inventory.");
			System.out.println(this.inventory);
			return "" + this.inventory;
		}
	}

	/**
	 * Add items that have duplicates in inventory(unused)
	 * 
	 * @param item 'item identity'
	 */
	public void addItemToInventory(String item) {
		this.inventory.add(item);
		System.out.println("item added to inventory");

	}

	/**
	 * Add items that are unique(one copy only)
	 * 
	 * @param item 'item identity'
	 */
	public void addUniqueItemToInventory(String item) { // only add to inventory if the unique item is not in inventory
		if (hasItemInInventory(item) == false) {
			this.inventory.add(item);
		}
	}

	/**
	 * Only used for developer testing
	 * 
	 * @param item 'item identity'
	 */
	public void removeItemFromInventory(String item) {
		this.inventory.remove(item);
		System.out.println("item removed from inventory");

	}

	// HAS ITEM IN INVENTORY
	/**
	 * Checks if item exists in ArrayList inventory
	 * 
	 * @param item 'item identity'
	 * @return true if item exists in ArrayList, false if item is not in the
	 *         ArrayList
	 */
	public boolean hasItemInInventory(String item) {
		return inventory.contains(item);
	}

	// GET INVENTORY
	/**
	 * @return The ArrayList inventory
	 */
	public ArrayList<String> getInventory() {
		return this.inventory;
	}
}
