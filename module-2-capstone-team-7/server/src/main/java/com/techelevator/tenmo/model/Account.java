package com.techelevator.tenmo.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Account {
    private int accountId;
    @NotBlank(message = "The field 'user_id' should not be blank.")
    private int userId;
    @DecimalMin(value = "0.00", message = "The field 'balance' should not be less than $0.00")
    private double balance = 0.00;  //set new account balance to default value of $1000.00


    //constructor

    // Used for creating an Account object in Java before sending it to the database via createNewAccount method in JdbAccountDao
    public Account(int userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }


    public Account(int accountId, int userId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }



    public Account() {

    }

    //Getter and Setter
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
