//////////////////////////////////////////////
//
// File: testCharMan.java
// Description: Char Manager tester
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 12, 2019
// Version: 0.01
// Revision Date: July 12, 2019
//
///////////////////////////////////////////////

//import java.util.Random;
//import java.security.SecureRandom;

public class testCharMan{

	public static void main ( String[] args) {
		
		CharMan manager = new CharMan();  // make a CharMan object named manager
		
		/*
		manager.setRandByte();  // set 1 Random Byte	
	        manager.byte2Array(manager.getRandByte());  // convert it to binary array
		System.out.println(manager.getRandByte());   // print the random byte
		manager.printArray(manager.get8BitArray(),8);  // print the bit array representation
		manager.charToArray('C');
		System.out.println("C = " + (int)'C');
		manager.printArray(manager.get16BitArray(),16); // print the bit representation of the char C
		
		System.out.println(manager.arrayToChar( manager.get16BitArray() ) );    // reconstruct the 16 bit array, and print it's value
		
		manager.randArray16(); // load a random 16 bit array into bitArray16
		
		// print the random array
		manager.printArray(manager.get16BitArray(),16);
		
		// convert to a char and store in ch			
		char testChar;
		
		testChar=manager.arrayToChar( manager.get16BitArray() ) ;
		
		System.out.print(testChar );
	        System.out.println(" =" + (int) testChar );
	
		manager.setChar(testChar);
	
		System.out.println(manager.getChar() );    // Print the random Char stored in ch

		short shrtnum = -12467;

		manager.shortToArray(shrtnum);
		manager.printArray(manager.get16BitArray(),16); // print the bit representation of the short shrtnum 
		System.out.println(manager.arrayToShort( manager.get16BitArray() ) );    // reconstruct the 16 bit array, and print it's value
		
		
		manager.randArray16();  // set a random 16 bit array 
		System.out.println(manager.arrayToShort( manager.get16BitArray() ) );    // reconstruct the 16 bit array, and print it's value
		
		*/


		// ENCRYPTION DECRYPTION TESTING // 
		
		// Generate Key
		manager.randArray16(); // make a random array 
		manager.setKey16( manager.get16BitArray()); // copy it to the key position
		
		// Character to Encode	
		manager.charToArray('C'); // conver the letter C to an array 
		manager.setInput16( manager.get16BitArray());
		
		// Encrypt		
		manager.xor16();  // perform the XOR operation using the Key and Input
	
	        // Print The Arrays	
		manager.printArray(manager.get16BitArray(),16); // print the bit representation of the char C
		
		manager.printArray(manager.get16BitInput(),16); // print the bit representation of the Input
		manager.printArray(manager.get16BitKey(),16); // print the bit representation of the Key 
		manager.printArray(manager.get16BitOutput(),16); // print the bit representation of the Output 

		// Decryption
		manager.setInput16(manager.get16BitOutput());    // set the input to the encrypted bit stream
		
		manager.xor16(); // perform the XOR operation using the Key and Input
		
		manager.printArray(manager.get16BitOutput(),16); // print the bit representation of the Output 

		char testChar;
		
		testChar=manager.arrayToChar( manager.get16BitOutput() ) ; // convert the output array to a char

                System.out.println(testChar);  // print the output
     		
		return;
		
	}
}