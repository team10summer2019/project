
public class FloorInventoryTest {
	
	public static void main(String[] args) {
		FloorInventory inv = new FloorInventory();
		inv.viewFloorInventory();
		inv.remove_flrInv("leverPiece1");
		inv.viewFloorInventory();
		inv.remove_flrInv("leverPiece2");
	}
}
