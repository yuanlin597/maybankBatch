package com.example.restservice.repository;

import com.example.restservice.entity.Transaction;
import com.example.restservice.entity.TransactionDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT NEW com.example.restservice.entity.TransactionDetails(t.id, t.accountNumber, t.trxAmount, t.description, c.customerId, t.trxDate) FROM Transaction t INNER JOIN Customer c on t.accountNumber = c.accountNumber")
    List<TransactionDetails> findAllTransaction(Pageable pageable);

    @Query("UPDATE Transaction set accountNumber = :accountNumber , trxAmount = :trxAmount , description = :description , trxDate = :trxDate where id = :id ")
    @Modifying
    void updateTransaction(@Param("id") Long id, @Param("accountNumber") Long accountNumber, @Param("trxAmount") BigDecimal trxAmount, @Param("description") String description, @Param("trxDate") Date trxDate);

    @Query("SELECT NEW com.example.restservice.entity.TransactionDetails(t.id, t.accountNumber, t.trxAmount, t.description, c.customerId, t.trxDate) FROM Transaction t INNER JOIN Customer c on t.accountNumber = c.accountNumber where c.accountNumber = :accountNumber")
    List<TransactionDetails> findTransactionByAccountNumber(@Param("accountNumber") Long accountNumber, Pageable pageable);

    @Query("SELECT NEW com.example.restservice.entity.TransactionDetails(t.id, t.accountNumber, t.trxAmount, t.description, c.customerId, t.trxDate) FROM Transaction t INNER JOIN Customer c on t.accountNumber = c.accountNumber where c.customerId = :customerId")
    List<TransactionDetails> findTransactionByCustomerId(@Param("customerId") Long customerId, Pageable pageable);

    @Query("SELECT NEW com.example.restservice.entity.TransactionDetails(t.id, t.accountNumber, t.trxAmount, t.description, c.customerId, t.trxDate) FROM Transaction t INNER JOIN Customer c on t.accountNumber = c.accountNumber where t.description like %:description%")
    List<TransactionDetails> findTransactionByDescription(@Param("description") String description, Pageable pageable);

}
