package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountDao dao;
    public AccountController(AccountDao dao){
        this.dao = dao;
    }


    @RequestMapping( path = "/balance", method = RequestMethod.GET)
    public String getBalance(Principal principal) {
        double accountBalance = dao.getBalance(principal.getName());

        BigDecimal bd = new BigDecimal(accountBalance).setScale(2, RoundingMode.HALF_UP);

        return bd.toString();
//        DecimalFormat d = new DecimalFormat("0.00");
//        return Double.parseDouble(d.format(accountBalance));
    }

//    @RequestMapping (path = "", method = RequestMethod.GET)
//    public List<Account> getAllAccounts(Principal principal) {
//        return dao.getAllAccounts(principal.getName());
//    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Account getAccountByAccountId(@Valid @PathVariable int id){
        Account account = dao.getAccountByAccountId(id);
        if (account == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found");
        } else {
            return dao.getAccountByAccountId(id);
        }
    }


//    @RequestMapping(path = "", method = RequestMethod.POST)
//    public Account createAccount(@RequestBody Account account){
//        return dao.createAccount(account);
//    }
}
