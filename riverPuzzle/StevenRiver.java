/**
 * @author Steven On
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
 
public class StevenRiver {
	//Instances variables.
	private String object;
	private ArrayList<String> right = new ArrayList<String>();
	private ArrayList<String> left = new ArrayList<String>();
	//Constructor.
	public StevenRiver() {
		
	}
	//This just says what the problem that the player has to solve with instructions.
	public void problem() {
		System.out.println("A farmer has a wolf, a goat, and a cabbage on one side of the river.\nHe wants to get all three across the river.");
		System.out.println("However, his boat can only fit one of them at a time.\nIf the wolf is left alone with the goat, the wolf will eat the goat.");
		System.out.println("If the goat is left alone with the cabbage, it will devour the cabbage.\nIf the cabbage is left alone with the wolf, nothing happens.\n");
		System.out.println("Instructions: to move the object left or right, type out the object and their direction. If the array appears to have double, type reset to reset the game.");
		System.out.println("For example: Move the goat left.\n");
	}
	//How the game will begin.
	public void start() {
		left.add("Left side of the river:");
		right.add("Right side of the river:");
		left.add("GOAT");
		left.add("WOLF");
		left.add("CABBAGE");
		left.add("FARMER");
		System.out.println(left);
		System.out.println(right);
	}
	//What the user inputs.
	public void userInput() {
		Scanner input = new Scanner(System.in);
		object = input.nextLine();
		object = object.toUpperCase();
	}
	//Moves the farmer and the object to the right.
	public void moveRight() {
		if (object.contains("GOAT") && object.contains("RIGHT")) {
			left.remove("GOAT");
			left.remove("FARMER");
			right.add("FARMER");
			right.add("GOAT");
			System.out.println(left);
			System.out.println(right);
		}
		if (object.contains("WOLF") && object.contains("RIGHT")) {
			left.remove("WOLF");
			left.remove("FARMER");
			right.add("FARMER");
			right.add("WOLF");
			System.out.println(left);
			System.out.println(right);
		}
		if (object.contains("CABBAGE") && object.contains("RIGHT")) {
			left.remove("CABBAGE");
			left.remove("FARMER");
			right.add("FARMER");
			right.add("CABBAGE");
			System.out.println(left);
			System.out.println(right);
		}
		if (object.contains("FARMER") && object.contains("RIGHT")) {
			left.remove("FARMER");
			right.add("FARMER");
			System.out.println(left);
			System.out.println(right);
		}
	}
	//Moves the farmer and object to the left.
	public void moveLeft() {
		if (object.contains("GOAT") && object.contains("LEFT")) {
			right.remove("GOAT");
			right.remove("FARMER");
			left.add("FARMER");
			left.add("GOAT");
			System.out.println(left);
			System.out.println(right);
		}
		if (object.contains("WOLF") && object.contains("LEFT")) {
			right.remove("WOLF");
			right.remove("FARMER");
			left.add("FARMER");
			left.add("WOLF");
			System.out.println(left);
			System.out.println(right);
		}
		if (object.contains("CABBAGE") && object.contains("LEFT")) {
			right.remove("CABBAGE");
			right.remove("FARMER");
			left.add("FARMER");
			left.add("CABBAGE");
			System.out.println(left);
			System.out.println(right);
		}
		if (object.contains("FARMER") && object.contains("LEFT")) {
			right.remove("FARMER");
			left.add("FARMER");
			System.out.println(left);
			System.out.println(right);
		}
	}
	//These three checkers below will check if there is a win or lose situation.
	public void checkGoatDeath() {
		if (left.contains("GOAT") && left.contains("WOLF") && right.contains("FARMER") || right.contains("GOAT") && right.contains("WOLF") && left.contains("FARMER")) {
			System.out.println("The wolf ate the goat!\n");
			reset();
		}
	}
	public void checkCabbage() {
		if (left.contains("GOAT") && left.contains("CABBAGE") && right.contains("FARMER") || right.contains("GOAT") && right.contains("CABBAGE") && left.contains("FARMER")) {
			System.out.println("The goat ate the cabbage!\n");
			reset();
		}
	}
	public void checkWin() {
		boolean gameDone = false;
		while (gameDone  == false) {
			userInput();
			moveLeft();
			moveRight();
			checkGoatDeath();
			checkCabbage();
			resetGame();
		if(right.contains("FARMER") && right.contains("GOAT") && right.contains("WOLF") && right.contains("CABBAGE")) {
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
		left.add("GOAT");
		left.add("WOLF");
		left.add("CABBAGE");
		left.add("FARMER");
		System.out.println(left);
		System.out.println(right);
	}
	//This allows the player to reset the game in case if anything messes up.
	public void resetGame() {
		if (object.contains("RESET")) {
			left.clear();
			right.clear();
			left.add("Left side of the river:");
			right.add("Right side of the river:");
			left.add("GOAT");
			left.add("WOLF");
			left.add("CABBAGE");
			left.add("FARMER");
			System.out.println(left);
			System.out.println(right);
		}
	}
}
