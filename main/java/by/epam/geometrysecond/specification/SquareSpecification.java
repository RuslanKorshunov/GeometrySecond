package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.KeyNotFoundException;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class SquareSpecification implements Predicate<Triangle>
{
    private final static Logger logger= LogManager.getLogger(SquareSpecification.class.getName());
    private final double MIN_SQUARE=20;
    private final double MAX_SQUARE=200;

    @Override
    public boolean test(Triangle triangle)
    {
        long triangleId=triangle.getTriangleId();
        Warehouse warehouse=Warehouse.getWarehouse();
        double square=0;
        try
        {
            square=warehouse.findSquare(triangleId);
        }
        catch(KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
        return (square>=MIN_SQUARE && square<=MAX_SQUARE);
    }
}
