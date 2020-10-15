package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TransactionManager {

    public ArrayList<String> lotsOfNames = new ArrayList<String>(); 
    public ArrayList<String> accountName = new ArrayList<String>();
    public ArrayList<String> moneyOut = new ArrayList<String>();
    // public ArrayList<String> moneyIn = new ArrayList<String>();
       
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

            // takes data from cells and adds to array (leaving space for balances later (moneyOut.add(attributes[?]);))
            while (row != null) {
                String[] attributes = ((String) row).split(",");
                Transaction transaction = new Transaction(attributes[0], attributes[1], attributes[2], attributes[3], Double.parseDouble(attributes[4])); 
                row = csvReader.readLine();                
                lotsOfNames.add(attributes[1]);
                lotsOfNames.add(attributes[2]);
            
                }
            }
            
            // removes duplicates from array and sorts it
            for (String element : lotsOfNames) { 
                if (!accountName.contains(element)) { 
                    accountName.add(element); 
                } 
            }
            Collections.sort(accountName);

            // calls new account for every name in array
            for (String name : accountName) {
                Account newAccount = new Account(name);
            }  
        } 

        catch (IOException e1) {
            e1.printStackTrace();
        }   
    }
}
