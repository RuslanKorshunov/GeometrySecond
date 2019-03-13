package by.epam.geometrysecond.parser;

import by.epam.geometrysecond.exception.IncorrectDataException;
import by.epam.geometrysecond.reader.PointReaderTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PointParserTest
{
    private final static Logger logger= LogManager.getLogger(PointParserTest.class.getName());
    private List<List<String>> expected;

    @BeforeClass(groups = {"parser"})
    public void setUp()
    {
        expected=new ArrayList<>();
        List<String> coordinates=new ArrayList<>();
        coordinates.add("1.23");
        coordinates.add("23.2");
        coordinates.add("34.12");
        coordinates.add("1.23");
        coordinates.add("23.2");
        coordinates.add("34.12");
        expected.add(coordinates);
    }

    @Test(groups = {"parser"})
    public void parseToCoordinatePositive() throws IncorrectDataException
    {
        PointParser pointParser = new PointParser();
        List<String> dataForParsing = new ArrayList<>();
        dataForParsing.add("1.23 23.2 34.12 1.23 23.2 34.12");
        List<List<String>> actual = pointParser.parseToCoordinates(dataForParsing);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"parser"},
            dependsOnMethods = {"parseToCoordinatePositive"})
    public void parseToCoordinatesException()
    {
        PointParser pointParser=new PointParser();
        List<String> emptyList=new ArrayList<>();
        try
        {
            List<List<String>> result=pointParser.parseToCoordinates(emptyList);
            Assert.fail("parseToCoordinatesException was failed");
        }
        catch(IncorrectDataException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

}