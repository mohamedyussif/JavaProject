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
    public void createSavingAccount(String accountHolderName, String accountNumber, double balance)
    {
        accounts[numAccounts++] = new SavingAccount(accountHolderName, accountNumber, balance);

    }

    @Override
    public void createCheckingAccount(String accountHolderName, String accountNumber, double balance)
    {
        accounts[numAccounts++] = new CheckingAccount(accountHolderName, accountNumber, balance);

    }

    @Override
    public void login(String accountNumber)
    {

        if (findAccount(accountNumber) == null)
            System.out.println("Invalid user");
        else
            System.out.println("Login successfully");

    }

    @Override
    public void reviewAccountInformation(String AccountNumber)
    {
        if (findAccount(AccountNumber ) == null)
            System.out.println("Invalid user");
        else
        {
            Account account = findAccount(AccountNumber);
            System.out.println("Account Name: " + account.getAccountHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Balance: " + account.getBalance());
        }

    }


    //perform deposit process, first search on the account in the array and if it stored, it will perform transaction
    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);

        try {
            Transaction transaction = new DepositTransaction();
            transaction.performTransaction(account, amount);
        } catch (NullPointerException e) {
            System.out.println("Account is not existed");
        }
    }

    //perform withdraw process, first search on the account in the array and if it stored, it will perform transaction
    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);

        try {
            Transaction transaction = new WithdrawTransaction();
            transaction.performTransaction(account, amount);
        } catch (NullPointerException e) {
            System.out.println("Account is not existed");
        }
    }

    //print the balance, first search on the account in the array and if it stored, it will print it
    @Override
    public double getBalance(String accountNumber)
    {
        Account account = findAccount(accountNumber);
        if (account == null)
        {
            System.out.println("Account number doesn't exist");
        }
        return account.getBalance();

    }

    @Override
    public void calculateInterest(String AccountNumber)
    {
        Account account = findAccount(AccountNumber);
        if (findAccount(AccountNumber) == null)
            System.out.println("Account number doesn't exist");
        else if (findAccount(AccountNumber) instanceof CheckingAccount )
            System.out.println("Your account is a checking account so you cant perform this process");
        else {
            SavingAccount savingAccount = (SavingAccount) account;
            savingAccount.calculateInterest();
            System.out.println("Your account balance is: " + savingAccount.getBalance());
        }




    }

    @Override
    public void issueCheck(String AccountNumber, double checkAmount)
    {
        Account account = findAccount(AccountNumber);
        if (account == null) {
            System.out.println("Account not found");
        } else if (account instanceof CheckingAccount checkingAccount) {
            checkingAccount.issueCheck(checkAmount);
        } else if (account instanceof SavingAccount) {
            System.out.println("Your account is a savings account, so you cannot issue checks");
        }

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
