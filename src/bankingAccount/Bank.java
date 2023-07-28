package bankingAccount;

public class Bank implements BankingSystem
{
    //declare array of objects, its type is Account to act as a database for ur bank
    private final Account[] accounts;

    //index for each account in the array
    private int numAccounts;

    //with each bank constructor it will construct an array of objects can hold 100 account
    public Bank()
    {
        accounts = new Account[100];
        numAccounts = 0;
    }

    //implement creating new account
    @Override
    public void createAccount(String accountHolderName, String accountNumber, double balance)
    {
        accounts[numAccounts++] = new Account(accountHolderName, accountNumber, balance);
    }

    //perform deposit process, first search on the account in the array and if it stored, it will perform transaction
    @Override
    public void deposit(String accountNumber, double amount)
    {
        Account account = findAccount(accountNumber);
        if (account == null)
        {
            System.out.println("Account number doesn't exist");
            return;
        }
        Transaction transaction = new DepositTransaction();
        transaction.performTransaction(account, amount);

    }

    //perform withdraw process, first search on the account in the array and if it stored, it will perform transaction
    @Override
    public void withdraw(String accountNumber, double amount)
    {
        Account account = findAccount(accountNumber);
        if (account == null)
        {
            System.out.println("Account number doesn't exist");
            return;
        }
        Transaction transaction = new WithdrawTransaction();
        transaction.performTransaction(account, amount);

    }

    //print the balance, first search on the account in the array and if it stored, it will print it
    @Override
    public double getBalance(String accountNumber)
    {
        Account account = findAccount(accountNumber);
        if (account == null)
        {
            System.out.println("Account number doesn't exist");
            return 0;
        }
        return account.getBalance();

    }

    //method of type accounts
    //method input: accountNumber
    //method purpose: seek with the entered account number in our array of object and
    // if it stored in this array then it will perform a specific functions on it like deposit or withdraw
    //if not exist, it will return null

    private Account findAccount(String accountNumber)
    {
        for (int index = 0; index < numAccounts; index++)
        {
            Account account = accounts[index];
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
    }
}
