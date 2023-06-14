package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Transactions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcTransactionsDao implements TransactionDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Transactions sendMoneyTransaction(Transactions transaction) {
        Transactions newTransaction = null;
        String sql = "INSERT INTO transactions (username_to, username_from, amount, request, status)" +
                "VALUES (?, ?, ?, ?, ?) RETURNING transaction_id;";
        String sqlTwo = "Update account Set balance = balance + ? Where user_id = (Select user_id From tenmo_user Where username = ?);"+
                "Update account Set balance = balance - ? Where user_id = (Select user_id From tenmo_user Where username = ?);";

        try {
            int newTransactionId = jdbcTemplate.queryForObject(sql, int.class, transaction.getUserNameTo(),
                    transaction.getUserNameFrom(), transaction.getAmount(), transaction.getRequest(), transaction.getStatus());
            jdbcTemplate.update(sqlTwo, transaction.getAmount(), transaction.getUserNameTo(), transaction.getAmount(), transaction.getUserNameFrom());

            newTransaction = getTransactionById(newTransactionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newTransaction;
    }

    @Override
    public Transactions getTransactionById(int transactionId) {
        Transactions transaction = null;
        String sql = "SELECT transaction_id, username_to, username_from, amount, request, status " +
                "FROM transactions WHERE transaction_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transactionId);
            if (results.next()) {
                transaction = mapRowToTransactions(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return transaction;
    }

    @Override
    public List<Transactions> getAllTransactions(String userName) {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "SELECT transaction_id, username_to, username_from, amount, request, status " +
                "FROM transactions WHERE username_to = ? OR username_from = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userName, userName);
            while (results.next()) {
                Transactions transactionsResult = mapRowToTransactions(results);
                transactions.add(transactionsResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return transactions;
    }

    private Transactions mapRowToTransactions(SqlRowSet rs) {
        Transactions transaction = new Transactions();
        transaction.setTransactionId(rs.getInt("transaction_id"));
        transaction.setUserNameTo(rs.getString("username_to"));
        transaction.setUserNameFrom(rs.getString("username_from"));
        transaction.setAmount(rs.getDouble("amount"));
        transaction.setRequest(rs.getBoolean("request"));
        transaction.setStatus(rs.getString("status"));
        return transaction;
    }
}

