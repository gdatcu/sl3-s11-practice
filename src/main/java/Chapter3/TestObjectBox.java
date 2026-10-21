package Chapter3;

public class TestObjectBox {
    public static void main(String[] args) {
// Utilizare:
        ObjectBox box = new ObjectBox();
        box.setContent("Salut"); // Stochează un String
        box.setContent(123);      // Ups! Acum stochează un Integer

// Problema apare la recuperare:
// Object value = box.getContent(); // value este de tip Object
// String text = (String) value; // Necesită CAST manual!
// Integer number = (Integer) value; // Aruncă ClassCastException la runtime!
    }
}
