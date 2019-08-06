package GUIWithPuzzles;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayRiddle {
 
	private Scanner input = new Scanner(System.in);
	private String inputAsString;
	private String answer;
	boolean solved = false;

	public PlayRiddle() {}
	  
	public void sayRiddle(CreateRiddle asd) {		//GIVES RIDDLE
		System.out.print("\nAnswer this riddle: ");
		System.out.println(asd.getRiddle());
	}
	
	public void instructions() {		//INSTRUCTIONS FOR WHAT USER CAN INPUT
		System.out.println("Type a one word guess, and then press ENTER. The guess must be one word, and cannot contain spaces.\nTo stop playing at any time, type exit, then press ENTER.");
	}
	
	public void getInput() {	//WILL INFINITELY GET INPUT IF THERES A SPACE
		inputAsString = input.nextLine();
	
		while (inputAsString.contains(" ")){	//WHILE INPUT CONTAINS SPACE OR MULTIPLE WORDS
			System.out.println("\nYour guess must be one word! Make sure there are no spaces in the guess.\n");
			input = new Scanner(System.in);
			inputAsString = input.nextLine();
			if (inputAsString.contentEquals("EXIT")) {
				return;
			} 
		}			//END OF WHILE
		this.inputAsString =  inputAsString.toUpperCase();			//CHANGES INPUT TO AN ALL-CAPS STRING. JUMPS STRAIGHT HERE IF NO SPACES IN INPUT
		if (inputAsString.contentEquals("EXIT")) {
			return;
		}
	} 
	
	public void addAnswer(CreateRiddle ans) {		//ADDS CORRECT ANSWER TO 
		answer = ans.getAnswer();
	}
	
	public boolean checkAnswer() {									//STEVEN HELPED DEBUG, KEPT RETURNING FALSE
		if (answer.contentEquals(inputAsString)) {			//https://stackoverflow.com/questions/25087878/java-comparing-arraylist-item-to-user-input-string
			System.out.println("\nCorrect!\n");								//https://docs.oracle.com/javase/8/docs/api/java/util/List.html
			solved = true;
			return solved;
		}
		else {
			System.out.println("\nWrong.\n");
			return solved;
		}
	}
	/*
	public void exitPrompt() {			//IF USER WANTS TO STOP AT SOME POINT
		System.out.println("Are you sure? Type exit and press ENTER again to confirm.");
		input = new Scanner(System.in);		//NEEDS USER INPUT AGAIN TO CONFIRM
		inputAsString = input.nextLine();
		this.inputAsString =  inputAsString.toUpperCase();	
		if (inputAsString.equals("EXIT")) {
			return;
		}
	} */
	
}