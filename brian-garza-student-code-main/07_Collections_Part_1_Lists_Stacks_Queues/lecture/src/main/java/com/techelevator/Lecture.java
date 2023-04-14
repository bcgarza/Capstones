package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");


		List<String> names = new ArrayList<>();
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippen");
		names.add("Mary");
		names.add("Gandolf");
		names.add("Aragorn");
		names.add("Legolas");
		names.add("Boromir");
		names.add("Gimli");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


//		for (String name : names){
//			System.out.println(name);
//		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add(2, "David");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(2);


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println(names.contains("Gimli"));
//

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfGandalf = names.indexOf("Gandolf");
		System.out.println(indexOfGandalf);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

//		String [] namesArray = names.toArray(new String[0]);
//		for(int i = 0; i<namesArray.length; i++){
//			System.out.println(namesArray[i]);
//		}


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

			System.out.println("####################");
			System.out.println("Lists can be reversed too");
			System.out.println("####################");


			System.out.println("####################");
			System.out.println("       FOREACH");
			System.out.println("####################");
			System.out.println();


		}
	}
