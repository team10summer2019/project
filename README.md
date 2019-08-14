# project
Team Project Files <BR>

These files may be found at https://github.com/team10summer2019/project.git <BR>

The final working version of our project may be checked out by cloning the final-branch branch of the repository.  Clone the directory with the following commands: <<BR>

$git clone https://github.com/team10summer2019/project.git -b final-branch  <BR>

This will create a directory named "project" which contains the java classes, images and class diagrams created during the production of the game "The Maze".  <BR>

#FinalGUI 
FinalGUI is the final production from team 10, and is a GUI application that must be run in eclipse.   The files for this game are found in "project/FinalGUI".
The main class that starts the game is "MazeGameGUI.java" and is found in the folder "project/FinalGUI". <BR>

This game consists of a player trapped in a three level Maze, with the goal of escaping the maze the player must traverse through different rooms by solving puzzles. 
The puzzles consist of Riddles, and games.  The player must find a map, a key, open a door and escape to the next level.  To do so other objects must be picked up and puzzles solved.<BR>

To run this game open Eclipse, and create a new project. Copy all the *.java files into the src folder. 
The main class which will be run as a java application is the file MazeGameGUI.java.  You will require javafx to run this class.  
Add the jar file jfxrt.jar to the build path as a library. Then run the class MazeGameGUI.java as a java application.<BR>

Create a folder in eclipse and copy all of the files from /project/FinalMaze/*.java  along with /project/FinalMaze/MazeGameGUI.java 
into the eclipse source folder. Also copy the directory /project/images/ into a package named "images" in the eclipse project. <BR> 

Then link jfxrt.jar into the library path.  Finally Run MazeGameGUI.java. as a java application in eclipse. <BR>

#FinalText
Final text is a version of the text based game corresponding to the game in FinalGUI.<BR>

To run these files create a new project in eclipse, and make a new package named "FinalText".  Copy all of the files from the folder /project/FinalText into this package. <BR>
Finally to run the game the main class is MazeGame.java.  Right click on this file and select Run As -> Java Application. This should start a console application version of the game.<BR> 

#JUnitTests

In the Folder /project/JUnitTests/ , are FloorInventoryTest_JUnit.java  InventoryTest_JUnit.java  LockLeverTest_JUnit.java and PointTest.java. Add these files to a folder
in the eclipse project created for FinalGUI and FinalText, nameing this folder JUnitTests.   Link JUnit to the library, by right clicking on the eclipse project folder and clicking the following:<BR>

Build Path -> Configure Build Path -> Add Library  -> Junit -> JUnit5 -> Finish -> Apply and Close.<BR>

To run the tests right click on them and select Run As -> Junit Test. <BR> 

The test should run with no errors.  <BR>

# maze5
This folder contains the preliminary game engine classes used by our team to create the final product FinalGUI. <BR>

In the folder maze5 is a demo of a maze that has a key, a map, and a monster. The player must traverse from room (0,0) to the room 
with the key, collect the key and traverse to the room with the Door, use the key and exit the maze to win.  There are three levels.
Level 1 is the same as maze version 1, with a randomly moving monster that you can fight.   Level 2 is a 6x6 36 room maze with random item placement for map and key.
Level 3 is a 8 x 8 64 room maze with all items randomly placed in the maze including the key,door, monster and map. <BR>

Currently to test the maze classes run the following commands <BR>

$cd maze5 <BR>
$javac *.java <BR>
$java MazeGame <BR>

In the game use the commands + Enter to move through the rooms in the maze, <BR>

Commands:  help, map, quit, left, right, down, up, take, open, escape, fight, attack, run. <BR>

Commands are case insensitive. "Map" displays a static map of the maze. "Quit" exits the main loop and 
terminates the program. The player moves around the map using the commands "Up","Down","Left",Right" where 
motion occurs to the adjacent room provided that there is no obstruction or Wall.
"Fight" starts the fighting dialog with the maze Wraith monster. In the fight dialog you can use the command attack, fight or run.  <BR>

The program will terminate after 1000 rounds of user input, if you win by exiting the final door in level 3 or if you die or quit. <BR>

The class diagram is located in /project/maze5/diagram/ both in pdf and dia formats. <BR>

# maze5GUI
This is a GUI frontend to display and control the maze and player commands from MazeGame.java implemented in javafx.  
To run these files, create a folder in eclipse, and copy all the .java files into the src folder. 
Retrive the GUI class from /project/maze5/GUI/MazeGameGUI.java. Add this file into the eclipse folder.  This is the main class that plays the GUI game. 
Add the jar file jfxrt.jar to the build path as a library. Then run the class MazeGameGUI.java as a java application.<BR>

Create a folder in eclipse and copy all of the files from /project/maze5/*.java  along with /project/maze5/GUI/MazeGameGUI.java 
into the eclipse source folder. Also copy the directory /project/maze5/images/ into a package images in eclipse. <BR> 

Then link jfxrt.jar into the library path.  Finally Run MazeGameGUI.java. as a java application in eclipse. <BR>


# LockLeverPuzzle
Locker Lever Puzzle is a preliminary text based version of the escape room.<BR> 

===Overview:===
Folder LockLeverPuzzle has multiple demos of the pieces that would be intended to fit together for a specialized puzzle by a class called LockLeverPuzzle. 
This program runs a text-based escape room styled interaction with the user. <BR>

The program is run on java through the main class.
Most classes are prompted and work with the start class.<BR>

The classes interact with each other properly and independently for the most part. 
Inventory is passed through all the Rooms(superclass and subclass: GenericRoom, Haine1Room, Haine2Room, Room3, Room4).<BR>

===Permissions=== <BR>
Classes: 

StaticObjects,DynamicObjects,and Start 
are permitted to be used as long as permission is granted and updates are verified for fair use of personal work. <BR>

===File Information========= <BR>

To run the game(Main.java file),<BR>

$cd LockLeverPuzzle <BR>
$javac *.java  <BR>
$java Main <BR>
