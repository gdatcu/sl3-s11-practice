package chapter2;

// Fisier: MainCalculator.java
public class MainCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Apelarea metodei depreciate - va genera un warning vizual în IDE
        // și posibil un warning la compilare (în funcție de setări)
        int oldSum = calc.add(5, 3);
        System.out.println("Rezultat (metoda veche): " + oldSum);

        System.out.println(); // Linie goală

        // Apelarea metodei noi
        int newSum = calc.sum(10, 7);
        System.out.println("Rezultat (metoda nouă): " + newSum);
    }
}
