package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.action.*;
import by.epam.geometrysecond.entity.*;
import by.epam.geometrysecond.exception.IncorrectDataException;
import by.epam.geometrysecond.repository.TriangleRepository;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleCreator extends Creator
{
    private static Logger logger= LogManager.getLogger(TriangleCreator.class);
    private static final int NUMBER_OF_POINTS=3;

    @Override
    public Triangle createFigure(List dataForTriangle) throws IncorrectDataException
    {
        if(dataForTriangle.size()!=NUMBER_OF_POINTS)
        {
            throw new IncorrectDataException("List dataForTriangle has size less "+NUMBER_OF_POINTS);
        }
        Point first=(Point) dataForTriangle.get(0);
        Point second=(Point) dataForTriangle.get(1);
        Point third=(Point) dataForTriangle.get(2);
        Triangle triangle=new Triangle(first, second, third);
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        try
        {
            TriangleAction triangleAction=new TriangleAction();
            triangleRepository.add(triangle);
            double perimeter = triangleAction.perimeter(triangle);
            double square = triangleAction.square(triangle);
            Warehouse warehouse=Warehouse.getWarehouse();
            warehouse.put(triangle.getTriangleId(), square, perimeter);
        }
        catch(TriangleNotExistsException e)
        {
            logger.log(Level.ERROR, e);
        }
        return triangle;
    }
}