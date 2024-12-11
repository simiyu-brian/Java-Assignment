public class WithdrawalTransaction extends BaseTransaction {
    private boolean isReversed;

    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < getAmount() && ba.getBalance() > 0) {
            double remainingBalance = ba.getBalance();
            ba.withdraw(remainingBalance);
            System.out.println("Partial withdrawal made: " + remainingBalance);
        } else if (ba.getBalance() >= getAmount()) {
            ba.withdraw(getAmount());
        } else {
            throw new InsufficientFundsException("Insufficient balance for withdrawal.");
        }
    }

    @Override
    public boolean reverse() {
        if (!isReversed) {
            System.out.println("Reversing withdrawal transaction...");
            isReversed = true;
            return true;
        }
        return false;
    }
}
