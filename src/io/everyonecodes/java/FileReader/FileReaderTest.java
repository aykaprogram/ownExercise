package io.everyonecodes.java.FileReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileReaderTest {
   FileReader fileReader = new FileReader();

    @Test
    void read() {
        List<String> result = fileReader.read("src/io/everyonecodes/java/tb5_files/files/document.txt");
        List<String> expected = List.of("line 1;part 1-2", "line 2;part 2-2", "line 3;part 3-2");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void readEmpty() {
        List<String> result = fileReader.read("src/io/everyonecodes/java/tb5_files/files/document.tx");
        Assertions.assertTrue(result.isEmpty());
    }
}
