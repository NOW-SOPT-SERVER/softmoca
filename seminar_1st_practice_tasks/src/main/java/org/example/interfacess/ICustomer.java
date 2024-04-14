package org.example.interfacess;

public interface ICustomer {
    void deposit(int amount);
    void withdraw(int amount);
    void transfer(ICustomer receiver, int amount);
    String getAccountNumber();



}

