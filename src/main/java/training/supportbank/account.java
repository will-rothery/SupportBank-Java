package training.supportbank;

public class account {
    
    private String name;
    private double balance;


    public account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }
}