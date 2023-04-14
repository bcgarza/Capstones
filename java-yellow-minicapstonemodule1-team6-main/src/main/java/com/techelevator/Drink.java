package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Drink extends InventoryItem {
    //CONSTRUCTOR
    public Drink(String name, BigDecimal price) {
        super(name, price);
    }
    //METHOD OVERRIDE FROM PURCHASABLE PRINTS MESSAGE UPON PURCHASE
    @Override
    public String getPurchaseMessage() {
        return "Glug Glug, Yum!";
    }

}
