import java.util.ArrayList;

public class FloorInventory {
	//objects that exist on the floor that can be picked up; works with dynamic objects
	///CREATE:ROOM: HAS LIST OF OBJECTS-> IF TAKEN AWAY ROOM SHOULD NOT HAVE IT
	
	//unique items shall only exist here
	//items that have more than one then it does not have a set tracker.
	private ArrayList<String> floorInventory = new ArrayList<String>();
	
	public FloorInventory() {
		add_unique_flrInv("leverPiece1");
		add_unique_flrInv("leverPiece2");
	}
	public void remove_flrInv(String item) {
		floorInventory.remove(item);
	}
	
	public void add_unique_flrInv(String item) {
		floorInventory.add(item);
	}
	/////////for developer
	public void viewInventory() {
		System.out.println(floorInventory);
	}

}
