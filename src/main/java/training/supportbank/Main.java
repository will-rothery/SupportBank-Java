package training.supportbank;

public class Main {
    public static void main(String args[]) {
        AccountManager accountManager = new AccountManager();
        TransactionManager inputData = new TransactionManager(accountManager);
        inputData.readData();
    }
}
