package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.action.TriangleAction;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.event.TriangleEvent;
import by.epam.geometrysecond.exception.KeyNotFoundException;
import by.epam.geometrysecond.exception.TriangleNotExistsException;
import by.epam.geometrysecond.warehouse.Warehouse;

public class PerimeterObserver implements Observer
{
    @Override
    public void update(TriangleEvent triangleEvent) throws TriangleNotExistsException, KeyNotFoundException
    {
        Triangle triangle=(Triangle) triangleEvent.getSource();
        TriangleAction triangleAction=new TriangleAction();
        Warehouse warehouse=Warehouse.getWarehouse();
        double perimeter = triangleAction.perimeter(triangle);
        warehouse.changePerimeter(triangle.getTriangleId(), perimeter);
    }
}
