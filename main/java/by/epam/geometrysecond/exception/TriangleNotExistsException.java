package by.epam.geometrysecond.exception;

public class TriangleNotExistsException extends CustomException
{
    public TriangleNotExistsException() {
    }

    public TriangleNotExistsException(String message) {
        super(message);
    }

    public TriangleNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleNotExistsException(Throwable cause) {
        super(cause);
    }
}
