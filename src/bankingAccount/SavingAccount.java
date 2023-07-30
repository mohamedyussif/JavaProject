package bankingAccount;

public class SavingAccount extends Account
{
    public SavingAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //method for calculating interest by using inherited deposit method and use the balance of each account
    // and pass the balance * 0.14 to deposit method as argument to add the interest to the account balance
    public void calculateInterest()
    {
        double balance = getBalance();
        if (balance < 1)
            System.out.println("Insufficient funds to issue check");
        else
            deposit((balance * 0.14));
    }
}
