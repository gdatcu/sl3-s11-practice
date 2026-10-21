package Chapter4;

import java.util.Arrays;
import java.util.List;

public class FilterMapWords {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "API", "Lambda", "rocks");

        System.out.println("Filtered and mapped words:");
        words.stream() // Obține stream
                .filter(word -> word.length() > 4) // Filtrează după lungime
                .map(String::toUpperCase) // Transformă în majuscule (method reference)
                // Echivalent cu: .map(word -> word.toUpperCase())
                .forEach(System.out::println); // Afișează fiecare rezultat (method reference)
        // Echivalent cu: .forEach(word -> System.out.println(word));
    }
}

