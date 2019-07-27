import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Anagram {
	private ArrayList<Character> word = new ArrayList<>();
	
	public String AnagramQuestion(){
		ArrayList<String> question = new ArrayList<>(
				//question = list of anagram questions
				Arrays.asList("SAVE", "CAT", "LISTEN")); //answer: vase, act, silent
		//randomly get one of the question from question list
		Random rand = new Random();
		int num = rand.nextInt(3);
		return question.get(num); //return one of the three question
	}
	
	public ArrayList<Character> getQuestion(){
		String que = AnagramQuestion();
		int stringLength = que.length();
		int testlength = 0;
		//get letter of question and add each letter to list(word)
		while (testlength != stringLength) {
			char letter = que.charAt(testlength);
			word.add(letter);
			testlength ++;
		}
		//System.out.println(word);
		return word; //return word to be rearrange
	}
	
	public boolean checkAnswer() {
		if (word.size() == 3 ) {
			if (word.get(0)== 'A' && word.get(1) == 'C' && word.get(2)== 'T') {
				System.out.println("Win");
				return true;
			}
			else {
				System.out.println("try again!" + word);
				getInput();
				checkAnswer();
			}
		} 
		else if (word.size() == 4 ) {
			if (word.get(0)== 'V' && word.get(1)== 'A' && word.get(2)== 'S' && word.get(3)== 'E') {
				System.out.println("Win");
				return true;
			} else {
				System.out.println("try again!" + word);
				getInput();
				checkAnswer();
			}
		} 
		else if (word.size() == 6 ) {
			if (word.get(0)== 'S' && word.get(1)== 'I' && word.get(2)== 'L' && word.get(3)== 'E' && word.get(4)== 'N'&& word.get(5)== 'T') {
				System.out.println("Win");
				return true;
			} else {
				System.out.println("try again!" + word);
				getInput();
				checkAnswer();
			}
		}
		return false;
	}
	
	
	
	
	public ArrayList<Character> getInput() {
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();//enter 2 numbers
		int answer1 = answer/10;
		int answer2 = answer%10;
		Collections.swap(word, answer1-1, answer2-1);
		return word;
	}
	
	public void askQuestion() {
		
		System.out.println("rearranging the letters into another word");
		System.out.println("Choose two letter to switch place");
		System.out.println("enter two number (eg. enter 12 if rearrange letter 1 and 2)");
		System.out.println(word);
		getInput();
	}

}
