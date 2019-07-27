package maze2;

public class TestHaineRiddle { 
	 
	public boolean notHamRid(){
		
		///MAKE A LOT OF RIDDLES
		CreateRiddle runner = new CreateRiddle();
		CreateRiddle riddle1 = new CreateRiddle("HUMAN" ,"What is the creature that walks on four legs in the morning,\ntwo legs at noon, and three in the evening?\n");
		CreateRiddle riddle2 = new CreateRiddle("PENNY", "What has a head, a tail, is brown, and has no legs?\n");
		CreateRiddle riddle4 = new CreateRiddle("BLACKBOARD","I get whiter the dirtier I get. What am I?\n");
		CreateRiddle riddle5 = new CreateRiddle("ICE","Made from water, but dies in water. What am I?\n");
		runner.addRiddles(riddle1);
		runner.addRiddles(riddle2);
		runner.addRiddles(riddle4);
		runner.addRiddles(riddle5);
		
		CreateRiddle theRiddle = runner.chooseRiddle();
		runner.addAnswer(theRiddle);
		runner.sayRiddle(theRiddle);
		 
		runner.instructions();
		runner.getInput();
		
		boolean solved = runner.checkAnswer();
		return solved;
		
	}
	
}
