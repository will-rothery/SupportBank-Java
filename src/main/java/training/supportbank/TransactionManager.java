package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionManager {
    private final AccountManager accountManager;
    public ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    
    public TransactionManager(AccountManager accountManager) {
        this.accountManager = accountManager;
	}

	public void readData() {    
        String row = "";
        
        try {

            // file reader
            BufferedReader csvReader = new BufferedReader(new FileReader(
                "C:\\Users\\willr\\Desktop\\BP\\JavaBootcamp\\Lesson3\\SupportBank-Java\\Transactions2014.csv"));

            // reads first line (titles)
            row = csvReader.readLine();

            // reads rest of information
            row = csvReader.readLine();

            // takes data from cells and adds to array
            while (row != null) {
                String[] attributes = ((String) row).split(",");
                Transaction transaction = new Transaction(attributes[0], attributes[1], attributes[2], attributes[3], Double.parseDouble(attributes[4]));
                double amount = Double.parseDouble(attributes[4]);
                row = csvReader.readLine();   

                // print all transactions
//                System.out.println(transaction.getPersonFrom() + " Pays £" + Double.toString(transaction.getAmount()) + " to " + transaction.getPersonTo() + " for: " + transaction.getNarrative());
            
                
                // creates accounts, avoiding duplicates for all people in list
                Account accountFrom = accountManager.createAccount(attributes[1]);
                Account accountTo = accountManager.createAccount(attributes[2]);
                accountFrom.addTransactions(transaction);
                accountTo.addTransactions(transaction);

                // sets balance for accounts
                accountFrom.setBalance(accountFrom.getBalance() - amount);
                accountTo.setBalance(accountTo.getBalance() + amount);
            }
            csvReader.close();

            // prints all account name and balance
            // accountManager.printAllAccounts();

        }  
        catch (IOException e1) {
            e1.printStackTrace();
        }   
    }
}