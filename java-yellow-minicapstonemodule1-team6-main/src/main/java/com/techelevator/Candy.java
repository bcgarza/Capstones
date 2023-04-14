package com.techelevator;

import java.math.BigDecimal;

public class Candy extends InventoryItem {
    //constructor
    public Candy(String name, BigDecimal price) {
        super(name, price);
    }
    //override method from purchasable interface
    @Override
    public String getPurchaseMessage() {
        return "Munch Munch, Yum!";
    }
}

