package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the length: ");
		String userInput = scanner.nextLine();
		System.out.println("Enter m or f");
		String meterOrFeet = scanner.nextLine();
		if (meterOrFeet.equals("m")) {
			System.out.println(userInput+"m"+ " is " +((int)(Integer.parseInt(userInput) * 3.2808399) +"f"));
		}
		else {
			System.out.println(userInput + "f" + " is "+((int)(Integer.parseInt(userInput) * 0.3048) + "m"));
		}



	}

}
