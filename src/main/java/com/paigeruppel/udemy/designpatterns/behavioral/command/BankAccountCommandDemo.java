package com.paigeruppel.udemy.designpatterns.behavioral.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BankAccountCommandDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        System.out.println(bankAccount);

        List<Command> commands = Arrays.asList(new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, 100), new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, 1000));

        for (Command c : commands) {
            c.execute();
            System.out.println(bankAccount);
        }

        Collections.reverse(commands);
        for (Command c : commands) {
            c.undo();
            System.out.println(bankAccount);
        }

        Collections.reverse(commands);
    }
}

class BankAccount {
    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + "; Current balance is " + balance);
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + "; Current balance is " + balance);
            return true;
        }
        return false;
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
    void undo();
}

class BankAccountCommand implements Command {
    private BankAccount account;
    private boolean succeeded;


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
                succeeded = true;
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!succeeded) return;
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }

    }
}