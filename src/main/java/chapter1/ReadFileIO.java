package chapter1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileIO {

    public static void main(String[] args) {
        String filePath = "config/test-settings.properties"; // Asigură-te că fișierul există

        System.out.println("Reading file using IO: " + filePath);

        // try-with-resources asigură închiderea automată a reader-ului
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            // Citește fișierul linie cu linie până la final (readLine() returnează null)
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + "--> " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            // Gestionează excepția (ex: fișier inexistent, probleme de permisiuni)
            System.err.println("Error reading file: " + e.getMessage());
            // Intr-un test real, aici ai putea arunca o excepție sau marca testul ca eșuat
            // e.printStackTrace(); // Util pentru debugging
        }
    }
}