package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transactions;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@PreAuthorize("isAuthenticated()")
public class TransactionsController {

    private TransactionDao dao;
    public TransactionsController(TransactionDao dao){
        this.dao = dao;
    }
    @Autowired
    private AccountDao accountDao;


    @RequestMapping(path = "", method = RequestMethod.POST)
    public Transactions sendMoneyTransaction(@Valid @RequestBody Transactions transaction, Principal principal) {

//        Transactions newTransaction = new Transactions();
        String userNameTo = transaction.getUserNameTo();
//        String userNameFrom = newTransaction.getUserNameFrom();

       // String userNameFrom = transaction.getUserNameFrom();

        if (userNameTo.equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You can not send money to yourself.");
        }

        double currentBalanceFromUser = accountDao.getBalance(principal.getName());

        if ((Double.compare(currentBalanceFromUser, transaction.getAmount())) >= 0) {
            return dao.sendMoneyTransaction(transaction);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds in sender's account.");
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Transactions getTransactionById(@PathVariable int transactionId){
        Transactions transaction = dao.getTransactionById(transactionId);
        if (transaction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction Not Found");
        } else {
            return dao.getTransactionById(transactionId);
        }
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Transactions> getAllTransactions(Principal principal){

        return dao.getAllTransactions(principal.getName());
    }
}

//{
//"userNameTo": "James10",
//"userNameFrom" : "James0",
//"amount" :1000.00,
//"request": false,
//"status": "approved"
//}