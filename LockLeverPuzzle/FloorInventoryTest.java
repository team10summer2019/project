
public class FloorInventoryTest {
	
	public static void main(String[] args) {
		FloorInventory inv = new FloorInventory();
		inv.viewInventory();
		inv.remove_flrInv("leverPiece1");
		inv.viewInventory();
		inv.remove_flrInv("leverPiece2");
	}
}
