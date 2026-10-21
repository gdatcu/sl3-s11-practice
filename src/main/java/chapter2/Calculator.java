package chapter2;

// Fisier: Calculator.java
public class Calculator {

    /**
     * Calculează suma a două numere.
     * @deprecated Folosiți {@link #sum(int, int)} în schimb. Această metodă va fi eliminată.
     * @param a Primul număr
     * @param b Al doilea număr
     * @return Suma numerelor
     */
    @Deprecated
    public int add(int a, int b) {
        System.out.println("Atenție: Se folosește metoda veche 'add'.");
        return a + b;
    }

    /**
     * Calculează suma a două numere (metoda preferată).
     * @param a Primul număr
     * @param b Al doilea număr
     * @return Suma numerelor
     */
    public int sum(int a, int b) {
        System.out.println("Se folosește metoda nouă 'sum'.");
        return a + b;
    }
}
