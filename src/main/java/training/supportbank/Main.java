package training.supportbank;

public class Main {
    public static void main(String args[]) {

        // calls account manager
        AccountManager accountManager = new AccountManager();

        // calls transaction manager
        TransactionManager transactionManager = new TransactionManager(accountManager);
        transactionManager.readData();
    }
}
