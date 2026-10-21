package Chapter4;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestInterfete {
    public static void main(String[] args) {

        // 1. Testare Predicate<T> (Metoda abstractă: test)
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("--- Test PREDICATE ---");
        System.out.println("Is 5 positive? " + isPositive.test(5));   // true
        System.out.println("Is -2 positive? " + isPositive.test(-2)); // false

        // 2. Testare Function<T, R> (Metoda abstractă: apply)
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("\n--- Test FUNCTION ---");
        System.out.println("Length of 'Java': " + stringLength.apply("Java")); // 4

        // 3. Testare Consumer<T> (Metoda abstractă: accept)
        Consumer<String> printMessage = msg -> System.out.println("LOG: " + msg);
        System.out.println("\n--- Test CONSUMER ---");
        printMessage.accept("Test started"); // Afișează: LOG: Test started

        // 4. Testare Supplier<T> (Metoda abstractă: get)
        Supplier<LocalDateTime> currentTime = () -> LocalDateTime.now();
        System.out.println("\n--- Test SUPPLIER ---");
        System.out.println("Current time: " + currentTime.get());
    }
}