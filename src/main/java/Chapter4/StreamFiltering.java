package Chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFiltering {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Spunem CE vrem: filtrează numerele pare și colectează-le într-o listă
        List<Integer> evenNumbers = numbers.stream() // 1. Obține un stream din listă
                .filter(n -> n % 2 == 0) // 2. Filtrează (folosind o lambda)
                .collect(Collectors.toList()); // 3. Colectează rezultatele

        System.out.println("Original list: " + numbers);
        System.out.println("Even numbers (Stream): " + evenNumbers);
    }
}