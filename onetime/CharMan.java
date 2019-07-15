//////////////////////////////////////////////
//
// File: CharMan.java
// Description: Char Manager
//
// Author: (Ron) Zorondras Rodriguez
// Course:  CPSC 233 Summer 2019
// Creation Date: July 12, 2019
// Version: 0.04
// Revision Date: July 13, 2019
//
///////////////////////////////////////////////

import java.util.Random;
import java.security.SecureRandom;

public class CharMan{

/////////////// PRIVATE MEMBER VARIABLES //////////////////////////////////////
	private String keyString;   // string to store the key
	private byte randByte;   // 1 byte for each byte of random 
	private char ch ;   // 16bit 2byte character variable  
	

	private SecureRandom random = new SecureRandom();  // secure random number generator object called random

 	private byte bytes[] = new byte[16];   // 16 byte array for random which places random numbers in this array 


	///////////  8 Bit Arrays ////////////////////////////////
	private int bitKey8[] = new int[8] ; // 8 bit array to store byte in binary representation
	private int bitInput8[] = new int[8] ; // 8 bit array to store byte in binary representation
	private int bitOutput8[] = new int[8] ; // 8 bit array to store byte in binary representation
	private int bitArray8[] = new int[8];  // temporary 8 bit array
	/////////// 16 Bit Arrays ////////////////////////////////
	private int bitKey16[] = new int[16] ; // 16 bit array to store byte in binary representation
	private int bitInput16[] = new int[16] ; // 16 bit array to store byte in binary representation
	private int bitOutput16[] = new int[16] ; // 16 bit array to store byte in binary representation
	private int bitArray16[] = new int[16];  // temporary 16 bit array
	
	
///////////////// Default Constructor /////////////////////////////////////////////

	CharMan(){
	keyString=null;
	random.nextBytes(bytes); // generate some random bytes stored int *bytes
	randByte= bytes[1]; // store a random byte into RandByte
	ch='\0';  // null terminator is input char
	}

///////////////// PUBLIC MEMBER FUNCTIONS ////////////////////////////////////////


///////////////// Accessor Member Functions //////////////////////////////////////

	public byte getRandByte(){
		return randByte;
	}
	
	public char getChar(){
		return ch;
	}
	
	////////////////////// 8 - bit getters ///////////////////////////////////////////////
	public int[] get8BitArray(){
		return copyArray(bitArray8,8);  // return the pointer to a copy of the bitArray  
	}
	
	public int[] get8BitKey(){
		return copyArray(bitKey8,8);  // return the pointer to a copy of the bitKey array 
	}
	
	public int[] get8BitInput(){
		return copyArray(bitInput8,8);  // return the pointer to a copy of the bitInput array 
	}
	
	public int[] get8BitOutput(){
		return copyArray(bitOutput8,8);  // return the pointer to a copy of the bitOutput array 
	}
	
	
	//////////////////////// 16-bit getters ///////////////////////////////////////////////
	public int[] get16BitArray(){
		return copyArray(bitArray16,16);  // return the pointer to a copy of the bitArray  
	}
	
	public int[] get16BitKey(){
		return copyArray(bitKey16,16);  // return the pointer to a copy of the bitKey array 
	}
	
	public int[] get16BitInput(){
		return copyArray(bitInput16,16);  // return the pointer to a copy of the bitInput array 
	}
	
	public int[] get16BitOutput(){
		return copyArray(bitOutput16,16);  // return the pointer to a copy of the bitOutput array 
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
		
		
//////////////////  Accessor Print Values ////////////////////////////////////////
	public void printArray(int[] Array, int size){

	System.out.print( "\n[ " );

		for (int k=0; k< size-1 ; k++){
		System.out.print( Array[k] ); 
		System.out.print(", ");
		}
	
	System.out.print( Array[size-1]);
	System.out.println(" ]");
	
	}

/////////////////  Mutator Member Functions //////////////////////////////////////////////
	public void setRandByte(){
	random.nextBytes(bytes);
	int index=0;
	
	byte num = bytes[0];  // get the first random byte
	
	if (num < 0){
	index = (int)(-1*num);  // grab a positive integer version of the first byte stored
	} else {
	
	index = (int)(num);
	}
	
	index = (index %16);   // take the first byte and mod by 16 to get the position of the random byte to store

	randByte= bytes[index]; // store a random byte 
	return;
	}

        // copy a bit array for safety return in accessors
	public int[] copyArray( int[] inArray, int size){
	int[] outArray = new int[size];
		for (int k=0; k< size; k++) {
		outArray[k]=inArray[k];
		}
	return outArray;
	
	}

       
       public void setChar( char chIn){
       ch=chIn;
       return;
       }
       
       
///////////////////////////////// ARRAY SETTERS ////////////////////////////////////////////////////

	
	//////////////////////////// 16-bit ////////////////////////////////////////////////////
	public void setBit16(int[] arrayIn){
	bitArray16=copyArray(arrayIn,16);  // return the pointer to a copy of the bitKey array
	return;
	}       
       
       	public void setKey16(int[] arrayIn){
	bitKey16=copyArray(arrayIn,16);  // return the pointer to a copy of the bitKey array
	return;
	}    
	
	public void setInput16(int[] arrayIn){
	bitInput16=copyArray(arrayIn,16);  // return the pointer to a copy of the bitKey array
	return;
	}        
	
	//////////////////////////// 8-bit /////////////////////////////////////////////////
	public void setBit8(int[] arrayIn){
	bitArray8=copyArray(arrayIn,8);  // return the pointer to a copy of the bitKey array
	return;
	}       
       
       	public void setKey8(int[] arrayIn){
	bitKey8=copyArray(arrayIn,8);  // return the pointer to a copy of the bitKey array
	return;
	}    
	
	public void setInput8(int[] arrayIn){
	bitInput8=copyArray(arrayIn,8);  // return the pointer to a copy of the bitKey array
	return;
	}        
       
       
/////////////////////////////// OPERATIONS ////////////////////////////////////////////////////////

    // take a byte and convert to 8-bit binary array  
	public void byte2Array( byte ByteIn){     

	byte num = ByteIn;  // copy the input to a local 
	
	// clear bitArray
		for (int k=0; k< 8 ; k++){
		bitArray8[k]=0;
		}

	// Set the Sign bit	
		if (num < 0){     
		bitArray8[0]=1;	 // store the sign
		num = (byte)(-1* num ); // switch input to positive 7 bit integer number 
		}
	
	// convert to binary by division and store in array 
	// read MSB on left side little endian
		for (int k=7; k> 0; k--){
		bitArray8[k]=num % 2 ;  // remainder after division by 2 
		num /=2;  // integer division by 2
		}
	}


        // convert 2byte char to a binary array
	public void charToArray(char CharIn ){   // take a byte and convert to 8-bit binary array    

	int num = (int) CharIn;  // copy the input char to a integer variable  
	
	// clear 16bitArray temp Array
		for (int k=0; k< 16 ; k++){
		bitArray16[k]=0;
		}
	
	// convert to binary by division and store in array 
	// read MSB on left side little endian
		for (int k=15; k>= 0; k--){
		bitArray16[k]=num % 2 ;  // remainder after division by 2 
		num /=2;  // integer division by 2
		}
	}

        // REQUIRES: 16 bit array of ints 0,1 
	// PROMISES: return a char with the correct char value representing the 16 bit array
	public char arrayToChar( int[] arrayIn) {
	
	char chret;
	int num=0 ;
	int coef;
	int power;
	int factor; 
	
	// loop over the 16 bit array 
               for (int k=0; k<16 ; k++){
		coef = arrayIn[k];
		
		power = 15-k;
		factor=1;
	        // generate the power of 2 
			for ( int j=0 ; j < power ; j++){
			factor*=2;
			} 
		// add the product of the power of 2 times the coefficient 1 or 0 in the array to the sum 
		num += coef*factor;
		
		}
	
	//num = num %256;   // restrict the range of values to extended ascii 0-256 regular ascii is 0-127   
	
	num=num %127;  // restrict the range of values to regular ascii 0-127  good for demonstration purposes
	
	chret = (char) num;
	
	return chret;
	
	}
       
	// PROMISES: to generate 2 random bytes and construct a random 16 bit array from them  
	public void randArray16() {
	
	setRandByte();  // set a random byte 
	byte2Array(randByte) ;  // load the 8 bit array bitArray8 with the random byte
	
		// clear the 16bitArray temp storage 
		for ( int k = 0 ; k < 16; k++){
		bitArray16[k]=0;	
		}
	 	
		// copy the first 8 bits of the temp array bitArray8
		for (int k=0; k<8; k++){
		bitArray16[k]=bitArray8[k];
		}
   
	setRandByte();  // set a random byte 
	byte2Array(randByte) ;  // load the 8 bit array bitArray8 with the random byte

		// copy the final 8 bits to the end of the array
		for ( int k=0; k< 8 ; k++){
		bitArray16[k+8]=bitArray8[k];
		} 
	}

	// PROMISES to turn 16bit array into a short
	// arrayToShort
	public short arrayToShort(int[] arrayIn){
	
	short retnum;
	
	int num=0;
	int coef;
	int power;
	int factor; 
	
	// loop over the 16 bit array 
               for (int k=1; k<16 ; k++){
		coef = arrayIn[k];
		
		power = 15-k;
		factor=1;
	        // generate the power of 2 
			for ( int j=0 ; j < power ; j++){
			factor*=2;
			} 
		// add the product of the power of 2 times the coefficient 1 or 0 in the array to the sum 
		num += coef*factor;
		
		}
		// apply the sign bit
		if ( arrayIn[0] ==1){  
		num=num*(-1);
		}
	
        retnum=(short) num ;
	
	return retnum;
	
	}
	
	
	public void shortToArray( short ShortIn){   // take a short and convert to 16-bit binary array    

	short num = ShortIn;  // copy the input to a local 
	
	// clear bitArray
		for (int k=0; k< 16 ; k++){
		bitArray16[k]=0;
		}

	// Set the Sign bit	
		if (num < 0){     
		bitArray16[0]=1;	 // store the sign
		num = (short)(-1* num ); // switch input to positive 7 bit integer number 
		}
	
	// convert to binary by division and store in array 
	// read MSB on left side little endian
		for (int k=15; k> 0; k--){
		bitArray16[k]=num % 2 ;  // remainder after division by 2 
		num /=2;  // integer division by 2
		}
	}

 //////////////////////////    XOR METHODS   //////////////////////////////////////////	
	// PROMISES  perform exclusive or XOR on two 16 bit arrays and return the XOR 16 bit array
	//             array 1 is bitKey16 array 2 is bitInput16 , result is stored in bitOutput16 
	
	public void xor16(){
	
	int size=16;
		for (int k=0 ; k<size ; k++){
		bitOutput16[k] = (bitKey16[k]+bitInput16[k])%2;
		}	
		
	return;
	
	}


	// PROMISES  perform exclusive or XOR on two 8 bit arrays and return the XOR 8 bit array
	public void xor8() {
		
	int size=8;
		for (int k=0 ; k<size ; k++){
		bitOutput8[k] = (bitKey8[k]+bitInput8[k])%2;
		}	
		
	return;
	
	}

} // Closing brace for class CharMan	
///////////////////////////////////////// END OF FILE  //////////////////////////////////////////////////////////

