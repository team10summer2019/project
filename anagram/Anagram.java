import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Anagram {
	public static ArrayList<String> bookList = new ArrayList<>(
			Arrays.asList("Storm of sword", "A song of ice and fire", "Velveteen Rabbit ", "Ender's game"));
			// first letter of each book - SAVE
			
	public static ArrayList<String> switchBookPosition() {
		System.out.println(bookList);
		System.out.println("Which book do you want to move?");
		Scanner book1 = new Scanner(System.in);
		int bookone = book1.nextInt(); 
		System.out.println("switch book with?");
		Scanner book2 = new Scanner(System.in);
		int booktwo = book2.nextInt();
		Collections.swap(bookList, bookone, booktwo);
		System.out.println(bookList);
		return bookList;
	}
	
	public static void main(String[] args) {
		switchBookPosition();
	}
}
