package io.everyonecodes.java.FileWriter;

import io.everyonecodes.java.FileReader.FileReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterTest {
    FileWriter writer = new FileWriter();
    FileReader reader = new FileReader();

    @Test
    void writeFile() {
        String contentRootPath = "src/io/everyonecodes/java/tb5_files/files/example/test1.txt";
        List<String> lines = List.of("Hello", "World", "!?");
        writer.write(contentRootPath, lines);
        List<String> result = reader.read(contentRootPath);
        List<String> expected = List.of("Hello", "World", "!?");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void writeNewFile() {
        String contentRootPath = "src/io/everyonecodes/java/tb5_files/files/example/test3.txt";
        List<String> lines = List.of("This is", "a test", "!");
        writer.write(contentRootPath,lines);
        List<String> result = reader.read(contentRootPath);
        List<String> expected = List.of("This is", "a test", "!");
        Assertions.assertEquals(expected, result);
    }

    @AfterAll
    void deleteTestFile() {
        Path path = Path.of("src/io/everyonecodes/java/tb5_files/files/example/test3.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
