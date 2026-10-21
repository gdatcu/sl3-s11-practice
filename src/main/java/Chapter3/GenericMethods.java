package Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethods {

    // Metodă generică simplă care primește un array de orice tip (T)
    // și afișează elementele lui.
    public static <T> void printArray(T[] inputArray) {
        System.out.print("[ ");
        for (T element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }

    // Metodă generică care returnează primul element dintr-o listă
    // (sau null dacă lista e goală)
    public static <E> E getFirstElement(List<E> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        // Apelare printArray cu diferite tipuri de array-uri
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"A", "B", "C"};
        Double[] doubleArray = {1.1, 2.2, 3.3};

        System.out.println("Integer Array:");
        printArray(intArray); // Compilatorul inferează T = Integer

        System.out.println("\nString Array:");
        printArray(stringArray); // Compilatorul inferează T = String

        System.out.println("\nDouble Array:");
        printArray(doubleArray); // Compilatorul inferează T = Double


        // Apelare getFirstElement
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String first = getFirstElement(names); // Compilatorul inferează E = String
        System.out.println("\nPrimul nume: " + first);

        List<Integer> numbers = new ArrayList<>(); // Lista goala
        Integer firstNumber = getFirstElement(numbers);
        System.out.println("Primul numar: " + firstNumber); // Va afisa null
    }
}

