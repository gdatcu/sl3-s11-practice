package chapter4;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.time.LocalDateTime;
import java.util.function.*;

public class InterfeteFunctionaleTest {

    @Test
    public void testPredicate() {
        Predicate<Integer> isPositive = n -> n > 0;

        // În TestNG aserțiunile primesc opțional un mesaj la final
        assertTrue(isPositive.test(5));
        assertFalse(isPositive.test(-2));
    }

    @Test
    public void testFunction() {
        Function<String, Integer> stringLength = s -> s.length();

        // ATENȚIE: În TestNG ordinea este assertEquals(actual, expected)
        // În JUnit 5 era invers: assertEquals(expected, actual)
        assertEquals(stringLength.apply("Java"), 4);
    }

    @Test
    public void testSupplier() {
        Supplier<LocalDateTime> currentTime = () -> LocalDateTime.now();

        assertNotNull(currentTime.get());
    }
}

