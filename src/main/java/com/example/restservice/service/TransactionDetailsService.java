package com.example.restservice.service;

import com.example.restservice.entity.Transaction;
import com.example.restservice.entity.TransactionDetails;
import com.example.restservice.repository.CustomerRepository;
import com.example.restservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public List<TransactionDetails> findAllTransactionWithCustomer(Pageable pageable){
        return transactionRepository.findAllTransaction(pageable);
    }

    public void updateTransactionDetails(Transaction transaction){
        transactionRepository.updateTransaction(transaction.getId(), transaction.getAccountNumber(), transaction.getTrxAmount(), transaction.getDescription(), transaction.getTrxDate());
    }

    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public List<TransactionDetails> findTransactionByAccountNumber(Long accountNumber, Pageable pageable){
        return transactionRepository.findTransactionByAccountNumber(accountNumber, pageable);
    }

    public List<TransactionDetails> findTransactionByCustomerId(Long customerId, Pageable pageable){
        return transactionRepository.findTransactionByCustomerId(customerId, pageable);
    }

    public List<TransactionDetails> findTransactionByDescription(String description, Pageable pageable){
        return transactionRepository.findTransactionByDescription(description, pageable);
    }



}
