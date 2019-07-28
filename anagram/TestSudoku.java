package anagram;

public class TestSudoku {

	public static void main(String[] args) {
		Sudoku test = new Sudoku();
		test.setGameBoard();
		test.answer();
		test.originalGameBoard();
		test.instruction();
	}
}
