package com.example.restservice.controller;

import com.example.restservice.entity.TransactionDetails;
import com.example.restservice.repository.CustomerRepository;
import com.example.restservice.entity.Transaction;
import com.example.restservice.service.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<TransactionDetails> findAllTransactionWithCustomer(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page-1, size);
        return transactionDetailsService.findAllTransactionWithCustomer(pageable);
    }

    @RequestMapping(value = "/updateTransaction", method = RequestMethod.POST)
    public void updateTransaction(@RequestBody Transaction transaction){
        Optional<Transaction> transactionOptional = transactionDetailsService.getTransactionById(transaction.getId());
        if(transactionOptional.isPresent()){
            transactionDetailsService.updateTransactionDetails(transaction);
        }
    }

    @RequestMapping(value = "/findAllTransactionByAccountNumber", method = RequestMethod.GET)
    public List<TransactionDetails> findAllTransactionByAccountNumber(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "accountNumber") Long accountNumber){
        Pageable pageable = PageRequest.of(page-1, size);
        return transactionDetailsService.findTransactionByAccountNumber(accountNumber, pageable);
    }

    @RequestMapping(value = "/findAllTransactionByCustomerId", method = RequestMethod.GET)
    public List<TransactionDetails> findAllTransactionByCustomerId(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "customerId") Long customerId){
        Pageable pageable = PageRequest.of(page-1, size);
        return transactionDetailsService.findTransactionByCustomerId(customerId, pageable);
    }

    @RequestMapping(value = "/findAllTransactionByDescription", method = RequestMethod.GET)
    public List<TransactionDetails> findAllTransactionByDescription(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "description") String description, @RequestParam(name="sortBy") String sortBy, @RequestParam(name="order") String order){
        Pageable pageable = PageRequest.of(page-1, size).withSort(Sort.by(Sort.Direction.fromString(order), sortBy));
        String descriptionFormatted = description.toUpperCase();

        return transactionDetailsService.findTransactionByDescription(descriptionFormatted, pageable);
    }

}
