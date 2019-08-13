package LockLeverPuzzle;
/**
 * @author Fiona Yong
 * @version July 28, 2019
 */
public class GenericComboLockTest {

	public static void main(String[] args) {
		//Errors will produce on the Key for ComboNum1_Key and ComboNum2_Key
		GenericComboLock errorLock = new GenericComboLock(11,22,3);
		
		//Lock should be locked in description
		//default "visual" combination lock is [0][0][0]
		GenericComboLock lock = new GenericComboLock(1,2,3);
		lock.checkCombo();
		
		//Lock will remain locked
		lock.setComboNum1(1);
		lock.checkCombo();
		
		//Lock will remain locked
		//Error on combo 1 caused an error
		lock.setComboNum1(11);
		lock.setComboNum2(2);
		lock.setComboNum3(3);
		
		//Lock should unlock
		lock.setComboNum1(1);
		lock.checkCombo();
		
		
		
		//This is just for you to see what your key was. This might only be temporary
		System.out.println(lock.getComboNum1_Key() + "," + lock.getComboNum2_Key() + "," + lock.getComboNum3_Key());
	}

}
