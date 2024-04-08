package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Customer {
    String name;
    String accountNumber;
    int balance;
    Map<String, Integer> history;

    Customer(String name, String accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.history = new HashMap<>();
    }

    void deposit(int amount) {
        balance += amount;
        history.put("Deposit", amount);
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            history.put("Withdraw", amount);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    void transfer(Customer receiver, int amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.balance += amount;
            history.put("Transfer to " + receiver.accountNumber, amount);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    void printHistory() {
        for (Map.Entry<String, Integer> entry : history.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Customer> customers = new HashMap<>();

    public static void main(String[] args) {
        System.out.print("생성할 고객 수 입력 > ");
        int customerCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < customerCount; i++) {
            System.out.print("고객 이름 입력 > ");
            String name = scanner.nextLine();
            System.out.print("계좌번호 입력 > ");
            String accountNumber = scanner.nextLine();
            System.out.print("초기 잔액 입력 > ");
            int initialBalance = scanner.nextInt();
            scanner.nextLine(); // consume newline
            customers.put(accountNumber, new Customer(name, accountNumber, initialBalance));
        }

        while (true) {
            System.out.print("로그인(계좌번호 입력) > ");
            String loginAccountNumber = scanner.nextLine();
            Customer currentCustomer = customers.get(loginAccountNumber);

            if (currentCustomer == null) {
                System.out.println("계좌번호가 잘못되었습니다.");
                continue;
            }

            boolean isLoggedOut = false;
            while (!isLoggedOut) {
                System.out.println("---------------------");
                System.out.println("   은행 프로그램   ");
                System.out.println("---------------------");
                System.out.println("1. 예금");
                System.out.println("2. 출금");
                System.out.println("3. 이체");
                System.out.println("4. 잔액 조회");
                System.out.println("5. 거래 내역 조회");
                System.out.println("0. 로그아웃");
                System.out.println("---------------------");
                System.out.print("선택 > ");

                int menu = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (menu) {
                    case 1:
                        System.out.print("예금 금액 입력 > ");
                        int depositAmount = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        currentCustomer.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("출금 금액 입력 > ");
                        int withdrawAmount = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        currentCustomer.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("이체할 계좌번호 입력 > ");
                        String receiverAccountNumber = scanner.nextLine();
                        Customer receiver = customers.get(receiverAccountNumber);
                        if (receiver == null) {
                            System.out.println("계좌번호가 잘못되었습니다.");
                        } else {
                            System.out.print("이체 금액 입력 > ");
                            int transferAmount = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            currentCustomer.transfer(receiver, transferAmount);
                        }
                        break;
                    case 4:
                        System.out.println("잔액: " + currentCustomer.balance + "원");
                        break;
                    case 5:
                        currentCustomer.printHistory();
                        break;
                    case 0:
                        System.out.println("로그아웃되었습니다.");
                        isLoggedOut = true;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
}