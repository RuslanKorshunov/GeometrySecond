package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.entity.Figure;
import by.epam.geometrysecond.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PointCreatorTest
{
    private static Logger logger = LogManager.getLogger(PointCreatorTest.class.getName());
    private List<String> badDataForPointFirst;
    private List<String> badDataForPointSecond;

    @DataProvider
    public Object[][] createFigureExceptionDate()
    {
        double x =1.0;
        double y =7.0;
        badDataForPointFirst=new ArrayList<>();
        badDataForPointSecond=new ArrayList<>();
        badDataForPointFirst.add(Double.toString(x));
        badDataForPointSecond.add(Double.toString(-x));
        badDataForPointSecond.add(Double.toString(y));
        return new Object[][]{{badDataForPointFirst}, {badDataForPointSecond}};
    }

    @Test(dataProvider = "createFigureExceptionDate")
    public void createFigureException(List<String> dataForPoint)
    {
        Creator<String> pointCreator=new PointCreator();
        Figure point;
        try
        {
            point=pointCreator.createFigure(dataForPoint);
            Assert.fail("createFigureException was failed");
        }
        catch(CustomException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}