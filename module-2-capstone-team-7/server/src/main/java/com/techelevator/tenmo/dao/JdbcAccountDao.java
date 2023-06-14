package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//    @Override

//    public Account createAccount(Account account) {
//        Account newAccount = null;
//        String sql = "INSERT INTO account (user_id, balance) VALUES (?, ?) " +
//                "RETURNING account_id;";
//        try {
//            int newAccountId = jdbcTemplate.queryForObject(sql, int.class, account.getUserId(), account.getBalance());
//            newAccount = getAccountByAccountId(newAccountId);
//        }
//        catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (BadSqlGrammarException e) {
//            throw new DaoException("SQL syntax error", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//        return newAccount;
//    }

    @Override
    public double getBalance(String userName) {
        double balance = 0.00;
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = (SELECT user_id FROM tenmo_user " +
                "WHERE username LIKE ?);";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userName);
            if (results.next()) {
                account = mapRowToAccount(results);
            }
            balance = account.getBalance();
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return balance;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ? AND user_id = " +
                "(SELECT user_id FROM account WHERE account_id = ?);";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId, accountId);
            if (results.next()) {
                account = mapRowToAccount(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return account;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ? ;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                account = mapRowToAccount(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return account;
    }
//    @Override
//    public List<Account> getAllAccounts(String userName) {
//        String sql = "SELECT account_id, user_id, balance FROM account " +
//                "WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username LIKE ?);";
//
//        List<Account> allUserAccounts = new ArrayList<>();
//
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userName);
//            while (results.next()) {
//                allUserAccounts.add(mapRowToAccount((results)));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (BadSqlGrammarException e) {
//            throw new DaoException("SQL syntax error", e);
//        }
//        return allUserAccounts;

//    @Override
//    public Account updateAccount(Account account) {
//        return null;
//    }

    private Account mapRowToAccount (SqlRowSet rs) {
        Account account =  new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }
}
