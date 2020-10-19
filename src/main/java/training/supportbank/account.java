package training.supportbank;

import java.util.ArrayList;

public class Account {
    
    // getters and setters for accounts
    private String name;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public Account(String name, double balance) {
        this.name = name;
        this.balance = 0.0;
    }

	public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }    
}