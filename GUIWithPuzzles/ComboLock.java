package GUIWithPuzzles;


import java.util.Scanner;
import java.util.ArrayList;

public class ComboLock {

	private ArrayList<String> correctCombo = new ArrayList<String>();
	private ArrayList<String> userInputs = new ArrayList<String>();
	
	public ComboLock(String one, String two, String three) {
		correctCombo.add(one);
		correctCombo.add(two);
		correctCombo.add(three);
	}
	  
	public void tryUnlock() {
		System.out.println("\nThere is a hole in one wall. It feels like some sort of mechanism was once in there..");
		System.out.println("In the middle of the room, there is a combination lock- similar to a padlock. From left to right, you can put in three numbers between 0 and 9.\n"
				+ "Input the combination, one digit at a time. Press ENTER after every input.");
		for (int i = 0; i < 3; i += 1) {
			Scanner input = new Scanner(System.in);
			String userTry = input.next();
			while (userTry.length() > 1 || !userTry.matches("[0-9]+")) {
				if (!userTry.matches("[0-9]+")) {
					System.out.println("Numbers only!");
				}
				if (userTry.length() > 1) {
					System.out.println("You can only enter one number at a time. Try again.");
				}
				input = new Scanner(System.in);
				userTry = input.next();
			}
			userInputs.add(userTry);
			System.out.println("You put in a " + userTry + ".");
		}
		//By now, has gotten three inputs and stored to correctCombo array
	}
	
	public boolean checkCombo() {
		if (correctCombo.equals(userInputs)) {
			System.out.println("Something clicks.\n");
			return true;
		}
		else {
			System.out.println("...Nothing happened.\n");
			return false;
		}
	}
	
	
}
