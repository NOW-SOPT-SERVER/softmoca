package org.example.classes;

import org.example.interfacess.ICustomer;

import java.util.HashMap;
import java.util.Map;

public class Account extends Customer {
    private Map<String, Integer> history;

    public Account(String name, String accountNumber, int balance) {
        super(name, accountNumber, balance);
        this.history = new HashMap<>();
    }

    // getter and setter methods for history
    public Map<String, Integer> getHistory() {
        return history;
    }

    public void setHistory(Map<String, Integer> history) {
        this.history = history;
    }

    // Override the methods of Customer to include history
    @Override
    public void deposit(int amount) {
        super.deposit(amount);
        history.put("Deposit", amount);
    }

    @Override
    public void withdraw(int amount) {
        if (getBalance() >= amount) {
            super.withdraw(amount);
            history.put("Withdraw", amount);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    @Override
    public void transfer(ICustomer receiver, int amount) {
        if (getBalance() >= amount) {
            super.transfer(receiver, amount);
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
