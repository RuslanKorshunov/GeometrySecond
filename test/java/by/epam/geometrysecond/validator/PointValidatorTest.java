package by.epam.geometrysecond.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PointValidatorTest
{
    private static Logger logger = LogManager.getLogger(PointValidatorTest.class.getName());

    @Test
    public void validPointPositive()
    {
        String data="1.2 2.3 4.5 6.78 8.0 12.2";
        boolean actual= PointValidator.validPoint(data);
        Assert.assertTrue(actual);
        logger.log(Level.INFO, "validPointPositive was successful");
    }

    @DataProvider
    public Object[][] validPointNegativeData()
    {
        return new Object[][]{{""}};
    }

    @Test(dataProvider = "validPointNegativeData")
    public void validPointNegative(String data)
    {
        boolean actual=PointValidator.validPoint(data);
        Assert.assertFalse(actual);
        logger.log(Level.INFO, "validPointNegative was successful");
    }
}