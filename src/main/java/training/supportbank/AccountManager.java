package training.supportbank;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class AccountManager {

    public ArrayList<Account> accountList = new ArrayList<Account>();

    public static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    // creates accounts avoiding duplicates and sets initial balance
    public Account createAccount(String name) {
        if (checkAccounts(name)) {
            return getAccount(name);
        } else {
            Account newAccount = new Account(name, 0.0);
            storeAccounts(newAccount);
            return newAccount;
        }
    }

    // stores accounts
    public void storeAccounts(Account newAccount) {
        accountList.add(newAccount);
    }

    // checks account list for duplicates
    public boolean checkAccounts(String name) {
        for (Account currentAccount : accountList) {
            String currentAccountName = currentAccount.getName();
            if (currentAccountName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    // prints accounts
    public void printAllAccounts() {
        for (Account currentAccount : accountList) {
            double preciseBalance = currentAccount.getBalance();
            System.out.println("Name: " + currentAccount.getName());
            System.out.println("Balance: " + decimalFormat.format(preciseBalance));
        }
    }

    // gets account from list by name
    public Account getAccount(String name) {
        for (Account currentAccount : accountList) {
            String currentAccountName = currentAccount.getName();
            if (currentAccountName.equals(name)) {
                return currentAccount;
            }
        }
        return null;
    }
}