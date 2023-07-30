package bankingAccount;

public class BankAccount
{
    //Main properties for any bank account
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    //Class constructor
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //get AccountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }

    //set AccountHolderName
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    //get accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    //get accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //method input: amount needed to deposit
    //method output: recalculate the balance

    public void deposit(double amount)
    {
        if (amount <= 0)
            System.out.println("Please enter value greater than one");
        else
            balance += amount;
    }

    //method input: amount needed to withdraw
    //method output: recalculate the balance
    public void withdraw(double amount)
    {
        if (balance < amount)
            System.out.println("Your balance is less than the needed amount");
        else
            balance -= amount;

    }

    //get balance
    public double getBalance() {
        return balance;
    }

    //set balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
