public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("456", 0);

        DepositTransaction deposit = new DepositTransaction(0);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(0);

        try {
            // Testing Deposit
            deposit.apply(account);
            deposit.printTransactionDetails();
            System.out.println("Balance after deposit: " + account.getBalance());

            // Testing Withdrawal
            withdrawal.apply(account);
            withdrawal.printTransactionDetails();
            System.out.println("Balance after withdrawal: " + account.getBalance());

            // Reversing Transactions
            deposit.reverse();
            withdrawal.reverse();

        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
