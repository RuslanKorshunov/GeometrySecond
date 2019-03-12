package by.epam.geometrysecond.repository;

import by.epam.geometrysecond.action.TriangleAction;
import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.comparator.IdComparator;
import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.specification.*;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleRepositoryTest
{
    private final static Logger logger=LogManager.getLogger(TriangleRepositoryTest.class);
    private Triangle triangleFirst;
    private Triangle triangleSecond;
    private List<Triangle> expectedIdSpecification;
    private List<Triangle> expectedPerimeterSpecification;
    private List<Triangle> expectedPointSpecification;
    private List<Triangle> expectedSquareSpecification;
    private List<Triangle> expectedIdComparator;

    @BeforeClass(groups = {"repository"})
    public void setUp() throws TriangleNotExistsException
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        Warehouse warehouse=Warehouse.getWarehouse();
        TriangleAction triangleAction=new TriangleAction();
        expectedIdSpecification=new ArrayList<>();
        expectedPerimeterSpecification=new ArrayList<>();
        expectedPointSpecification=new ArrayList<>();
        expectedSquareSpecification=new ArrayList<>();
        expectedIdComparator=new ArrayList<>();

        Point first=new Point(1,2);
        Point second=new Point(2, 3);
        Point third=new Point(2, 2);
        triangleFirst =new Triangle(first, second, third);
        third=new Point(2, 3);
        triangleSecond=new Triangle(first, second, third);

        first=new Point(5, 7);
        second=new Point(6, 5);
        third=new Point(20, 20);
        Triangle triangle=new Triangle(first, second, third);
        triangleRepository.add(triangle);
        expectedIdSpecification.add(triangle);
        expectedPerimeterSpecification.add(triangle);
        expectedSquareSpecification.add(triangle);
        expectedIdComparator.add(triangle);
        double perimeter=triangleAction.perimeter(triangle);
        double square=triangleAction.square(triangle);
        warehouse.put(triangle.getTriangleId(), square, perimeter);

        first=new Point(0, 0);
        second=new Point(0, 20);
        third=new Point(16, 0);
        triangle=new Triangle(first, second, third);
        triangleRepository.add(triangle);
        expectedIdSpecification.add(triangle);
        expectedPerimeterSpecification.add(triangle);
        expectedSquareSpecification.add(triangle);
        expectedIdComparator.add(triangle);
        perimeter=triangleAction.perimeter(triangle);
        square=triangleAction.square(triangle);
        warehouse.put(triangle.getTriangleId(), square, perimeter);

        second=new Point(0, 1);
        third=new Point(6, 0);
        triangle=new Triangle(first, second, third);
        triangleRepository.add(triangle);
        expectedIdSpecification.add(triangle);
        expectedPointSpecification.add(triangle);
        expectedIdComparator.add(triangle);
        perimeter=triangleAction.perimeter(triangle);
        square=triangleAction.square(triangle);
        warehouse.put(triangle.getTriangleId(), square, perimeter);
    }

    @Test(groups = {"repository"})
    public void addPositive() throws TriangleNotExistsException
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        boolean actual=triangleRepository.add(triangleFirst);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"addPositive"})
    public void addFirstNegative() throws TriangleNotExistsException
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        triangleRepository.add(triangleFirst);
        boolean actual=triangleRepository.add(triangleFirst);
        Assert.assertFalse(actual);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"addFirstNegative"})
    public void addSecondNegative()
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        try
        {
            boolean actual=triangleRepository.add(triangleSecond);
            Assert.fail("addSecondNegative was failed");
        }
        catch(TriangleNotExistsException e)
        {
            logger.log(Level.ERROR, e);
        }
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"addSecondNegative"})
    public void removePositive() throws TriangleNotExistsException
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        triangleRepository.add(triangleFirst);
        boolean actual=triangleRepository.remove(triangleFirst);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"removePositive"})
    public void removeNegative() throws TriangleNotExistsException
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        boolean actual=triangleRepository.remove(triangleFirst);
        Assert.assertFalse(actual);
    }


    @Test(groups = {"repository"},
            dependsOnMethods = {"removeNegative"})
    public void queryIdSpecification()
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        Specification idSpecification=new IdSpecification();
        List<Triangle> actual=triangleRepository.query(idSpecification);
        actual.sort(new IdComparator());
        Assert.assertEquals(actual, expectedIdSpecification);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"queryIdSpecification"})
    public void queryPerimeterSpecification()
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        Specification perimeterSpecification=new PerimeterSpecification();
        List<Triangle> actual=triangleRepository.query(perimeterSpecification);
        actual.sort(new IdComparator());
        Assert.assertEquals(actual, expectedPerimeterSpecification);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"queryPerimeterSpecification"})
    public void queryPointSpecification()
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        Specification pointSpecification=new PointSpecification();
        List<Triangle> actual=triangleRepository.query(pointSpecification);
        for(Triangle triangle:actual)
        actual.sort(new IdComparator());
        Assert.assertEquals(actual, expectedPointSpecification);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"queryPointSpecification"})
    public void querySquareSpecification()
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        Specification squareSpecification=new SquareSpecification();
        List<Triangle> actual=triangleRepository.query(squareSpecification);
        actual.sort(new IdComparator());
        Assert.assertEquals(actual, expectedSquareSpecification);
    }

    @Test(groups = {"repository"},
            dependsOnMethods = {"querySquareSpecification"})
    public void sortIdComparator()
    {
        TriangleRepository triangleRepository=TriangleRepository.getTriangleRepository();
        Comparator idComparator=new IdComparator();
        List<Triangle> actual=triangleRepository.sort(idComparator);
        Assert.assertEquals(actual, expectedIdComparator);
    }
}