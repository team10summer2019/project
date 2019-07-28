package maze2;
/**
 * @author Fiona
 *
 */
import java.util.Scanner;
 
public class Start {
	private static boolean gameRunning = true;
	private static boolean inRoom1 = true;
	private static Start gameMethods = new Start();
	private static Scanner keyboard = new Scanner(System.in);
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item = new DynamicObjects();
	private Inventory playerInventory = new Inventory();
	private FloorInventory roomInventory = new FloorInventory();
	
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
			gameMethods.exitView(userInput);
				
		}
	}
	private void exitView(String userInput) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("Exiting..");
			gameMethods.inRoom1 = false;
			gameRunning = false;
		}
	}
	
	public void room1() {
		while (inRoom1 == true) {
			System.out.println("//////////Room 1://///////////\nThis room has a bear with a red box beside it. There is a shelf with three birds sitting on it: a red bird, yellow bird, and green bird.");
			System.out.println("To view your Inventory:\n'i'");
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
			gameMethods.exitView(userInput);
		}
	}
////////////////////////ITEM METHODS////////////////////////////////
	public void viewInventory() {
		playerInventory.viewInventory();
	}
	//////////Add Unique Object to Inventory////////////
	//change status of dynamic object(ANY!)
	//Adds unique item to Inventory and removes unique item from FloorInventory
	public void uniqueObject_toInventory(String item) { 
		System.out.println("You added '" + item + "' to your inventory.");
		dyn_item.changeStatus_dynObj(item);
		playerInventory.addUniqueItemToInventory(item); //adds item to Inventory
		roomInventory.remove_flrInv(item); //removes item from FloorInventory
		//roomInventory.viewFloorInventory();
	}
	//////////BEAR////////////
	public void viewBear() {
		System.out.println("<><>BEAR<><>");
		boolean awaitInput = true;
		boolean awaitInput1 = true;
	
		while (awaitInput == true) {
			stat_item.aBear();
			//If item was not encountered before 
			//RECOMMENDED TO USE THIS FOR REFERENCE:FOR ENCOUNTERING DYNAMIC OBJECTS THAT WILL BE PICKED UP)
			if (playerInventory.hasItemInInventory(dyn_item.leverP1) == false) {
				while (awaitInput1 == true) {
					System.out.println("It is holding an object.\nView object? 'y'/'n'");
					userInput = keyboard.next();
					if (userInput.equalsIgnoreCase("y")) {
						dyn_item.itemInfo_dynObj(dyn_item.leverP1);
						uniqueObject_toInventory(dyn_item.leverP1);
						awaitInput1 = false;
					} else if (userInput.equalsIgnoreCase("n")) {
						System.out.println("You decided not to view the object.");		
						awaitInput1 = false;
					}
				}
			}
		awaitInput = false;
		}	
	}
	//////////REDBOX////////////
	public void viewRedBox() { 
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
	//////////SHELF////////////
	public void viewShelf() {
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			System.out.println("<><>SHELF<><>");
			stat_item.aShelf();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("r")) {
				stat_item.aBirdR();
			}
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aBirdY();
			} 
			if (userInput.equalsIgnoreCase("g")) {
				stat_item.aBirdG();
			}
			if (userInput.equalsIgnoreCase("stop")) {
				System.out.println("you left the shelf");
				awaitInput = false;
			}
		}
	}
	//////////MIRROR////////////
	//viewMirror by Haine
	public void viewMirror() {
		System.out.println("<><>MIRROR<><>");
		stat_item.aMirror();
	}
	
}
