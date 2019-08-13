package LockLeverPuzzle;
/**
 * @author Fiona Yong
 * @version August 9,2019
 * 
 * CLASS
 * LOCK LEVER
 * Lever comes in two pieces. This class checks if the two lever pieces are in the player inventory or not, then combine it if it exists
 * LockLever works with dynamicObjects as well as LockLeverPuzzle 
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
	/**
	 * Changes the status of obj_leverPiece1_Key when present
	 * @param status true if present and picked up
	 */
	public void setLeverPiece1(boolean status) {//changes status of lever piece 1 when present
		this.obj_LeverPiece1 = status;
		System.out.println("ITEM leverpiece1 IS PICKED UP");
	}
	/**
	 * Changes the status of obj_leverPiece2_Key when present
	 * @param status true if present and picked up
	 */
	public void setLeverPiece2(boolean status) {//changes status of lever piece 2 when present
		this.obj_LeverPiece2 = status;
		System.out.println("ITEM leverpiece2 IS PICKED UP");
	}

	//GETTERS
	/**
	 * @return true if user has encountered this object
	 */
	public boolean getLeverPiece1() {
		return this.obj_LeverPiece1;
	}
	/**
	 * @return true if user has encountered this object
	 */
	public boolean getLeverPiece2() {
		return this.obj_LeverPiece2;
	}
	/**
	 * Returns status of obj_Lever_Key
	 * @return getter
	 */
	public boolean getObjLeverKey() { 
		return this.getObjLeverKey();
	}
	//METHODS
	/**
	 * Get leverPiece1 and leverPiece2 info from player inventory
	 * If both pieces exist in the inventory, puts together lever
	 * @return
	 */
	public boolean combinedLeverStatus() {
		if (obj_LeverPiece1 == true && obj_LeverPiece2 == true) {//CHANGE THIS INFO SO THAT IT CHECKS THE PLAYERS INVENTORY
			obj_Lever_Key = true;
			System.out.println("LEVER MADE");
		}
		return obj_Lever_Key;
	}

	/**
	 * Checks if both objects exists
	 * "Makes" and adds lockLever to inventory, while removing the pieces.
	 * @param i
	 */
	public void addCombinedLever(Inventory i) {
		if (combinedLeverStatus() == true) {
			grInv.removeItemFromInventory("leverPiece1");
			grInv.removeItemFromInventory("leverPiece2");
			grInv.addItemToInventory("lockLever");
			System.out.println("Having both items,'leverPiece1' and 'leverPiece2' was attached together to create item 'lockLever'. Now you have a fully functioning lever piece.");
		}
	}
	
	/**
	 * If both pieces exist a new string will be prompted for the lever pieces to be combined(unused)
	 */
	public void combinedLever_String() { 
		if (obj_LeverPiece1 == true && obj_LeverPiece2 == true) {
			System.out.println("*Combine LeverPieces? 'Combine'*");
		}
	}
}
