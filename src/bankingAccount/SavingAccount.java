package bankingAccount;

public class SavingAccount extends Account
{
    public SavingAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public void calculateInterest()
    {
        System.out.println("Your balance after interest = " + (getBalance() + (getBalance() * 0.14)));
    }
}
