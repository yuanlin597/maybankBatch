package com.example.restservice.entity;

import com.example.restservice.entity.Transaction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

//    @Id
//    @Column(name = "ID")
//    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private Long accountNumber;

    public Customer() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Customer(Long customerId, Long accountNumber) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

}
