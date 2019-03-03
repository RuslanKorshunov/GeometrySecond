package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.repository.Repository;
import by.epam.geometrysecond.repository.TriangleRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SquareObserverTest
{
    private Triangle triangleFirst;
    private Triangle triangleSecond;

    @BeforeClass
    public void setUp()
    {
        Point first=new Point(12.2, 7.6);
        Point second=new Point(7.6, 8.23);
        Point third=new Point (1,0);
        triangleFirst =new Triangle(first, second, third);
        triangleSecond=new Triangle(first, second, third);
        Observer observer=new SquareObserver();
        triangleFirst.attach(observer);
        triangleSecond.attach(observer);
        Repository repository= TriangleRepository.getTriangleRepository();
        repository.add(triangleFirst);
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