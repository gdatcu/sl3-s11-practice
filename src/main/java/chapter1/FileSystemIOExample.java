package chapter1;

import java.io.File;
import java.io.IOException;

public class FileSystemIOExample {

    public static void main(String[] args) {
        // Crearea unui obiect File pentru un fișier existent sau inexistent
        File configFile = new File("config/test-settings.properties");
        File dataDir = new File("test-data");
        File nonExistentFile = new File("nonexistent.txt");

        // Verificarea existenței
        System.out.println("configFile exists? " + configFile.exists()); // Depinde dacă fișierul există
        System.out.println("dataDir exists? " + dataDir.exists());     // Depinde dacă directorul există
        System.out.println("nonExistentFile exists? " + nonExistentFile.exists()); // false

        // Verificarea dacă este fișier sau director
        if (dataDir.exists()) {
            System.out.println("dataDir is directory? " + dataDir.isDirectory());
            System.out.println("dataDir is file? " + dataDir.isFile());
        }

        // Obținerea căii absolute
        System.out.println("Absolute path for configFile: " + configFile.getAbsolutePath());

        // Crearea unui director nou (dacă nu există)
        File newDir = new File("output-logs");
        if (!newDir.exists()) {
            boolean created = newDir.mkdir(); // mkdir() creează un singur nivel
            // boolean created = newDir.mkdirs(); // mkdirs() creează și directoarele părinte necesare
            System.out.println("Directory output-logs created? " + created);
        }

        // Listarea fișierelor dintr-un director
        if (dataDir.isDirectory()) {
            System.out.println("\nFiles in " + dataDir.getName() + ":");
            File[] files = dataDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println("- " + f.getName());
                }
            }
        }
    }
}