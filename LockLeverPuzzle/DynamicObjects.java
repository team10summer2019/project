
/**
 * @author Fiona
 *
 */
public class DynamicObjects extends StaticObjects{
	/*
	 * CLASS
	 * DYNAMIC OBJECTS
	 * These are objects that behave as Keys(usually a boolean for access)
	 * These objects are things that are taken from the room and placed into the inventory
	 */
	//ArrayList<String> itemExistence = new ArrayList<String>();//*TESTING for FLOOR OBJECTS
	private LockLever changeStatus = new LockLever();
	final String leverP1 = "leverPiece1";
	final String leverP2 = "leverPiece2";
	final String cabinetKey = "cabinetKey";
	final String topHat = "topHat";
	
	public DynamicObjects() {
		
	}
	////////////////////Print Dynamic Item Information//////////////////////
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
	public void changeStatus_dynObj(String item) {
		if (item == "leverPiece1") {
			changeStatus_leverP1();
		}
		if (item == "leverPiece2") {
			changeStatus_leverP2();
		}
		
	}
	//////////////leverP1///////////////////
	private String string_leverP1() {
		System.out.println("It is a metal rod with an end that has grooves on it like a screw. The other end looks like it should attach to a hinge mechanism.");
		return "leverPiece1";
	}
	
	private void changeStatus_leverP1() { //TEST BY CHANGING RETURN TO STRING RATHER THAN VOID
		changeStatus.setLeverPiece1(true);	//set true because item exists
	}
	/////////////leverP2//////////////////
	private String string_leverP2() {
		System.out.println("It is a metal rod that is hollow on one end and a red round knob. It almost looks like a toy lollipop. There are grooves inside the hollow end of the rod.");
		return "leverPiece2";
	}
	
	private void changeStatus_leverP2() {
		changeStatus.setLeverPiece2(true);
	}
	/////////cabinetKey///////////////////
	private String string_cabinetKey() {
		System.out.println("It is a key for the cabinet.");
		return "cabinetKey";
	}
	//////////////topHat///////////////////
	private String string_topHat() {
		System.out.println("It is a fancy black felt tophat with a black satin ribbon around it.");
		return "topHat";
	}
	public void combinedLever_String(LockLever lockLeverCheck) {
		if (lockLeverCheck.combinedLeverStatus() == true) {
			System.out.println("*Combine LeverPieces? 'Combine'*");
		}
	}
}
