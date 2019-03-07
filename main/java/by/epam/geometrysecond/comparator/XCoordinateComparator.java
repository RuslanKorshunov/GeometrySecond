package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Triangle;

import java.util.Comparator;

public class XCoordinateComparator implements Comparator<Triangle>
{
    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond)
    {
        Double xFirst=triangleFirst.getFirst().getX();
        Double xSecond=triangleSecond.getFirst().getX();
        return (xFirst.compareTo(xSecond));
    }
}
