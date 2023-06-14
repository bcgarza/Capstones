package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcAccountDaoTests extends BaseDaoTests{

    private JdbcAccountDao accountDao;
    private JdbcUserDao userDao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        accountDao = new JdbcAccountDao(jdbcTemplate);
        userDao = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void test_createAccount_Expect_Not_Null_newAccountId_2003_balance_1000() {

        String userName = "TEST_USER";
        String password = "test_password";
        boolean userCreated = userDao.create(userName,password); //creates new user which automatically creates new account

        User user = userDao.findByUsername(userName);
        int userId = user.getId();

        Account testAccount = accountDao.getAccountByUserId(userId);
        int newAccountId = testAccount.getAccountId();
        double newAccountBalance = testAccount.getBalance();

        Assert.assertNotNull(testAccount);
        Assert.assertEquals(2003, newAccountId);
        Assert.assertEquals(1000.00, newAccountBalance, 0.001);
    }

    @Test
    public void test_getAccountByAccountId_Expect_Not_Null(){

        int accountId = 2001;
        Account testAccount = accountDao.getAccountByAccountId(accountId);

        Assert.assertNotNull(testAccount);
    }

    @Test
    public void test_getAccountByUserId_Expect_Not_Null() {

        String userName = "bob";
        User user = userDao.findByUsername(userName);
        int userId = user.getId();

        Account testAccount = accountDao.getAccountByUserId(userId);

        Assert.assertNotNull(testAccount);
    }

    @Test
    public void test_getBalance_Expect_1000() {
        String userName = "user";
        User user = userDao.findByUsername(userName);
        int userId = user.getId();

        Account testAccount = accountDao.getAccountByUserId(userId);

        Assert.assertEquals(1000.00, testAccount.getBalance(), 0.001);
    }
}
