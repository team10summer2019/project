# project
Team Project Files

# maze 
In the folder maze is a demo of a maze that has a key.  It is currently incomplete.   The player must traverse from room (0,0) to the room 
with the key, collect the key and traverse to the room with the Door, use the key and exit the maze to win.

currently to test the maze classes run the following commands <BR>

$cd maze <BR>
$javac *.java <BR>
$java MazeGame <BR>


In the game use the commands Enter to cycle through the rooms in the array list, <BR>

Commands:  help, map, quit, left, right, down, up, take, open, escape. <BR>

Commands are case insensitive. "Map" displays a static map of the maze. "Quit" exits the main loop and 
terminates the program. The player moves around the map using the commands "Up","Down","Left",Right" where 
motion occurs to the adjacent room provided that there is no obstruction or Wall.  <BR>

The program will terminate after 100 rounds of user input. <BR>

The class diagram is located in maze/diagram/ both in pdf and dia formats. <BR>


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

# EscapeRoom-LockLeverPuzzle

===Overview:===

Folder LockLeverPuzzle has multiple demos of the pieces that would fit together for a specialized puzzle by a class called LockLeverPuzzle.

The program is run on java through the main class.
Most classes are prompted and work with the start class.

The classes interact with each other properly and independently for the most part. 

===Bugs:===

More work will be needed to adjust inventory pick up as well as remove items when already picked up.
Parent Inventory and child DynamicObjects still require some review and processing with interactions with the user/player itself. 
////////////

To run the game(Main.java file),
$cd LockLeverPuzzle 
$javac *.java 
$java Main

