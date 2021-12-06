package io.everyonecodes.java.tc5_ownExcercise;

import io.everyonecodes.java.FileReader.FileReader;
import io.everyonecodes.java.FileWriter.FileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();

        String filePath = "src/io/everyonecodes/java/tc5_ownExcercise/passwords.csv";


        Scanner scanner = new Scanner(System.in);
        try {
            String username ="";
            boolean usernameWithoutSemicolon = true;
            while (usernameWithoutSemicolon) {
                System.out.println("Enter your username: ");
                username = scanner.nextLine();
                if (username.contains(";"))
                    System.out.println("No semicolons in username allowed");
                else
                    usernameWithoutSemicolon = false;
            }
            System.out.println("Checking to see if username exists...");

            String line = "";
            List<String> usernamesAndPasswords = fileReader.read(filePath);
            List<String> usernames = new ArrayList<>();

            for (String x : usernamesAndPasswords) {
                List <String>elements = List.of(x.split(";"));
                usernames.add(elements.get(0));
            }


            if (usernames.contains(username)) {
                System.out.println("Username exists! Enter password for this user or leave(type 'exit'): ");
                String inputPW = scanner.nextLine();
                if (inputPW.equals("exit")){
                    System.out.println("Better try next time...");
                }
                boolean inputting = true;
                while (inputting) {
                    for (String y : usernamesAndPasswords) {
                        List <String>elements = List.of(y.split(";"));
                        if (username.equals(elements.get(0))) {
                            if (inputPW.equals(elements.get(1))) {
                                List<String> temp = new ArrayList<>(List.of(username + ";" + inputPW));
                                fileWriter.append("src/io/everyonecodes/java/tc5_ownExcercise/passwords.csv", temp);
                                System.out.println("Correct! User logged in!");
                                inputting = false;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Username not in database, creating new user with username " + username);
                System.out.println("Enter a password for new user:");
                String pw = scanner.nextLine();
                List<String> temp = new ArrayList<>(List.of(username + ";" + pw));


                fileWriter.append("src/io/everyonecodes/java/tc5_ownExcercise/passwords.csv", temp);
                System.out.println("User with given password has been registered.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
