package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CandyTest {

    @Test
    public void testCandyPurchaseMessage() {
        // Arrange
        String expectedPurchaseMessage = "Munch Munch, Yum!";
        BigDecimal candyPrice = new BigDecimal("1.00");
        Candy candy = new Candy("Test Candy", candyPrice);

        // Act
        String actualPurchaseMessage = candy.getPurchaseMessage();

        // Assert
        assertEquals(expectedPurchaseMessage, actualPurchaseMessage);
    }
}