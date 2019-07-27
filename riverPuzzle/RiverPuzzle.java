/**
 * @author Steven On
 *
 */ 
import java.util.*;
 
public class RiverPuzzle {
	
	//Instances variables.
	private String object;
	private ArrayList<String> right = new ArrayList<String>();
	private ArrayList<String> left = new ArrayList<String>();
	
	//Constructor.
	public RiverPuzzle() {
	}
	
	//This just says what the problem that the player has to solve with instructions.
	public void problem() {
		System.out.println("You the player, have a wolf, a goat, and a cabbage on one side of the river.\nYou need to get all three across the river.");
		System.out.println("However, your boat can only fit one of them at a time.\nIf the wolf is left alone with the goat, the wolf will eat the goat.");
		System.out.println("If the goat is left alone with the cabbage, it will devour the cabbage.\nIf the cabbage is left alone with the wolf, nothing happens.");
		System.out.println("You can also move across the river by yourself.\n");
		System.out.println("Instructions: to move the object left or right, type out the object and their direction. Type reset to reset the game.");
		System.out.println("For example: Move the goat right.\n");
	}
	
	//How the game will begin.
	public void start() {
		left.add("Left side of the river:");
		right.add("Right side of the river:");
		left.add("Goat");
		left.add("Wolf");
		left.add("Cabbage");
		left.add("Player");
		System.out.println(left);
		System.out.println(right);

	}
	
	//What the user inputs.
	public void userInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nWhat is your move? ");
		object = input.nextLine();
		System.out.println(" ");
		object = object.toUpperCase();
	}
	
	//Moves the farmer and the object to the right.
	public void moveRight() {
		if (object.contains("GOAT") && object.contains("RIGHT")) {
			left.remove("Goat");
			left.remove("Player");
			right.add("Player");
			right.add("Goat");
			for(int i = 0; i < right.size(); i++) {
	            for(int j = i + 1; j < right.size(); j++) {
	                if(right.get(i).equals(right.get(j))){
	                    right.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
		if (object.contains("WOLF") && object.contains("RIGHT")) {
			left.remove("Wolf");
			left.remove("Player");
			right.add("Player");
			right.add("Wolf");
			for(int i = 0; i < right.size(); i++) {
	            for(int j = i + 1; j < right.size(); j++) {
	                if(right.get(i).equals(right.get(j))){
	                    right.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
		if (object.contains("CABBAGE") && object.contains("RIGHT")) {
			left.remove("Cabbage");
			left.remove("Player");
			right.add("Player");
			right.add("Cabbage");
			for(int i = 0; i < right.size(); i++) {
	            for(int j = i + 1; j < right.size(); j++) {
	                if(right.get(i).equals(right.get(j))){
	                    right.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
		if (object.contains("PLAYER") && object.contains("RIGHT")) {
			left.remove("Player");
			right.add("Player");
			for(int i = 0; i < right.size(); i++) {
	            for(int j = i + 1; j < right.size(); j++) {
	                if(right.get(i).equals(right.get(j))){
	                    right.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
	}
	
	//Moves the farmer and object to the left.
	public void moveLeft() {
		if (object.contains("GOAT") && object.contains("LEFT")) {
			right.remove("Goat");
			right.remove("Player");
			left.add("Player");
			left.add("Goat");
			for(int i = 0; i < left.size(); i++) {
	            for(int j = i + 1; j < left.size(); j++) {
	                if(left.get(i).equals(left.get(j))){
	                    left.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
	
		}
		if (object.contains("WOLF") && object.contains("LEFT")) {
			right.remove("Wolf");
			right.remove("Player");
			left.add("Player");
			left.add("Wolf");
			for(int i = 0; i < left.size(); i++) {
	            for(int j = i + 1; j < left.size(); j++) {
	                if(left.get(i).equals(left.get(j))){
	                    left.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
		if (object.contains("CABBAGE") && object.contains("LEFT")) {
			right.remove("Cabbage");
			right.remove("Player");
			left.add("Player");
			left.add("Cabbage");
			for(int i = 0; i < left.size(); i++) {
	            for(int j = i + 1; j < left.size(); j++) {
	                if(left.get(i).equals(left.get(j))){
	                    left.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
		if (object.contains("PLAYER") && object.contains("LEFT")) {
			right.remove("Player");
			left.add("Player");
			for(int i = 0; i < left.size(); i++) {
	            for(int j = i + 1; j < left.size(); j++) {
	                if(left.get(i).equals(left.get(j))){
	                    left.remove(j);
	                    j--;
	                }
	            }
	        }
			System.out.println(left);
			System.out.println(right);
			
		}
	}
	//These three checkers below will check if there is a win or lose situation.
	public void checkGoatAndCabbage() {
		
		if (left.contains("Goat") && left.contains("Wolf") && right.contains("Player") || right.contains("Goat") && right.contains("Wolf") && left.contains("Player")) {
			System.out.println("\nThe wolf ate the goat!");
			reset();
		}
		if (left.contains("Goat") && left.contains("Cabbage") && right.contains("Player") || right.contains("Goat") && right.contains("Cabbage") && left.contains("Player")) {
			System.out.println("\nThe goat ate the cabbage!");
			reset();
		}
	}
	public void checkWin() {
		problem();
		start();
		boolean gameDone = false;
		while (gameDone  == false) {
			userInput();
			moveLeft();
			moveRight();
			checkGoatAndCabbage();
			resetGame();
			if(right.contains("Player") && right.contains("Goat") && right.contains("Wolf") && right.contains("Cabbage")) {
				System.out.println("You solved it!");
				gameDone = true;
		}
	}
}
	
	//When the player encounters a loss this will reset the game for them.
	public void reset() {
		System.out.println("You failed. The game will now reset.\n");
		left.clear();
		right.clear();
		left.add("Left side of the river:");
		right.add("Right side of the river:");
		left.add("Goat");
		left.add("Wolf");
		left.add("Cabbage");
		left.add("Player");
		System.out.println(left);
		System.out.println(right);
	}
	
	//This allows the player to reset the game in case if anything messes up.
	public void resetGame() {
		if (object.equals("RESET")) {
			System.out.println("You have restarted the game!");
			left.clear();
			right.clear();
			left.add("Left side of the river:");
			right.add("Right side of the river:");
			left.add("Goat");
			left.add("Wolf");
			left.add("Cabbage");
			left.add("Player");
			System.out.println(left);
			System.out.println(right);
		}
	}
}
