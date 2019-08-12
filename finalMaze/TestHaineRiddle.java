package finalMaze;




public class TestHaineRiddle { 
	 
	public CreateRiddle riddleOne(){
		///MAKE A LOT OF RIDDLES 
		CreateRiddle theRiddle = new CreateRiddle();
		CreateRiddle riddle1 = new CreateRiddle("HUMAN" ,"What is the creature that walks on four legs in the morning,\ntwo legs at noon, and three in the evening?\n");
		CreateRiddle riddle2 = new CreateRiddle("PENNY", "What has a head, a tail, is brown, and has no legs?\n");
		CreateRiddle riddle3 = new CreateRiddle("BLACKBOARD","I get whiter the dirtier I get. What am I?\n");
		CreateRiddle riddle4 = new CreateRiddle("ICE","Made from water, but dies in water. What am I?\n");
		theRiddle.addRiddles(riddle1);
		theRiddle.addRiddles(riddle2);
		theRiddle.addRiddles(riddle3);
		theRiddle.addRiddles(riddle4);
		
		CreateRiddle returnRiddle = theRiddle.chooseRiddle();
		
		return returnRiddle;
		 
	} 
	
	public CreateRiddle riddleTwo(){
		///MAKE A LOT OF RIDDLES
		CreateRiddle theRiddle = new CreateRiddle();
		CreateRiddle riddle5 = new CreateRiddle("OWL" ,"I always ask but never answer. Who am I?\n");
		CreateRiddle riddle6 = new CreateRiddle("EGG", "You can only eat me after you break me. What am I?\n");
		CreateRiddle riddle7 = new CreateRiddle("BREATH","What can you hold without using your hands or arms?\n");
		theRiddle.addRiddles(riddle5);
		theRiddle.addRiddles(riddle6);
		theRiddle.addRiddles(riddle7);
		
		CreateRiddle returnRiddle = theRiddle.chooseRiddle();
	
		return returnRiddle;
		
	} 
	
	public CreateRiddle riddleThree(){
		///MAKE A LOT OF RIDDLES
		CreateRiddle theRiddle = new CreateRiddle();
		CreateRiddle riddle8 = new CreateRiddle("FLEAS" ,"When they are caught, they are thrown away. When they escape, you itch all day. What are they?\n");
		CreateRiddle riddle9 = new CreateRiddle("G", "What always ends everything?\n");
		CreateRiddle riddle10 = new CreateRiddle("KEYBOARD","I have keys, but no locks. I have a space, but no room.\nYou can enter but you can't go outside. What am I?\n");
		CreateRiddle riddle11 = new CreateRiddle("TOWEL","What gets wet when drying?");
		theRiddle.addRiddles(riddle8);
		theRiddle.addRiddles(riddle9);
		theRiddle.addRiddles(riddle10);
		theRiddle.addRiddles(riddle11);
		
		CreateRiddle returnRiddle = theRiddle.chooseRiddle();
	
		return returnRiddle;
		
	}
	
}
