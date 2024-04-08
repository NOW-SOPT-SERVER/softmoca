package org.example.classes;

import org.example.interfacess.ICustomer;

import java.util.HashMap;
import java.util.Map;

public class Customer implements ICustomer {
    public String name;
    public String accountNumber;
    public int balance;
    public Map<String, Integer> history;

    public Customer(String name, String accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.history = new HashMap<>();
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

    public Map<String, Integer> getHistory() {
        return history;
    }

    public void setHistory(Map<String, Integer> history) {
        this.history = history;
    }

    // ICustomer interface methods
    @Override
    public void deposit(int amount) {
        balance += amount;
        history.put("Deposit", amount);
    }

    @Override
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            history.put("Withdraw", amount);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    @Override
    public void transfer(ICustomer receiver, int amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.deposit(amount); // use the deposit method of the receiver
            history.put("Transfer to " + receiver.getAccountNumber(), amount);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    public void printHistory() {
        for (Map.Entry<String, Integer> entry : history.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
