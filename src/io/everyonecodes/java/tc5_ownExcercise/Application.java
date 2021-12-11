package io.everyonecodes.java.tc5_ownExcercise;

import io.everyonecodes.java.FileWriter.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriter();
        ElementSplitter elementSplitter = new ElementSplitter();
        InputChecker inputChecker = new InputChecker();

        boolean exit = true;
        while (exit) {
            List<String> usernames = elementSplitter.splitElementAndReturnUsernames();
            try {
                System.out.println("To exit the program, type exit!");
                String username = inputChecker.getValidUsername();
                if (username.equals("exit"))
                    return;

                System.out.println("Checking to see if username exists...");
                if (usernames.contains(username)) {
                    System.out.println("Username exists! Enter password for this user or leave(type 'exit'): ");


                    int counter = 1;
                    while (counter >= 0) {
                        String inputPW = inputChecker.getValidPassword();

                        if (inputPW.equals("exit"))
                            return;
                        if (elementSplitter.checkPasswordOfSpecificUser(username, inputPW)) {
                            System.out.println("Correct! User logged in!");
                            break;
                        } else {
                            System.out.println("Sorry, your username/password does not match our database. Contact the administrator.");
                            if(!(counter==0)) {
                                System.out.println("attempts left: 1");
                            }
                            counter--;
                        }

                    }
                    if (counter<0) {
                        System.out.println("User failed to log in. Exiting program.");
                        return;
                    }
                } else {
                    System.out.println("Username not in database, creating new user with username " + username);
                    System.out.println("Enter a password for new user:");
                    System.out.println("\nNot allowed: \n\tSemicolons\n\tDigit at beginning\n\tinput shorter than 2 characters");
                    String inputPW = inputChecker.getValidPassword();

                    if (inputPW.equals("exit"))
                        return;
                    List<String> temp = new ArrayList<>(List.of(username + ";" + inputPW));


                    fileWriter.append("src/io/everyonecodes/java/tc5_ownExcercise/passwords.csv", temp);
                    System.out.println("User with given password has been registered.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
