package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.dao.JdbcTransactionsDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transactions;
import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcTransactionsDaoTests extends BaseDaoTests{

    private JdbcTransactionsDao transactionsDao;
    private JdbcUserDao userDao;
    private JdbcAccountDao accountDao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        transactionsDao = new JdbcTransactionsDao(jdbcTemplate);
        userDao = new JdbcUserDao(jdbcTemplate);
        accountDao = new JdbcAccountDao(jdbcTemplate);
    }

    @Test
    public void test_sendMoneyTransaction_Send_50_Expect_Transactions_Table_and_Account_Balances_Update () {
        String userNameTo = "bob";
        String userNameFrom = "user";

        User userTo = userDao.findByUsername(userNameTo);
        User userFrom = userDao.findByUsername(userNameFrom);

        Account accountTo = accountDao.getAccountByUserId(userTo.getId());
        Account accountFrom = accountDao.getAccountByUserId(userFrom.getId());

        Transactions newTransaction = new Transactions(userNameTo, userNameFrom, 50.00, false, "approved");
        Transactions verifyTransaction = transactionsDao.sendMoneyTransaction(newTransaction);

        Account updatedAccountTo = accountDao.getAccountByUserId(userTo.getId());
        Account updatedAccountFrom = accountDao.getAccountByUserId(userFrom.getId());

        Assert.assertNotNull(verifyTransaction);
        Assert.assertEquals(1050, updatedAccountTo.getBalance(), 0.001);
        Assert.assertEquals(950, updatedAccountFrom.getBalance(), 0.001);
    }

    @Test
    public void test_getAllTransactions_UserName_Bob_Return_List_size_2 () {
        String userNameTo = "bob";
        String userNameFrom = "user";

        User userTo = userDao.findByUsername(userNameTo);
        User userFrom = userDao.findByUsername(userNameFrom);

        Account accountTo = accountDao.getAccountByUserId(userTo.getId());
        Account accountFrom = accountDao.getAccountByUserId(userFrom.getId());

        Transactions newTransaction = new Transactions(userNameTo, userNameFrom, 50.00, false, "approved");
        transactionsDao.sendMoneyTransaction(newTransaction);

        Transactions newTransactionTwo = new Transactions(userNameTo, userNameFrom, 100.00, false, "approved");
        transactionsDao.sendMoneyTransaction(newTransactionTwo);

        Account updatedAccountTo = accountDao.getAccountByUserId(userTo.getId());
        Account updatedAccountFrom = accountDao.getAccountByUserId(userFrom.getId());

        List<Transactions> allTransactions = new ArrayList<>();
        allTransactions = transactionsDao.getAllTransactions("bob");

        Assert.assertEquals(2, allTransactions.size());
    }

    @Test
    public void test_getTransactionById_transactionId_3002_Expect_NotNull () {
        String userNameTo = "bob";
        String userNameFrom = "user";

        User userTo = userDao.findByUsername(userNameTo);
        User userFrom = userDao.findByUsername(userNameFrom);

        Account accountTo = accountDao.getAccountByUserId(userTo.getId());
        Account accountFrom = accountDao.getAccountByUserId(userFrom.getId());

        Transactions newTransaction = new Transactions(userNameTo, userNameFrom, 50.00, false, "approved");
        Transactions verifyTransaction = transactionsDao.sendMoneyTransaction(newTransaction);

        Transactions newTransactionTwo = new Transactions(userNameTo, userNameFrom, 100.00, false, "approved");
        Transactions verifyTransactionTwo = transactionsDao.sendMoneyTransaction(newTransactionTwo);

       Transactions getTransaction = transactionsDao.getTransactionById(verifyTransactionTwo.getTransactionId());

        Assert.assertEquals(3002, getTransaction.getTransactionId());

    }

}
