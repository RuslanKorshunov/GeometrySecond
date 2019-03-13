package by.epam.geometrysecond.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PointValidatorTest
{
    private final static Logger logger = LogManager.getLogger(PointValidatorTest.class.getName());

    @Test(groups = {"pointValidator"})
    public void validPointPositive()
    {
        String data="1.2 2.3 4.5 6.78 8.0 12.2";
        boolean actual= PointValidator.validPoint(data);
        Assert.assertTrue(actual);
    }

    @Test(groups = {"pointValidator"},
            dependsOnMethods = {"validPointPositive"})
    public void validPointNegative()
    {
        String data="";
        boolean actual=PointValidator.validPoint(data);
        Assert.assertFalse(actual);
    }
}