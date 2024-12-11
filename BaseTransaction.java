import java.util.Calendar;
import java.util.UUID;

public abstract class BaseTransaction implements TransactionInterface {
    private double amount;
    private Calendar date;
    private String transactionID;

    public BaseTransaction(double amount) {
        this.amount = amount;
        this.date = Calendar.getInstance();
        this.transactionID = UUID.randomUUID().toString();
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    @Override
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;

    @Override
    public abstract boolean reverse();
}

