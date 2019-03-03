package by.epam.geometrysecond.comparator;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YCoordinateComparatorTest
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
        YCoordinateComparator yCoordinateComparator=new YCoordinateComparator();
        int actual=yCoordinateComparator.compare(triangleFirst, triangleSecond);
        int expected=-1;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareSecondPositive()
    {
        YCoordinateComparator yCoordinateComparator=new YCoordinateComparator();
        int actual=yCoordinateComparator.compare(triangleSecond, triangleFirst);
        int expected=1;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareThirdPositive()
    {
        YCoordinateComparator yCoordinateComparator=new YCoordinateComparator();
        triangleSecond.getFirst().setY(7.6);
        int actual=yCoordinateComparator.compare(triangleFirst, triangleSecond);
        int expected=0;
        Assert.assertEquals(actual,expected);
    }
}