package com.techelevator.dao;

import com.techelevator.tenmo.model.Transactions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionsTest {
    Transactions transactionOne;
    Transactions transactionTwo;

    @Before
    public void setup() {
        transactionOne = new Transactions("bob", "user", 5.50, false, "approved");
        transactionTwo = new Transactions("user", "bob", 150.00, false, "approved");
    }

    @Test
    public void test_getUserNameTo_From_transactionOne_Expected_bob() {
        String expected = "bob";

        String actual = transactionOne.getUserNameTo();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getUserNameFrom_From_transactionOne_Expected_user() {
        String expected = "user";

        String actual = transactionOne.getUserNameFrom();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getAmount_From_transactionTwo_Expected_150() {
        double expected = 150.00;

        double actual = transactionTwo.getAmount();

        Assert.assertEquals(expected, actual, 0.001);
    }
    @Test
    public void test_getRequest_From_transactionOne_Expected_false() {
        boolean expected = false;

        boolean actual = transactionOne.getRequest();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getStatus_From_transactionTwo_Expected_Approved() {
        String expected = "approved";

        String actual = transactionTwo.getStatus();

        Assert.assertEquals(expected, actual);
    }
}
