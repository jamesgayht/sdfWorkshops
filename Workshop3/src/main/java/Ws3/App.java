package Ws3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart!");
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> cartItems = new LinkedList<String>();
        boolean hasNext = true;
        

        while (hasNext) {
            System.out.print("Input command here > ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            int inputWordCount = userInput.indexOf(' ');
            String userCommand;

            if (inputWordCount > 1) {
                userCommand = userInput.substring(0, inputWordCount);
            } else {
                userCommand = userInput;
            }

            switch (userCommand) {
                case "login": 
                    if(inputWordCount < 2) {
                        System.out.println("Please input your username to login.");

                    } else {
                        try {
                            String username = userInput.substring(inputWordCount);
                            File userDb = new File("/Users/jumo/Downloads/NUS_VTTP/VTTP_Workshops/Workshop3/cartdb/" + username + ".db");
                            if(userDb.createNewFile()) {
                                System.out.println("New database created, userDb = " + userDb);
                            } else {
                                System.out.println("Database already exist, fetching contents ... ");
                                InputStream is = new FileInputStream(userDb);
                                InputStreamReader isr = new InputStreamReader(is);
                                BufferedReader br = new BufferedReader(isr); 
                            }
                        } catch (Exception e) {
                            System.out.println("An error occured.");
                            e.printStackTrace();
                        }
                    }                        
            
                case "add":
                    if (inputWordCount < 2) {
                        System.out.println("Please name an item to be added.");
                        
                    } else {
                        String userItems = userInput.substring(inputWordCount);
                        String[] itemsToAdd = userItems.split(",");
                        String item;

                        if (cartItems.size() == 0) {
                            for (int i = 0; i < itemsToAdd.length; i++) {
                                item = itemsToAdd[i].trim();
                                System.out.printf("Added %s to cart. \n", item);
                                cartItems.add(item);
                            }

                        } else {
                            for (int i = 0; i < itemsToAdd.length; i++) {
                                item = itemsToAdd[i].trim();
                                boolean isFound = false;
                                for (int j = 0; j < cartItems.size(); j++) {
                                    if (item.equals(cartItems.get(j))) {
                                        System.out.println("Item already exists.");
                                        isFound = true;
                                        break;
                                    }
                                }

                                if (!isFound) {
                                    System.out.printf("Added %s to cart.\n", item);
                                    cartItems.add(item);
                                }
                            }
                        }
                    }
                    break;

                case "list":
                    if (cartItems.size() == 0) {
                        System.out.println("Your cart is empty.");
                    } else {
                        for (int i = 0; i < cartItems.size(); i++) {
                            int cartIndex = i + 1;
                            System.out.printf("%d. %s \n", cartIndex, cartItems.get(i));
                        }
                    }
                    break;

                case "delete":
                    if (inputWordCount < 2) {
                        System.out.println("Please provide an index for deletion.");
                    } else {
                        try {
                            int delIndex = Integer.parseInt(userInput.substring(inputWordCount).trim());
    
                            if (delIndex > cartItems.size()) {
                                System.out.println("Invalid index, please use list to check items.");
                            } else {
                                System.out.printf("Deleted %d. %s \n", delIndex, cartItems.get(delIndex - 1));
                                cartItems.remove((delIndex - 1));
                            }
                            
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Please use index for deletion");
                        }
                    }
                    break;

                case "exit":
                    hasNext = false;
                    break;
                
                default: 
                    System.out.println("Invalid command, please use \"add, delete, list or exit\".");
            }
        }

        scanner.close();
    }
}
