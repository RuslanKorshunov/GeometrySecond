package by.epam.geometrysecond.exception;

public class WorkWithFileException extends Exception {
    public WorkWithFileException() {
    }

    public WorkWithFileException(String message) {
        super(message);
    }

    public WorkWithFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkWithFileException(Throwable cause) {
        super(cause);
    }
}
