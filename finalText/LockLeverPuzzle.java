package finalText;


/**
 * @author Fiona
 *
 */ 
public class LockLeverPuzzle extends GenericComboLock {
	/*
	 * CLASS
	 * LOCK LEVER PUZZLE
	 * lock lever puzzle has the same traits as GenericComboLock
	 * an additional lever key is set to act as a key
	 * puzzle will unlock both combination and lever are put in the right position
	 */
	private boolean lever_canUse;
	private String lever_position;
	private boolean correctLeverPosition;
	
	//CONSTRUCTORS
	public LockLeverPuzzle(int comboNum1_Key, int comboNum2_Key, int comboNum3_Key) {
		super(comboNum1_Key,comboNum2_Key,comboNum3_Key);
	}
	
	//METHODS
	public void information() {
		//if user had click on it, this initializes first thing
		System.out.print("This contraption..this looks like a combination lock. Theres three gears, each with a shape drawn right underneath it.\nThere's a hole on the side of the contraption.");
		super.checkCombo();
	}
	
	public boolean checkLever() { //check if obj_Lever_Key exists
		boolean leverExists = false;
		
		LockLever lever = new LockLever();
		if  (lever.combinedLever() == true) {
			lever_canUse = true;
		}
		
		return leverExists; 
	}
	
	public void shiftLever() {//forwards,backwards,neutral
		if (lever_canUse == true) {
			if (lever_position == "neutral") { //Unnecessary, only used for checks(neutral and backwards)
				System.out.println("in neutral");
			}
			if (lever_position == "toward") {
				System.out.println("towards you");
			}
			if (lever_position == "away") {
				System.out.println("away from you");
				correctLeverPosition = true;
			}
		} else {
			System.out.println("The hole on the side of the contraption must do something. Maybe something can help activate it.");
		}
	}
	
	public void solvePuzzle() {
		if ((super.checkCombo() == true) && (correctLeverPosition == true)) {
			System.out.println("The door opens to the next room");
		}
	}
}
