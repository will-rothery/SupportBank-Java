package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TransactionManager {

    public ArrayList<String> lotsOfNames = new ArrayList<String>();
    public ArrayList<String> accountName = new ArrayList<String>();
    // public ArrayList<String> moneyOut = new ArrayList<String>();
    // public ArrayList<String> moneyIn = new ArrayList<String>();
       
    public void readData() {    
        String row = "";

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(
                "C:\\Users\\willr\\Desktop\\BP\\JavaBootcamp\\Lesson3\\SupportBank-Java\\Transactions2014.csv"));
            row = csvReader.readLine();
            row = csvReader.readLine();
            while (row != null) {
                String[] attributes = ((String) row).split(",");
                Transaction transaction = new Transaction(attributes[0], attributes[1], attributes[2], attributes[3], Double.parseDouble(attributes[4])); 
                row = csvReader.readLine();                
                lotsOfNames.add(attributes[1]);
                lotsOfNames.add(attributes[2]);
            }         
            for (String element : lotsOfNames) { 
                if (!accountName.contains(element)) { 
                    accountName.add(element); 
                } 
            }
            Collections.sort(accountName);
            // System.out.println(accountName);
            
            for (String name : accountName) {
                Account newAccount = new Account(name);
            }  
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }   
    }
}