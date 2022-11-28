Day 01 Workshop Software Development Foundation Objective

The objective of this workshop is to write a console based shopping cart with Java. The shopping cart will be stored with an appropriate collection type.

Setup
a. Create an accountonGithub.com.Youcanignorethisstepifyouhavean account.
b. CreatearepositoryonGithub
c. Open your IDE and create a Maven project
d. Make the project directory a Git repository
e. Add.gitignore to ignore the target directory
f. Add the remote repository (step b above) as the origin of your local repository

Workshop
Write a Java console program that allows a user to add, remove and list the contents of a shopping card.
The behaviour of the program is shown below. The > is the prompt

Welcome to your shopping cart
> list
Your cart is empty
> add apple
 apple added to cart
> add orange, pear
orange added to cart
pear added to cart
> list
1. apple
2. orange
3. pear
delete 2
orange removed from cart
> list
1. apple
2. pear
> add apple, grapes
You have apple in your cart
grapes added to cart
> list
1. apple
2. pear
 3. grapes
> delete 4
Incorrect item index

You are to implement the following commands
• list - list the contents of the cart. If the cart is empty, print an appropriate message. The contents of the cart should be numbered when you are listing them
• add - add one or more items to the cart. Multiple items are separated by a comma (,).
You should not add an item that is already in the cart. Print an appropriate message.
Item names are case sensitive (or you can try implementing case insensitive)
• delete - delete an item from the cart based on the item’s index (from list command). If an incorrect index is provided, display an error message
Submission
When you have completed your program, commit and push your code to the remote repository.
