package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Triangle;
import java.util.Comparator;

public class YCoordinateComparator implements Comparator<Triangle>
{
    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond)
    {
        Double yFirst=triangleFirst.getFirst().getY();
        Double y=triangleSecond.getFirst().getY();
        return (yFirst.compareTo(y));
    }
}
