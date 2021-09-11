package by.automation.part1.lesson10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// DONE !! :-)
//		Task 1: маски

//		а) 123-45-67
//		^\d{3}\-\d{2}\-\d{2}
//		б) 8 (025) 123-45-67
//		\d{1}\s\(\d{3}\)\s\d{3}\-\d{2}\-\d{2}
//		в) +375(25)123-45-67
//		\+\d{3}\(\d{2}\)\d{3}\-\d{2}\-\d{2}

		divideTextIntoSentences();
		System.out.println();

		divideTextIntoWords();
		System.out.println();

		// Method must catch a list of strings (Task). But Okay :-)
//		joinIntoString();
	}

	public static void divideTextIntoSentences() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your text with sentences: ");
		String str = in.nextLine();
		for (String substr : str.split("(?<=[.!?])\\s*")) {
			System.out.println(substr);
		}
	}

	public static void divideTextIntoWords() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your text with words: ");
		String str = in.nextLine();
		for (String substr : str.split("\\s")) {
			System.out.println(substr);
		}
	}

	public static void joinIntoString() {
		ArrayList<String> stringList = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your string: ");
		String str = in.nextLine();
		while (!str.equals("0")) {
			stringList.add(str);
			System.out.println("Enter your string: ");
			str = in.nextLine();
		}
		String wholeString = String.join(",", stringList);
		System.out.println(wholeString);
	}

}
