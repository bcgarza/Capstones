package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

//	int [] numberList = new int[5];
//		numberList[0] = 5;
//		numberList[1] = 10;
//		numberList[2] = 7;
//		numberList[3] = 8;
//		numberList[4] = 19;
//
//
//		int sumOfNumbers = 0;
//		for (int i = 0; i <= numberList.length-1; i++){
//			sumOfNumbers += numberList[i];
//
//		}
//		System.out.println(sumOfNumbers);




		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
//		String literalString = "literal string";
//		System.out.println("this is a literal string" + literalString);
//
//		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		System.out.println(" *** charAt() ***");
		String name = "Brian Garza";
		char first = name.charAt(0);
		char fourth = name.charAt(3);
		char g = name.charAt(6);
		System.out.println("is g, g: " +g);

		for (char character: name.toCharArray()){
			System.out.println(character);

		}
		System.out.println("*** contains ***");
				String hello = "hello world";

		boolean containsHello = hello.contains("hello");
		System.out.println("contains hello? " + containsHello);



		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		String endsWithTest = "whatever";
		System.out.println((endsWithTest.endsWith("ever") && endsWithTest.endsWith("tever")));

		String startsWith = "NewString";
		System.out.println((startsWith.startsWith("new") || startsWith.startsWith("NewSt")));

		String indexTest = "abcdefg";
		System.out.println(indexTest);


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
