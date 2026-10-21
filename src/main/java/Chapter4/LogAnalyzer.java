package Chapter4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogAnalyzer {

    public static void main(String[] args) {
        Path logFilePath = Paths.get("output-logs", "test-run.log"); // Presupunem că fișierul există
        String targetTestId = "TC-105";

        try (Stream<String> lines = Files.lines(logFilePath)) { // Obține stream de linii
            Set<String> uniqueErrorsForTest = lines
                    .filter(line -> line.contains("ERROR"))       // Păstrează doar liniile cu ERROR
                    .filter(line -> line.contains(targetTestId)) // Păstrează doar cele cu ID-ul țintă
                    .map(line -> line.substring(line.indexOf("ERROR:") + 6).trim()) // Extrage mesajul de eroare
                    .distinct()                                   // Elimină duplicatele
                    .collect(Collectors.toSet());                 // Colectează într-un Set

            System.out.println("Unique error messages for " + targetTestId + ":");
            if (uniqueErrorsForTest.isEmpty()) {
                System.out.println(" - None found -");
            } else {
                uniqueErrorsForTest.forEach(error -> System.out.println(" - " + error));
            }

        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }
}

