package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.warehouse.KeyNotFoundException;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareSpecification implements Specification
{
    private final static Logger logger= LogManager.getLogger(SquareSpecification.class);
    private final static double MIN_SQUARE=20;
    private final static double MAX_SQUARE=200;

    @Override
    public boolean test(Triangle triangle)
    {
        long triangleId=triangle.getTriangleId();
        Warehouse warehouse=Warehouse.getWarehouse();
        double square=-1;
        try
        {
            square=warehouse.findSquare(triangleId);
        }
        catch(KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e);
        }
        return (square>=MIN_SQUARE && square<=MAX_SQUARE);
    }
}
