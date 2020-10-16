package training.supportbank;

public class Transaction {

    // getters and setters for transactions
    private String date;
    private String personFrom;
    private String personTo;
    private String narrative;
    static double amount;
	    
    public Transaction(String date, String personFrom, String personTo, String narrative, double amount) {
		this.date = date;
		this.personFrom = personFrom;
		this.personTo = personTo;
		this.narrative = narrative;
		Transaction.amount = amount;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(String personFrom) {
        this.personFrom = personFrom;
    } 

    public String getPersonTo() {
        return personTo;
    }

    public void setPersonTo(String personTo){
        this.personTo = personTo;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative){
        this.narrative = narrative;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount){
        Transaction.amount = amount;
    }
} 