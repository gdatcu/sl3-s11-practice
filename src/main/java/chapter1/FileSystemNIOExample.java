package chapter1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileSystemNIOExample {

    public static void main(String[] args) throws IOException { // Main poate arunca IOException
        // Crearea unui obiect Path
        Path configPath = Paths.get("config", "test-settings.properties");
        Path dataPath = Paths.get("test-data");
        Path nonExistentPath = Paths.get("nonexistent.txt");

        // Verificarea existenței
        System.out.println("configPath exists? " + Files.exists(configPath));
        System.out.println("dataPath exists? " + Files.exists(dataPath));
        System.out.println("nonExistentPath exists? " + Files.exists(nonExistentPath)); // false

        // Verificarea dacă este fișier sau director
        if (Files.exists(dataPath)) {
            System.out.println("dataPath is directory? " + Files.isDirectory(dataPath));
            System.out.println("dataPath is regular file? " + Files.isRegularFile(dataPath));
        }

        // Obținerea căii absolute
        System.out.println("Absolute path for configPath: " + configPath.toAbsolutePath());

        // Crearea unui director nou (aruncă excepție dacă eșuează sau există deja)
        Path newDirPath = Paths.get("output-logs-nio");
        if (!Files.exists(newDirPath)) {
            try {
                Files.createDirectory(newDirPath); // createDirectory() creează un singur nivel
                // Files.createDirectories(newDirPath); // creează și directoarele părinte
                System.out.println("Directory output-logs-nio created.");
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
        }

        // Listarea fișierelor dintr-un director (folosind Stream API)
        if (Files.isDirectory(dataPath)) {
            System.out.println("\nFiles in " + dataPath.getFileName() + " (NIO):");
            try (Stream<Path> stream = Files.list(dataPath)) {
                stream.forEach(path -> System.out.println("- " + path.getFileName()));
            } catch (IOException e) {
                System.err.println("Failed to list directory contents: " + e.getMessage());
            }
        }
    }
}