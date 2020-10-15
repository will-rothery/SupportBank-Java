package training.supportbank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    public void readData() {    
        String row = "";

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(
                "C:\\Users\\willr\\Desktop\\BP\\JavaBootcamp\\Lesson3\\SupportBank-Java\\Transactions2014.csv"));
            List<Transaction> csvData = new ArrayList<>();
            row = csvReader.readLine();
            row = csvReader.readLine();
            while (row != null) {
                String[] attributes = ((String) row).split(",");
                Transaction transaction = new Transaction("a", "b", "c", "d", 0.0);
                csvData.add(transaction); 
                row = csvReader.readLine();
                System.out.println(transaction);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }   
    }
}

// public static void main( String[] args )
// {
//     int i;
//     String s;
//     Transaction t;
//     List<Transaction> myTransactionList;
//     Transaction[] myTransactions;

//     i = 123;
//     s = "123";
//     t = new Transaction();
//     myTransactionList = new ArrayList<>();
//     myTransactions = new Transaction[10];

//     t.date = "123";
//     t.from = "Bob";

//     myTransactionList.add(t);
    
//     // More code happens inbetween

//     Transaction will;
//     will = myTransactionList.get(0);
//     System.out.println(will.date);
// }tem.out.println(will.date);
// }tem.out.println(will.date);
// }