package workbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex2_ReadLog {
    public static void main(String[] args) {
        Path logFile = Paths.get("test-output", "execution.log");

        if (!Files.exists(logFile)) {
            System.out.println("Fișierul nu există! Rulați mai întâi Exercițiul 1.");
            return;
        }

        System.out.println("--- Conținut Fișier ---");
        // try-with-resources închide stream-ul automat la final
        try (Stream<String> lines = Files.lines(logFile)) {
            // Afișăm fiecare linie în consolă
            lines.forEach(line -> System.out.println("-> " + line));
        } catch (IOException e) {
            System.err.println("Eroare la citire: " + e.getMessage());
        }
    }
}
