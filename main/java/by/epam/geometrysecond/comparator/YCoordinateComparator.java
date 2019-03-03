package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class YCoordinateComparator implements Comparator<Triangle>
{
    private final static Logger logger= LogManager.getLogger(YCoordinateComparator.class.getName());

    public YCoordinateComparator()
    {
        logger.log(Level.INFO, "An object YCoordinateComparator was created");
    }

    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond)
    {
        Double yFirst=triangleFirst.getFirst().getY();
        Double y=triangleSecond.getFirst().getY();
        return (yFirst.compareTo(y));
    }
}
