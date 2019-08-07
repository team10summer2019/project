
/**
 * @author Fiona
 *
 */
public class Main {
	
	public static void main(String[] args) {
		GenericRoom gameRooms = new GenericRoom();
		gameRooms.playerInventory.viewInventory();
		gameRooms.configuration(1);
		gameRooms.configuration(2);
		gameRooms.configuration(3);
		gameRooms.configuration(4);
		gameRooms.playerInventory.viewInventory();
		
	}
}
