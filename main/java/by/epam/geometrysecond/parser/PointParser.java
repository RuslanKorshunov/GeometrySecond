package by.epam.geometrysecond.parser;

import by.epam.geometrysecond.exception.IncorrectDataException;
import by.epam.geometrysecond.validator.PointValidator;

import java.util.ArrayList;
import java.util.List;

public class PointParser
{
    private final static String SPACE="\\s";

    public List<List<String>> parseToCoordinates(List<String> dataForParsing) throws IncorrectDataException
    {
        if(dataForParsing.isEmpty())
        {
            throw new IncorrectDataException("The list dataForParsing is empty");
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