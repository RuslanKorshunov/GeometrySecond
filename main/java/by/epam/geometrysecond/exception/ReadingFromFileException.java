package by.epam.geometrysecond.exception;

public class ReadingFromFileException extends CustomException
{
    public ReadingFromFileException() {
    }

    public ReadingFromFileException(String message) {
        super(message);
    }

    public ReadingFromFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadingFromFileException(Throwable cause) {
        super(cause);
    }
}
