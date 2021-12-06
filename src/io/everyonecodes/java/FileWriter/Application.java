package io.everyonecodes.java.FileWriter;

import java.util.List;

public class Application {
    public static void main(String[] args) {
       FileWriter fileWriter = new FileWriter();

        fileWriter.write("src/io/everyonecodes/java/tb5_files/files/example/test1.txt", List.of("Hello", "World",
                "!"));
        fileWriter.append("src/io/everyonecodes/java/tb5_files/files/example/test2.txt",List.of(" How are you", "?"));
    }
}
