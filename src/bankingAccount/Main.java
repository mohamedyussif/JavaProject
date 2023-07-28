package bankingAccount;


public class Main {
    public static void main(String[] args)
    {
        //new bank with system properties
        Bank bank = new Bank();

        //create bank account
        bank.createAccount("MohamedYoussif", "123", 1000);

        //deposit money into the account
        bank.deposit("123", 100);

        //withdraw money into the account
        bank.withdraw("123", 200);

        //get the account balance
        double balance = bank.getBalance("123");
        System.out.println(balance);

        //create savingAccount and get interest for its balance
        SavingAccount savingAccount = new SavingAccount("Mohamedyussif", "456", 2000);
        savingAccount.calculateInterest();

        //create git  account that issue its checks
        CheckingAccount checkingAccount = new CheckingAccount("MohamedYoussif", "789", 3000);
        checkingAccount.issueCheck();

        // check the output of any banking process if I entered invalid account number
        bank.deposit("012", 1000);



    }
}