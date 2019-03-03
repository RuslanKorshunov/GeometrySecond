package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.KeyNotFoundException;
import by.epam.geometrysecond.observer.PerimeterObserver;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class PerimeterSpecification implements Predicate<Triangle>
{
    private final static Logger logger= LogManager.getLogger(PerimeterObserver.class.getName());

    @Override
    public boolean test(Triangle triangle)
    {
        final double MIN_PERIMETER=20;
        final double MAX_PERIMETER=200;
        long triangleId=triangle.getTriangleId();
        Warehouse warehouse=Warehouse.getWarehouse();
        double perimeter=0;
        try
        {
            perimeter=warehouse.findPerimeter(triangleId);
        }
        catch(KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
        return (perimeter>=MIN_PERIMETER && perimeter<=MAX_PERIMETER);
    }
}