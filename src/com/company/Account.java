package com.company;

import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    Account(){}

    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double  getMonthlyInterestRate(){
        return  (annualInterestRate/100) / 12 ;
    }

    public double getMonthlyInterest(){
        return (balance * getMonthlyInterestRate());
    }

    public static double withDraw(double money, Account account){
        if(money > account.getBalance()){
            return 0;
        }else {
            account.setBalance((account.getBalance() + account.getMonthlyInterest()) - money);
            return account.getBalance();
        }
    }

    public static double deposit(double money, Account account){
        account.setBalance(account.getBalance()+money);
        return account.getBalance();
    }
}
