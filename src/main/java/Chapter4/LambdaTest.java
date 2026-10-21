package Chapter4;

import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {

        // 1. Fără parametri, returnează o valoare -> Folosim Supplier<T>
        Supplier<Integer> c1 = () -> 42;
        System.out.println("1: " + c1.get()); // Afișează 42

        // 2. Un parametru (inferat), returnează boolean -> Folosim Predicate<T>
        Predicate<Integer> c2 = n -> n % 2 == 0;
        System.out.println("2: " + c2.test(4)); // Afișează true

        // 3. Un parametru (explicit), returnează boolean -> Folosim Predicate<T>
        Predicate<Integer> c3 = (Integer n) -> n > 0;
        System.out.println("3: " + c3.test(-5)); // Afișează false

        // 4. Doi parametri (inferate), returnează valoare -> Folosim BiFunction<T, U, R>
        BiFunction<Integer, Integer, Integer> c4 = (a, b) -> a * b;
        System.out.println("4: " + c4.apply(3, 5)); // Afișează 15

        // 5. Doi parametri (explicite), bloc de cod cu return -> Folosim BiFunction<T, U, R>
        BiFunction<Integer, Integer, Integer> c5 = (Integer a, Integer b) -> {
            int sum = a + b;
            System.out.println("Calculating sum: " + sum);
            return sum;
        };
        int result5 = c5.apply(10, 20); // Afișează "Calculating sum: 30"

        // 6. Un parametru, nu returnează nimic (void) -> Folosim Consumer<T>
        Consumer<String> c6 = message -> System.out.println(message);
        c6.accept("Hello from Lambda!"); // Afișează "Hello from Lambda!"
    }
}
