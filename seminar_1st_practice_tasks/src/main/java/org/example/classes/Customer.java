package org.example.classes;

import org.example.interfacess.ICustomer;
import java.util.HashMap;
import java.util.Map;



import org.example.interfacess.ICustomer;

public class Customer implements ICustomer {
    private String name;
    private String accountNumber;
    public int balance;

    public Customer(String name, String accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // ICustomer interface methods
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    @Override
    public void transfer(ICustomer receiver, int amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.deposit(amount); // use the deposit method of the receiver
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}
