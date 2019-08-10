
/**
 * @author Fiona
 *
 */
public class LockLever {
	/*
	 * CLASS
	 * LOCK LEVER
	 * Lever comes in two pieces. This class checks if the two lever pieces are in the player inventory or not, then combine it if it exists
	 * LockLever works with dynamicObjects as well as LockLeverPuzzle 
	 */
	private boolean obj_Lever_Key = false; //the full piece turns into a "key" object
	private boolean obj_LeverPiece1 = false;
	private boolean obj_LeverPiece2 = false;
	private Inventory grInv;
	
	//CONSTRUCTORS
	public LockLever() {
		
	}
	
	public LockLever(GenericRoom gr) {
		grInv = gr.playerInventory;
	}
	//SETTERS
	//changes status of lever piece
	public void setLeverPiece1(boolean status) {//changes status of lever piece 1 when present
		this.obj_LeverPiece1 = status;
		System.out.println("ITEM leverpiece1 IS PICKED UP");
	}
	public void setLeverPiece2(boolean status) {//changes status of lever piece 2 when present
		this.obj_LeverPiece2 = status;
		System.out.println("ITEM leverpiece2 IS PICKED UP");
	}
	//GETTERS
	public boolean getLeverPiece1() {
		return this.obj_LeverPiece1;
	}
	public boolean getLeverPiece2() {
		return this.obj_LeverPiece2;
	}
	
	//METHODS
	//get leverPiece1 and leverPiece2 info from player inventory
	//if both pieces exist in the inventory, put together lever
	public boolean combinedLeverStatus() {
		if (obj_LeverPiece1 == true && obj_LeverPiece2 == true) {//CHANGE THIS INFO SO THAT IT CHECKS THE PLAYERS INVENTORY
			obj_Lever_Key = true;
			System.out.println("LEVER MADE");
		}
		return obj_Lever_Key;
	}
	//check and add if both objects exists
	//"makes" and adds lockLever to inventory
	public void addCombinedLever(Inventory i) {
		if (combinedLeverStatus() == true) {
			grInv.removeItemFromInventory("leverPiece1");
			grInv.removeItemFromInventory("leverPiece2");
			grInv.addItemToInventory("lockLever");
			System.out.println("Having both items,'leverPiece1' and 'leverPiece2' was attached together to create item 'lockLever'. Now you have a fully functioning lever piece.");
		}
	}
	//returns status of obj_Lever_Key
	public boolean getObjLeverKey() { //*
		return this.getObjLeverKey();
	}
	public void combinedLever_String() { //*
		if (obj_LeverPiece1 == true && obj_LeverPiece2 == true) {
			System.out.println("*Combine LeverPieces? 'Combine'*");
		}
	}
}
