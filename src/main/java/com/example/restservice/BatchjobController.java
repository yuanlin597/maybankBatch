package com.example.restservice;

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



}
