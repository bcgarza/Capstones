package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transactions;

import java.util.List;

public interface TransactionDao {
    // create

    public Transactions sendMoneyTransaction(Transactions transaction);

    // read

    public Transactions getTransactionById(int transactionId);

    public List<Transactions> getAllTransactions(String userName);


    // update


    // delete
}
