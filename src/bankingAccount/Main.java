package bankingAccount;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //new bank with system properties
        Bank bank = new Bank();
        System.out.println("Hello Sir, due to launching our bank and you are our first client you should create account to store it in our database and it's account number = 1");

        //index for account no that increment in each account creation
        int index = 1;

        System.out.println("Please enter your name:");
        String accountHolderName = input.nextLine();

        System.out.println("Please enter your initial balance:");
        double accountBalance = 0.0;
        boolean validInput = false;
        //loop and checking if the entered balance is valid balance or not
        while (!validInput) {
            try {
                accountBalance = input.nextDouble();
                input.nextLine(); // consume the newline character
                validInput = accountBalance >= 0;
                if (!validInput) {
                    System.out.println("Please enter a valid positive balance");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid balance");
                input.nextLine(); // consume the invalid input
            }
        }




        // variable store the value of account no that initiated by 1
        String accountNumber = String.valueOf(index);

        System.out.println("Please enter the type of your account\n1- Saving Account\n2- Checking Account");
        int accountType = input.nextInt();
        input.nextLine(); // consume the newline character

        // condition for validating on the choosen account type
        if (accountType == 1) {
            bank.createSavingAccount(accountHolderName, accountNumber, accountBalance);
            System.out.println("Account created successfully");
        }
        else if (accountType == 2) {
            bank.createCheckingAccount(accountHolderName, accountNumber, accountBalance);
            System.out.println("Account created successfully");
        }
        else
            System.out.println("Wrong choice, enter a valid choice next time");

        // review the info of the first account
        bank.reviewAccountInformation(accountNumber);
        System.out.println("-----------------------\n");
        System.out.println("Account created successfully");



        boolean isDone = false;
        //loop for making the program end when user choose
        do
        {
            System.out.println("Hello sir, please choose what do you want. \n1- Create Account\n2- Login with Account Number\n3- Perform a deposit process\n4- perform a withdraw process\n5- Review Account Information\n6- Calculate your interest\n7- Issue a check\n8- Goodbye");
            int choice = input.nextInt();
            input.nextLine();

            //loop check if user choose the right choice for performing his choosen process
            while (choice < 1 || choice > 9)
            {
                System.out.println("Please enter a valid choice");
                choice = input.nextInt();
                input.nextLine();
            }

            switch (choice) {
                //create new account and choose the type if its saving account or checking account and validate on the choice of account type
                case 1 -> {
                    System.out.println("Please Enter your name");
                    accountHolderName = input.nextLine();
                    accountNumber = String.valueOf(++index);
                    System.out.println("Please Enter your initial balance");
                    accountBalance = input.nextDouble();
                    input.nextLine(); // consume the newline character
                    System.out.println("Please enter the type of your account\n1- Saving Account\n2- Checking Account");
                    accountType = input.nextInt();
                    input.nextLine(); // consume the newline character
                    if (accountType == 1) {
                        bank.createSavingAccount(accountHolderName, accountNumber, accountBalance);
                        System.out.println("Account created successfully");
                    }
                    else if (accountType == 2) {
                        bank.createCheckingAccount(accountHolderName, accountNumber, accountBalance);
                        System.out.println("Account created successfully");
                    }
                    else
                        System.out.println("Wrong choice, enter a valid choice next time");


                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");

                }
                //login to existing account and check if the user insert valid account number or not
                case 2 -> {
                    System.out.println("please enter Account Number");
                    accountNumber = input.nextLine();
                    bank.login(accountNumber);
                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");
                }
                //perform deposit process on the account based on entering account no and validate if the user exist or not
                case 3 -> {
                    System.out.println("Please enter your account number");
                    accountNumber = input.nextLine();
                    System.out.println("Please enter the amount you need to deposit");
                    double amount = input.nextDouble();
                    input.nextLine();
                    bank.deposit(accountNumber, amount);
                    System.out.println("your amount = " + bank.getBalance(accountNumber));

                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");
                }

                //perform withdraw process on the account based on entering account no and validate if the user exist or not
                case 4 -> {
                    System.out.println("Please enter your account number");
                    accountNumber = input.nextLine();
                    System.out.println("Please enter the amount you need to deposit");
                    double amount = input.nextDouble();
                    input.nextLine();
                    bank.withdraw(accountNumber, amount);
                    System.out.println("your amount = " + bank.getBalance(accountNumber));

                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");
                }

                //review the account if by entering account no and check if this no is a valid account or not
                case 5 -> {
                    System.out.println("Please enter your account number");
                    accountNumber = input.nextLine();
                    bank.reviewAccountInformation(accountNumber);

                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");
                }

                //calculate interest for only saving accounts by entering account no
                case 6 -> {
                    System.out.println("Please enter your account number");
                    accountNumber = input.nextLine();
                    bank.calculateInterest(accountNumber);

                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");
                }

                //issue a check for only checking accounts by entering account no
                case 7 -> {
                    System.out.println("Please enter your account number");
                    accountNumber = input.nextLine();
                    System.out.println("Please Enter amount of check that need to withdraw from your account");
                    double checkAmount = input.nextDouble();
                    input.nextLine();
                    bank.issueCheck(accountNumber, checkAmount);

                    System.out.println("do you want something again, please enter yes");
                    String checkState = input.nextLine();
                    if (checkState.equalsIgnoreCase("yes"))
                        isDone = true;
                    else
                        System.out.println("GoodBye");
                }

                //the user exit from the applicatio
                case 8 -> {
                    System.out.println("Thank you, goodbye");
                    isDone = true;
                }
                default -> System.out.println("Please insert valid choice");
            }

        }
        while(isDone);



    }
}