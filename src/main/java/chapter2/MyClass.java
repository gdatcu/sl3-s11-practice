package chapter2;

public class MyClass {

    @Deprecated // Adnotare aplicată pe câmp
    private int oldField;

    @Override // Adnotare aplicată pe metodă
    public String toString() {
        return "MyClass object";
    }

    @SuppressWarnings("unused") // Adnotare cu parametru, aplicată pe variabilă locală
    public void myMethod() {
        int unusedVariable = 10;
        // ... restul logicii ...
    }
}