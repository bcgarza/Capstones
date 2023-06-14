package com.techelevator.dao;

import com.techelevator.tenmo.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    Account accountOne;
    Account accountTwo;
    @Before

    public void setup() {
        accountOne = new Account(2001,1001, 1000.00 );
        accountTwo = new Account(2002, 1002, 1550.51);
    }

    @Test
    public void test_getAccountID_From_accountTwo_Expect_2002() {
        int expected = 2002;

        int actual = accountTwo.getAccountId();

        Assert.assertEquals(2002, actual);
    }

    @Test
    public void test_getUserId_From_accountTwo_Expect_2002() {
        int expected = 1002;

        int actual = accountTwo.getUserId();

        Assert.assertEquals(1002, actual);
    }

    @Test
    public void test_getbalance_From_accountTwo_Expect_1550_decimal_50() {
        double expected = 1550.51;

        double actual = accountTwo.getBalance();

        Assert.assertEquals(expected, actual, 0.001);
    }

}
