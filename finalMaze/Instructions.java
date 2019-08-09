package finalMaze;

public class Instructions {

	public String hintInstructions() {
		return "\nThere is a room(1H) with a bunch of objects, time to visit the room. " + "Type 'Look' to begin and 'Exit'";
	}
	
	public String room1Instructions() {
		return ("In the centre of the room, you can see a teddy bear on the floor holding something. There is a blackboard on one wall. Next to that wall, there is a shelf with three photos displayed.")
				+(" Looking down at the ground, you realize you have stepped into a shallow puddle.\n")
				+("To view certain things, type:\n'Bear'\n'Blackboard'\n'Shelf'\n'Puddle'\n")
				+("To stop looking around the room, type 'return' or press the R key.");
	}
	
	public String bearInstructionsNoLever() {
		return ("The fluffy teddy bear is holding something. It is a metal rod \n")
		+("with an end that has grooves on it like a screw. The other end looks like it should attach to a hinge mechanism.")
		+(" You take the metal piece. It looks like it could be useful.");
	}
	
	public String bearInstructionsYesLever() {
		return ("A very cute, fluffy teddy bear.");
	}
	
	public String shelfInstructions() {
		return ("You are viewing the shelf.")
		+(" There are three framed photos, neatly lined up next to each other.")
		+("\nIn the left photo, A baby smiles at the camera. It looks like it's having the time of it's life on all fours.")
		+(" The centre photo shows a young man in a graduation gown. He stands victoriously on stage.")
		+(" On the right there is a picture perfect family photo. The elderly man in the middle leans heavily on his cane, as if it were a third leg helping him stand.")
		+("\nTo stop looking around the room, type 'return' or press the R key.")
		+("\nTo look at the other items, type 'look' or press the L key.");
	}
	
	public String puddleInstructions() {
		return ("Upon closer inspection, it's not much of a puddle. It just looks like someone dropped\nice cubes where you're standing, and it melted.\n")
		+("\nTo stop looking around the room, type 'return' or press the R key.")
		+("\nTo look at the other items, type 'look' or press the L key.");
	}
	
	public String blackboardInstructions() {
		return ("It is a regular blackboard, about as big as the ones in classrooms.")
		+("\nIt's covered in chalk profanities. There is no chalk to write with.")
		+("\nWhere the chalk and eraser should be, there are a handful of pennies.")
		+("\nTo stop looking around the room, type 'return' or press the R key.")
		+("\nTo look at the other items, type 'look' or press the L key.");
	}
	
}
