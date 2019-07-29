package maze2;

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
	public void aBear() {
		System.out.println("This is a bear.");
		
	}
	
	public void aBracelet() {
		System.out.println("This is a bracelet with four yellow stars on it.");
	}
	
	public void aCard() {
		System.out.println("\nA black seven of spades playing card.\n");
	}
	
	public void aNote() {
		System.out.println("You find a folded sticky note inside. You unfold the note. It is a torn page from a nursery book. The note reads:");
		System.out.println("__________________");
		System.out.println("|'One,Two'        |");
		System.out.println("|'Tie your Shoe.' |");
		System.out.println("|_________________|");
		System.out.println();
		System.out.println("The 'Two' has been circled in crayon. There is a picture of a green shoe right below the nursery rhyme.\n");
	}
	
	public void aLeftPhoto() {
		System.out.println("\nA baby smiles at the camera. It looks like it's having the time of it's life on all fours.");
	}
	
	public void aMiddlePhoto() {
		System.out.println("\nThere is a young man in a graduation gown. He stands victoriously on stage.");
	}
	
	public void aRightPhoto() {
		System.out.println("\nIt's a picture perfect family photo. The elderly man in the middle leans heavily on his cane, as if it were a third leg helping him stand.");
	}
	
	public void redBox() {
		System.out.println("It is a red box. Someone painted a white 1 on the lid.\nOpen? 'y'/'n'");
	}
	
	public void yellowBox() {
		System.out.println("A very bright, yellow box.\nOpen? 'y'/'n'");
	}
	
	public void greenBox() {
		System.out.println("Someone wrote a sloppy 3 on the lid with sharpie.\nOpen? 'y'/'n'\"");
	}
	
	public void aShelf() {
		System.out.println("You are viewing the shelf.");
		System.out.println("There are three framed photos, neatly lined up next to each other.");
		System.out.println("For a closer look at the photo on the left, type: 'Left'.");
		System.out.println("For a closer look at the photo in the middle, type: 'Middle'.");
		System.out.println("For a closer look at the photo on the right, type: 'Right'.");
		System.out.println("To stop viewing the shelf, type 'Stop'.");
		System.out.println("..and then press ENTER.");
	}
	//added items by Haine
	public void aPuddle() {
		System.out.println("Upon closer inspection, it's not much of a puddle. It just looks like someone dropped\nice cubes where you're standing, and it melted.\n");
	}
	
	public void aBlackboard() {
		System.out.println("It is a regular blackboard, about as big as the ones in classrooms.\nIt's covered in chalk profanities. Write on it? 'y'/'n'");
	}
		
		
}
