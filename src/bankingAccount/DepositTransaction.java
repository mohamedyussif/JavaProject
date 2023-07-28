package bankingAccount;

public class DepositTransaction extends Transaction
{

    //override perform method to execute deposit process
    @Override
    public void performTransaction(Account account, double amount)
    {
        account.deposit(amount);
    }
}
