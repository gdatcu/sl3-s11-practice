package workbook;

public class Ex4_GenericClass {
    public static void main(String[] args) {
        // Instanțiem clasa forțând T să fie String
        TestResult<String> stringResult = new TestResult<>("Login_UI", "PASSED_WITH_WARNINGS");
        stringResult.printSummary();

        // Instanțiem clasa forțând T să fie Integer
        TestResult<Integer> intResult = new TestResult<>("API_Status_Check", 200);
        intResult.printSummary();

        // Instanțiem clasa forțând T să fie Boolean
        TestResult<Boolean> boolResult = new TestResult<>("DB_Connection", true);
        boolResult.printSummary();
    }
}
