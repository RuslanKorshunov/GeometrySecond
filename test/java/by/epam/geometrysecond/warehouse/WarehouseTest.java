package by.epam.geometrysecond.warehouse;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WarehouseTest
{
    private final static Logger logger= LogManager.getLogger(WarehouseTest.class);
    private Triangle triangle;

    @BeforeClass(groups = {"warehouse"})
    public void setUp()
    {
        Point first=new Point(0, 0);
        Point second=new Point(0, 6);
        Point third=new Point(8, 0);
        triangle=new Triangle(first, second, third);
        double perimeter=24;
        double square=12;
        Warehouse warehouse=Warehouse.getWarehouse();
        warehouse.put(triangle.getTriangleId(), square, perimeter);
    }

    @Test(groups = {"warehouse"})
    public void findPerimeterPositive() throws KeyNotFoundException
    {
        Warehouse warehouse=Warehouse.getWarehouse();
        double actual=warehouse.findPerimeter(triangle.getTriangleId());
        double expected=24;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"warehouse"},
            dependsOnMethods = {"findPerimeterPositive"})
    public void findPerimeterNegative()
    {
        Warehouse warehouse=Warehouse.getWarehouse();
        try
        {
            double actual=warehouse.findPerimeter(1);
            Assert.fail("findPerimeterNegative was failed");
        }
        catch(KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e);
        }
    }

    @Test(groups = {"warehouse"},
            dependsOnMethods = {"findPerimeterNegative"})
    public void findSquarePositive() throws KeyNotFoundException
    {
        Warehouse warehouse=Warehouse.getWarehouse();
        double actual=warehouse.findSquare(triangle.getTriangleId());
        double expected=12;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"warehouse"},
            dependsOnMethods = {"findSquarePositive"})
    public void findSquareNegative()
    {
        Warehouse warehouse=Warehouse.getWarehouse();
        try
        {
            double actual=warehouse.findSquare(1);
            Assert.fail("findSquareNegative was failed");
        }
        catch(KeyNotFoundException e)
        {
            logger.log(Level.ERROR, e);
        }
    }
}