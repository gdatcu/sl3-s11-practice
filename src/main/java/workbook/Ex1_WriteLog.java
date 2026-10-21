package workbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Ex1_WriteLog {
    public static void main(String[] args) {
        // 1. Definim calea către director și fișier
        Path logDir = Paths.get("test-output");
        Path logFile = logDir.resolve("execution.log");

        try {
            // 2. Creăm directorul dacă nu există
            if (!Files.exists(logDir)) {
                Files.createDirectories(logDir);
                System.out.println("Director creat: " + logDir.toAbsolutePath());
            }

            // 3. Mesajul de logat
            String logMessage = "[" + LocalDateTime.now() + "] INFO: Login Test a rulat cu succes.\n";

            // 4. Scriem în fișier (Dacă nu există, îl creează. Dacă există, adaugă la final - APPEND)
            Files.writeString(logFile, logMessage,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            System.out.println("Log adăugat în: " + logFile.getFileName());

        } catch (IOException e) {
            System.err.println("Eroare la scrierea logului: " + e.getMessage());
        }
    }
}


