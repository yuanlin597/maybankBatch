package com.example.restservice;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetails {

    private Long accountNumber;

    private BigDecimal trxAmount;

    private String description;

    private String trxDate;

    private String trxTime;

    private Long customerId;

    private Date trxDateTime;

    public TransactionDetails() {
    }

    public TransactionDetails(Long accountNumber, BigDecimal trxAmount, String description, String trxDate, String trxTime, Long customerId, Date trxDateTime) {
        this.accountNumber = accountNumber;
        this.trxAmount = trxAmount;
        this.description = description;
        this.trxDate = trxDate;
        this.trxTime = trxTime;
        this.customerId = customerId;
        this.trxDateTime = trxDateTime;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(BigDecimal trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTrxTime() {
        return trxTime;
    }

    public void setTrxTime(String trxTime) {
        this.trxTime = trxTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getTrxDateTime() {
        return trxDateTime;
    }

    public void setTrxDateTime(Date trxDateTime) {
        this.trxDateTime = trxDateTime;
    }
}
