package workbook;

class TestResult<T> {
    private String testName;
    private T resultData; // T devine tipul datelor stocate

    public TestResult(String testName, T resultData) {
        this.testName = testName;
        this.resultData = resultData;
    }

    public void printSummary() {
        System.out.println("Test: " + testName + " | Result: " + resultData + " (Tip: " + resultData.getClass().getSimpleName() + ")");
    }
}