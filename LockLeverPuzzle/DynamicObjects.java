package LockLeverPuzzle;
/**
 * @author Fiona Yong
 * @version August 9, 2019
 * 
 * CLASS
 * DYNAMIC OBJECTS
 * These are objects that behave as Keys(usually a boolean for access).
 * These objects are things that are taken from the room and placed into the inventory.
 */
public class DynamicObjects extends StaticObjects{

	private LockLever changeStatus;
	final String leverP1 = "leverPiece1";
	final String leverP2 = "leverPiece2";
	final String cabinetKey = "cabinetKey";
	final String topHat = "topHat"; 
	
	public DynamicObjects(LockLever changeStatus) {
		this.changeStatus = changeStatus; 
	}
	////////////////////Print Dynamic Item Information//////////////////////
	/**
	 * Prints dynamic item information(details about the item itself).
	 * @param item The item that has been called by a Room Class/looked at or taken into Inventory Class in the game
	 */
	public void itemInfo_dynObj(String item) {
		if (item == "leverPiece1") {
			string_leverP1();
		}
		if (item == "leverPiece2") {
			string_leverP2();
		}
		if (item == "cabinetKey") {
			string_cabinetKey();
		}
		if (item == "topHat") {
			string_topHat();
		}
		
	}
	
	////////////////////Change Dynamic Item Status//////////////////////////
	//CHANGE ANY DYN ITEM STATUS
	//UPDATE HERE if more dynamic items were added
	/**
	 * Changes the status of the dynamic item in LockLever for pieces 'leverPiece1' and 'leverPiece2'.
	 * @param item The item that has been called by a Room Class/looked at or taken into Inventory Class in the game.
	 * @return The current status of having the String 'item' in Inventory Class.
	 */
	public LockLever changeStatus_dynObj(String item) {
		if (item == "leverPiece1") {
			changeStatus_leverP1();
			return changeStatus;
		}
		if (item == "leverPiece2") {
			changeStatus_leverP2();
			return changeStatus;
		}
		return changeStatus;
		
	}
	//////////////leverP1///////////////////
	/**
	 * Gets the information for 'leverPiece1'
	 * @return Information for 'leverPiece1'
	 */
	private String string_leverP1() {
		System.out.println("It is a metal rod with an end that has grooves on it like a screw. The other end looks like it should attach to a hinge mechanism.");
		return "leverPiece1";
	}
	/**
	 * Calls to an instance of LockLever class to change the status of the object existing in Inventory Class.
	 */
	private void changeStatus_leverP1() { //TEST BY CHANGING RETURN TO STRING RATHER THAN VOID
		changeStatus.setLeverPiece1(true);	//set true because item exists
	}

	/////////////leverP2//////////////////
	/**
	 * Gets the information for 'leverPiece2'
	 * @return Information for 'leverPiece2'
	 */
	private String string_leverP2() {
		System.out.println("It is a metal rod that is hollow on one end and a red round knob. It almost looks like a toy lollipop. There are grooves inside the hollow end of the rod.");
		return "leverPiece2";
	}
	/**
	 * Calls to an instance of LockLever class to change the status of the object existing in Inventory Class.
	 */
	private void changeStatus_leverP2() {
		changeStatus.setLeverPiece2(true);
	}
	
	/////////cabinetKey///////////////////
	/**
	 * Gets the information for 'cabinetKey'
	 * @return Information for 'cabinetKey'
	 */
	private String string_cabinetKey() {
		System.out.println("It is a key for the cabinet.");
		return "cabinetKey";
	}
	//////////////topHat///////////////////
	/**
	 * Gets the information for 'topHat'
	 * @return Information for 'topHat'
	 */
	private String string_topHat() {
		System.out.println("It is a fancy black felt tophat with a black satin ribbon around it.");
		return "topHat";
	}
}
