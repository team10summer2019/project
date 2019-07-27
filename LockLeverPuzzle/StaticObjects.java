
/**
 * @author Fiona
 *
 */
public class StaticObjects extends Inventory {
	/*
	 * These are objects that only provide a description.
	 * They may be neutral objects or objects that provide clues.
	 * These objects are things that are taken from the room and placed into the inventory.
	 */
	public StaticObjects() {
		
	}
	//METHODS

	//UNIQUE METHODS
	public void aBear() {
		System.out.println("This is a bear.");
	}
	
	public void aBracelet() {
		System.out.println("This is a bracelet with four yellow stars on it.");
	}
	
	public void aCard() {
		System.out.println("A black seven of spades playing card.");
	}
	
	public void aPaper() {
		System.out.println("You unfold the paper. It is torn and looks like it came from a nursery book.");
		System.out.println("On it, there writes: '--two, tie your shoe.'. There is a drawing of a green shoe right beneath it.");
	}
	
	public void aBird1() {
		System.out.println("It is a red Bird. There is a circle stamped on it.");
	}
	
	public void aBird2() {
		System.out.println("It is a yellow Bird. There is a asterisk stamped on it.");
	}
	
	public void aBird3() {
		System.out.println("It is a green Bird. There is a diamond stamped on it.");
	}
}
