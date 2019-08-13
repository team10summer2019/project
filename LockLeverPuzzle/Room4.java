package LockLeverPuzzle;
import java.util.Scanner;
/**
 * @author Fiona Yong
 * @version August 13, 2019
 *
 * CLASS
 * ROOM4
 * Runs Room specific configurations
 *
 */

public class Room4 extends GenericRoom {
	
	//Room specific variables
	private static boolean inRoom4 = true;
	//private static Room4 gameMethods = new Room4();
	//Other variables
	private static Scanner keyboard = new Scanner(System.in);
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item; 
	private Inventory playerInventory; 
	private FloorInventory roomInventory; 
	LockLever lockLeverCheck;
	
//////////CONSTRUCTORS////////////
	/**
	 * @param gr passes instance of GenericRoom's prompted instance of Classes
	 */
	public Room4(GenericRoom gr) { 
		super();
		this.playerInventory = new Inventory(gr.playerInventory);
		this.roomInventory = new FloorInventory(gr.roomInventory);
		this.dyn_item = new DynamicObjects(gr.lockLeverCheck);
		this.lockLeverCheck = new LockLever(gr);
	}	
//////////EXIT VIEW////////////
	/**
	 * Leaves current room if permitted
	 * @param userInput checks if input was 'exit' to leave
	 */
	private void exitView(String userInput) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("Exiting..");
			Room4.inRoom4 = false;
			//keyboard.close(); //for isolated game from MazeGame only (DEVELOPERS USE)
		}
	}
//////////ROOM 4////////////
	/**
	 * Lets user play through room when called
	 */
	public void room4() {
		while (inRoom4 == true) {
			System.out.println("//////////Room 4://///////////\nThis room has a bear with a red box beside it. There is a shelf with three birds sitting on it: a red bird, yellow bird, and green bird.");
			System.out.println("To view your Inventory:\n'i'");
			System.out.println("To view certain items, type:\n'Bear'\n'RedBox'\n'Shelf'");
			System.out.println("To stop looking around the room, type:\n'Exit'");
			userInput = keyboard.next();
			///////VIEW INVENTORY
			if (userInput.equalsIgnoreCase("i")) {
				viewInventory();
			}
			///////VIEW BEAR
			//viewBear();
			if (userInput.equalsIgnoreCase("bear")) {
				viewBear();
			}
			////////VIEW REDBOX
			if (userInput.equalsIgnoreCase("redbox")) {
				viewRedBox();
			}
			////////VIEW SHELF
			if (userInput.equalsIgnoreCase("shelf")) {
				viewShelf();
			}
			exitView(userInput);
		}
	}
//////////SET INROOM4////////////
	/**
	 * @param inRoom_Bool Status of being in Room; true if in Room, false if not in Room
	 */
	public void setInRoom4(boolean inRoom_Bool) {
		Room4.inRoom4 = inRoom_Bool;
	}
	
////////////////////////ITEM METHODS////////////////////////////////
/*
 * Unique methods that are used in the class
 */
	/**
	 * Views player inventory
	 */
	public void viewInventory() {
		playerInventory.viewInventory();
	}

	//////////Add Unique Object to Inventory////////////
	/**
	 * Changes the status of any DynamicObjects item.
	 * Adds the unique item to Inventory and removes unique item from FloorInventory by its string 'identity name'
	 * @param item 'Item identity name'
	 */
	public void uniqueObject_toInventory(String item) { 
		System.out.println("You added '" + item + "' to your inventory.");
		this.lockLeverCheck = dyn_item.changeStatus_dynObj(item); 
		playerInventory.addUniqueItemToInventory(item); //adds item to Inventory
		roomInventory.remove_flrInv(item); //removes item from FloorInventory
		//roomInventory.viewFloorInventory();
	}
	
	//////////BEAR////////////
	/**
	 * Provide information and interactions with object in room
	 */
	private void viewBear() {
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
	/**
	 * Provide information and interactions with object in room
	 */
	private void viewRedBox() { 
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
	/**
	 * Provide information and interactions with object in room
	 */
	private void viewShelf() {
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
}
