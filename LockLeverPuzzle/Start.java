/**
 * @author Fiona
 *
 */
import java.util.Scanner;

public class Start {
	///CREATE:ROOM: HAS LIST OF OBJECTS-> IF TAKEN AWAY ROOM SHOULD NOT HAVE IT
	
	//CONSTANTS PUT INSIDE INTERFACE
	private static boolean gameRunning = true;
	private static boolean inRoom1 = true;
	private static Start gameMethods = new Start();
	private static Scanner keyboard = new Scanner(System.in);
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item = new DynamicObjects();
	private Inventory playerInventory = new Inventory();
	
	public static void gameMenu() {
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("Welcome, time to visit the room.");
			System.out.println("Type 'Start' to begin and 'Exit'");
			String userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("start")) {
				System.out.println("Initializing..");
				gameMethods.room1();
			} 
			if (userInput.equalsIgnoreCase("exit")) {
				System.out.println("Exiting..");
				gameRunning = false;
				keyboard.close();
			}
				
		}
	}
	
	public void room1() {
		while (inRoom1 == true) {
			System.out.println("//////////Room 1://///////////\nThis room has a bear with a red box beside it. There is a shelf with three birds sitting on it: a red bird, yellow bird, and green bird.");
			System.out.println("To view Inventory:\n'i'");
			System.out.println("To view certain items, type:\n'Bear'\n'RedBox'\n'Shelf'\n'Mirror'");
			userInput = keyboard.next();
			///////VIEW INVENTORY
			if (userInput.equalsIgnoreCase("i")) {
				gameMethods.viewInventory();
			}
			///////VIEW BEAR
			//gameMethods.viewBear();
			if (userInput.equalsIgnoreCase("bear")) {
				gameMethods.viewBear();
			}
			////////VIEW REDBOX
			if (userInput.equalsIgnoreCase("redbox")) {
				gameMethods.viewRedBox();
			}
			////////VIEW SHELF
			if (userInput.equalsIgnoreCase("shelf")) {
				gameMethods.viewShelf();
			}
			////////////VIEW MIRROR
			if (userInput.equalsIgnoreCase("mirror")) {
				gameMethods.viewMirror();
			}
		}
	}
	////////////////////////METHODS////////////////////////////////
	public void viewInventory() {
		playerInventory.viewInventory();
	}
	public void viewBear() {
		System.out.println("<><>BEAR<><>");
		boolean awaitInput = true;
			
		while (awaitInput == true) {
			stat_item.aBear();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				playerInventory.addItemToInventory(dyn_item.dynObj_leverPiece1());
				//dyn_item.dynObj_leverPiece1();
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to view the object");
				awaitInput = false;				
			}
		}	
	}
	
	public void viewRedBox() { //PROBLEM -> awaitImput is not working
		System.out.println("<><>REDBOX<><>");
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			stat_item.redBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aCard();
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box");
				awaitInput = false;
			}
		}
	}
	
	public void viewShelf() {
		System.out.println("<><>SHELF<><>");
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			stat_item.aShelf();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("r")) {
				stat_item.aBirdR();
				awaitInput = false;
			}
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aBirdY();
				awaitInput = false;
			} 
			if (userInput.equalsIgnoreCase("g")) {
				stat_item.aBirdG();
				awaitInput = false;
			}
			if (userInput.equalsIgnoreCase("stop")) {
				System.out.println("you left the shelf");
				awaitInput = false;
			}
		}
	}
	
	public void viewMirror() {
		System.out.println("<><>MIRROR<><>");
		stat_item.aMirror();
	}
	
}
