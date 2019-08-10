package LockLeverPuzzle;
/**
 * @author Fiona
 *
 */
public class StaticObjects extends Inventory {
	/*
	 * CLASS
	 * STATIC OBJECTS
	 * These are objects that only provide a description.
	 * They may be neutral objects or objects that provide clues.
	 * (Some of these objects are things that are taken from the room and placed into the inventory. NOT IMPLEMENTED)
	 */
	public StaticObjects() {
		
	}
	//METHODS

	//UNIQUE METHODS
	/////ROOM1/////
	
	public void aMirror() {
		System.out.println("This is a mirror.");
		
	}
	
	public void aBear() {
		System.out.println("This is a bear.");
		
	}
	
	public void aBracelet() {
		System.out.println("This is a bracelet with four yellow stars on it.");
	}
	
	public void aCard() {
		System.out.println("A black seven of spades playing card.");
	}
	
	public void aPaper() {
		System.out.println("You unfold the paper. It is torn and looks like it came from a nursery book.");
		System.out.println("On it, there writes: '--two, tie your shoe.'. There is a drawing of a green shoe right beneath it.");
	}
	
	public void aBirdR() {
		System.out.println("It is a red Bird. There is a circle stamped on it.");
	}
	
	public void aBirdY() {
		System.out.println("It is a yellow Bird. There is a asterisk stamped on it.");
	}
	
	public void aBirdG() {
		System.out.println("It is a green Bird. There is a diamond stamped on it.");
	}
	
	public void redBox() {
		System.out.println("It is a red box.\nOpen? 'y'/'n'");
	}
	public void aShelf() {
		System.out.println("You are viewing the shelf.");
		System.out.println("There is a red Bird, a yellow Bird, and a green Bird.\nTo view type:\n'r'-red Bird\n'y'-yellow Bird\n'g'-greenbird");
		System.out.println("To stop viewing the shelf, type 'Stop'.");
	}
	
	/////ROOM2////
	public void aCabinet() {
		System.out.println("It is a cabinet.");
	}
	
	public void greenBox() {
		System.out.println("It is a green box.");
	}
	
	public void aNote() {
		System.out.println("You unfold the note. It is a torn page from a nursery book. The note reads:");
		System.out.println("__________________");
		System.out.println("|'One,Two'        |");
		System.out.println("|'Tie your Shoe.' |");
		System.out.println("|_________________|");
		System.out.println("The 'Two' has been circled in crayon. There is a picture of a green shoe right below the nursery rhyme.");
	}
	
	public void underCabinet() {
		System.out.println("There is a yellow box sitting underneath the cabinet. Look inside the box? 'y'/'n'");
	}
	
	public void inYellowBox() {
		System.out.println("You opened the yellow box.\nThere is a bracelet in the box.");
	}
	/////ROOM1HAINE/////
	public void aLeftPhoto() {  //Added by Haine
		System.out.println("\nA baby smiles at the camera. It looks like it's having the time of it's life on all fours.");
	}
	
	public void aMiddlePhoto() {  //Added by Haine
		System.out.println("\nThere is a young man in a graduation gown. He stands victoriously on stage.");
	}
	
	public void aRightPhoto() {  //Added by Haine
		System.out.println("\nIt's a picture perfect family photo. The elderly man in the middle leans heavily on his cane, as if it were a third leg helping him stand.");
	}
	
	public void aPuddle() { //Added by Haine
		System.out.println("Upon closer inspection, it's not much of a puddle. It just looks like someone dropped\nice cubes where you're standing, and it melted.\n");
	}
	
	public void aBlackboard() {
		System.out.println("It is a regular blackboard, about as big as the ones in classrooms.\nIt's covered in chalk profanities. Write on it? 'y'/'n'");
	}
	
	/////ROOM2HAINE/////
	public void aCardH() { //Added by Haine
		System.out.println("\nIt has Happy Birthday written on it.\n");
	}
	public void orangeBox() { //Addedd by Haine
		System.out.println("It is an orange box. Someone painted a white 1 on the lid.\nOpen? 'y'/'n'");
	}
	
	public void purpleBox() { //Added by Haine
		System.out.println("A very bright, purple box.\nOpen? 'y'/'n'");
	}
	
	public void toyBox() { //Added by Haine
		System.out.println("Someone wrote a sloppy 8 on the lid with sharpie.\nOpen? 'y'/'n'\"");
	}
	
	public void aShelfH() { //Modified and added by Haine
		System.out.println("You are viewing the shelf.");
		System.out.println("There are three framed photos, neatly lined up next to each other.");
		System.out.println("For a closer look at the photo on the left, type: 'Left'.");
		System.out.println("For a closer look at the photo in the middle, type: 'Middle'.");
		System.out.println("For a closer look at the photo on the right, type: 'Right'.");
		System.out.println("To stop viewing the shelf, type 'Stop'.");
		System.out.println("..and then press ENTER.");
	}
	
	public void aNoteH() { //Modified and added by Haine
		System.out.println("You find a folded sticky note inside. You unfold the note. The note reads:");
		System.out.println("__________________");
		System.out.println("|'Wishlist'       |");
		System.out.println("|-Doll            |");
		System.out.println("|-Racecar      	  |");
		System.out.println("|_________________|");
	}
}
