package com.techelevator.tenmo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Transactions {
// instance variables

    private int transactionId;
    @NotBlank (message = "The field 'username_to' should not be blank.")
    private String userNameTo;
    @NotBlank (message = "The field 'username_from' should not be blank.")
    private String userNameFrom;
    @DecimalMin(value = "0.01", message = "The field 'amount' should not be less than or equal to $0.00")
    private double amount;
    @NotNull(message = "The field 'request' should be 'true' or 'false'.")
    private Boolean request = false;
    @NotBlank (message = "The field 'status' should not be blank")
    private String status = "Approved";

    // Constructor

    public Transactions(String userNameTo, String userNameFrom, double amount, Boolean request, String status) {
        this.userNameTo = userNameTo;
        this.userNameFrom = userNameFrom;
        this.amount = amount;
        this.request = request;
        this.status = status;
    }

    public Transactions() {
    }

    // Getters and setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserNameTo() {
        return userNameTo;
    }

    public void setUserNameTo(String userNameTo) {
        this.userNameTo = userNameTo;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Boolean getRequest() {
        return request;
    }

    public void setRequest(Boolean request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
