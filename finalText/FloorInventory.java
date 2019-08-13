package finalText;

/**
 * @author Fiona
 *
 */
import java.util.ArrayList;

public class FloorInventory {
	//objects that exist on the floor that can be picked up; works with dynamic objects
	///CREATE:ROOM: HAS LIST OF OBJECTS-> IF TAKEN AWAY ROOM SHOULD NOT HAVE IT
	
	//unique items shall only exist here
	//items that have more than one then it does not have a set tracker.
	private ArrayList<String> floorInventory;
	
	public FloorInventory() {
		this.floorInventory = new ArrayList<String>();
		add_unique_flrInv("leverPiece1");
		add_unique_flrInv("leverPiece2");
	}
	public void remove_flrInv(String item) {
		floorInventory.remove(item);
		//For Dev: System.out.println("item removed from floor.");
	}
	
	public void add_unique_flrInv(String item) {
		floorInventory.add(item);
		//For Dev: System.out.println("item added to floor.");
	}
	/////////for developer
	public void viewFloorInventory() {
		System.out.println("Floor Inventory:");
		System.out.println(floorInventory);
	}

}
