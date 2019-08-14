package FinalText;


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
	//CONSTRUCTORS
	public LockLever() {
		
	}
	//SETTERS
	//changes status of lever piece
	public void setLeverPiece1(boolean status) {//changes status of lever piece 1 when present
		this.obj_LeverPiece1 = status;
		System.out.println("ITEM leverpiece1 IS PICKED UP\n");
	}
	public void setLeverPiece2(boolean status) {//changes status of lever piece 2 when present
		this.obj_LeverPiece2 = status;
		System.out.println("ITEM leverpiece2 IS PICKED UP\n");
	}
	
	//METHODS
	//get leverPiece1 and leverPiece2 info from player inventory
	//if both pieces exist in the inventory, put together lever
	public boolean combinedLever() {
		if (obj_LeverPiece1 == true && obj_LeverPiece2 == true) {//CHANGE THIS INFO SO THAT IT CHECKS THE PLAYERS INVENTORY
			obj_Lever_Key = true;
			System.out.println("LEVER MADE");
		}
		return obj_Lever_Key;
	}
}
