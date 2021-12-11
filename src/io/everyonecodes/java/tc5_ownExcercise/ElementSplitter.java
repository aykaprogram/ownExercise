package io.everyonecodes.java.tc5_ownExcercise;

import io.everyonecodes.java.FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;

public class ElementSplitter {

    private FileReader fileReader = new FileReader();
    String filePath = "src/io/everyonecodes/java/tc5_ownExcercise/passwords.csv";

    public List<List<String>> usernamesAndPasswordsSplitter() {
        List<String> usernamesAndPasswords = fileReader.read(filePath);
        List<List<String>> listOfSplitElements = new ArrayList<>();
        for (String x : usernamesAndPasswords) {
            List<String> elements = List.of(x.split(";"));
            listOfSplitElements.add(elements);
        }
        return listOfSplitElements;
    }

    public List<String> splitElementAndReturnUsernames() {
        List<String> usernames = new ArrayList<>();
        List<List<String>> listOfSplitElements = usernamesAndPasswordsSplitter();
        for (List<String> x : listOfSplitElements) {
            usernames.add(x.get(0));
        }
        return usernames;
    }

    public boolean checkPasswordOfSpecificUser(String username, String password) {
        List<List<String>> listOfSplitElements = usernamesAndPasswordsSplitter();
        for (List<String> x : listOfSplitElements) {
            if (x.get(0).equals(username))
                if (x.get(1).equals(password))
                    return true;

        }
        return false;
    }
}
