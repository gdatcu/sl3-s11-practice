package workbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex8_MasterChallenge {
    public static void main(String[] args) {
        Path logFile = Paths.get("automated_test_results.csv");

        // PASUL A: Pregătirea datelor (Fișiere NIO)
        List<String> mockData = Arrays.asList(
                "10:00:01,SUCCESS",
                "10:05:22,TIMEOUT",
                "10:10:14,SUCCESS",
                "10:12:00,NULL_POINTER",
                "10:15:30,TIMEOUT",
                "10:20:00,TIMEOUT"
        );

        try {
            // Suprascriem fișierul cu datele de test
            Files.write(logFile, mockData);
            System.out.println("Fișier de log generat cu succes!\n");

            // PASUL B: Citirea și Procesarea (Stream-uri & Lambda)
            try (Stream<String> fileLines = Files.lines(logFile)) {

                long timeoutCount = fileLines
                        // Transformăm linia de text într-un Obiect de tip LogEntry
                        .map(line -> {
                            String[] parts = line.split(",");
                            return new LogEntry(parts[0], parts[1]);
                        })
                        // Filtrăm doar obiectele care au eroarea TIMEOUT
                        .filter(entry -> entry.getErrorType().equals("TIMEOUT"))
                        // Numărăm câte elemente au mai rămas în flux (stream)
                        .count();

                System.out.println("=== RAPORT EXECUTIE ===");
                System.out.println("Total erori de rețea (TIMEOUT) întâlnite: " + timeoutCount);
                if (timeoutCount > 2) {
                    System.out.println("STATUS: Eșec masiv al rețelei. Testele au fost blocate.");
                }

            }

            // (Opțional) Curățăm fișierul generat la final
            Files.deleteIfExists(logFile);

        } catch (IOException e) {
            System.err.println("Eroare de I/O critică: " + e.getMessage());
        }
    }
}




