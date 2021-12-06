package io.everyonecodes.java.FileReader;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> fileLines = fileReader.read("src/io/everyonecodes/java/tb5_files/files/document.txt");

        System.out.println(fileLines);
    }
}
