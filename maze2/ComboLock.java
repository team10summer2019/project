package maze2;

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
		System.out.println("From left to right, input the combination, one digit at a time. Press ENTER after every number.");
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
		}
		//By now, has gotten three inputs and stored to correctCombo array
	}
	
	public void checkCombo() {
		if (correctCombo.equals(userInputs)) {
			System.out.println("You got the right combo!");
		}
		else {
			System.out.println("Wrong combo!");
		}
	}
	
	
}
