package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.action.TriangleAction;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.event.TriangleEvent;
import by.epam.geometrysecond.exception.KeyNotFoundException;
import by.epam.geometrysecond.exception.TriangleNotExistsException;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterObserver implements Observer
{
    private final static Logger logger=LogManager.getLogger(PerimeterObserver.class.getName());

    @Override
    public void update(TriangleEvent triangleEvent)
    {
        Triangle triangle=(Triangle) triangleEvent.getSource();
        TriangleAction triangleAction=new TriangleAction();
        Warehouse warehouse=Warehouse.getWarehouse();
        try
        {
            double perimeter = triangleAction.perimeter(triangle);
            warehouse.changePerimeter(triangle.getTriangleId(), perimeter);
        }
        catch(TriangleNotExistsException|KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
