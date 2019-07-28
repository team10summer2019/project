package anagram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
	private ArrayList<ArrayList<Integer>> gameBoard = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> OrgGameBoard = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
	
	public  ArrayList<ArrayList<Integer>> originalGameBoard() {
		ArrayList<Integer> firstRow = new ArrayList<>(
				Arrays.asList(0, 1, 5, 0, 4, 0));
		OrgGameBoard.add(firstRow);
		ArrayList<Integer> secondRow = new ArrayList<>(
				Arrays.asList(0, 0, 0, 1, 2, 0));
		OrgGameBoard.add(secondRow);
		ArrayList<Integer> thirdRow = new ArrayList<>(
				Arrays.asList(5, 2, 0, 4, 6, 3));
		OrgGameBoard.add(thirdRow);
		ArrayList<Integer> fourthRow = new ArrayList<>(
				Arrays.asList(0, 3, 4, 2, 5, 0));
		OrgGameBoard.add(fourthRow);
		ArrayList<Integer> fifthRow = new ArrayList<>(
				Arrays.asList(1, 5, 0, 6, 3, 0));
		OrgGameBoard.add(fifthRow);
		ArrayList<Integer> sixthRow = new ArrayList<>(
				Arrays.asList(4, 0, 0, 5, 1, 2));
		OrgGameBoard.add(sixthRow);
		return OrgGameBoard;
	}
	
	public ArrayList<ArrayList<Integer>> setGameBoard() {
		ArrayList<Integer> firstRow = new ArrayList<>(
				Arrays.asList(0, 1, 5, 0, 4, 0));
		gameBoard.add(firstRow);
		ArrayList<Integer> secondRow = new ArrayList<>(
				Arrays.asList(0, 0, 0, 1, 2, 0));
		gameBoard.add(secondRow);
		ArrayList<Integer> thirdRow = new ArrayList<>(
				Arrays.asList(5, 2, 0, 4, 6, 3));
		gameBoard.add(thirdRow);
		ArrayList<Integer> fourthRow = new ArrayList<>(
				Arrays.asList(0, 3, 4, 2, 5, 0));
		gameBoard.add(fourthRow);
		ArrayList<Integer> fifthRow = new ArrayList<>(
				Arrays.asList(1, 5, 0, 6, 3, 0));
		gameBoard.add(fifthRow);
		ArrayList<Integer> sixthRow = new ArrayList<>(
				Arrays.asList(4, 0, 0, 5, 1, 2));
		gameBoard.add(sixthRow);
		return gameBoard;
	}
	
	public ArrayList<ArrayList<Integer>> answer() {
		ArrayList<Integer> firstRow = new ArrayList<>(
				Arrays.asList(2, 1, 5, 3, 4, 6));
		answer.add(firstRow);
		ArrayList<Integer> secondRow = new ArrayList<>(
				Arrays.asList(3, 4, 6, 1, 2, 5));
		answer.add(secondRow);
		ArrayList<Integer> thirdRow = new ArrayList<>(
				Arrays.asList(5, 2, 1, 4, 6, 3));
		answer.add(thirdRow);
		ArrayList<Integer> fourthRow = new ArrayList<>(
				Arrays.asList(6, 3, 4, 2, 5, 1));
		answer.add(fourthRow);
		ArrayList<Integer> fifthRow = new ArrayList<>(
				Arrays.asList(1, 5, 2, 6, 3, 4));
		answer.add(fifthRow);
		ArrayList<Integer> sixthRow = new ArrayList<>(
				Arrays.asList(4, 6, 3, 5, 1, 2));
		answer.add(sixthRow);
		return answer;
	}
	
	public void printGameBoard(ArrayList<ArrayList<Integer>> board) {
		int count = 0;
		while (count != 6) {
			System.out.println(board.get(count));
			count++;
		}
	}
	
	public void validlocation(int row, int col) {
		//player can only input number if the default value is 0  in the initial game board
		ArrayList<Integer> str = OrgGameBoard.get(row);
		if (str.get(col) != 0 ) {
			System.out.println("invalid input, cannot change the number here");
			chooseRowColumn();
		} else {
			enterInput(row, col);
		}
		
	}
	
	public void chooseRowColumn() {
		System.out.println("choose a row and column you want to input a number");
		System.out.println("row 1 ~ 6, column 1 ~ 6. eg. for row 1 column 1, enter 11");
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();//enter 2 numbers(place where the number will change row? & column?)
		int row = answer / 10 - 1;
		int col = answer % 10 - 1;
		//System.out.println(row);
		//System.out.println(col);
		if (row < 0 || row > 5) {
			System.out.println("invalid input, can only enter  number from 1 to 6 for row");
			chooseRowColumn();
		} else if (col < 0 || col > 5) {
			System.out.println("invalid input, can only enter  number from 1 to 6 for column");
			chooseRowColumn();
		} else {
			validlocation(row, col);
		}
	}
	
	public void enterInput(int row, int col) {
		//enter number to change 0
		System.out.println("enter a number from 1 ~ 6 that will be enter into row: " + (row+1) + ", col: "+ (col+1));
		ArrayList<Integer> str = gameBoard.get(row);
		Scanner input = new Scanner(System.in);
		Integer num = input.nextInt();
		if (num<1 || num>6) {
			System.out.println("invalid input, can only enter number from 1~6");
		} else {
			str.set(col, num); 
			System.out.println("the following is the game board");
			printGameBoard(gameBoard);
			System.out.println("the following is the original board as reference");
			printGameBoard(OrgGameBoard);
			checkAnswer();
		}
	}
	
	
	public boolean checkAnswer() {
		//return true when game is finished
		//System.out.println("this is answer" + answer);
		boolean isEqual = gameBoard.equals(answer);
		if (isEqual == true) {
			System.out.println("win");
			return true;
		} else {
			chooseRowColumn();
		}
		return false;
	}
	
	
	public void instruction() {
		System.out.println("fill all empty squares so that the number 1 to 6 appear exactly once in each row, column and box.");
		printGameBoard(gameBoard);
		chooseRowColumn();
	}
}