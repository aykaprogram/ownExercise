package io.everyonecodes.java.tc5_ownExcercise;

import java.util.List;
import java.util.Optional;

public class PasswordParser {
    int elementsPerLine = 1;
    int nameIndex = 0;
    int passwordIndex = 1;

    Optional<Password> parseValues(String name, String password) {
        Password user = new Password(name, password);
        return Optional.of(user);
    }

    public Optional<Password> parseLine(String line) {
        List<String> elements = List.of(line.split(";", -1));
        if (elements.size() != elementsPerLine) {
            return Optional.empty();
        }
        return parseValues(elements.get(nameIndex), elements.get(passwordIndex));
    }

}
