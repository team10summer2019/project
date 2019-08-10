import java.util.Scanner;
/**
 * @author Fiona
 * @author Haine
 *
 * Version Updated: August 5, 2019
 */

public class Room1Haine extends GenericRoom {
	private static boolean inRoom1H = true;
	//removed gameMethods
	private static Scanner keyboard = new Scanner(System.in); 
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item = new DynamicObjects();
	public Inventory playerInventory; //*
	public FloorInventory roomInventory; //*
	public LockLever lockLeverCheck; //*
	//private boolean gotBearLever1 = false;
	//private boolean gotBearLever2 = false;
//////////CONSTRUCTORS////////////
	public Room1Haine(GenericRoom gr) { //*
		super();
		this.playerInventory = new Inventory(gr.playerInventory);
		this.roomInventory = new FloorInventory(gr.roomInventory);
		this.lockLeverCheck = new LockLever(gr);
	}
//////////EXIT VIEW////////////
/*
* Leaves room
*/
	private void exitView(String userInput) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("\nYou decide to stop looking around the room.\n");
			Room1Haine.inRoom1H = false;
		}
	}
//////////ROOM 1 HAINE////////////
/*
* Lets you play through room
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
	public void setInRoom1H(boolean inRoom_Bool) {
		Room1Haine.inRoom1H = inRoom_Bool;
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
		this.playerInventory.addUniqueItemToInventory(item); //adds item to Inventory
		roomInventory.remove_flrInv(item); //removes item from FloorInventory
		//roomInventory.viewFloorInventory();
	}
//////////BEAR////////////
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
	public void viewPuddle() {
		System.out.println("\n<><>PUDDLE<><>");
		stat_item.aPuddle();
	}
////////BLACKBOARD//////////		//Haine
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

