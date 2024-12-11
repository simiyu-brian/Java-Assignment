public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(getAmount());
    }

    @Override
    public boolean reverse() {
        System.out.println("Reversing deposit transaction...");
        return true;
    }
}

