package chapter1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInputFile {

    public static void main(String[] args) {
        String fileName = "input.txt"; // Fișierul trebuie să existe la rădăcina proiectului

        System.out.println("Reading content from: " + fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Failed to read file '" + fileName + "': " + e.getMessage());
        }
    }
}