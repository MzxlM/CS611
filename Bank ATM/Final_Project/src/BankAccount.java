/**
*@ClassName:BankAccount
*@Description:A BankAccount object. It is super class of CheckingAccount,SavingAccount and SecurityAccount. It stores basic
 * information of a bank account.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public abstract class BankAccount {
    private int accountID;//id on DB
    private int userId; //userId on DB
    private String accountType; // saving checking or something
    private double balance; // how much money in it
    private Currency currency; // in what currency.

    //constructors
    public BankAccount(int accountID, int userId, String accountType, double amount, Currency currency) {
        this.accountID = accountID;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = amount;
        this.currency = currency;
    }

    //check if there's enough money on account
    public boolean hasEnoughBalance(double amount) {
        return !(amount > balance);
    }

    public abstract boolean canClose();


    //getters and setters
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
