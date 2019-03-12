package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.warehouse.KeyNotFoundException;
import by.epam.geometrysecond.observer.PerimeterObserver;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class PerimeterSpecification implements Predicate<Triangle>
{
    private final static Logger logger= LogManager.getLogger(PerimeterObserver.class.getName());
    private final static double MIN_PERIMETER=20;
    private final static double MAX_PERIMETER=200;

    @Override
    public boolean test(Triangle triangle)
    {
        long triangleId=triangle.getTriangleId();
        Warehouse warehouse=Warehouse.getWarehouse();
        double perimeter=-1;
        try
        {
            perimeter=warehouse.findPerimeter(triangleId);
        }
        catch(KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e);
        }
        return (perimeter>=MIN_PERIMETER && perimeter<=MAX_PERIMETER);
    }
}