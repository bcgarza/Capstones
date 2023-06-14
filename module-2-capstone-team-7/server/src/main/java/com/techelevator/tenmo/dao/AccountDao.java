package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import javax.accessibility.AccessibleValue;
import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    //read
    public double getBalance(String userName);

//    List<Account> getAllAccounts(String userName);

    public Account getAccountByAccountId(int id);

    public Account getAccountByUserId(int id);

    //create

//    Account createAccount(Account account);

//    //Update
//    public Account updateAccount(Account account);

    //delete

}
