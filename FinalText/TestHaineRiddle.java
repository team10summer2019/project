package FinalText;

public class TestHaineRiddle { 
	 
	public boolean riddleOne(){ 
		///MAKE A LOT OF RIDDLES 
		CreateRiddle runner = new CreateRiddle();
		CreateRiddle riddle1 = new CreateRiddle("HUMAN" ,"What is the creature that walks on four legs in the morning,\ntwo legs at noon, and three in the evening?\n");
		CreateRiddle riddle2 = new CreateRiddle("PENNY", "What has a head, a tail, is brown, and has no legs?\n");
		CreateRiddle riddle3 = new CreateRiddle("BLACKBOARD","I get whiter the dirtier I get. What am I?\n");
		CreateRiddle riddle4 = new CreateRiddle("ICE","Made from water, but dies in water. What am I?\n");
		runner.addRiddles(riddle1);
		runner.addRiddles(riddle2);
		runner.addRiddles(riddle3);
		runner.addRiddles(riddle4);
		
		CreateRiddle theRiddle = runner.chooseRiddle();
		runner.addAnswer(theRiddle);
		runner.sayRiddle(theRiddle);
		 
		runner.instructions();
		runner.getInput();
		
		boolean solved = runner.checkAnswer();
		return solved;
		
	}
	
	public boolean riddleTwo(){
		///MAKE A LOT OF RIDDLES
		CreateRiddle runner = new CreateRiddle();
		CreateRiddle riddle5 = new CreateRiddle("OWL" ,"I always ask but never answer. What do you think I am?\n");
		CreateRiddle riddle6 = new CreateRiddle("EGG", "You can only use me after you break me. What am I?\n");
		CreateRiddle riddle7 = new CreateRiddle("BREATH","What can you hold without using your hands or arms?\n");
		runner.addRiddles(riddle5);
		runner.addRiddles(riddle6);
		runner.addRiddles(riddle7);
		
		CreateRiddle theRiddle = runner.chooseRiddle();
		runner.addAnswer(theRiddle);
		runner.sayRiddle(theRiddle);
		 
		runner.instructions();
		runner.getInput();
		
		boolean solved = runner.checkAnswer();
		return solved;
		
	}
	
	public boolean riddleThree(){
		///MAKE A LOT OF RIDDLES
		CreateRiddle runner = new CreateRiddle();
		CreateRiddle riddle8 = new CreateRiddle("FLEAS" ,"When they are caught, they are thrown away. When they escape, you itch all day. What are they?\n");
		CreateRiddle riddle9 = new CreateRiddle("G", "What always ends everything?\n");
		CreateRiddle riddle10 = new CreateRiddle("KEYBOARD","I have keys, but no locks. I have a space, but no room.\nYou can enter but you can't go outside. What am I?\n");
		CreateRiddle riddle11 = new CreateRiddle("TOWEL","What gets wet when drying?");
		runner.addRiddles(riddle8);
		runner.addRiddles(riddle9);
		runner.addRiddles(riddle10);
		runner.addRiddles(riddle11);
		
		CreateRiddle theRiddle = runner.chooseRiddle();
		runner.addAnswer(theRiddle);
		runner.sayRiddle(theRiddle);
		 
		runner.instructions();
		runner.getInput();
		
		boolean solved = runner.checkAnswer();
		return solved;
		
	}
	
}
