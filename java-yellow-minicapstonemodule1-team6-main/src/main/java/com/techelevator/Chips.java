package com.techelevator;

import java.math.BigDecimal;

public class Chips extends InventoryItem{
    //constructor
    public Chips(String name, BigDecimal price) {
        super(name, price);
    }
    //override method from purchasable interface
    @Override
    public String getPurchaseMessage() {
        return "Crunch Crunch, Yum!";
    }
}
