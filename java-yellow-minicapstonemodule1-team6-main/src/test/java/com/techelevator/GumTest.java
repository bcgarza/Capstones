package com.techelevator;

import org.junit.Test;

import javax.naming.BinaryRefAddr;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class GumTest {

    @Test
    public void testGumPurchaseMessage() {
        // Arrange
        String expectedPurchaseMessage = "Chew Chew, Yum!";
        BigDecimal gumPrice = new BigDecimal("1.00");
        Gum gum = new Gum("Test Gum", gumPrice);

        // Act
        String actualPurchaseMessage = gum.getPurchaseMessage();

        // Assert
        assertEquals(expectedPurchaseMessage, actualPurchaseMessage);
    }
}
