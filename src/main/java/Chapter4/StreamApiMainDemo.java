package Chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamApiMainDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "David");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 1. Exemplu FILTER (Intermediară) + COLLECT (Terminală)
        System.out.println("--- 1. FILTER & COLLECT ---");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Nume care încep cu 'A': " + filteredNames); // [Alice, Anna]


        // 2. Exemplu MAP (Intermediară) + COLLECT (Terminală)
        System.out.println("\n--- 2. MAP & COLLECT ---");
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Păstratele numerelor: " + squares); // [1, 4, 9, 16, 25]

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nume cu majuscule: " + upperCaseNames);


        // 3. Exemplu FOREACH (Terminală)
        System.out.println("\n--- 3. FOREACH ---");
        names.stream().forEach(name -> System.out.println("Hello, " + name));


        // 4. Exemplu COUNT (Terminală)
        System.out.println("\n--- 4. COUNT ---");
        long countLongNames = names.stream()
                .filter(name -> name.length() > 4)
                .count();
        System.out.println("Număr de nume cu lungime > 4: " + countLongNames); // 3


        // 5. Exemplu FINDFIRST (Terminală) + OPTIONAL
        System.out.println("\n--- 5. FINDFIRST ---");
        Optional<String> firstB = names.stream()
                .filter(name -> name.startsWith("B"))
                .findFirst();

        if (firstB.isPresent()) {
            System.out.println("Primul nume care începe cu B: " + firstB.get()); // Bob
        }


        // 6. Exemple ANYMATCH / ALLMATCH / NONEMATCH (Terminale)
        System.out.println("\n--- 6. MATCHING ---");
        boolean anyStartWithC = names.stream().anyMatch(name -> name.startsWith("C"));
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);

        System.out.println("Există vreun nume cu 'C'? " + anyStartWithC); // true
        System.out.println("Sunt toate numerele > 0? " + allPositive);    // true
        System.out.println("Nu există niciun număr < 0? " + noneNegative); // true


        // 7. Demonstrație vizuală: Comportamentul LAZY (Leneș)
        System.out.println("\n--- 7. DEMONSTRAȚIE LAZY ---");
        AtomicInteger counter = new AtomicInteger(0);

        System.out.println("1. Construim pipeline-ul fără operație terminală...");
        var lazyStream = names.stream()
                .filter(name -> {
                    System.out.println("   [Filter rulat pentru: " + name + "]");
                    counter.incrementAndGet();
                    return name.startsWith("A");
                });

        System.out.println("   -> Valoare contor acum: " + counter.get());
        System.out.println("   (Observi că nu s-a printat nimic din interiorul filter-ului!)");

        System.out.println("2. Apelăm acum operația terminală (.count())...");
        long totalResult = lazyStream.count();

        System.out.println("   -> Rezultat count: " + totalResult);
        System.out.println("   -> Valoare contor la final: " + counter.get());
    }
}
