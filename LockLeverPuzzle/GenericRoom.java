import java.util.Scanner;

/**
 * @author Fiona
 *
 * Version Updated: August 5, 2019
 */
//Renamed from "Start" class 
public class GenericRoom {
//want to combine main "?" "Room" methods in here
	
	//General Room variables
	private static boolean gameRunning = true;
	//private static boolean configurationRunning = true;
	private static Scanner kb = new Scanner(System.in);
	
	private Player p1 = new Player();//transfer player input into player
	private StaticObjects stat_item = new StaticObjects();
	private DynamicObjects dyn_item = new DynamicObjects();
	protected Inventory playerInventory;
	protected FloorInventory roomInventory;
	protected LockLever lockLeverCheck;
	
	//Room specific variables:gameMenus(GM)
	private static GenericRoom gr = new GenericRoom();
	private static Room1Haine room1HGM; //*
	private static Room2Haine room2HGM; //*
	private static Room3 room3GM; //*
	private static Room4 room4GM; //*
	
	public GenericRoom() { //*
		playerInventory = new Inventory();
		roomInventory = new FloorInventory();
		lockLeverCheck = new LockLever();
	}
	//Other variables
	private String roomName;  
	
//////////GAME MENU////////////
	/*
	 * Calls for particular Room to initiate 
	 */
	//////////////////////////////////////////////////////////////////
	//CONFIGURATION
	/*
	 * FOR DEVELOPERS: CALL FOR CONFIGURATION TO RUN A ROOM
	 */
	public void configuration(int roomNum) {
		//rename my room1 to room4
		if (roomNum == 1) {
			gameMenu_Room1Haine();
		}
		if (roomNum == 2) {
			gameMenu_Room2Haine();
		}
		if (roomNum == 3) {
			gameMenu_Room3();
		}
		if (roomNum == 4) {
			gameMenu_Room4();
		}
		setGameRunning(false);
	}
	
	/////////ROOMS////////////////

	//ROOM 1 HAINE
	private void gameMenu_Room1Haine() {
		setGameRunning(true);
		room1HGM = new Room1Haine(gr); //*
		while (gameRunning == true) {
			//////////SET roomName
			
			setRoomName("Room2");
			//////////GAME MENU
			System.out.println("\nThere is a room(1H) with a bunch of objects, time to visit the room.");
			System.out.println("Type 'Explore' to begin and 'Exit'");
			String userInput = kb.next();
			if (userInput.equalsIgnoreCase("explore")) {
				System.out.println("\nYou decide to take a look around the room. Some things stand out to you.");
				System.out.println("Initializing..");
				room1HGM.room1H();
				setGameRunning(false);				
			} 
			exitView(userInput, this.roomName);
		}
	}
	
	//ROOM 2 HAINE
	private void gameMenu_Room2Haine() {
		setGameRunning(true);
		room2HGM = new Room2Haine(gr); //*
		while (gameRunning == true) {
			//////////SET roomName
			setRoomName("Room2H");
			
			//////////GAME MENU
			System.out.println("\nThere is a room(2H) with a bunch of objects, time to visit the room.");
			System.out.println("Type 'Explore' to begin and 'Exit'");
			String userInput = kb.next();
			if (userInput.equalsIgnoreCase("explore")) {
				System.out.println("\nFor whatever reason, you hold your breath when you approach this room. You let go of your breath and choose to look around anyways.");
				System.out.println("Initializing..");
				room2HGM.room2H();
				setGameRunning(false);
			} 
			exitView(userInput, this.roomName);
		}
	}
	
	//ROOM 3
	private void gameMenu_Room3() {
		setGameRunning(true);
		room3GM = new Room3(gr); //*
		while (gameRunning == true) {
			//////////SET roomName
			setRoomName("Room3");
			//////////GAME MENU
			System.out.println("\nThere is a room(3) with a bunch of objects, time to visit the room.");
			System.out.println("Type 'Explore' to begin and 'Exit'");
			String userInput = kb.next();
			if (userInput.equalsIgnoreCase("explore")) {
				System.out.println("Initializing..");
				room3GM.room3();
				setGameRunning(false);
			} 
			exitView(userInput, this.roomName);
		}
	}
	
	//ROOM 4
	private void gameMenu_Room4() {
		setGameRunning(true);
		room4GM = new Room4(gr); //*
		while (gameRunning == true) {
			//
			//////////SET roomName
			setRoomName("Room4");
			//////////GAME MENU
			System.out.println("\nThere is a room(4) with a bunch of objects, time to visit the room.");
			System.out.println("Type 'Explore' to begin and 'Exit'");
			String userInput = kb.next();
			if (userInput.equalsIgnoreCase("explore")) {
				System.out.println("Initializing..");
				room4GM.room4();
				setGameRunning(false);
			}
			exitView(userInput, this.roomName);
		}
	}
	
//////////EXIT VIEW////////////
	/*
	 * Leaves Room
	 */
	private void exitView(String userInput, String roomName) {
		if (userInput.equalsIgnoreCase("exit")) { //don't need to prompt for each item(aka. make a new method to call it) because it'll be combined later on
			System.out.println("You decided not to explore the room.");
			if (this.roomName.equals("Room1H")) {
				room1HGM.setInRoom1H(false);
			}
			if (this.roomName.equals("Room2H")) {
				room2HGM.setInRoom2H(false);
			}	
			if (this.roomName.equals("Room3")) {
				room3GM.setInRoom3(false);
			}
			if (this.roomName.equals("Room4")) {
				room4GM.setInRoom4(false);
			}	
			setGameRunning(false);
			//kb.close(); //for isolated game from MazeGame only (DEVELOPERS USE)
		}
	}
//////////SET GAMERUNNING////////////
	private void setGameRunning(boolean status) {
		GenericRoom.gameRunning = status;
	}
//////////SET ROOMNAME////////////
	/*
	 * sets specific room that will be running
	 */
	private void setRoomName(String roomName) {
		this.roomName = roomName;
	}
//////////Add Unique Object to Inventory////////////
	//change status of dynamic object(ANY!)
	//Adds unique item to Inventory and removes unique item from FloorInventory
	protected void uniqueObject_toInventory(String item) { 
		System.out.println("You added '" + item + "' to your inventory.");
		dyn_item.changeStatus_dynObj(item);
		this.playerInventory.addUniqueItemToInventory(item); //adds item to Inventory
		roomInventory.remove_flrInv(item); //removes item from FloorInventory
	}
}
