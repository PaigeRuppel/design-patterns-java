package com.paigeruppel.udemy.designpatterns.behavioral.command;

public class BankAccountCommandDemo {
}

class BankAccount {
    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + "; Current balance is " + balance);
    }

    public void withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + "; Current balance is " + balance);
        } else {
            System.out.println("Withdrawl amount exceeds overdraft limit.");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}