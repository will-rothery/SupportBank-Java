package training.supportbank;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        // calls account manager
        AccountManager accountManager = new AccountManager();

        // calls transaction manager
        TransactionManager transactionManager = new TransactionManager(accountManager);
        transactionManager.readData();

        // find transactions
        TransactionFinder transactionFinder = new TransactionFinder(accountManager);
        Scanner scanner = new Scanner(System.in);
        String accountName = "";

        // loop until exit is called
        while (!accountName.equalsIgnoreCase("exit")) {
            System.out.println("Please enter account name:");
            accountName = scanner.nextLine();
            if (!accountName.equalsIgnoreCase("exit")) {
                transactionFinder.displayAccountTransactions(accountName);
            }
        }
    }
}


