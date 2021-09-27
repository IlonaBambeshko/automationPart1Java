package by.automation.part1.lesson16;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
//		task 1.
		getSortedListWithoutSer();

//		task 2.
		getElementWithVor();

//		task 3.
		getSortedCollectionOfPrices();
	}

	public static void getSortedCollectionOfPrices() {
		ArrayList<Phone> phones = new ArrayList<>();
		Collections.addAll(phones,
				new Phone("BB", 100),
				new Phone("CCC", 200),
				new Phone("A", 150));

		Collection<Price> prices = phones.stream().sorted(Comparator.comparingInt(p -> p.getName().length()))
				.map(Phone::getPrice).map(Price::new).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(prices);
	}

	public static void getElementWithVor() {
		ArrayList<String> birds = new ArrayList<String>();
		Collections.addAll(birds, "Sinica", "Zhuravl", "Voron", "Aist", "Flamingo", "Vorona");

		Optional<String> bird = birds.stream()
				.filter(p -> p.toLowerCase(Locale.ROOT).contains("vor"))
				.findFirst();
		bird.ifPresentOrElse(System.out::println,
				() -> System.out.println("No elements"));
	}

	public static void getSortedListWithoutSer() {
		ArrayList<String> names = new ArrayList<String>();
		Collections.addAll(names, "Karl", "Sergey", "Johnny", "Alexandr", "Sergey2", "");

		names.stream().filter(p -> !p.toLowerCase(Locale.ROOT)
						.contains("ser")).sorted(Comparator.comparingInt(String::length))
				.forEach(System.out::println);
	}
}
