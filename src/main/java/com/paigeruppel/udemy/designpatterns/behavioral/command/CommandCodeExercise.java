package com.paigeruppel.udemy.designpatterns.behavioral.command;

public class CommandCodeExercise {
}

class Command2 {
    enum Action {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command2(Action action, int amount) {
        this.action = action;
        this.amount = amount;
    }
}

class Account {
    public int balance;

    public void process(Command2 c) {
        switch (c.action) {
            case DEPOSIT:
                balance += c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                c.success = balance - c.amount >= 0;
                if (c.success) balance -= c.amount;
                break;
        }
    }
}