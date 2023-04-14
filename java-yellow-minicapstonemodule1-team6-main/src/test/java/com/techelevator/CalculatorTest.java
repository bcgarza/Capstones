package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculatorTest {

    @Test
    public void setCurrentMoneyProvided_subtractsMoneyInput_whenIsPurchaseIsTrue() {
        Calculator calculator = new Calculator();
        BigDecimal currentMoneyProvided = new BigDecimal("2.50");
        BigDecimal moneyInput = new BigDecimal("1.25");
        BigDecimal expected = new BigDecimal("1.25");

        calculator.setCurrentMoneyProvided(currentMoneyProvided, moneyInput, true);

        Assert.assertEquals(expected, calculator.getCurrentMoneyProvided());
    }

    @Test
    public void setCurrentMoneyProvided_addsMoneyInput_whenIsPurchaseIsFalse() {
        Calculator calculator = new Calculator();
        BigDecimal currentMoneyProvided = new BigDecimal("1.25");
        BigDecimal moneyInput = new BigDecimal("0.75");
        BigDecimal expected = new BigDecimal("2.00");

        calculator.setCurrentMoneyProvided(currentMoneyProvided, moneyInput, false);

        Assert.assertEquals(expected, calculator.getCurrentMoneyProvided());
    }
}


