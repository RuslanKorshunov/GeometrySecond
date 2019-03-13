package by.epam.geometrysecond.action;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.parser.PointParserTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TriangleActionTest
{
    private static Logger logger = LogManager.getLogger(TriangleAction.class.getName());
    private Triangle triangle;

    @BeforeTest(groups = {"triangle"})
    public void setUpSecond()
    {
        Point first=new Point(1, 1);
        Point second=new Point(2, 2);
        Point third=new Point(3, 3);
        triangle=new Triangle(first, second, third);
    }

    @Test(groups = {"triangle"})
    public void isTriangleNegative()
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isTriangleNegative")
    public void triangleNotExistException()
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
            dependsOnMethods = "triangleNotExistException")
    public void isTrianglePositive()
    {
        TriangleAction triangleAction=new TriangleAction();
        Point first=new Point(0, 0);
        Point second=new Point(0, 6);
        Point third=new Point(8, 0);
        triangle=new Triangle(first, second ,third);
        boolean actual=triangleAction.isTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = {"isTrianglePositive"})
    public void calculateSidePositive()
    {
        TriangleAction triangleAction=new TriangleAction();
        Point first=triangle.getFirst();
        Point second=triangle.getSecond();
        double actual=triangleAction.calculateSide(first, second);;
        double expected=6;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "calculateSidePositive")
    public void perimeterPositive() throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        double actual=triangleAction.perimeter(triangle);
        double expected=24;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "perimeterPositive")
    public void squarePositive() throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        double actual=triangleAction.square(triangle);
        double expected=24;
        Assert.assertEquals(actual, expected);
    }


    @Test(groups = {"triangle"},
            dependsOnMethods = "squarePositive")
    public void isRightTrianglePositive() throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        boolean actual=triangleAction.isRightTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isRightTrianglePositive")
    public void isRightTriangleNegative() throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.changePoint(triangle.getFirst(), 1, 2);
        boolean actual=triangleAction.isRightTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isRightTriangleNegative")
    public void isIsoscelesTrianglePositive() throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.changePoint(triangle.getFirst(), 0, 0);
        triangle.changePoint(triangle.getThird(), 6, 0);
        boolean actual=triangleAction.isIsoscelesTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"triangle"},
            dependsOnMethods = "isIsoscelesTrianglePositive")
    public void isIsoscelesTriangleNegative() throws TriangleNotExistsException
    {
        TriangleAction triangleAction=new TriangleAction();
        triangle.changePoint(triangle.getThird(), 7, 0);
        boolean actual=triangleAction.isIsoscelesTriangle(triangle);
        Assert.assertFalse(actual);
    }



    /*@Test(groups = {"fullPath"},
            dependsOnMethods = "isIsoscelesTriangleNegative")
    public void isEquilateralTriangleNegative() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isEquilateralTriangle(triangle);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" isn't a equilateral triangle");
    }

    @Test
    public void isEquilateralTrianglePositive() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isEquilateralTriangle(triangle);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" is a equilateral triangle");
    }

    @Test
    public void isAcuteTriangleNegative() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isAcuteTriangle(triangle);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" isn't a acute triangle");
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = "isEquilateralTriangleNegative")
    public void isAcuteTrianglePositive() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isAcuteTriangle(triangle);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" is a acute triangle");
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = "isAcuteTrianglePositive")
    public void isObtuseTriangleNegative() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isObtuseTriangle(triangle);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" isn't a obtuse triangle");
    }

    @Test
    public void isObtuseTrianglePositive() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isObtuseTriangle(triangle);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" is a obtuse triangle");
    }*/
}