package Workshop2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

public class BankAccount {

    private final String accountName;
    private final String accountNumber = UUID.randomUUID().toString().substring(8); 
    private float accountBalance;
    private LinkedList<String> transactionsPerformed = new LinkedList<String>();
    private boolean isClosed;
    private LocalDate createdDate;
    private LocalDate closedDate;
    // methods: deposit, withdraw,

    public BankAccount (String accountName) {
        this.accountName = accountName; 
    }

    public BankAccount (String accountName, float accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance; 
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LinkedList<String> getTransactionsPerformed() {
        return transactionsPerformed;
    }

    public void setTransactionsPerformed(LinkedList<String> transactionsPerformed) {
        this.transactionsPerformed = transactionsPerformed;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }

    public BankAccount createNewAccount(String username) {
        BankAccount newAccount = new BankAccount(username);
        newAccount.createdDate = LocalDate.now();
        newAccount.accountBalance = 0f; 
        newAccount.isClosed = false; 
        return newAccount; 
    }

    public BankAccount createNewAccount(String username, float userBalance) { 
        BankAccount newAccount = new BankAccount(username); 
        newAccount.setAccountBalance(userBalance);
        newAccount.createdDate = LocalDate.now();
        newAccount.isClosed = false; 
        return newAccount; 
    }

    public BankAccount deleteAccount (BankAccount userAccount) {
            userAccount.setAccountBalance(0f);
            userAccount.setClosedDate(LocalDate.now());
            userAccount.setTransactionsPerformed(null);
            userAccount.setClosed(true);
        return userAccount; 
    }

    public float deposit(float amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("NO NEGATIVE NUMBERS DUDE.");
        } else {
            System.out.printf("Depositted %f at %s.\n", amount, LocalDateTime.now().toString());

            this.accountBalance = accountBalance + amount; 

            System.out.printf("Your account has $%f remaining.\n", this.accountBalance);

            transactionsPerformed.add("Depositted " + amount + " at " + LocalDateTime.now().toString()); 
        }
        
        return accountBalance; 
    }

    public float withdraw (float amount) {
        if(amount > accountBalance || amount < 0) {
            throw new IllegalArgumentException ("Either you don't have enough money or it's an invalid amount.");
        } else {
            System.out.printf("Withdrew %f at %s.\n", amount, LocalDateTime.now().toString());

            this.accountBalance = accountBalance - amount;  

            System.out.printf("Your account has $%f remaining.\n", this.accountBalance);

            transactionsPerformed.add("Withdrew " + amount + " at " + LocalDateTime.now().toString()); 

        }
        return accountBalance; 
    }

}
