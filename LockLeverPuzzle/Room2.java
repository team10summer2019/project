import java.util.Scanner;

/**
 * @author Fiona
 * Version Updated: July 29, 2019
 */

public class Room2 {
	private static boolean gameRunning = true;
	private static boolean inRoom2 = true;//*
	private static Room2 gameMethods = new Room2();//*
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
			System.out.println("Welcome to Room 2, time to visit the room.");
			System.out.println("Type 'Start' to begin and 'Exit'");
			String userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("start")) {
				System.out.println("Initializing..");
				gameMethods.room2();
			} 
			gameMethods.exitView(userInput);
				
		}
	}
	private void exitView(String userInput) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("Exiting..");
			gameMethods.inRoom2 = false;
			gameRunning = false;
			keyboard.close(); //for isolated game from MazeGame only (DEVELOPERS USE)
		}
	}
	
	public void room2() {
		while (inRoom2 == true) {
			System.out.println("//////////Room 2://///////////\nThis room has a cabinet.");
			System.out.println("To view your Inventory:\n'i'");
			System.out.println("To view certain items, type:\n'Cabinet'-to look inside the cabinet\n'Under'-to look underneath the cabinet");
			userInput = keyboard.next();
			if (userInput.equalsIgnoreCase("i")) {
				gameMethods.viewInventory();
			}
			///////VIEW CABINET
			if (userInput.equalsIgnoreCase("cabinet")) {
				gameMethods.viewCabinet();
			}
			///////VIEW UNDER CABINET
			if (userInput.equalsIgnoreCase("under")) {
				gameMethods.viewUnderCabinet();
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
	//////////CABINET/////////
	/*
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