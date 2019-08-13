package finalMaze;




 
import java.util.ArrayList;
import java.util.Random;
  

public class CreateRiddle extends PlayRiddle{

	private String answer;
	private String riddle;
	private ArrayList<CreateRiddle> riddles = new ArrayList<CreateRiddle>();
	
	//CONSTRUCTORS
	
	public CreateRiddle() {}
	
	public CreateRiddle(CreateRiddle toCopy) {
		this.answer = toCopy.answer;
		this.riddle = toCopy.riddle;
	}
	
	public CreateRiddle(String answer, String riddle) {
		this.answer = answer;
		this.riddle = riddle;
	}
	
	//GETTERS
	
	public String getAnswer() {
		return this.answer;
	}
	
	public String getRiddle() {
		return this.riddle;
	}
	
	public ArrayList<CreateRiddle> getListRiddles() {
		return this.riddles;
	}
	
	// SETTER
	
	public void addRiddles(CreateRiddle r) {
		riddles.add( new CreateRiddle(r));
	}
	
	//OTHER
	
	public CreateRiddle chooseRiddle() {		//CHOOSES A RANDOM RIDDLE HERE
		Random chooser = new Random();
		int nextChooser = chooser.nextInt(riddles.size());	//RETURNS A RIDDLE
		return riddles.get(nextChooser);
	}
	

	
	
}
