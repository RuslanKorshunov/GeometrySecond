package by.epam.geometrysecond.exception;

public class OpenFileException extends CustomException
{
    public OpenFileException() {
    }

    public OpenFileException(String message) {
        super(message);
    }

    public OpenFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenFileException(Throwable cause) {
        super(cause);
    }
}
