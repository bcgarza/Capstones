package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ChipsTest {

    @Test
    public void testChipsPurchaseMessage() {
        // Arrange
        String expectedPurchaseMessage = "Crunch Crunch, Yum!";
        BigDecimal chipsPrice = new BigDecimal("1.00");
        Chips chips = new Chips("Test Chips", chipsPrice);

        // Act
        String actualPurchaseMessage = chips.getPurchaseMessage();

        // Assert
        assertEquals(expectedPurchaseMessage, actualPurchaseMessage);
    }
}