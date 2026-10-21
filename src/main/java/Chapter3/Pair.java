package Chapter3;

// Fisier: Pair.java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Metodă main pentru testare rapidă
    public static void main(String[] args) {
        // Pereche String -> Integer
        Pair<String, Integer> agePair = new Pair<>("Age", 30);
        System.out.println("Pair 1 - Key: " + agePair.getKey() + ", Value: " + agePair.getValue());

        // Pereche Integer -> String
        Pair<Integer, String> rolePair = new Pair<>(1, "Admin");
        System.out.println("Pair 2 - Key: " + rolePair.getKey() + ", Value: " + rolePair.getValue());
    }
}