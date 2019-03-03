package by.epam.geometrysecond.parser;

import by.epam.geometrysecond.exception.EmptyListException;
import by.epam.geometrysecond.reader.PointReaderTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PointParserTest
{
    private static Logger logger= LogManager.getLogger(PointParserTest.class.getName());
    private PointParser pointParser=new PointParser();
    public static List<List<String>> result;

    @Test
    public void parseToCoordinatesException()
    {
        List<String> emptyList=new ArrayList<>();
        try
        {
            result=pointParser.parseToCoordinates(emptyList);
            Assert.fail("parseToCoordinatesException was failed");
        }
        catch(EmptyListException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    @Test(groups = {"fullPath"})
    public void parseToCoordinatePositive() throws EmptyListException
    {
        List<String> dataForParsing= PointReaderTest.coordinates;
        result=pointParser.parseToCoordinates(dataForParsing);
        logger.log(Level.INFO, "parseToCoordinatePositive was successful");
    }
}