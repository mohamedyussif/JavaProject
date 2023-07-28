package bankingAccount;

public class CheckingAccount extends Account
{
    public CheckingAccount(String accountHolderName, String accountNumber, double balance)
    {
        super(accountHolderName, accountNumber, balance);
    }

    public void issueCheck()
    {
        System.out.println("you have a valid check to issue with value" + getBalance());
    }
}
