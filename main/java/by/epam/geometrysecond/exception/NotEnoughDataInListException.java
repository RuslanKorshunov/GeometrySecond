package by.epam.geometrysecond.exception;

public class NotEnoughDataInListException extends CustomException
{
    public NotEnoughDataInListException() {
        super();
    }

    public NotEnoughDataInListException(String message) {
        super(message);
    }

    public NotEnoughDataInListException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughDataInListException(Throwable cause) {
        super(cause);
    }
}
