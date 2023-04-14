package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    @Test
    public void testDrinkPurchaseMessage() {
        // Arrange
        String expectedPurchaseMessage = "Glug Glug, Yum!";
        BigDecimal drinkPrice = new BigDecimal("1.00");
        Drink drink = new Drink("Test Drink", drinkPrice);

        // Act
        String actualPurchaseMessage = drink.getPurchaseMessage();

        // Assert
        assertEquals(expectedPurchaseMessage, actualPurchaseMessage);
    }

}