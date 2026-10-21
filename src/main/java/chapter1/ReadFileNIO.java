package chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadFileNIO {

    public static void main(String[] args) {
        Path filePath = Paths.get("config", "test-settings.properties"); // Asigură-te că fișierul există

        // Metoda 1: Citirea tuturor liniilor într-o listă (potrivit pentru fișiere mici)
        System.out.println("\nReading all lines at once using NIO:");
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8); // Specificăm encoding-ul
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file with readAllLines: " + e.getMessage());
        }

        // Metoda 2: Procesarea liniilor ca un Stream (mai eficient pentru fișiere mari)
        System.out.println("\nReading lines as a Stream using NIO:");
        // try-with-resources pentru a închide stream-ul automat
        try (Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file with Files.lines: " + e.getMessage());
        }
    }
}