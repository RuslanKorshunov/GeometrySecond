package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Triangle;

import java.util.Comparator;

public class IdComparator implements Comparator<Triangle>
{
    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond)
    {
        Long idFirst=triangleFirst.getTriangleId();
        Long idSecond=triangleSecond.getTriangleId();
        return (idFirst.compareTo(idSecond));
    }
}