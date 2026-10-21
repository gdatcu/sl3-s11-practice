package chapter5;

// O clasă generică simplă pentru a stoca un rezultat și statusul său
public class TestResult<T> {
    private T testIdentifier;
    private String status; // Simplificat ca String pentru exemplu

    public TestResult(T testIdentifier, String status) {
        this.testIdentifier = testIdentifier;
        this.status = status;
    }

    public T getTestIdentifier() {
        return testIdentifier;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "testIdentifier=" + testIdentifier +
                ", status='" + status + '\'' +
                '}';
    }
}