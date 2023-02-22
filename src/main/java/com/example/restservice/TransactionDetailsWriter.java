package com.example.restservice;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionDetailsWriter implements ItemWriter<TransactionDetails> {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void write(List list) throws Exception {
        list.stream().forEach(x->{
            TransactionDetails transactionDetails = (TransactionDetails) x;

            Customer customer = new Customer(transactionDetails.getCustomerId(), transactionDetails.getAccountNumber());
            customerRepository.save(customer);

            Transaction transaction = new Transaction();
//            transaction.setAccountNumber(transactionDetails.getAccountNumber());
            transaction.setTrxAmount(transactionDetails.getTrxAmount());
            transaction.setDescription(transactionDetails.getDescription());
            transaction.setTrxDate(transactionDetails.getTrxDateTime());
            transactionRepository.save(transaction);
        });
    }

}
