package com.example.restservice.service;

import com.example.restservice.entity.Transaction;
import com.example.restservice.entity.TransactionDetails;
import com.example.restservice.repository.CustomerRepository;
import com.example.restservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAllTransaction(){
        return transactionRepository.findAll();
    }

    public List<TransactionDetails> findAllTransactionWithCustomer(){
        return transactionRepository.findAllTransaction();
    }

//    public void updateTransactionDetails(){
//        transactionRepository.update
//    }


}
