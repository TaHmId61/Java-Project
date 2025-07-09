package projectfiles;

import java.io.Serializable;

public class User implements Serializable {

    private String number;
    private String pin;
    private double balance;
    private String type;

    public User(String number, String pin, String type) {
        this.number = number;
        this.pin = pin;
        this.balance = 0;
        this.type = type;
    }

    public User(String number, String pin, double balance, String type) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
        this.type = type;

    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "User[number=" + number + ", pin=" + pin + ", balance=" + balance + ", type=" + type + "]";
    }
}
