package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TransactionManager {
    private AccountManager accountManager;
    
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
                System.out.println(transaction.getPersonFrom() + " Pays £" + Double.toString(transaction.getAmount()) + " to " + transaction.getPersonTo() + " for: " + transaction.getNarrative());
            
                
                // creates accounts, avoiding duplicates for all people in list
                accountManager.createAccount(attributes[1]);
                accountManager.createAccount(attributes[2]);

                // finds accounts
                Account accountFrom = accountManager.getAccount(attributes[1]);
                Account accountTo = accountManager.getAccount(attributes[2]);

                // sets balance for accounts
                accountFrom.setBalance(accountFrom.getBalance() - amount);
                accountTo.setBalance(accountTo.getBalance() + amount);
            }

            // prints all account name and balance
            // accountManager.printAllAccounts();          
        }  
        catch (IOException e1) {
            e1.printStackTrace();
        }   
    }
}