package com.paigeruppel.udemy.designpatterns.behavioral.command;

import java.util.Arrays;
import java.util.List;

public class BankAccountCommandDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        System.out.println(bankAccount);

        List<BankAccountCommand> commands = Arrays.asList(new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, 100), new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, 1000));

        for (BankAccountCommand c : commands) {
            c.execute();
            System.out.println(bankAccount);
        }
    }
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

interface Command {
    void execute();
}

class BankAccountCommand implements Command {
    private BankAccount account;



    public enum Action {
        DEPOSIT, WITHDRAW;
    }
    private Action action;

    private int amount;
    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void execute() {
        switch (action){
            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAW:
                account.withdraw(amount);
                break;
        }
    }
}