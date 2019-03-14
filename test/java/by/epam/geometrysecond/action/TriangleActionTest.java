package by.epam.geometrysecond.action;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleActionTest
{
    private static Logger logger = LogManager.getLogger(TriangleAction.class.getName());

    @DataProvider
    public Object[][] takeNonExistentTriangle()
    {
        Point first=new Point(1, 1);
        Point second=new Point(2, 2);
        Point third=new Point(3, 3);
        Triangle triangle=new Triangle(first, second, third);
        return new Object[][]{{triangle}};
    }

    @DataProvider
    public Object[][] takeExistentTriangle()
    {
        Point first=new Point(0, 0);
        Point second=new Point(0, 6);
        Point third=new Point(8, 0);
        Triangle triangle=new Triangle(first, second ,third);
        return new Object[][]{{triangle}};
    }

    @Test(groups = {"triangle"},
            dataProvider = "takeNonExistentTriangle")
    public void isTriangleNegative(Triangle triangle)
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isTriangleNegative",
            dataProvider = "takeNonExistentTriangle")
    public void triangleNotExistException(Triangle triangle)
    {
        TriangleAction triangleAction=new TriangleAction();
        try
        {
            double actual = triangleAction.perimeter(triangle);
            Assert.fail("perimeterTriangleNotExistException was failed");
        }
        catch(TriangleNotExistsException e)
        {
            logger.log(Level.ERROR, e);
        }
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "triangleNotExistException",
            dataProvider = "takeExistentTriangle")
    public void isTrianglePositive(Triangle triangle)
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = {"isTrianglePositive"},
            dataProvider = "takeExistentTriangle")
    public void calculateSidePositive(Triangle triangle)
    {
        TriangleAction triangleAction=new TriangleAction();
        Point first=triangle.getFirst();
        Point second=triangle.getSecond();
        double actual=triangleAction.calculateSide(first, second);;
        double expected=6;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "calculateSidePositive",
            dataProvider = "takeExistentTriangle")
    public void perimeterPositive(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        double actual=triangleAction.perimeter(triangle);
        double expected=24;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "perimeterPositive",
            dataProvider = "takeExistentTriangle")
    public void squarePositive(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        double actual=triangleAction.square(triangle);
        double expected=24;
        Assert.assertEquals(actual, expected);
    }


    @Test(groups = {"triangle"},
            dependsOnMethods = "squarePositive",
            dataProvider = "takeExistentTriangle")
    public void isRightTrianglePositive(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isRightTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isRightTrianglePositive",
            dataProvider = "takeExistentTriangle")
    public void isRightTriangleNegative(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.setPoint(triangle.getFirst(), 1, 2);
        boolean actual=triangleAction.isRightTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isRightTriangleNegative",
            dataProvider = "takeExistentTriangle")
    public void isIsoscelesTrianglePositive(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.setPoint(triangle.getFirst(), 0, 0);
        triangle.setPoint(triangle.getThird(), 6, 0);
        boolean actual=triangleAction.isIsoscelesTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isIsoscelesTrianglePositive",
            dataProvider = "takeExistentTriangle")
    public void isIsoscelesTriangleNegative(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.setPoint(triangle.getThird(), 7, 0);
        boolean actual=triangleAction.isIsoscelesTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isIsoscelesTriangleNegative",
            dataProvider = "takeExistentTriangle")
    public void isEquilateralTriangleNegative(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isEquilateralTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isEquilateralTriangleNegative",
            dataProvider = "takeExistentTriangle")
    public void isAcuteTrianglePositive(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.setPoint(triangle.getSecond(), 4, 20);
        boolean actual=triangleAction.isAcuteTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isAcuteTrianglePositive",
            dataProvider = "takeExistentTriangle")
    public void isObtuseTriangleNegative(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isObtuseTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isObtuseTriangleNegative",
            dataProvider = "takeExistentTriangle")
    public void isObtuseTrianglePositive(Triangle triangle) throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.setPoint(triangle.getSecond(), -1, 6);
        boolean actual=triangleAction.isObtuseTriangle(triangle);
        Assert.assertTrue(actual);
    }
}