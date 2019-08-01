# project
Team Project Files

# maze4 
In the folder maze4 is a demo of a maze that has a key and a monster. The player must traverse from room (0,0) to the room 
with the key, collect the key and traverse to the room with the Door, use the key and exit the maze to win.  There are three levels.
Level 1 is the same as maze version 1, with a randomly moving monster that you can fight.   Level 2 is a 6x6 36 room maze with random item placement for map and key.
Level 3 is a 8 x 8 64 room maze with all items randomly placed in the maze including the key,door, monster and map. 

Currently to test the maze classes run the following commands <BR>

$cd maze4 <BR>
$javac *.java <BR>
$java MazeGame <BR>

In the game use the commands Enter to cycle through the rooms in the array list, <BR>

Commands:  help, map, quit, left, right, down, up, take, open, escape, fight, attack, run. <BR>

Commands are case insensitive. "Map" displays a static map of the maze. "Quit" exits the main loop and 
terminates the program. The player moves around the map using the commands "Up","Down","Left",Right" where 
motion occurs to the adjacent room provided that there is no obstruction or Wall.
"Fight" starts the fighting dialog with the maze Wraith monster. In the fight dialog you can use the command attack, fight or run.  <BR>

The program will terminate after 300 rounds of user input, if you win by exiting the final door in level 3 or if you die or quit. <BR>

The class diagram is located in /project/maze4/diagram/ both in pdf and dia formats. <BR>

# mazeGUI
This is fork of maze4 with a preliminary javafx display and control pannel implemented in javafx.  
To run these files, create a folder in eclipse, and add the jar file jfxrt.jar to the build path as a library.  
Then run the class MazeGameGUI.java as a java application.<BR>

Create a folder in eclipse and copy all of the files from /project/mazeGUI/*.java into the eclipse source folder.
Then link jfxrt.jar into the library path.  Finally Run MazeGameGUI.java.<BR>


# HaineRiddle
HAINE KIM DEMO 1 <BR>

WHERE TO FIND THE FILE: <BR>
Github --> team10summer2019 --> project --> haine (folder) <BR>

Folder contains three files. HaineRiddle.java, TestHaineRiddle.java and this README file.
Save to a directory and compile both HaineRiddle and TestHaineRiddle through command prompt/terminal. 
If using Eclipse, import both HaineRiddle.java and TestHaineRiddle.java into a default package. If not in default package, add: <BR>

package packageNameHere; at the very top/beginning of both files, and save. <BR>

Run the TestHaineRiddle.java file, and play through Eclipse console <BR>

$cd haine <BR>
$javac *.java <BR>
$java TestHaineRiddle <BR>


# RiverPuzzle

Compile files in the directory riverPuzzle directory and run using the following commands <BR>

$ cd riverPuzzle <BR>
$javac *.java <BR>
$java TestStevenRiver <BR>

# LockLeverPuzzle(plus Escape Room Implementations)

===Overview:===

Folder LockLeverPuzzle has multiple demos of the pieces that would fit together for a specialized puzzle by a class called LockLeverPuzzle. This program runs a text-based escape room styled interaction with the user.

The program is run on java through the main class.
Most classes are prompted and work with the start class.

The classes interact with each other properly and independently for the most part. 

===Bugs and Future Updates:===

LockLeverPuzzle requires review and editing to have it interacting with the user/player.

============

To run the game(Main.java file),
$cd LockLeverPuzzle 
$javac *.java 
$java Main

