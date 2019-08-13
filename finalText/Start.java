package finalText;


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
	private boolean gotBearLever1 = false;
	private boolean gotBearLever2 = false;
	
	public boolean gameMenuOne() {
		gameRunning = true;
		inRoom1 = true;
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("\nYou decide to take a look around the room. Some things stand out to you.");
			this.gotBearLever1 = gameMethods.room1();
			} 
		return this.gotBearLever1;		
	}

	public boolean gameMenuTwo() {
		gameRunning = true;
		inRoom1 = true;
		while (gameRunning == true) {
			//////////GAME MENU
			System.out.println("\nFor whatever reason, you hold your breath when you approach this room. You let go of your breath and choose to look around anyways.");
			this.gotBearLever2 = gameMethods.room2();
			} 
		return this.gotBearLever2;		
	}
	
	private void exitView(String userInput) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("\nYou decide to stop looking around the room.\n");
			gameMethods.inRoom1 = false;
			gameRunning = false;
		}
	}
////////////////////////////ROOMS//////////////////////////////
	
	public boolean room1() {
		while (inRoom1 == true) {
			System.out.println("In the centre of the room, you can see a teddy bear on the floor, holding something. There is a blackboard on one wall. Next to that wall, there is a shelf with three photos displayed.");
			System.out.println("Looking down at the ground, you realize you have stepped into a shallow puddle.\n");
			
			System.out.println("To view your Inventory, type:\n'i'");
			System.out.println("To view certain things, type:\n'Bear'\n'Blackboard'\n'Shelf'\n'Puddle'");
			System.out.println("To stop looking around the room, type:\n'Exit'");
			System.out.println("..and then press ENTER.");
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
			if (userInput.equalsIgnoreCase("blackboard")) {
				gameMethods.viewBlackboard();
			}
			////////VIEW SHELF
			if (userInput.equalsIgnoreCase("shelf")) {
				gameMethods.viewShelf();
			}
			////////////VIEW MIRROR
			if (userInput.equalsIgnoreCase("puddle")) {
				gameMethods.viewPuddle();
			}
			gameMethods.exitView(userInput);
			
		}		//End of while loop
		return gotBearLever1;
	}
	
	public boolean room2() {
		while (inRoom1 == true) {
			System.out.println("\nThis room looks tidier than the other room. Mostly because this room only has three boxes.");
			System.out.println("A red box, a yellow box, and a green box all placed nicely side by side.");
			System.out.println("You feel content seeing a room so colourful and organized.\n");
			
			System.out.println("To view your Inventory, type:\n'i'");
			System.out.println("To view certain things, type:\n'Redbox'\n'Yellowbox'\n'Greenbox'");
			System.out.println("To stop looking around the room, type:\n'Exit'");
			System.out.println("..and then press ENTER.");
			userInput = keyboard.next();
			///////VIEW INVENTORY
			if (userInput.equalsIgnoreCase("i")) {
				gameMethods.viewInventory();
			}
			///////VIEW REDBOX
			//gameMethods.viewBear();
			if (userInput.equalsIgnoreCase("redbox")) {
				gameMethods.viewRedBox();
			}
			////////VIEW YELLOW BOX
			if (userInput.equalsIgnoreCase("yellowbox")) {
				gameMethods.viewYellowBox();
			}
			////////VIEW GREEN BOX
			if (userInput.equalsIgnoreCase("greenbox")) {
				gameMethods.viewGreenBox();
			}
			gameMethods.exitView(userInput);
			
		}		//End of while loop
		return gotBearLever2;
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
			if (playerInventory.hasItemInInventory(dyn_item.leverP1) == false) {
				while (awaitInput1 == true) {
					System.out.println("It is holding ...something.\nView object? 'y'/'n'");
					userInput = keyboard.next();
					if (userInput.equalsIgnoreCase("y")) {
						dyn_item.itemInfo_dynObj(dyn_item.leverP1);
						uniqueObject_toInventory(dyn_item.leverP1);
						this.gotBearLever1 = true;
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
	
	
	
	//////////REDBOX////////////
	public void viewRedBox() { 
		System.out.println("\n<><>RED BOX<><>");
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			stat_item.redBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aCard();
				this.gotBearLever1 = true;
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box.\n");
				awaitInput = false;
			}
		}  
	} 
	
	//////////YELLOWBOX////////////
	public void viewYellowBox() { 
		System.out.println("<><>YELLOW BOX<><>");
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			stat_item.yellowBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				stat_item.aNote();
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box.\n");
				awaitInput = false;
			}
		}
	}

	//////////YELLOWBOX////////////
	public void viewGreenBox() { 
		System.out.println("<><>GREEN BOX<><>");
		boolean awaitInput = true;
	
		while (awaitInput == true) {
			stat_item.greenBox();
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				System.out.println("Is this someone's toy chest? It's full of children's knick knacks. One of them, a stuffed owl with comically large eyes looks back at you.");
				System.out.println("You pick up the silly owl. There's a rubber egg underneath. You put the owl back down. Looking up, you see a poorly scribbled 8 under the lid.");
				if (gotBearLever2 == false) {
					dyn_item.itemInfo_dynObj(dyn_item.leverP2);
					uniqueObject_toInventory(dyn_item.leverP2);
					this.gotBearLever2 = true;
				}
				awaitInput = false;
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("you decided not to open the box.\n");
				awaitInput = false;
			}
		}
	}
	
	//////////SHELF////////////
	public void viewShelf() {
		boolean awaitInput = true;
		
		while (awaitInput == true) {
			System.out.println("\n<><>SHELF<><>");
			stat_item.aShelf();
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
