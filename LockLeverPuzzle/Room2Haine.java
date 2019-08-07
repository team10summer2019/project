import java.util.Scanner;
/**
 * @author Fiona
 * @author Haine
 *
 * Version Updated: August 5, 2019
 */

public class Room2Haine extends GenericRoom {
	private static boolean inRoom2H = true;
	private static Room2Haine gameMethods = new Room2Haine();
	private static Scanner keyboard = new Scanner(System.in); 
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item = new DynamicObjects();
	private Inventory playerInventory = new Inventory();
	private FloorInventory roomInventory = new FloorInventory();
	//private boolean gotBearLever1 = false;
	//private boolean gotBearLever2 = false;
	/*
	public boolean gameMenuOne() {
		gameRunning = true;
		inRoom2 = true;
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("\nYou decide to take a look around the room. Some things stand out to you.");
			this.gotBearLever1 = gameMethods.room1();
			} 
		return this.gotBearLever1;		
	}

	public boolean gameMenuTwo() {
		gameRunning = true;
		inRoom2 = true;
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("\nFor whatever reason, you hold your breath when you approach this room. You let go of your breath and choose to look around anyways.");
			this.gotBearLever2 = gameMethods.room2();
			} 
		return this.gotBearLever2;		
	}
	*/
//////////EXIT VIEW////////////
/*
* Leaves room
*/
	private void exitView(String userInput) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("\nYou decide to stop looking around the room.\n");
			Room2Haine.inRoom2H = false;
		}
	}
//////////ROOM 2 HAINE////////////
/*
* Lets you play through room
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
				gameMethods.viewInventory();
			}
			///////VIEW ORANGEBOX
			//gameMethods.viewBear();
			if (userInput.equalsIgnoreCase("orangebox")) {
				gameMethods.viewOrangeBox();
			}
			////////VIEW YELLOW BOX
			if (userInput.equalsIgnoreCase("purplebox")) {
				gameMethods.viewPurpleBox();
			}
			////////VIEW GREEN BOX
			if (userInput.equalsIgnoreCase("toybox")) {
				gameMethods.viewToyBox();
			}
			gameMethods.exitView(userInput);
			
		}//End of while loop
		//return gotBearLever2;
	}

//////////SET INROOM2H////////////
	public void setInRoom2H(boolean inRoom_Bool) {
		Room2Haine.inRoom2H = inRoom_Bool;
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
//////////ORANGEBOX////////////
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
