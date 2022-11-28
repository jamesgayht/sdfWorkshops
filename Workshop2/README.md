Day 02 Workshop Software Development Foundation Objective

The objective of this workshop is to use object oriented techniques to model bank account Setup
a. CreateanewrepositoryonGithubforthisworkshop
b. OpenyourIDEandcreateaMavenproject
c. Add TestNG to pom.xml
d. MaketheprojectdirectoryaGitrepository
e. Add.gitignoretoignorethetargetdirectory
f. Add the remote repository (step b above) as the origin of your local repository

Workshop
Task 1
Write the following Java classes to model a bank account. The bank account should contain the following members and methods
BankAccount class
􏰀 Members - all members are private. You should provide getters and setters. o account holder’s name - string. This is a read only property viz. cannot be changed once it is set
o randomly generated account number - string
o account balance - float
o transactions for operations performed on the account - a list of strings o closed to indicate if this account has been closed - boolean
o account creating date
o account closing date
account holder’s name and account number are read only properties. They are set when this class is created and cannot be changed during the lifetime of the instance.

􏰀 Methods
o deposit - deposit some amount into the account. This operation should be added to the transactions list (above); for example, if $100 is added to the account, then you should add the following “deposit $100 at <date time>” to transaction list
Deposits only accepts positive amount. If an in correct amount is given or account is closed, throw an IllegalArgumentException.
o withdraw - withdraw some amount from the account. This operation should be added to the transactions list (above); for example, if $100 is added to the account, then you should add the following “withdraw $100 at <date time>” to transaction list
Deposits only accepts positive amount. If an in correct amount is given
or the account is closed, throw an IllegalArgumentException 􏰀 Constructor
o The first constructor has a single parameter which is the account holder’s name. Initialize the balance to 0
o The second constructor has 2 parameters; the first is the account holder’s name and the second is the initial account balance.

Task 2
Write FixedDepositAccount class
SamemembersandmethodsasBankAccountclass. Inaddition, FixedDepositAccount has the following variation in members, methods and constructors
􏰀 Members
o interest - float
o duration in months - integer
The default interest and duration is 3 and 6 respective. They can be changed but only once. Any subsequent attempt to change more than once will result in an IllegalArgumentException thrown
Once balance is set, it cannot be changed.
􏰀 Members
o withdraw() and deposit() methods will not update the account’s
balance viz. they will perform a NOP (no operation)
o getBalance() should return the balance plus the interest viz if
interest is 3 and balance is 100, the getBalance() should return 103 􏰀 Constructor

o The following are the constructors signature
􏰁 public FixedDepositAccount(String name, Float balance)
􏰁 public FixedDepositAccount(String name, Float balance, Float interest)
􏰁 public FixedDepositAccount(String name, Float balance, Float interest, Integer duration)

Task 3
Write test for the above 2 classes to ensure that they conform to the given specification
Submission
When you have completed your program, commit and push your code to the remote repository.
