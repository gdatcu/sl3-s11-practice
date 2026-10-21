package workbook;

// 1. Clasă custom pentru parsare
class LogEntry {
    String timestamp;
    String errorType;

    public LogEntry(String timestamp, String errorType) {
        this.timestamp = timestamp;
        this.errorType = errorType;
    }
    public String getErrorType() { return errorType; }
}
