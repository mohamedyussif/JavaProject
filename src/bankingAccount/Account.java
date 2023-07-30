package bankingAccount;

public class Account extends BankAccount
{
    // secondary data specific for each account
    private String email;
    private long mobileNumber;

    //Class constructor
    public Account(String accountHolderName, String accountNumber, double balance)
    {
        super(accountHolderName, accountNumber, balance);

    }

}
