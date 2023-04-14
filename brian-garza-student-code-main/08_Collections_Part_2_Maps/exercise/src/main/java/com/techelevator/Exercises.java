package com.techelevator;

import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		//build your map
		Map<String, String> animalGroupName = new HashMap<>();
		//fill your map with keys and values
		animalGroupName.put("rhino", "crash");
		animalGroupName.put("giraffe", "Tower");
		animalGroupName.put("elephant", "herd");
		animalGroupName.put("lion", "pride");
		animalGroupName.put("crow", "Murder");
		animalGroupName.put("flamingo", "pat");
		animalGroupName.put("deer", "herd");
		animalGroupName.put("dog", "pack");
		animalGroupName.put("crocodile", "float");
		//check if the name is null AND if the group name contains keys of the animal name and then converts them to
		if(animalName != null && animalGroupName.containsKey(animalName.toLowerCase())){
			return animalGroupName.get(animalName.toLowerCase());
		}
		return "unknown";
	}

		/*
		 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
		 * If the item is not on sale, return 0.00.
		 *
		 * If the item number is empty or null, return 0.00.
		 *
		 * "KITCHEN4001" -> 0.20
		 * "GARAGE1070" -> 0.15
		 * "LIVINGROOM"	-> 0.10
		 * "KITCHEN6073" -> 0.40
		 * "BEDROOM3434" -> 0.60
		 * "BATH0073" -> 0.15
		 *
		 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
		 * should all return 0.20.
		 *
		 * isItOnSale("kitchen4001") → 0.20
		 * isItOnSale("") → 0.00
		 * isItOnSale("GARAGE1070") → 0.15
		 * isItOnSale("dungeon9999") → 0.00
		 *
		 */
		public double isItOnSale (String itemNumber){
			//Create map to see items and if they are on sale
			Map<String, Double> onSale = new HashMap<>();

			// build map
			onSale.put("KITCHEN4001", 0.20);
			onSale.put("GARAGE1070", 0.15);
			onSale.put("LIVINGROOM", 0.10);
			onSale.put("KITCHEN6073", 0.40);
			onSale.put("BEDROOM3434", 0.60);
			onSale.put("BATH0073", 0.15);

			//check if is actually on sale
			if (itemNumber != null && onSale.containsKey(itemNumber.toUpperCase())) {

				return onSale.get(itemNumber.toUpperCase());
			}

			return 0.00;
		}



	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		//create map
			Map<String, Integer> peterPaysPaul = new HashMap<>();

			peterPaysPaul.put("Paul", peterPaul.get("Paul"));
			peterPaysPaul.put("Peter", peterPaul.get("Peter"));

			//check if peter has more than 0 money and if paul has less than 10.
		if(peterPaul.get("Peter")> 0 && peterPaul.get("Paul")<1000) {

			//calculations to substract from peter and add to paul
			int stealFromPeter = peterPaul.get("Peter") / 2;
			int addToPaul = peterPaul.get("Paul") + stealFromPeter;

			peterPaysPaul.put("Paul", addToPaul);
			peterPaysPaul.put("Peter", peterPaul.get("Peter") - stealFromPeter);

		}

		return peterPaysPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		Map<String, Integer> contributed = new HashMap<>();

			if(peterPaul.get("Peter")>=5000 && peterPaul.get("Paul")>=10000) {

				Integer peterContribute = peterPaul.get("Peter") / 4;
				Integer paulContribute = peterPaul.get("Paul") / 4;

				contributed.put("PeterPaulPartnership", peterContribute + paulContribute);
				contributed.put("Peter", peterPaul.get("Peter") - peterContribute);
				contributed.put("Paul", peterPaul.get("Paul") - paulContribute);

			}
			else {
				return peterPaul;
			}


		return contributed;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {

		Map<String, String> newString = new HashMap<>();

		for(int i=0; i<words.length; i++){

			String currentWord = words[i];
			String firstChar = currentWord.charAt(0) + "";
			String lastChar = currentWord.charAt(currentWord.length()-1) + "";
			newString.put(firstChar, lastChar);
		}

		return newString;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {

		Map<String, Integer> newMapString = new HashMap<>();

		for(String newString : words){
			if(newMapString.containsKey(newString)){
				newMapString.put(newString, newMapString.get(newString)+1);
			}else{
				newMapString.put(newString,1);
			}
		}

		return newMapString;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> newcount = new HashMap<>();

		for(Integer newNewCouts : ints){
			if(newcount.containsKey(newNewCouts)){
				newcount.put(newNewCouts, newcount.get(newNewCouts)+1);
			}else{
				newcount.put(newNewCouts,1);
			}
		}

		return newcount;
	}


	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		//Create map
		Map<String, Boolean> newString = new HashMap<>();
		//For loop is used to loop through original string of 'words' and creates 'newKeys'
		for (String newKeys : words) {
			//checks if the 'newString' contains the same keys as 'newKeys'
			if (newString.containsKey(newKeys)) {
				//adds 'newKeys' to the 'Key' section of the map and returns true for the 'Value' section of the map.
				newString.put(newKeys, true);

			} else {
				newString.put(newKeys, false);
			}
		}
		return newString;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		//create new map to combine 2 maps and call the contents of warehouse 1 to the new map
		// so it already contains keys and value from it.
		Map<String, Integer> mergingMaps = new HashMap<>(mainWarehouse);

		//the for loop creates new string addStrings and loops through remoteWarehouse from the beginning.
		for(Map.Entry<String,Integer> addStrings : remoteWarehouse.entrySet()){

			//final string is created with newKeys and assigned the value of the previous strings
			//new integer is created and given the value of previous maps values
			String newKeys = addStrings.getKey();
			Integer newValue = addStrings.getValue();

			//if statement gives condition - if new map contains the newkeys collected, then combine the Values of those that are found.
			//then they are assigned the name newestValue and have a combined value.
			//then if they don't meet those requirements it displays the ones that are unmatched.
			if(mergingMaps.containsKey(newKeys)){
				Integer newestValue = mergingMaps.get(newKeys) + newValue;
				mergingMaps.put(newKeys, newestValue);

			}else{
				mergingMaps.put(newKeys, newValue);
			}
		}
		return mergingMaps;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {


		return null;
	}

}
