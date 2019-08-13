//////////////////////////////
//
//  README.txt
//
//  Author: (Ron) Zorondras Rodriguez
//  Date: August 11, 2019
//  Version: 0.01
//  Revision Date: August 11,2019
//  Description:  Instructions for running MazeGame.java 
//                and MazeGameGUI.java in maze5 folder
//
//////////////////////////////////

To get these files use the following command line commands in linux or windows with git

$ mkdir project
$ cd project
$ git clone https://github.com/team10summer2019/project.git -b final-branch
$ cd project
$ cd maze5

In the maze5 directory are the up to date final files associated with the game engine MazeGame.java and MazeGameGUI.java 
used by team10 in the course CPSC 233 at the University of Calgary.  These files were created by (Ron) Zorondras Rodriguez and modified by the team members including Haine Kim, Steven On, Fiona Yong, and Kate Hsu.  The logic, classes, text game, and GUI game formed the backbone or game engine that was extended by the team by incorporating riddles, puzzles and other games completed by the team in earlier text based version submissions. 

To play the text based game perform the following commands:

$ javac *.java
$ java MazeGame

Read the instructions and press ENTER. If you need to see the commands type "help"

MazeGame is a 3 level dungeon maze with a monster, a key, and map, and a door.  The player must traverse from the starting location using the commands up,down,left,right, find the key and obtain it using the command "take", and then traverse to the door open it with the command "open" and then escape the level with the command "escape".  You must defeate the level maze wraith monster to escape. To do so you must find and consume food using the command "take", to increase your health points and fight the monster using the command "fight", "attack" or "run".  If you die, go over 1000 turns, or type "quit", the game terminates.  Traverse all three levels to win the game.

To play MazeGameGUI, you must import the file project "/maze5/GUI/MazeGameGUI.java" along with all of the files in the folder "project/maze5/" into eclipse and copy the folder "project/images" and all it's files into a package in the src directory. You will also need to copy the jar file jfxrt.jar and link it as a library, using "build path" -> "configure build path" -> "Libraries" ->"add jar file". To run the file right click on the file MazeGameGUI.java, and select "Run As" -> Java Application.   The commands in the GUI version are the same as the text based version however several key controls for motion and operations have been added.  Traverse with a,s,d,w , q to quit, t for take, f to fight, o to open the door, and e to escape.

To examine the Class Diagram, go into the folder "/project/maze5/diagram/" and open the file MazeGame5_all.pdf.  
The dia file with the UML class descriptions is also provided in this folder. 

For bug reports and further assistance contact Ron Rodriguez using the email zarodrig@ucalgary.ca 

