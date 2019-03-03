package by.epam.geometrysecond.exception;

public class EmptyListException extends CustomException
{
    public EmptyListException() {
        super();
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyListException(Throwable cause) {
        super(cause);
    }
}
