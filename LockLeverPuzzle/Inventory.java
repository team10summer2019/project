
/**
 * @author Fiona
 *
 */
import java.util.ArrayList;

public class Inventory {
	private ArrayList<String> inventory;
	
	public Inventory() {
		inventory = new ArrayList<String>();
	}
	//METHODS
	//view objects(auto pick up if important)
	//adds item to inventory(AS WELL REMOVE FROM ROOM)
	public void viewInventory() {
		System.out.println(inventory);
	}
	
	public void addItemToInventory(String item) {
		this.inventory.add(item);
		System.out.println("item added to inventory");
	}
	
	public void removeItemFromInventory(String item) {
		this.inventory.remove(item);
		System.out.println("item removed from inventory");
	}
	//combine items>static obj>dynamic obj
	//user input for interaction

}
