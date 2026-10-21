package chapter4;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamApiTest {

    // Sursă comună de date pentru teste
    private final List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "David");
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void testFilter() {
        // Păstrăm doar numele care încep cu "A"
        List<String> filtered = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        // Verificăm că am extras exact 2 nume și că acestea sunt Alice și Anna
        assertEquals(filtered.size(), 2);
        assertTrue(filtered.contains("Alice"));
        assertTrue(filtered.contains("Anna"));
    }

    @Test
    public void testMap() {
        // Transformăm fiecare număr în pătratul său
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        // Verificăm rezultatul transformării: [1, 4, 9, 16, 25]
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);
        assertEquals(squares, expected);
    }

    @Test
    public void testCollectAndMapToUpperCase() {
        // Transformăm în majuscule și colectăm într-o listă nouă
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(upperCaseNames.get(0), "ALICE");
        assertEquals(upperCaseNames.get(1), "BOB");
    }

    @Test
    public void testCount() {
        // Numărăm elementele din stream după filtrare
        long count = names.stream()
                .filter(name -> name.length() > 4) // Alice (5), Charlie (7), David (5)
                .count();

        assertEquals(count, 3L); // count() returnează un tip long
    }

    @Test
    public void testFindFirst() {
        // Căutăm primul nume care începe cu "B"
        Optional<String> firstB = names.stream()
                .filter(name -> name.startsWith("B"))
                .findFirst();

        assertTrue(firstB.isPresent());
        assertEquals(firstB.get(), "Bob");
    }

    @Test
    public void testMatchOperations() {
        // anyMatch: Verifică dacă BĂRĂM un element respectă condiția
        boolean anyStartWithC = names.stream().anyMatch(name -> name.startsWith("C"));
        assertTrue(anyStartWithC);

        // allMatch: Verifică dacă TOATE elementele sunt mai mari decât 0
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        assertTrue(allPositive);

        // noneMatch: Verifică dacă NICIUN element nu este negativ
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        assertTrue(noneNegative);
    }

    @Test
    public void testLazyBehavior() {
        // Un contor care se incrementează când un element trece prin filter
        AtomicInteger filterCounter = new AtomicInteger(0);

        // Pasul 1: Construim pipeline-ul (Sursă + Operație intermediară)
        var streamPipeline = names.stream()
                .filter(name -> {
                    filterCounter.incrementAndGet();
                    return name.startsWith("A");
                });

        // Demonstrație LAZY: Pentru că nu am apelat o operație terminală,
        // codul din interiorul filter() NU s-a executat încă!
        assertEquals(filterCounter.get(), 0, "Operațiile intermediare sunt lazy și nu ar trebui să ruleze încă!");

        // Pasul 2: Apelăm operația terminală (count)
        long total = streamPipeline.count();

        // Acum că am pus o operație terminală, tot pipeline-ul s-a declanșat
        assertEquals(total, 2L);
        assertEquals(filterCounter.get(), 5, "Acum operația intermediară a fost executată pentru toate cele 5 elemente!");
    }
}
