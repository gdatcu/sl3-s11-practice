package Chapter3;

// Fisier: GenericSearch.java
public class GenericSearch {

    /**
     * Găsește indexul primei apariții a unui element într-un array generic.
     * Folosește Objects.equals() pentru a gestiona corect valorile null.
     * @param array Array-ul în care se caută.
     * @param elementToFind Elementul de căutat.
     * @param <T> Tipul elementelor din array.
     * @return Indexul primei apariții sau -1 dacă nu este găsit.
     */
    public static <T> int findElement(T[] array, T elementToFind) {
        if (array == null) {
            return -1; // Sau aruncă IllegalArgumentException
        }
        for (int i = 0; i < array.length; i++) {
            // Folosim Objects.equals pentru a compara corect, inclusiv null-uri
            if (java.util.Objects.equals(array[i], elementToFind)) {
                return i; // Am găsit elementul, returnăm indexul
            }
        }
        return -1; // Elementul nu a fost găsit
    }

    public static void main(String[] args) {
        // Test cu String-uri
        String[] names = {"Alice", "Bob", "Charlie", "Bob"};
        int indexBob = findElement(names, "Bob"); // Ar trebui să fie 1 (prima apariție)
        int indexDavid = findElement(names, "David"); // Ar trebui să fie -1
        int indexNull = findElement(names, null); // Ar trebui să fie -1 (dacă nu există null în array)

        System.out.println("Index of 'Bob': " + indexBob);
        System.out.println("Index of 'David': " + indexDavid);
        System.out.println("Index of null: " + indexNull);


        // Test cu Integer-i
        Integer[] numbers = {10, 20, 30, 20};
        Integer twenty = 20; // Folosim obiect Integer
        int index20 = findElement(numbers, twenty); // Ar trebui să fie 1
        int index40 = findElement(numbers, 40); // Ar trebui să fie -1

        System.out.println("\nIndex of 20: " + index20);
        System.out.println("Index of 40: " + index40);

        // Test cu null in array
        String[] namesWithNull = {"Alice", null, "Charlie"};
        int indexOfNullInArray = findElement(namesWithNull, null); // Ar trebui să fie 1
        System.out.println("Index of null in namesWithNull: " + indexOfNullInArray);
    }
}

