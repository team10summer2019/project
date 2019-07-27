
/**
 * @author Fiona
 *
 */
public class DynamicObjectsTest {

	public static void main(String[] args) {
		DynamicObjects lever_keys = new DynamicObjects();
		
		//Finding first dynamic object 
		lever_keys.dynObj_leverPiece1();
		lever_keys.viewInventory();
		
		//Finding second dynamic object 
		lever_keys.dynObj_leverPiece2();
		lever_keys.viewInventory();
		
		lever_keys.removeItemFromInventory("leverPiece1");
		lever_keys.viewInventory();
		
		////////////////////////////////

	}

}
