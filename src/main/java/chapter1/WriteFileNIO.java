package chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption; // Pentru a controla modul de scriere
import java.util.Arrays;
import java.util.List;

public class WriteFileNIO {

    public static void main(String[] args) {
        Path outputPath = Paths.get("output-logs", "test-report.txt");

        // Metoda 1: Scrierea unui singur String (suprascrie fișierul)
        try {
            Files.writeString(outputPath, "--- Test Report ---\n", StandardCharsets.UTF_8);
            System.out.println("Initial content written to " + outputPath.getFileName());

            // Adăugarea la fișier (append)
            Files.writeString(outputPath, "Test Case 1: PASSED\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(outputPath, "Test Case 2: FAILED\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            System.out.println("Appended results to " + outputPath.getFileName());

        } catch (IOException e) {
            System.err.println("Error using writeString: " + e.getMessage());
        }

        // Metoda 2: Scrierea unei colecții de linii (suprascrie)
        Path csvPath = Paths.get("output-logs", "users.csv");
        List<String> csvLines = Arrays.asList("username,password", "testuser,pass123", "admin,adminpass");
        try {
            Files.write(csvPath, csvLines, StandardCharsets.UTF_8); // Suprascrie implicit
            // Pentru append: Files.write(csvPath, csvLines, StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            System.out.println("\nCSV data written to " + csvPath.getFileName());
        } catch (IOException e) {
            System.err.println("Error using Files.write: " + e.getMessage());
        }
    }
}