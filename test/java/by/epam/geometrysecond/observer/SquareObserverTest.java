package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.repository.Repository;
import by.epam.geometrysecond.repository.TriangleRepository;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareObserverTest
{
    @Test(groups = {"observer"})
    public void updateFirstPositive() throws TriangleNotExistsException
    {
        Point first=new Point(12.2, 7.6);
        Point second=new Point(7.6, 8.23);
        Point third=new Point (1,0);
        Triangle triangle =new Triangle(first, second, third);
        addInRepository(triangle);
        boolean actual= triangle.setPoint(triangle.getFirst(), 7.7, 7.8);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"observer"},
            dependsOnMethods = {"updateFirstPositive"})
    public void updateFirstNegative() throws TriangleNotExistsException
    {
        Point first=new Point(12.2, 7.6);
        Point second=new Point(7.6, 8.23);
        Point third=new Point (1,0);
        Triangle triangle =new Triangle(first, second, third);
        addInRepository(triangle);
        boolean actual= triangle.setPoint(triangle.getFirst(), 7.6, 8.23);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"observer"},
            dependsOnMethods = {"updateFirstNegative"})
    public void updateSecondNegative()
    {
        Point first=new Point(12.2, 7.6);
        Point second=new Point(7.6, 8.23);
        Point third=new Point (1,0);
        Triangle triangle =new Triangle(first, second, third);
        Observer observer=new PerimeterObserver();
        triangle.attach(observer);
        boolean actual=triangle.setPoint(triangle.getFirst(), 12, 0);
        Assert.assertFalse(actual);
    }

    private void addInRepository(Triangle triangle) throws TriangleNotExistsException
    {
        Observer observer=new SquareObserver();
        triangle.attach(observer);
        Repository repository=TriangleRepository.getTriangleRepository();
        repository.add(triangle);
        Warehouse warehouse=Warehouse.getWarehouse();
        warehouse.put(triangle.getTriangleId(), 1, 1);
    }
}