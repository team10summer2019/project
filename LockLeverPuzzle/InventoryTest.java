
/**
 * @author Fiona
 *
 */
public class InventoryTest {

	public static void main(String[] args) {
		Inventory myInventory = new Inventory();
		
		myInventory.addItemToInventory("Apple");
		myInventory.addItemToInventory("Orange");
		myInventory.viewInventory();
		
		myInventory.removeItemFromInventory("Apple");
		myInventory.viewInventory();

	}

}
