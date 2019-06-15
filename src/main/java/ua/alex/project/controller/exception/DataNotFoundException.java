package ua.alex.project.controller.exception;

public class DataNotFoundException extends RuntimeException {
    private String failedData;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String failedData) {
        this.failedData = failedData;

    }

    public DataNotFoundException(String message, String failedData ) {
        super(message);
        this.failedData = failedData;
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
