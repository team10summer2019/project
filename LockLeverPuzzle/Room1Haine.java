import java.util.Scanner;
/**
 * @author Fiona Yong
 * @author Haine Kim
 * @version August 13, 2019
 *
 * CLASS
 * ROOM1HAINE
 * Runs Room specific configurations
 *
 */

/*
 * CLASS
 * ROOM1HAINE
 * Runs Room specific configurations
 */
public class Room1Haine extends GenericRoom {
	private static boolean inRoom1H = true;
	//removed gameMethods
	private static Scanner keyboard = new Scanner(System.in); 
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item;
	public Inventory playerInventory; 
	public FloorInventory roomInventory; 
	public LockLever lockLeverCheck; 
	//private boolean gotBearLever1 = false;
	//private boolean gotBearLever2 = false;
//////////CONSTRUCTORS////////////
	/**
	 * @param gr passes instance of GenericRoom's prompted instance of Classes
	 */
	public Room1Haine(GenericRoom gr) { 
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
			System.out.println("\nYou decide to stop looking around the room.\n");
			Room1Haine.inRoom1H = false;
		}
	}
//////////ROOM 1 HAINE////////////
/**
 * Lets user play through room when called
 */
public void room1H() {
	while (inRoom1H == true) {
		System.out.println("//////////Room 1H://///////////");
		System.out.println("In the centre of the room, you can see a teddy bear on the floor, holding something. There is a blackboard on one wall. Next to that wall, there is a shelf with three photos displayed.");
		System.out.println("Looking down at the ground, you realize you have stepped into a shallow puddle.\n");
		if (lockLeverCheck.combinedLeverStatus() == true) {
			
		}
		System.out.println("To view your Inventory, type:\n'i'");
		System.out.println("To view certain things, type:\n'Bear'\n'Blackboard'\n'Shelf'\n'Puddle'");
		System.out.println("To stop looking around the room, type:\n'Exit'");
		System.out.println("..and then press ENTER.");
		userInput = keyboard.next();
		///////VIEW INVENTORY
		if (userInput.equalsIgnoreCase("i")) {
			viewInventory();
		}
		///////VIEW BEAR
		//gameMethods.viewBear();
		if (userInput.equalsIgnoreCase("bear")) {
			viewBear();
		}
		////////VIEW REDBOX
		if (userInput.equalsIgnoreCase("blackboard")) {
			viewBlackboard();
		}
		////////VIEW SHELF
		if (userInput.equalsIgnoreCase("shelf")) {
			viewShelfH();
		}
		////////////VIEW MIRROR
		if (userInput.equalsIgnoreCase("puddle")) {
			viewPuddle();
		}
		exitView(userInput);
		
	}//End of while loop
	//return gotBearLever1;
}
//////////SET INROOM1H////////////
	/**
	 * @param inRoom_Bool Status of being in Room; true if in Room, false if not in Room
	 */
	public void setInRoom1H(boolean inRoom_Bool) {
		Room1Haine.inRoom1H = inRoom_Bool;
	}
////////////////////////ITEM METHODS////////////////////////////////
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
		dyn_item.changeStatus_dynObj(item);
		this.playerInventory.addUniqueItemToInventory(item); //adds item to Inventory
		roomInventory.remove_flrInv(item); //removes item from FloorInventory
		//roomInventory.viewFloorInventory();
	}
//////////BEAR////////////
	/**
	 * Provide information and interactions with object in room
	 */
	public void viewBear() {
		System.out.println("\n<><>BEAR<><>");
		boolean awaitInput = true;
		boolean awaitInput1 = true;
	
		while (awaitInput == true) {
			stat_item.aBear();
			//If item was not encountered before 
			//RECOMMENDED TO USE THIS FOR REFERENCE:FOR ENCOUNTERING DYNAMIC OBJECTS THAT WILL BE PICKED UP)
			if (playerInventory.hasItemInInventory(dyn_item.topHat) == false) {
				while (awaitInput1 == true) {
					System.out.println("It is holding ...something.\nView object? 'y'/'n'");
					userInput = keyboard.next();
					if (userInput.equalsIgnoreCase("y")) {
						dyn_item.itemInfo_dynObj(dyn_item.topHat);
						uniqueObject_toInventory(dyn_item.topHat);
						//this.gotBearLever1 = true;
						awaitInput1 = false;
					} else if (userInput.equalsIgnoreCase("n")) {
						System.out.println("You decided not to take a closer look.\n");		
						awaitInput1 = false;
					}
				}
			}
		awaitInput = false;
		}	
	}
//////////SHELF////////////
	/**
	 * Provide information and interactions with object in room
	 */
	public void viewShelfH() {
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			System.out.println("\n<><>SHELF<><>");
			stat_item.aShelfH();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("left")) {
				stat_item.aLeftPhoto();
			}
			if (userInput.equalsIgnoreCase("middle")) {
				stat_item.aMiddlePhoto();
			} 
			if (userInput.equalsIgnoreCase("right")) {
				stat_item.aRightPhoto();
			}
			if (userInput.equalsIgnoreCase("stop")) {
				System.out.println("you left the shelf.\n");
				awaitInput = false;
			}
		}
	}
//////////PUDDLE////////////		//Haine
	/**
	 * Provide information and interactions with object in room
	 * @author Haine Kim
	 */
	public void viewPuddle() {
		System.out.println("\n<><>PUDDLE<><>");
		stat_item.aPuddle();
	}
////////BLACKBOARD//////////		//Haine
	/**
	 * Provide information and interactions with object in room
	 * @author Haine Kim
	 */
	public void viewBlackboard() { 
		System.out.println("\n<><>BLACKBOARD<><>");
		boolean awaitInput = true;
		while (awaitInput == true) {
			stat_item.aBlackboard();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				System.out.println("\nThere is nothing to write with. There are pennies faced head side up where you think the chalk and eraser should be.\n");
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("\nYou decided not to vandalize the already vandalized blackboard.\n");
				awaitInput = false;
			}
		}
	} 
}

