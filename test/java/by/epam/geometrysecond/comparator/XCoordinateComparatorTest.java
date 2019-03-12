package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XCoordinateComparatorTest
{
    private Triangle triangleFirst;
    private Triangle triangleSecond;

    @BeforeClass
    public void setUp()
    {
        Point first=new Point(12.2, 7.6);
        Point second=new Point(7.6, 8.23);
        Point third=new Point (1,0);
        triangleFirst=new Triangle(first, second, third);
        first=new Point(12.3, 8.8);
        second=new Point(0, 0);
        third=new Point(2, 2);
        triangleSecond=new Triangle(first, second, third);
    }

    @Test
    public void compareFirstPositive()
    {
        XCoordinateComparator xCoordinateComparator=new XCoordinateComparator();
        int actual=xCoordinateComparator.compare(triangleFirst, triangleSecond);
        int expected=-1;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareSecondPositive()
    {
        XCoordinateComparator xCoordinateComparator=new XCoordinateComparator();
        int actual=xCoordinateComparator.compare(triangleSecond, triangleFirst);
        int expected=1;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareThirdPositive()
    {
        XCoordinateComparator xCoordinateComparator=new XCoordinateComparator();
        triangleSecond.getFirst().setX(12.2);
        int actual=xCoordinateComparator.compare(triangleFirst, triangleSecond);
        int expected=0;
        Assert.assertEquals(actual,expected);
    }
}