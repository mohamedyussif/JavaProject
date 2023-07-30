package bankingAccount;

public interface BankingSystem
{
    //absract function for creating saving account
    void createSavingAccount(String accountHolderName, String accountNumber, double balance);

    //absract function for creating checking account
    void createCheckingAccount(String accountHolderName, String accountNumber, double balance);

    //absract function for login to existing account
    void login(String accountNumber);

    //absract function for review account info
    void reviewAccountInformation(String AccountNumber);

    //absract function for deposit on existing account
    void deposit(String accountNumber, double amount);

    //absract function for withdraw on existing account
    void withdraw(String accountNumber, double amount);

    //absract function for getbalance of existing account
    double getBalance(String AccountNumber);

    //absract function for calculate interest on existing saving account
    void calculateInterest(String AccountNumber);

    //absract function for issue a check from checking account
    void issueCheck(String AccountNumber, double checkAmount);
}
