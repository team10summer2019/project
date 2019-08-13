package LockLeverPuzzle;

/**
 * @author Fiona Yong
 * @version August 7, 2019
 * 
 * CLASS
 * FLOOR INVENTORY
 * These are items from DynamicObjects class that are present in the Room Classes. 
 * If the item is taken from the room, the Floor Inventory will not have the item and the Inventory Class will.
 * This is used to ensure that unique items are properly removed from the Room itself and is not duplicated.
 * Items that have more than one will not be tracked in here
 */
import java.util.ArrayList;

public class FloorInventory {

	private ArrayList<String> floorInventory;

////////////////////Constructors//////////////////////
	/**
	 * Constructor with predetermined DynamicObjects items.
	 */
	public FloorInventory() {
		this.floorInventory = new ArrayList<String>();
		add_unique_flrInv("leverPiece1");
		add_unique_flrInv("leverPiece2");
		add_unique_flrInv("cabinetKey");
		add_unique_flrInv("topHat");
	}

	/**
	 * Copy constructor.
	 * 
	 * @param toCopy
	 */
	public FloorInventory(FloorInventory toCopy) {
		this.floorInventory = toCopy.floorInventory;
	}

////////////////////Remove Unique Item To Floor Inventory//////////////////////
	/**
	 * Removes item from the ArrayList floorInventory
	 * 
	 * @param item Is the unique item's 'string identity' that help check if it's in
	 *             FloorInventory.
	 */
	public void remove_flrInv(String item) {
		floorInventory.remove(item);
		// For Dev: System.out.println("item removed from floor.");
	}

////////////////////Add Unique Item To Floor Inventory//////////////////////
	/**
	 * Adds item from the ArrayList floorInventory
	 * 
	 * @param item Is the unique item's 'string identity' that help check if it's in
	 *             FloorInventory.
	 */
	public void add_unique_flrInv(String item) {
		floorInventory.add(item);
		// For Dev: System.out.println("item added to floor.");
	}

////////////////////View FLoor Inventory as a String//////////////////////
	// For Dev: RETURN floorInventory AS A STRING
	/**
	 * For the developers use to return the ArrayList floorInventory
	 * 
	 * @return A String of the ArrayList floorInventory.
	 */
	public String viewFloorInventory() {
		System.out.println("Floor Inventory:");
		System.out.println(floorInventory);
		return "" + this.floorInventory;
	}

////////////////////Get Floor Inventory(ArrayList<String>)//////////////////////
	/**
	 * @return ArrayList floorInventory to Room classes.
	 */
	public ArrayList<String> getFloorInventory() {
		return this.floorInventory;
	}

}
