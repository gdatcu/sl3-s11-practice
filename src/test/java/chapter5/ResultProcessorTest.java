package chapter5;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class ResultProcessorTest {

    private List<TestResult<String>> testResults; // Listă pentru a stoca rezultatele parsate

    // Metoda Setup: Citește fișierul înainte de rularea testelor
    @BeforeClass
    public void setup() {
        testResults = new ArrayList<>();
        // Folosim un path relativ la directorul de resurse
        String fileName = "test_results.txt";
        // Obținem path-ul complet folosind ClassLoader
        Path filePath = null;
        try {
            // Încercăm să obținem URL-ul resursei
            java.net.URL resourceUrl = getClass().getClassLoader().getResource(fileName);
            if (resourceUrl == null) {
                throw new IOException("Resource file not found: " + fileName);
            }
            filePath = Paths.get(resourceUrl.toURI());

            System.out.println("Reading data from: " + filePath);

            // Citim toate liniile folosind try-with-resources și Files.lines (care returnează un Stream)
            try (Stream<String> lines = Files.lines(filePath)) {
                testResults = lines
                        .map(line -> line.split(",")) // Împarte fiecare linie la virgulă -> String[]
                        .filter(parts -> parts.length == 2) // Păstrează doar liniile cu 2 părți
                        .map(parts -> new TestResult<>(parts[0].trim(), parts[1].trim())) // Creează obiecte TestResult<String>
                        .collect(Collectors.toList()); // Colectează rezultatele într-o listă
            }
            System.out.println("Successfully loaded " + testResults.size() + " test results.");

        } catch (IOException | NullPointerException | java.net.URISyntaxException e) {
            System.err.println("Failed to read or process test results file: " + e.getMessage());
            // Într-un test real, am putea folosi Assert.fail() aici
            testResults = new ArrayList<>(); // Asigurăm că lista nu e nullă
        }
    }

    // Metoda de Test: Procesează datele citite folosind Stream API
    @Test
    public void countFailedTests() {
        System.out.println("\nCounting failed tests using Stream API...");

        // Folosim stream pe lista deja populată în setup
        long failedCount = testResults.stream()
                .filter(result -> "FAILED".equalsIgnoreCase(result.getStatus())) // Filtrează după status FAILED
                .count(); // Numără elementele rămase

        System.out.println("Number of failed tests found: " + failedCount);

        // Verificare (Assertion) specifică TestNG/JUnit
        assertEquals(failedCount, 3, "Should have found 3 failed tests.");
        System.out.println("Assertion passed!");
    }
}

