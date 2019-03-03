package by.epam.geometrysecond.action;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.TriangleNotExistsException;
import by.epam.geometrysecond.parser.PointParserTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TriangleActionTest
{
    private static Logger logger = LogManager.getLogger(TriangleAction.class.getName());
    private Triangle triangle;
    private TriangleAction triangleAction=new TriangleAction();

    @BeforeClass(groups = "fullPath")
    public void setUpFirst()
    {
        List<List<String>> coordinatesAll= PointParserTest.result;
        List<String> coordinates=coordinatesAll.get(0);
        double x=Double.valueOf(coordinates.get(0));
        double y=Double.valueOf(coordinates.get(1));
        Point first=new Point(x, y);
        x=Double.valueOf(coordinates.get(2));
        y=Double.valueOf(coordinates.get(3));
        Point second=new Point(x, y);
        x=Double.valueOf(coordinates.get(4));
        y=Double.valueOf(coordinates.get(5));
        Point third=new Point(x, y);
        triangle=new Triangle(first, second, third);
    }

    @BeforeClass(groups = {"notTriangle"})
    public void setUpSecond()
    {
        Point first=new Point(1, 1);
        Point second=new Point(2, 2);
        Point third=new Point(3, 3);
        triangle=new Triangle(first, second, third);
    }

    @Test(groups = {"notTriangle"})
    public void isTriangleNegative()
    {
        boolean actual=triangleAction.isTriangle(triangle);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" isn't a triangle");
    }

    @Test(groups = {"fullPath"})
    public void isTrianglePositive()
    {
        boolean actual=triangleAction.isTriangle(triangle);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" is a triangle");
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = {"isTrianglePositive"})
    public void calculateSidePositive()
    {
        Point first=triangle.getFirst();
        Point second=triangle.getSecond();
        double actual=triangleAction.calculateSide(first, second);
        actual=Math.floor(actual);
        double expected=39;
        Assert.assertEquals(actual, expected);
        logger.log(Level.INFO, "calculateSidePositive was successful");
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = "calculateSidePositive")
    public void perimeterPositive() throws TriangleNotExistsException
    {
        double actual=triangleAction.perimeter(triangle);
        actual=Math.floor(actual);
        double expected=98;
        Assert.assertEquals(actual, expected);
        logger.log(Level.INFO, "perimeterPositive was successful");
    }

    @Test(groups = {"notTriangle"},
            dependsOnMethods = "isTriangleNegative")
    public void triangleNotExistException()
    {
        try
        {
            double actual = triangleAction.perimeter(triangle);
            Assert.fail("perimeterTriangleNotExistException was failed");
        }
        catch(TriangleNotExistsException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = "perimeterPositive")
    public void squarePositive() throws TriangleNotExistsException
    {
        double actual=triangleAction.square(triangle);
        actual=Math.floor(actual);
        double expected=420;
        Assert.assertEquals(actual, expected);
        logger.log(Level.INFO, "squarePositive was successful");
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = "squarePositive")
    public void isRightTriangleNegative() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isRightTriangle(triangle);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" isn't a right triangle");
    }

    @Test(dependsOnMethods = "isTrianglePositive")
    public void isRightTrianglePositive() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isRightTriangle(triangle);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" is a right triangle");
    }

    @Test(groups = {"fullPath"},
            dependsOnMethods = "isRightTriangleNegative")
    public void isIsoscelesTriangleNegative() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isIsoscelesTriangle(triangle);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" isn't a isosceles triangle");
    }

    @Test(dependsOnMethods = "isTrianglePositive")
    public void isIsoscelesTrianglePositive() throws TriangleNotExistsException
    {
        boolean actual=triangleAction.isIsoscelesTriangle(triangle);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "The figure №"+triangle.getTriangleId()+" is a isosceles triangle");
    }

    @Test(groups = {"fullPath"},
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
    }
}