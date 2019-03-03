package by.epam.geometrysecond.parser;

import by.epam.geometrysecond.exception.EmptyListException;
import by.epam.geometrysecond.validator.PointValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointParser
{
    private static Logger logger= LogManager.getLogger(PointParser.class.getName());
    private final static String SPACE="\\s";

    public PointParser()
    {
        logger.log(Level.INFO, "A object PointParser was created");
    }

    public List<List<String>> parseToCoordinates(List<String> dataForParsing) throws EmptyListException
    {
        if(dataForParsing.isEmpty())
        {
            throw new EmptyListException("The list dataForParsing is empty");
        }
        List<List<String>> result=new ArrayList<>();
        for(String dataAboutPoint: dataForParsing)
        {
            if(PointValidator.validPoint(dataAboutPoint))
            {
                List<String> coordinates=new ArrayList<>();
                for(String coordinate:dataAboutPoint.split(SPACE))
                {
                    coordinates.add(coordinate);
                }
                result.add(coordinates);
            }
        }
        return result;
    }
}