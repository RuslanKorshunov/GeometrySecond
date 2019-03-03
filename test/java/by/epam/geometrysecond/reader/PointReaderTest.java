package by.epam.geometrysecond.reader;

import by.epam.geometrysecond.exception.CustomException;
import by.epam.geometrysecond.exception.EmptyFileException;
import by.epam.geometrysecond.exception.OpenFileException;
import by.epam.geometrysecond.exception.ReadingFromFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class PointReaderTest
{
    private static Logger logger= LogManager.getLogger(PointReaderTest.class.getName());
    private PointReader pointReader=new PointReader();
    public static List<String> coordinates;

    @DataProvider
    public Object[][] readOpenFileExceptionData()
    {
        return new Object[][]{{"src/main/resources/emptyFile.txt"}};
    }

    @Test(dataProvider = "readOpenFileExceptionData")
    public void readOpenFileException(String filePath)
    {
        try
        {
            coordinates=pointReader.read(filePath);
            Assert.fail("readOpenFileException was failed");
        }
        catch(OpenFileException|ReadingFromFileException|EmptyFileException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    @Test(groups = {"fullPath"})
    public void readOpenFilePositive() throws CustomException
    {
        coordinates=pointReader.read("");
        logger.log(Level.INFO, "readOpenFilePositive was successful");
    }
}