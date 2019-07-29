
/**
 * @author Fiona
 *
 */
public class DynamicObjectsTest {

	public static void main(String[] args) {
		DynamicObjects lever_keys = new DynamicObjects();
		
		//Finding first dynamic object 
		lever_keys.changeStatus_dynObj(lever_keys.leverP1);
		lever_keys.addItemToInventory(lever_keys.leverP1);
		lever_keys.viewInventory();
		
		//Finding second dynamic object 
		lever_keys.changeStatus_dynObj(lever_keys.leverP2);
		lever_keys.addItemToInventory(lever_keys.leverP2);
		lever_keys.viewInventory();
		
		lever_keys.removeItemFromInventory("leverPiece1");
		lever_keys.viewInventory();
		
		////////////////////////////////

	}

}
