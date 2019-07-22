import java.util.Scanner;

public class HaineRiddle {

	private Scanner input;
	private int dotCounter;	//THIS IS FOR AESTHETICS AND LOOKS APPEARANCES
	private String answer;
	
	public HaineRiddle() {}
	
	public void sayRiddle() {
		System.out.println("What is the creature that walks on four legs in the morning,\ntwo legs at noon, and three in the evening?\n(It's one word.)\n");
	}
	
	public void getInput() {
		input = new Scanner(System.in);
		answer = input.nextLine();
		answer =  answer.toUpperCase();			//CHANGES INPUT TO AN ALL-CAPS STRING
	}
	
	public void checkAnswer() {
		if (answer.contains("HUMAN")){
			System.out.println("\nYou live another day.");
		}
		
		else {
			System.out.println("\nThe Sphinx smirks. Let's try again..\n");		//IF WRONG ANSWER

			while (!answer.contains("HUMAN")) {
				dotCounter ++;
				
				input = new Scanner(System.in);		//NEW INPUT
				answer = input.nextLine();
				answer =  answer.toUpperCase();		//WAITS FOR INPUT HERE
				
				if (!answer.contains("HUMAN")) {
					System.out.print("\nKeep trying");
					for (int i = 0; i < dotCounter + 1; i++) {
						System.out.print(".");
					}		//END OF FOR LOOP
					System.out.println("\n");
				}
			}	//END OF WHILE LOOP
			
			System.out.println("\nYou feel like you barely escaped with your life.");
			
		}		//END OF ELSE
	}			//END OF METHOD

}
