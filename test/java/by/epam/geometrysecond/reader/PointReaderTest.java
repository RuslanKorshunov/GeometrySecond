package by.epam.geometrysecond.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PointReaderTest
{
    private static Logger logger= LogManager.getLogger(PointReaderTest.class.getName());
    private List<String> expected;

    @DataProvider
    public Object[][] readOpenFileExceptionData()
    {
        return new Object[][]{{"src/main/resources/emptyFile.txt"}};
    }

    @BeforeClass(groups = {"reader"})
    public void setUp()
    {
        expected=new ArrayList<>();
        expected.add("1.23 23.2 34.12 1.23 23.2 34.12");
        expected.add("12.ф 1.12 0.12 12.ф 1.12 0.12");
        expected.add("-12.12 фы ававав -12.12 фы ававав");
        expected.add("-1.23 23.2 34.12 -1.23 23.2 34.12");
        expected.add("3.4 1.2 3.4 1.2");
    }

    @Test(groups = {"reader"})
    public void readFirstPositive() throws WorkWithFileException
    {
        String path="src/main/resources/points.txt";
        PointReader pointReader=new PointReader();
        List<String> actual=pointReader.read(path);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"reader"},
            dependsOnMethods = {"readFirstPositive"})
    public void readSecondPositive() throws WorkWithFileException
    {
        String nonexistentPath="src/main/resources/points2.txt";
        PointReader pointReader=new PointReader();
        List<String> actual=pointReader.read(nonexistentPath);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"reader"},
            dependsOnMethods = {"readSecondPositive"})
    public void readFirstNegative()
    {
        String emptyPath="src/main/resources/empty.txt";
        PointReader pointReader=new PointReader();
        try
        {
            List<String> actual=pointReader.read(emptyPath);
            Assert.fail("readFirstNegative was failed");
        }
        catch(WorkWithFileException e)
        {
            logger.log(Level.ERROR, e);
        }
    }
}