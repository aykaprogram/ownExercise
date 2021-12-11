package io.everyonecodes.java.tc5_ownExcercise;

import java.util.Scanner;

public class InputChecker {
    private Scanner scanner = new Scanner(System.in);
    private ExitVerifier exitVerifier = new ExitVerifier();

    public String checkInputForUserName() {
        String username = "";
        boolean invalidUsername = true;
        while (invalidUsername) {
            System.out.println("Enter your username! \nNot allowed: \n\tSemicolons\n\tDigit at beginning" +
                    "\n\tinput shorter than 2 characters: ");
            username = scanner.nextLine();

            if (exitVerifier.verifyExitInput(username))
                return "exit";



            if (username.contains(";") || Character.isDigit(username.charAt(0)) || !(username.length()>1))
                System.out.println("invalid username");
            else
                invalidUsername = false;

        }
        return username;
    }

    public String getValidUsername() {
        return checkInputForUserName();
    }

    public String checkInputForPassword() {
        String password = "";
        boolean invalidPassword = true;
        while (invalidPassword) {
            password = scanner.nextLine();

            if (exitVerifier.verifyExitInput(password))
                return "exit";



            if (password.contains(";") || Character.isDigit(password.charAt(0)) || !(password.length()>1))
                System.out.println("invalid password");
            else
                invalidPassword = false;

        }
        return password;
    }

    public String getValidPassword() {
        return checkInputForPassword();
    }
}
