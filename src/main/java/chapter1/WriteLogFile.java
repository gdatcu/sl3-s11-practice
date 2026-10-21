package chapter1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteLogFile {

    public static void main(String[] args) {
        Path logDirPath = Paths.get("output-logs");
        Path logFilePath = logDirPath.resolve("activity.log"); // Creează calea completă

        try {
            // Creează directorul dacă nu există
            if (!Files.exists(logDirPath)) {
                Files.createDirectories(logDirPath);
                System.out.println("Created directory: " + logDirPath.toAbsolutePath());
            }

            // Formatter pentru timestamp
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

            // Scriem în fișier folosind append mode (true)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath.toString(), true))) {
                writer.write(LocalDateTime.now().format(formatter) + ": Application started.");
                writer.newLine();
                writer.write(LocalDateTime.now().format(formatter) + ": Processing data...");
                writer.newLine();
                System.out.println("Successfully appended logs to: " + logFilePath.toAbsolutePath());
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            // e.printStackTrace();
        }
    }
}