package training.supportbank;

import java.text.DecimalFormat;

public class TransactionFinder {
    private final AccountManager accountManager;

    public TransactionFinder(AccountManager dave) {
        this.accountManager = dave;
    }

    public void displayAccountTransactions(String accountName) {
        for (Account currentAccount : accountManager.accountList) {
            if (currentAccount.getName().contains(accountName)) {
                System.out.println("Name: " + currentAccount.getName());
                System.out.println("Balance: " + this.accountManager.decimalFormat.format(currentAccount.getBalance()));
                for (Transaction transaction : currentAccount.getTransactions()) {
                    System.out.println(transaction.getPersonFrom() + " Pays £" + Double.toString(transaction.getAmount()) + " to " + transaction.getPersonTo() + " for: " + transaction.getNarrative());
                }
//                break;
            }
        }
    }
}
