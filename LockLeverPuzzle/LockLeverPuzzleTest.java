
/**
 * @author Fiona
 *
 */
public class LockLeverPuzzleTest {

	public static void main(String[] args) {
		LockLeverPuzzle puzzle = new LockLeverPuzzle(1,2,3);
		
		puzzle.setComboNum1(1);
		puzzle.setComboNum1(2);
		puzzle.setComboNum1(3);
		puzzle.checkCombo();
		puzzle.shiftLever();

	}

}
