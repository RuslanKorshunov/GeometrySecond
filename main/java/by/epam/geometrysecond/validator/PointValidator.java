package by.epam.geometrysecond.validator;

public class PointValidator
{
    private static final String REGEX_FOR_VALID_POINT ="^[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+$";
    
    public static boolean validPoint(String point)
    {
        return point.matches(PointValidator.REGEX_FOR_VALID_POINT);
    }
}