package com.example.restservice.repository;

import com.example.restservice.entity.Transaction;
import com.example.restservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT NEW com.example.restservice.entity.TransactionDetails(t.accountNumber, t.trxAmount, t.description, c.customerId, t.trxDate) FROM Transaction t INNER JOIN Customer c on t.accountNumber = c.accountNumber")
    List<TransactionDetails> findAllTransaction();
}
