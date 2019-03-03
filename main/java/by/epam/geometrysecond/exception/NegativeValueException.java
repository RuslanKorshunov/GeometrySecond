package by.epam.geometrysecond.exception;

public class NegativeValueException extends CustomException
{
    public NegativeValueException() {
        super();
    }

    public NegativeValueException(String message) {
        super(message);
    }

    public NegativeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeValueException(Throwable cause) {
        super(cause);
    }
}
