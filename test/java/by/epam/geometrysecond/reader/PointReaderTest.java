package by.epam.geometrysecond.reader;

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
        catch(WorkWithFileException e)
        {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    @Test(groups = {"fullPath"})
    public void readOpenFilePositive() throws WorkWithFileException
    {
        coordinates=pointReader.read("");
        logger.log(Level.INFO, "readOpenFilePositive was successful");
    }
}