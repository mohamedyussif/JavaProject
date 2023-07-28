package bankingAccount;

public interface BankingSystem
{
    //abstracted main functions to perform on any account
    void createAccount(String accountHolderName, String accountNumber, double balance);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    double getBalance(String AccountNumber);
}
