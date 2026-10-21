package Chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldStyleFiltering {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>();

        // Spunem explicit CUM să iterăm și să verificăm
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        System.out.println("Original list: " + numbers);
        System.out.println("Even numbers: " + evenNumbers);
    }
}

