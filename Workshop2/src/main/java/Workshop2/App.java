package Workshop2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        System.out.println("Welcome to your new bank account!");

        // testing for bank account 
        BankAccount jamesAccount = new BankAccount("James"); 
        BankAccount jackAccount = new BankAccount("Jack", 100); 

        jamesAccount.deposit(100);
        jamesAccount.withdraw(10);
        System.out.println(jamesAccount.getTransactionsPerformed()); 
        // end of testing 

        // testing for creating bank account via CLI input
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount("Temp"); 
        LinkedList<String> transaction = new LinkedList<String>();
        String userInput;
        float initialBalance;
        boolean exit = false;
        String dateTime = LocalDateTime.now().toString();
        String userInstructions;
        String[] splitString;
        String command;
        float amount;
        
        jackAccount.withdraw(20); 
        jackAccount.deposit(90);
        System.out.println(jackAccount.getTransactionsPerformed()); 

        System.out.print("Please key in the account holder's name: \n");
        userInput = scanner.nextLine();

        System.out.print("Please key in the initial balance if any: \n");
        try {
            initialBalance = scanner.nextFloat();
            if (initialBalance < 0) {
                System.out.println("NO NEGATIVE NUMBER DUDE, WILL INITIALIZE AS 0.");
                userAccount = userAccount.createNewAccount(userInput);
            } else if (initialBalance == 0) {
                userAccount = userAccount.createNewAccount(userInput);
            } else {
                userAccount = userAccount.createNewAccount(userInput, initialBalance);
            }
        } catch (Exception e) {
            System.out.println("Invalid input, balance will be initialised to 0.");
            initialBalance = 0f;
        }

        userInstructions = scanner.nextLine();

        while (!exit) {

            System.out.println("Please key in a command e.g. deposit/withdraw and the amount.\nTo exit, please send \"finish\".\nTo close your account, please send \"close\".");
            userInstructions = scanner.nextLine();
            splitString = userInstructions.split(" ", 2);
            if(splitString.length > 1) {
                command = splitString[0];
                try {
                    amount = Float.parseFloat(splitString[1]);
                } catch (Exception e) {
                    System.out.println("Please input a valid command and amount.");
                    amount = 0;
                }
            } else {
                command = userInstructions;
                amount = 0f;
            }

            switch (command) {
                case "deposit":
                    if(amount < 0) {
                        System.out.println("NO NEGATIVE AMOUNT DUDE.");
                    } else {
                        System.out.printf("Deposit %f at %s.\n", amount, dateTime);
                        userAccount.setAccountBalance(userAccount.getAccountBalance() + amount);
                        System.out.println(userAccount.getAccountBalance());
                        transaction.add("Deposit " + amount + " at " + dateTime);
                    }

                    break;

                case "withdraw":
                    if(amount > userAccount.getAccountBalance() || amount < 0) {
                        System.out.println("Either you don't have that much money or this is an invalid amount.");
                    } else {
                        System.out.printf("Withdrew %f at %s.\n", amount, dateTime);
                        userAccount.setAccountBalance(userAccount.getAccountBalance() - amount);
                        System.out.println(userAccount.getAccountBalance());
                        transaction.add("Withdrew " + amount + " at " + dateTime);
                        userAccount.setTransactionsPerformed(transaction);
                    }
                    break;

                case "close":
                    System.out.println("Thank you for banking with us, we are sad to see you go :(");
                    userAccount.deleteAccount(userAccount);
                    exit = true;
                    break;

                case "finish":
                    userAccount.setTransactionsPerformed(transaction);
                    System.out.println(userAccount.getTransactionsPerformed());
                    exit = true;
                    break;
            }

        }
        scanner.close();
        // end of testing 

        // testing FD account
        FixedDepositAccount jamesFixedDepositAccount = new FixedDepositAccount("James", 100); 
        
        System.out.println(jamesFixedDepositAccount.getAccountBalance());
        jamesFixedDepositAccount.deposit(100);
        jamesFixedDepositAccount.withdraw(100); 
        jamesFixedDepositAccount.updateInterest(7); 
        jamesFixedDepositAccount.updateInterestDuration(12); 
        jamesFixedDepositAccount.updateInterestDuration(3); 
        System.out.println(jamesFixedDepositAccount.getAccountBalance());
        // end of testing 
    }
}