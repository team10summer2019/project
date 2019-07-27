
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
	
	public DynamicObjects() {
		
	}
	
	public String dynObj_leverPiece1() { //TEST BY CHANGING RETURN TO STRING RATHER THAN VOID
		System.out.println("It is a metal rod with an end that has grooves on it like a screw. The other end looks like it should attach to a hinge mechanism.");
		changeStatus.setLeverPiece1(true);	//set true because item exists
		//super.addItemToInventory("leverPiece1");//don't make explicit for actual game(just description)
		return "leverPiece1";
	}
	public String dynObj_leverPiece2() {
		System.out.println("It is a metal rod that is hollow on one end and a red round knob. It almost looks like a toy lollipop. There are grooves inside the hollow end of the rod.");
		changeStatus.setLeverPiece2(true);
		//super.addItemToInventory("leverPiece2");;//don't make explicit for actual game(just description)
		return "leverPiece2";
	}
	/////////UNUSED
	public void dynObj_regularKey() {
		System.out.println("It is a key.");
	}
}
