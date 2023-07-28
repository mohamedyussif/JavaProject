package bankingAccount;

public class WithdrawTransaction extends Transaction
{

    //override perform method to execute deposit process
    @Override
    public void performTransaction(Account account, double amount)
    {
        account.withdraw(amount);
    }
}
