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

public class SquareObserver implements Observer
{
    private final static Logger logger=LogManager.getLogger(SquareObserver.class.getName());

    public SquareObserver()
    {
        logger.log(Level.INFO, "An object SquareObserver was created");
    }

    @Override
    public void update(TriangleEvent triangleEvent) throws TriangleNotExistsException, KeyNotFoundException
    {
        Triangle triangle=(Triangle) triangleEvent.getSource();
        TriangleAction triangleAction=new TriangleAction();
        Warehouse warehouse=Warehouse.getWarehouse();
        double square = triangleAction.square(triangle);
        warehouse.changeSquare(triangle.getTriangleId(), square);
    }
}
