package GUIWithPuzzles;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayRiddle extends MazeGameGUI {
 
	//storeInput=textIn.getText();
	
	
	private Scanner input = new Scanner(System.in);
	private String inputAsString;
	private String answer;
	boolean solved = false;

	public PlayRiddle() {}
	  
	public void sayRiddle(CreateRiddle asd) {		//GIVES RIDDLE
		System.out.print("\nAnswer this riddle: ");
		System.out.println(asd.getRiddle());
	}
	
	public String instructions() {		//INSTRUCTIONS FOR WHAT USER CAN INPUT
		return "Type a one word guess, and then press ENTER. The guess must be one word, and cannot contain spaces.\nTo stop playing at any time, type exit, then press ENTER.";
	}
	
	/*public void getInput() {	
		
		this.inputAsString =  inputAsString.toUpperCase();	
	
		if (inputAsString.contains(" ")){	//WHILE INPUT CONTAINS SPACE OR MULTIPLE WORDS
			System.out.println("\nYour guess must be one word! Make sure there are no spaces in the guess.\n");
			return;
		}
		if (inputAsString.equals("EXIT")) {
			return;
		} 
	} */
	
	public void addAnswer(CreateRiddle ans) {		//ADDS CORRECT ANSWER TO 
		answer = ans.getAnswer();
	}
	
	public boolean checkAnswer() {									//STEVEN HELPED DEBUG, KEPT RETURNING FALSE
		
		inputAsString = super.getStoreInput().toUpperCase();
		
		System.out.println("checked the answer");
		
		if (inputAsString.contains(" ")) {
			return solved;
		}
		if (answer.contentEquals(inputAsString)) {	
			System.out.println("\nCorrect!\n");								
			solved = true;
			return solved;
		}
		if (inputAsString.equals("EXIT")) {
			System.out.println("You decide not to answer for now.");
			return solved;
		}
		else {
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