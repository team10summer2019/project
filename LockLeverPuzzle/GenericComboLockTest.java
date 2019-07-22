
/**
 * @author Fiona
 *
 */
public class GenericComboLockTest {

	public static void main(String[] args) {
		System.out.println("////new instance/////");
		//Lock should be locked in description
		//default "visual" combination lock is [0][0][0]
		GenericComboLock lock = new GenericComboLock(1,2,3);
		lock.checkCombo();
		System.out.println("/////////");
		//Lock will remain locked
		lock.setComboNum1(1);
		lock.checkCombo();
		System.out.println("/////////");
		//Lock will remain locked
		//Error on combo 1 caused an error
		lock.setComboNum1(11);
		lock.setComboNum2(2);
		lock.setComboNum3(3);
		System.out.println("/////////");
		//Lock should unlock
		lock.setComboNum1(1);
		lock.checkCombo();
		System.out.println("/////////");
		
		
		//This is just for you to see what your key was. This might only be temporary
		System.out.println("For developers information, code was set to:" + lock.getComboNum1_Key() + "," + lock.getComboNum2_Key() + "," + lock.getComboNum3_Key());
	}

}
