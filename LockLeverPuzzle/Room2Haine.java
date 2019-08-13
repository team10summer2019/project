package LockLeverPuzzle;
import java.util.Scanner;
/**
 * @author Fiona Yong
 * @author Haine Kim
 * @version August 13, 2019
 *
 * CLASS
 * ROOM2HAINE
 * Runs Room specific configurations
 *
 */

/*
 * CLASS
 * ROOM2HAINE
 * Runs Room specific configurations
 */
public class Room2Haine extends GenericRoom {
	private static boolean inRoom2H = true;
	//private static Room2Haine gameMethods = new Room2Haine();
	private static Scanner keyboard = new Scanner(System.in); 
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private LockLever lockLeverCheck; 
	private DynamicObjects dyn_item;
	private Inventory playerInventory; 
	private FloorInventory roomInventory; 
	//private boolean gotBearLever1 = false;
	//private boolean gotBearLever2 = false;
	/*
	public boolean gameMenuOne() {
		gameRunning = true;
		inRoom2 = true;
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("\nYou decide to take a look around the room. Some things stand out to you.");
			this.gotBearLever1 = room1();
			} 
		return this.gotBearLever1;		
	}

	public boolean gameMenuTwo() {
		gameRunning = true;
		inRoom2 = true;
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("\nFor whatever reason, you hold your breath when you approach this room. You let go of your breath and choose to look around anyways.");
			this.gotBearLever2 = room2();
			} 
		return this.gotBearLever2;		
	}
	*/
//////////CONSTRUCTORS////////////
	/**
	 * @param gr passes instance of GenericRoom's prompted instance of Classes
	 */
	public Room2Haine(GenericRoom gr) { 
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
			Room2Haine.inRoom2H = false;
		}
	}
//////////ROOM 2 HAINE////////////
	/**
	 * Lets user play through room when called
	 */
	public void room2H() {
		while (inRoom2H == true) {
			System.out.println("//////////Room 2H://///////////");
			System.out.println("This room looks tidier than the other room. Mostly because this room only has three boxes.");
			System.out.println("A orange box, a purple box, and a toy box all placed nicely side by side.");
			System.out.println("You feel content seeing a room so colourful and organized.\n");
			
			System.out.println("To view your Inventory, type:\n'i'");
			System.out.println("To view certain things, type:\n'Orangebox'\n'Purplebox'\n'Toybox'");
			System.out.println("To stop looking around the room, type:\n'Exit'");
			System.out.println("..and then press ENTER.");
			userInput = keyboard.next();
			///////VIEW INVENTORY
			if (userInput.equalsIgnoreCase("i")) {
				viewInventory();
			}
			///////VIEW ORANGEBOX
			//viewBear();
			if (userInput.equalsIgnoreCase("orangebox")) {
				viewOrangeBox();
			}
			////////VIEW YELLOW BOX
			if (userInput.equalsIgnoreCase("purplebox")) {
				viewPurpleBox();
			}
			////////VIEW GREEN BOX
			if (userInput.equalsIgnoreCase("toybox")) {
				viewToyBox();
			}
			exitView(userInput);
			
		}//End of while loop
		//return gotBearLever2;
	}

//////////SET INROOM2H////////////
	/**
	 * @param inRoom_Bool Status of being in Room; true if in Room, false if not in Room
	 */
	public void setInRoom2H(boolean inRoom_Bool) {
		Room2Haine.inRoom2H = inRoom_Bool;
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
//////////ORANGEBOX////////////
	/**
	 * Provide information and interactions with object in room
	 */
	public void viewOrangeBox() { 
		System.out.println("\n<><>ORANGE BOX<><>");
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			stat_item.orangeBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aCardH();
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box.\n");
				awaitInput = false;
			}
		}  
	} 
	
	//////////PURPLEBOX////////////
	/**
	 * Provide information and interactions with object in room
	 */
	public void viewPurpleBox() { 
		System.out.println("<><>PURPLE BOX<><>");
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			stat_item.purpleBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aNoteH();
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box.\n");
				awaitInput = false;
			}
		}
	}

	//////////TOYBOX////////////
	/**
	 * Provide information and interactions with object in room
	 */
	public void viewToyBox() { 
		System.out.println("<><>TOY BOX<><>");
		boolean awaitInput = true;
	
		while (awaitInput == true) {
			stat_item.toyBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				System.out.println("Is this someone's toy chest? It's full of children's knick knacks. One of them, a stuffed owl with comically large eyes looks back at you.");
				System.out.println("You pick up the silly owl. There's a rubber egg underneath. You put the owl back down. Looking up, you see a poorly scribbled 8 under the lid.");
				/*if (gotBearLever2 == false) {
					dyn_item.itemInfo_dynObj(dyn_item.leverP2);
					uniqueObject_toInventory(dyn_item.leverP2);
					this.gotBearLever2 = true;
				}*/
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box.\n");
				awaitInput = false;
			}
		}
	}	
}
