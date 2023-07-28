package bankingAccount;

public abstract class Transaction
{
    //method input: account needed to perform transaction, amount needed to be transacted
    // transaction on the balance of the account
    public abstract void performTransaction(Account account, double amount);
}
