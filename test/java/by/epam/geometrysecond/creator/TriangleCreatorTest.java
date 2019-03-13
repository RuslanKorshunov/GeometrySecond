package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.entity.Figure;
import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.exception.IncorrectDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreatorTest
{
    private final static Logger logger=LogManager.getLogger(TriangleCreatorTest.class);

    @DataProvider
    public Object[][] createFigureExceptionData()
    {
        Point first=new Point(1, 7);
        Point second=new Point(12.2, 2.5);
        List<Point> dataForTriangle=new ArrayList<>();
        dataForTriangle.add(first);
        dataForTriangle.add(second);
        return new Object[][]{{dataForTriangle}};
    }

    @Test(groups = {"creator"},
            dataProvider = "createFigureExceptionData")
    public void createFigureIncorrectDataException(List<Point> dataForTriangle)
    {
        Creator triangleCreator=new TriangleCreator();
        Figure triangle;
        try
        {
            triangle=((TriangleCreator) triangleCreator).createFigure(dataForTriangle);
            Assert.fail("createFigureIncorrectDataException was failed");
        }
        catch(IncorrectDataException e)
        {
            logger.log(Level.ERROR, e);
        }
    }
}