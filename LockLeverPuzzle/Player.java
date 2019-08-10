import java.util.ArrayList;

/**
 * @author Fiona
 *
 * Version updated: August 8, 2019
 */
public class Player {
	private ArrayList<String> playerInventory;
	//METHODS
	//view objects(auto pick up if important)
	//combine items
	//user input for interaction
	public Player() {
		playerInventory = new ArrayList<String>();
	}
	public Player(Inventory toCopy) {
		setPlayerInventory(toCopy.getInventory());
	}
	public ArrayList<String> getPlayerInventory() {
		return playerInventory;
	}
	
	public void setPlayerInventory(ArrayList<String> playerInventory) {
		this.playerInventory = playerInventory;
	}
}
