package com.techelevator;

import java.math.BigDecimal;

public class Gum extends InventoryItem {
    //CONSTRUCTOR
    public Gum(String name, BigDecimal price) {
        super(name, price);
    }
    //METHOD OVERRIDE FROM PURCHASABLE INTERFACE, PRINTS WHEN PURCHASED
    @Override
    public String getPurchaseMessage() {
        return "Chew Chew, Yum!";
    }
}
