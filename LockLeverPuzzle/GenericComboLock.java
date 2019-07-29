
/**
 * @author Fiona
 * 
 * Version Updated: July 29, 2019
 */
public class GenericComboLock {
	/* PROJECT MEMBER NOTES:
	 * This lock has a set max of three digit number combinations.
	 * I don't imagine that we will be using more or less from where we are right now.
	 * If we plan on doing more, this would need to be modified to accommodate more digits.
	 * Note that ERRORs do not cause any interruption in how the program is run yet. They will be modified in the future.
	 */
	
	/*
	 * CLASS
	 * GENERIC COMBINATION LOCK
	 * The number of combo switches is a maximum of 3.
	 * When user combo input matches key, combo lock will unlock to true.
	 * 
	 */
	
	//NTS:use Protected <
	
	//OTHER CLASSES CAN ACCESS
	private int comboNum1_Key;
	private int comboNum2_Key;
	private int comboNum3_Key;
	
	//USER CAN ACCESS
	private int comboNum1 = 0;
	private int comboNum2 = 0;
	private int comboNum3 = 0;
	
	
	//CONSTRUCTORS
	public GenericComboLock() {
		
	}
	public GenericComboLock(int comboNum1_Key, int comboNum2_Key, int comboNum3_Key){
		setComboNum_Key(comboNum1_Key,comboNum2_Key,comboNum3_Key);
		information();
		
	}
	//GETTERS (not sure if needed yet)
	public int getComboNum1_Key() {
		return this.comboNum1_Key;
	}
	public int getComboNum2_Key() {
		return this.comboNum2_Key;
	}
	public int getComboNum3_Key() {
		return this.comboNum3_Key;
	}
	
	//SETTERS
	//key
	private void setComboNum_Key(int comboNum1_Key, int comboNum2_Key, int comboNum3_Key) {
		if ((digitCap(comboNum1_Key, comboNum2_Key, comboNum3_Key) == true)) {
			this.comboNum1_Key = comboNum1_Key;
			this.comboNum2_Key = comboNum2_Key;
			this.comboNum3_Key = comboNum3_Key;
		} else {
			System.out.println("ERROR. NUMBERS DID NOT MEET CONSTRAINT");
			}
		
	}
	//user
	public void setComboNum1(int comboNum1) {
		if ((digitCap(comboNum1) == true)) {
			this.comboNum1 = comboNum1;
		} else {
			System.out.println("ERROR. user COMBO 1 DID NOT MEET CONSTRAINT");
			}
	}
	public void setComboNum2(int comboNum2) {
		if ((digitCap(comboNum2) == true)) {
			this.comboNum2 = comboNum2;
		} else {
			System.out.println("ERROR. user COMBO 2 DID NOT MEET CONSTRAINT");
			}
	}
	public void setComboNum3(int comboNum3) {
		if ((digitCap(comboNum3) == true)) {
			this.comboNum3 = comboNum3;
		} else {
			System.out.println("ERROR. user COMBO 3 DID NOT MEET CONSTRAINT");
			}
	}
	
	//METHODS
	private boolean digitCap(int comboNum) {
		boolean inConstraint = false;
		
		//combinations is only from digits 0 through 9 inclusive
		if (comboNum >= 0 && comboNum <=9) {
			inConstraint = true;
		} 
		return inConstraint;
	}
	
	public boolean digitCap(int comboNum1_Key, int comboNum2_Key, int comboNum3_Key) {
		boolean allInConstraint = false;
		boolean combo1Rest = false;
		boolean combo2Rest = false;
		boolean combo3Rest = false;
		
		//combinations is only from digits 0 through 9 inclusive
		if (comboNum1_Key >= 0 && comboNum1_Key <=9) {
			combo1Rest = true;
		} else {
			System.out.println("ERROR Number 1");
			}
		
		if (comboNum2_Key >= 0 && comboNum2_Key <=9) {
			combo2Rest = true;
		} else {
			System.out.println("ERROR Number 2");
			}
				
		if (comboNum3_Key >= 0 && comboNum3_Key <=9) {
			combo3Rest = true;	
		} else {
			System.out.println("ERROR Number 3");
			}
		if (combo1Rest == true && combo2Rest == true && combo3Rest == true) {
			allInConstraint = true;
		}
		return allInConstraint;
	}
	
	//if all comboNum# matches the comboNum#_Key, checkCombo is a Pass
	//if it does not, the user modifiers comboNum# will be all set back to 0
	public boolean checkCombo() {
		boolean comboMatch = false;
		if ((comboNum1_Key == comboNum1) && (comboNum2_Key == comboNum2) && (comboNum3_Key == comboNum3)) {
			comboMatch = true;
			System.out.println("The lock is now unlocked. "); //MIGHT NEED TO EDIT:unknown and will return in a diff method(easier for overriding)
		} else {
			System.out.println("The lock appears to be locked. "); 
		}
		return comboMatch;
	}
	
	//Generic User Click Description(PUT IN A NEW CLASS FOR ITEMS LATER ON; this one is an override of the generic static objects)
	public void information() {
		//if user had click on it, this initializes first thing
		System.out.print("This looks like a combination lock. ");
		checkCombo();
	}
}
