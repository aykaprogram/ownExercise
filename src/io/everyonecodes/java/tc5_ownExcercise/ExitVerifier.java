package io.everyonecodes.java.tc5_ownExcercise;

public class ExitVerifier {
    public boolean verifyExitInput (String input) {
        boolean verified = false;
        if (input.toLowerCase().equals("exit")) {
            verified = true;
            System.out.println("Exiting Program nya");
        }
        return verified;
    }

}
