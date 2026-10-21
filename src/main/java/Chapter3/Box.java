package Chapter3;

// Definim clasa Box cu un parametru de tip T
public class Box<T> {
    private T content; // Câmpul este de tipul generic T

    public void setContent(T content) { // Metoda acceptă un parametru de tip T
        this.content = content;
    }

    public T getContent() { // Metoda returnează un obiect de tip T
        return content;
    }

    public static void main(String[] args) {
        // Utilizare cu Integer: Specificăm tipul concret între <>
        Box<Integer> integerBox = new Box<>(); // Diamant operator <> inferează tipul
        integerBox.setContent(123);
        // integerBox.setContent("abc"); // EROARE DE COMPILARE! Tip incompatibil.
        int number = integerBox.getContent(); // Nu mai este nevoie de cast! Compilatorul știe că e Integer.
        System.out.println("Integer Box contains: " + number);

        // Utilizare cu String: Specificăm alt tip concret
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello Generics!");
        String text = stringBox.getContent(); // Nu e nevoie de cast!
        System.out.println("String Box contains: " + text);

        // Putem folosi orice tip (chiar și clase proprii)
        // Box<WebDriver> driverBox = new Box<>();
        // driverBox.setContent(new ChromeDriver());
        // WebDriver driver = driverBox.getContent();
    }
}