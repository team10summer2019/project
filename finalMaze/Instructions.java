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
	
	public String room2Instructions() {
		return ("For whatever reason, you hold your breath when you approach this room. You let go of your breath and choose to look around anyways.")
				+("This room looks tidier than the other room. Mostly because this room only has three boxes.")
				+("A red box, a yellow box, and a green box all placed nicely side by side.")
				+("You feel content seeing a room so colourful and organized.\n")
				+("To view certain things, type:\n'Redbox'\n'YellowBox'\n'Greenbox'\n")
				+("To stop looking around the room, type 'return' or press the R key.");
	}
	
	public String greenBoxInstructionsNoLever() {
		return ("Is this someone's toy chest? It's full of children's knick knacks. One of them, a stuffed owl with comically large eyes looks back at you.\n")
		+("You pick up the silly owl. There's a rubber egg underneath. You put the owl back down. Looking up, you see a poorly scribbled 8 under the lid.\n")
		+("You find another metal rod, but this one is hollow on one end and has a red round knob on the other side.")
		+("It almost looks like a toy lollipop. There are grooves inside the hollow end of the rod that looks like if fits with the first rod.");
	}
	
	public String greenBoxInstructionsYesLever() {
		return ("There is a silly owl on top of a rubber egg in the greenbox.");
	}
	
	public String redBoxInstructions() {
		return ("A black seven of spades playing card.");
	}
	
	public String yellowBoxInstructions() {
		return ("You unfold the note. It is a torn page from a nursery book. The note reads:\n")
		+("__________________\n")
		+("|'One,Two'         |\n")
		+("|'Tie your Shoe.' |\n")
		+("|_________________|\n")
		+("The 'Two' has been circled in crayon. There is a picture of a green shoe right below the nursery rhyme.");
	}
	
	public String comboInstructions() {
		return ("There is a hole in one wall. It feels like some sort of mechanism was once in there...\n")
				+ ("In the middle of the room, there is  a combination lock- similar to a padlock. From left to right, you can put in three numbers between 0 and 9. ")
				+ ("Input all three numbers into the combination.");		
	}
	
	public String unlockWithLevers() {
		return ("Something in the wall clicks...\n")
				+("You put together the two metal rods. It combines into a trusty lever.\n")
				+("You stick the lever into the hole in the wall, and it fits perfectly.\n")
				+("The wall vanishes once you pull the lever. You see a door far in the distance...");
	}
}
