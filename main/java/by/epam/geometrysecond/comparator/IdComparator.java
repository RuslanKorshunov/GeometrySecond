package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class IdComparator implements Comparator<Triangle>
{
    private final static Logger logger= LogManager.getLogger(IdComparator.class.getName());

    public IdComparator()
    {
        logger.log(Level.INFO, "An object IdComparator was created");
    }

    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond)
    {
        Long idFirst=triangleFirst.getTriangleId();
        Long idSecond=triangleSecond.getTriangleId();
        return (idFirst.compareTo(idSecond));
    }
}
