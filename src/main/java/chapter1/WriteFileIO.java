package chapter1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteFileIO {

    public static void main(String[] args) {
        String outputPath = "output-logs/test-run.log";

        // try-with-resources pentru închidere automată și flush
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) { // true = append mode
            writer.write("Test run started at: " + LocalDateTime.now());
            writer.newLine(); // Adaugă o linie nouă (cross-platform)
            writer.write("Executing test case TC-001...");
            writer.newLine();
            writer.write("Test case TC-001 PASSED.");
            writer.newLine();
            writer.flush(); // Forțează scrierea buffer-ului pe disc (opțional aici datorită try-with-resources)
            System.out.println("Successfully wrote to log file: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            // e.printStackTrace();
        }
    }
}