package bankingAccount;

public class CheckingAccount extends Account
{
    public CheckingAccount(String accountHolderName, String accountNumber, double balance)
    {
        super(accountHolderName, accountNumber, balance);
    }

    //method for issue  check by using inherited withdraw method and use the balance of each account
    // and pass the amount that want to withdraw to withdraw method as argument to add the interest to the account balance
    public void issueCheck(double checkAmount)
    {
        double balance = getBalance();
        if (balance < checkAmount)
            System.out.println("Insufficient funds to issue check");
        else
            withdraw(checkAmount);


    }
}
