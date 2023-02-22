package com.example.restservice.controller;

import com.example.restservice.entity.TransactionDetails;
import com.example.restservice.repository.CustomerRepository;
import com.example.restservice.entity.Transaction;
import com.example.restservice.service.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchjobController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionDetailsService transactionDetailsService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

        return "this is test";
    }

    @RequestMapping(value = "/findAllTransaction", method = RequestMethod.GET)
    public List<Transaction> findAllTransaction(){
        return transactionDetailsService.findAllTransaction();
    }

    @RequestMapping(value = "/findAllTransactionWithCustomer", method = RequestMethod.GET)
    public List<TransactionDetails> findAllTransactionWithCustomer(){
        return transactionDetailsService.findAllTransactionWithCustomer();
    }

}
