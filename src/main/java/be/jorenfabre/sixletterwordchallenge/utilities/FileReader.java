package be.jorenfabre.sixletterwordchallenge.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    public static List<String> read(String fileName) {
        try {
            return Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            return null;
        }
    }
}
