package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class XCoordinateComparator implements Comparator<Triangle>
{
    private final static Logger logger= LogManager.getLogger(XCoordinateComparator.class.getName());

    public XCoordinateComparator()
    {
        logger.log(Level.INFO, "An object XCoordinateComparator was created");
    }

    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond)
    {
        Double xFirst=triangleFirst.getFirst().getX();
        Double xSecond=triangleSecond.getFirst().getX();
        return (xFirst.compareTo(xSecond));
    }
}
