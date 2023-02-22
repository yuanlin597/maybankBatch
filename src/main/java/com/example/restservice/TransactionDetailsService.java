package com.example.restservice;

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

//    public TransactionDetails findByAccountNumber(String accountNumber){
//        Long acctNo = Long.parseLong(accountNumber);
//
//        List<Customer> customerList = customerRepository
//    }


}
