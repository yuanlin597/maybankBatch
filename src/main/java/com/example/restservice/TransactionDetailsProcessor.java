package com.example.restservice;

import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDetailsProcessor implements ItemProcessor {
    @Override
    public Object process(Object o) throws Exception {
        TransactionDetails transactionDetails = (TransactionDetails) o;
        Long accountNumber = transactionDetails.getAccountNumber();
        BigDecimal trxAmount = transactionDetails.getTrxAmount();
        String description = transactionDetails.getDescription();
        String trxDate = transactionDetails.getTrxDate();
        String trxTime = transactionDetails.getTrxTime();
        Long customerId = transactionDetails.getCustomerId();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date trxDateTime=simpleDateFormat.parse(trxDate + " " + trxTime);

        TransactionDetails newTransactionDetails = new TransactionDetails(accountNumber, trxAmount, description, trxDate, trxTime, customerId, trxDateTime);

        return newTransactionDetails;
    }
}
