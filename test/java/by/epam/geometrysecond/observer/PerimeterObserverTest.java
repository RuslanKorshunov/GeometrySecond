package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.repository.Repository;
import by.epam.geometrysecond.repository.TriangleRepository;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PerimeterObserverTest
{
    private Triangle triangleFirst;
    private Triangle triangleSecond;

    @BeforeClass
    public void setUp() throws TriangleNotExistsException
    {
        Point first=new Point(12.2, 7.6);
        Point second=new Point(7.6, 8.23);
        Point third=new Point (1,0);
        triangleFirst =new Triangle(first, second, third);
        triangleSecond=new Triangle(first, second, third);
        Observer observer=new PerimeterObserver();
        triangleFirst.attach(observer);
        triangleSecond.attach(observer);
        Repository repository=TriangleRepository.getTriangleRepository();
        repository.add(triangleFirst);
        Warehouse warehouse=Warehouse.getWarehouse();
        warehouse.put(triangleFirst.getTriangleId(), 1, 1);
    }

    @Test
    public void updateFirstPositive()
    {
        boolean actual= triangleFirst.changePoint(triangleFirst.getFirst(), 7.7, 7.8);
        Assert.assertTrue(actual);
    }

    @Test
    public void updateFirstNegative()
    {
        boolean actual= triangleFirst.changePoint(triangleFirst.getFirst(), 7.6, 8.23);
        Assert.assertFalse(actual);
    }

    @Test
    public void updateSecondNegative()
    {
        boolean actual=triangleSecond.changePoint(triangleSecond.getFirst(), 12, 0);
        Assert.assertFalse(actual);
    }
}