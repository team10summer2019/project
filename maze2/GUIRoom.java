package maze2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//4x8 button, same as Ron's grid for room


public class GUIRoom extends Application {
	//private Maze maze = new Maze();
	private Room room = new Room();
	//testing: private Room room = new Room(0,0, true, false, true, true);
	
	public HBox topWall() {
		//set button for top wall if room have top wall
		HBox t = new HBox();
		Button h00 = new Button("-");
		Button h01 = new Button("-");
		Button h02 = new Button("-");
		Button h03 = new Button("-");
		Button h04 = new Button("-");
		Button h05 = new Button("-");
		Button h06 = new Button("-");
		Button h07 = new Button("-");
		
		t.getChildren().add(h00);
		t.getChildren().add(h01);
		t.getChildren().add(h02);
		t.getChildren().add(h03);
		t.getChildren().add(h04);
		t.getChildren().add(h05);
		t.getChildren().add(h06);
		t.getChildren().add(h07);
		return t;
	}
	
	public HBox BottomWall() {
		//set button for bottom wall if room have bottom wall
		HBox b = new HBox(); 
		Button h30 = new Button("-");
		Button h31 = new Button("-");
		Button h32 = new Button("-");
		Button h33 = new Button("-");
		Button h34 = new Button("-");
		Button h35 = new Button("-");
		Button h36 = new Button("-");
		Button h37 = new Button("-");
		
		b.getChildren().add(h30);
		b.getChildren().add(h31);
		b.getChildren().add(h32);
		b.getChildren().add(h33);
		b.getChildren().add(h34);
		b.getChildren().add(h35);
		b.getChildren().add(h36);
		b.getChildren().add(h37);
		return b;
	}
	
	public HBox noTopOrBottomWall() {
		////set button for top / bottom wall if room doesn't have top/bottom wall
		HBox tb = new HBox(); 
		Button h0 = new Button(" ");
		Button h1 = new Button(" ");
		Button h2 = new Button(" ");
		Button h3 = new Button(" ");
		Button h4 = new Button(" ");
		Button h5 = new Button(" ");
		Button h6 = new Button(" ");
		Button h7 = new Button(" ");
		
		tb.getChildren().add(h0);
		tb.getChildren().add(h1);
		tb.getChildren().add(h2);
		tb.getChildren().add(h3);
		tb.getChildren().add(h4);
		tb.getChildren().add(h5);
		tb.getChildren().add(h6);
		tb.getChildren().add(h7);
		return tb;
	}
	
	public HBox leftWall1() {
		//set first left side wall if room have left wall
		HBox lw1 = new HBox();
		Button h10 = new Button("|  "); //left wall
		Button h11 = new Button(" ");
		Button h12 = new Button(" ");
		Button h13 = new Button(" ");
		Button h14 = new Button(" ");
		Button h15 = new Button(" ");
		Button h16 = new Button(" ");
		Button h17 = new Button(" "); // no right wall
		
		lw1.getChildren().add(h10);
		lw1.getChildren().add(h11);
		lw1.getChildren().add(h12);
		lw1.getChildren().add(h13);
		lw1.getChildren().add(h14);
		lw1.getChildren().add(h15);
		lw1.getChildren().add(h16);
		lw1.getChildren().add(h17);
		return lw1;
	}
	
	public HBox leftWall2() {
		//set second wall for left side if room have left wall
		HBox lw2 = new HBox();
		Button h20 = new Button("|  "); //left wall
		Button h21 = new Button(" ");
		Button h22 = new Button(" ");
		Button h23 = new Button(" ");
		Button h24 = new Button(" ");
		Button h25 = new Button(" ");
		Button h26 = new Button(" ");
		Button h27 = new Button(" "); // no right wall
		
		lw2.getChildren().add(h20);
		lw2.getChildren().add(h21);
		lw2.getChildren().add(h22);
		lw2.getChildren().add(h23);
		lw2.getChildren().add(h24);
		lw2.getChildren().add(h25);
		lw2.getChildren().add(h26);
		lw2.getChildren().add(h27);
		return lw2;
	}
	
	public HBox rightWall1() {
		//set first right side wall if room have right wall
		HBox rw1 = new HBox();
		Button h10 = new Button(" "); 
		Button h11 = new Button(" ");
		Button h12 = new Button(" ");
		Button h13 = new Button(" ");
		Button h14 = new Button(" ");
		Button h15 = new Button(" ");
		Button h16 = new Button(" ");
		Button h17 = new Button("  |"); //right wall
		
		rw1.getChildren().add(h10);
		rw1.getChildren().add(h11);
		rw1.getChildren().add(h12);
		rw1.getChildren().add(h13);
		rw1.getChildren().add(h14);
		rw1.getChildren().add(h15);
		rw1.getChildren().add(h16);
		rw1.getChildren().add(h17);
		return rw1;
	}
	
	public HBox rightWall2() {
		//set second right side wall if room have right wall
		HBox rw2 = new HBox();
		Button h20 = new Button(""); //left wall
		Button h21 = new Button("");
		Button h22 = new Button("");
		Button h23 = new Button("");
		Button h24 = new Button("");
		Button h25 = new Button("");
		Button h26 = new Button("");
		Button h27 = new Button("  |"); // no right wall
		
		rw2.getChildren().add(h20);
		rw2.getChildren().add(h21);
		rw2.getChildren().add(h22);
		rw2.getChildren().add(h23);
		rw2.getChildren().add(h24);
		rw2.getChildren().add(h25);
		rw2.getChildren().add(h26);
		rw2.getChildren().add(h27);
		return rw2;
	}
	
	public HBox LeftandRightWall1() {
		//set button for room if room have both left and right wall
		HBox w1 = new HBox();
		Button h10 = new Button("|  "); 
		Button h11 = new Button(" ");
		Button h12 = new Button(" ");
		Button h13 = new Button(" ");
		Button h14 = new Button(" ");
		Button h15 = new Button(" ");
		Button h16 = new Button(" ");
		Button h17 = new Button("  |");
		
		w1.getChildren().add(h10);
		w1.getChildren().add(h11);
		w1.getChildren().add(h12);
		w1.getChildren().add(h13);
		w1.getChildren().add(h14);
		w1.getChildren().add(h15);
		w1.getChildren().add(h16);
		w1.getChildren().add(h17);
		return w1;
	}
	
	public HBox LeftandRightWall2() {
		//set button for room if room have both left and right wall (second wall)
		HBox w2 = new HBox();
		Button h20 = new Button("|"); 
		Button h21 = new Button(" ");
		Button h22 = new Button(" ");
		Button h23 = new Button(" ");
		Button h24 = new Button(" ");
		Button h25 = new Button(" ");
		Button h26 = new Button(" ");
		Button h27 = new Button("|");
		
		w2.getChildren().add(h20);
		w2.getChildren().add(h21);
		w2.getChildren().add(h22);
		w2.getChildren().add(h23);
		w2.getChildren().add(h24);
		w2.getChildren().add(h25);
		w2.getChildren().add(h26);
		w2.getChildren().add(h27);
		return w2;
	}
	
	

	public void start (Stage primaryStage) {
		VBox root = new VBox();
		
		if (room.getTopWall() == false) {
			HBox tb = noTopOrBottomWall();
			HBox w1 = LeftandRightWall1();
			HBox w2 = LeftandRightWall2();
			HBox b = BottomWall();
			root.getChildren().add(tb);
			root.getChildren().add(w1);
			root.getChildren().add(w2);
			root.getChildren().add(b);
		} else if (room.getBottomWall()==false) {
			HBox t = topWall();
			HBox w1 = LeftandRightWall1();
			HBox w2 = LeftandRightWall2();
			HBox tb = noTopOrBottomWall();
			root.getChildren().add(t);
			root.getChildren().add(w1);
			root.getChildren().add(w2);
			root.getChildren().add(tb);
			
		} else if (room.getLeftWall() == false) {
			HBox t = topWall();
			HBox rw1 = rightWall1();
			HBox rw2 = rightWall2();
			HBox b = BottomWall();
			root.getChildren().add(t);
			root.getChildren().add(rw1);
			root.getChildren().add(rw2);
			root.getChildren().add(b);
		} else if (room.getRightWall() == false) {
			HBox t = topWall();
			HBox lw1 = leftWall1();
			HBox lw2 = leftWall2();
			HBox b = BottomWall();
			root.getChildren().add(t);
			root.getChildren().add(lw1);
			root.getChildren().add(lw2);
			root.getChildren().add(b);
		} 
		

		Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
