package ui.Models;

import java.time.temporal.TemporalAmount;

public class DepositToCheckingModel {
    private String accountForDeposit;
    private double balance;
    private double depositAmount;
    private double newBalance;

    public DepositToCheckingModel(String accountForDeposit, double balance, double depositAmount, double newBalance) {
        this.accountForDeposit = accountForDeposit;
        this.balance = balance;
        this.depositAmount = depositAmount;
        this.newBalance = newBalance;
    }

    public String getAccountForDeposit() {
        return accountForDeposit;
    }

    public void setAccountForDeposit(String accountForDeposit) {
        this.accountForDeposit = accountForDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }
}
