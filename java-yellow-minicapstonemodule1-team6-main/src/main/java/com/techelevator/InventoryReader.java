package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryReader {

    static Map<String, InventoryItem> inventoryItemMap = new HashMap<>();

    public static Map<String, InventoryItem> buildInventory() {

        //be able to read through inventory file
        File file = new File("vendingmachine.csv");
        try (Scanner scanner = new Scanner(file)) {
            //loop through it and split into its separate lines
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arrayLine = line.split("\\|");
                if (arrayLine[3].equals("Chip")) {
                    //inventory map.put(A1,new category chip drink gum)
                    inventoryItemMap.put(arrayLine[0], new Chips(arrayLine[1], new BigDecimal(arrayLine[2])));
                }
                if (arrayLine[3].equals("Drink")) {
                    inventoryItemMap.put(arrayLine[0], new Drink(arrayLine[1], new BigDecimal(arrayLine[2])));
                }
                if (arrayLine[3].equals("Candy")) {
                    inventoryItemMap.put(arrayLine[0], new Candy(arrayLine[1], new BigDecimal(arrayLine[2])));
                }
                if (arrayLine[3].equals("Gum")) {
                    inventoryItemMap.put(arrayLine[0], new Gum(arrayLine[1], new BigDecimal(arrayLine[2])));
                }
            }//PRINTS OUT AN ERROR IF THE ABOVE IF STATEMENTS FAIL TO FOLLOW THROUGH.
        } catch (FileNotFoundException e) {
            System.out.println("File can not be read from.");
        }
        return inventoryItemMap;
    }
        //METHOD TO DISPLAY INVENTORY AVAILABILITY TO USER BY CALLING THE POPULATED MAP
        public static void displayInventory(Map<String, InventoryItem> inventoryItemMap){
            for (String itemKey : inventoryItemMap.keySet()) {
                InventoryItem item = inventoryItemMap.get(itemKey);
                System.out.println(itemKey + " | " + item.getName() + " | $" + item.getPrice() + " | " + item.getQuantity());
            }
        }

    public static Map<String, InventoryItem> getInventoryItemMap() {
        return inventoryItemMap;
    }
}



