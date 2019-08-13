import java.util.Scanner;
/**
 * @author Fiona Yong
 * @version August 13, 2019
 *
 * CLASS
 * ROOM3
 * Runs Room specific configurations
 *
 */

public class Room3 extends GenericRoom {
	
	//Room specific variables
	private static boolean inRoom3 = true;
	
	//private static Room3 gameMethods = new Room3();
	//Other variables
	private static Scanner keyboard = new Scanner(System.in);
	private String userInput;
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item;
	private Inventory playerInventory;
	private FloorInventory roomInventory;

//////////CONSTRUCTORS////////////
	/**
	 * @param gr passes instance of GenericRoom's prompted instance of Classes
	 */
	public Room3(GenericRoom gr) { 
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
			Room3.inRoom3 = false;
			//keyboard.close(); //for isolated game from MazeGame only (DEVELOPERS USE)
		}
	}
	
//////////ROOM 3////////////
	/**
	 * Lets user play through room when called
	 */
	public void room3() {
		while (inRoom3 == true) {
			System.out.println("//////////Room 3://///////////\nThis room has a cabinet.");
			System.out.println("To view your Inventory:\n'i'");
			System.out.println("To view certain items, type:\n'Cabinet'-to look inside the cabinet\n'Under'-to look underneath the cabinet");
			System.out.println("To stop looking around the room, type:\n'Exit'");
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("i")) {
				viewInventory();
			}
			///////VIEW CABINET
			if (userInput.equalsIgnoreCase("cabinet")) {
				viewCabinet();
			}
			///////VIEW UNDER CABINET
			if (userInput.equalsIgnoreCase("under")) {
				viewUnderCabinet();
			}
			exitView(userInput);
		}
	}
//////////SET INROOM3////////////
	/**
	 * @param inRoom_Bool Status of being in Room; true if in Room, false if not in Room
	 */
	public void setInRoom3(boolean inRoom_Bool) {
		Room3.inRoom3 = inRoom_Bool;
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
		dyn_item.changeStatus_dynObj(item);
		playerInventory.addUniqueItemToInventory(item); //adds item to Inventory
		roomInventory.remove_flrInv(item); //removes item from FloorInventory
		//roomInventory.viewFloorInventory();
	}
	//////////CABINET/////////
	/**
	 * Provide information and interactions with object in room
	 * If user has key, cabinet can be opened and viewed, otherwise it doesn't do anything
	 * The cabinet initially contains box and leverPiece2 
	 */
	public void viewCabinet() {
		System.out.println("<><>CABINET<><>");
		boolean awaitInput = true;
	
		while (awaitInput == true) {
			stat_item.aCabinet();
			//if cabinet is unlocked because there is cabinetKey in inventory
			if (playerInventory.hasItemInInventory(dyn_item.cabinetKey) == true) {
				System.out.println("The cabinet is unlocked. You open the cabinet.");
				boolean awaitInput1 = true;
				//if lever does not exist in inventory///////////////////////////////////////////
				if (playerInventory.hasItemInInventory(dyn_item.leverP2) == false) {
					while (awaitInput1 == true) {
						System.out.println("There is a green box in the cabinet as well as a metal object..is it a broken lever?");
						System.out.println("To view, type:\n'GreenBox'\n'Lever'-metal object");
						System.out.println("To stop viewing the cabinet, type 'Stop'.");
						userInput = keyboard.next();
						//viewing GREENBOX//
						if (userInput.equalsIgnoreCase("greenbox")) {
							System.out.println("<><>GREENBOX<><>");
							boolean awaitInput2 = true;
							while (awaitInput2 == true) {
								stat_item.greenBox();
								System.out.println("Open the green box? 'y'/'n'");
								userInput = keyboard.next();
								if (userInput.equalsIgnoreCase("y")) {
									stat_item.aNote();
									awaitInput2 = false;
								} else if (userInput.equalsIgnoreCase("n")) {
									System.out.println("You decided not to open the box");
									awaitInput2 = false;
								}
							}
							awaitInput = false;
						}
						//viewing LEVER//
						if (userInput.equalsIgnoreCase("lever")) {
							if (playerInventory.hasItemInInventory(dyn_item.leverP2) == false) {
								while (awaitInput1 == true) {
									System.out.println("View lever? 'y'/'n'");
									userInput = keyboard.next();
									if (userInput.equalsIgnoreCase("y")) {
										dyn_item.itemInfo_dynObj(dyn_item.leverP2);
										uniqueObject_toInventory(dyn_item.leverP2);
										awaitInput1 = false;
									} else if (userInput.equalsIgnoreCase("n")) {
										System.out.println("You decided not to take the lever.");	
										awaitInput1 = false;
									}
								}
							}
						}
						if (userInput.equalsIgnoreCase("stop")) {
							System.out.println("You left the cabinet.");
							awaitInput1 = false;
						}
					}
				}
				//if lever exists in inventory//////////////////////////////////////////////////
				if (playerInventory.hasItemInInventory(dyn_item.leverP2) == true) {
					while (awaitInput1 == true) {
						System.out.println("There is a green box in the cabinet.");
						System.out.println("To view, type:\n'GreenBox'");
						System.out.println("To stop viewing the cabinet, type 'Stop'.");
						userInput = keyboard.next();
						//viewing GREENBOX//
						if (userInput.equalsIgnoreCase("greenbox")) {
							System.out.println("<><>GREENBOX<><>");
							boolean awaitInput2 = true;
							while (awaitInput2 == true) {
								stat_item.greenBox();
								System.out.println("Open the green box? 'y'/'n'");
								userInput = keyboard.next();
								if (userInput.equalsIgnoreCase("y")) {
									stat_item.aNote();
									awaitInput2 = false;
								} else if (userInput.equalsIgnoreCase("n")) {
									System.out.println("You decided not to open the box");
									awaitInput2 = false;
								}
							}
							awaitInput2 = false;
						}
						if (userInput.equalsIgnoreCase("stop")) {
							System.out.println("You left the cabinet.");
							awaitInput1 = false;
						}
					}
				}
			} 
			//if there is no cabinetKey in inventory
			if (playerInventory.hasItemInInventory(dyn_item.cabinetKey) == false) {
				System.out.println("The cabinet is locked. There is a key lock on it.");
			}
		awaitInput = false;
		}	
	}
	//////////VIEW UNDER CABINET/////////
	/*
	 * Provide information and interactions with object in room
	 * opens views yellow box, inside a bracelet and key
	 */
	public void viewUnderCabinet() {
		boolean awaitInput = true;
		while (awaitInput == true) {
			System.out.println("<><>UNDERNEATH CABINET<><>");
			stat_item.underCabinet(); //there is a yellow box, view box? y/n
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("y")) {
				//in yellow box
				boolean awaitInput1 = true;
				//if key does not exist in inventory
				if (playerInventory.hasItemInInventory(dyn_item.cabinetKey) == false) {
					while (awaitInput1 == true) {
						System.out.println("<><>YELLOWBOX<><>");
						stat_item.inYellowBox(); //there is bracelet
						System.out.println("There is also a key in the box.");
						System.out.println("To view, type:\n'Bracelet'\n'Key'");
						System.out.println("To stop viewing the yellow box, type 'Stop'.");
						userInput = keyboard.next();
						if (userInput.equalsIgnoreCase("bracelet")) {
							stat_item.aBracelet();
						} 
						if (userInput.equalsIgnoreCase("key")) {
							dyn_item.itemInfo_dynObj(dyn_item.cabinetKey);
							uniqueObject_toInventory(dyn_item.cabinetKey);
							awaitInput1 = false;
						}
						if (userInput.equalsIgnoreCase("stop")) {
							System.out.println("You left the yellow box.");
							awaitInput1 = false;
						}
					}
				awaitInput1 = false;
				}
				//if key exists in inventory
				if (playerInventory.hasItemInInventory(dyn_item.cabinetKey) == true) {
					while (awaitInput1 == true) {
						System.out.println("<><>YELLOWBOX<><>");
						stat_item.inYellowBox(); //there is bracelet
						System.out.println("To view, type:\n'Bracelet'");
						System.out.println("To stop viewing the yellow box, type 'Stop'.");
						userInput = keyboard.next();
						if (userInput.equalsIgnoreCase("bracelet")) {
							stat_item.aBracelet();
						} 
						if (userInput.equalsIgnoreCase("stop")) {
							System.out.println("You left the yellow box.");
							awaitInput1 = false;
						}
					}
				awaitInput1 = false;
				}
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println("You decided not to open the box");
				awaitInput = false;
			}
		awaitInput = false;
		}
	}
}