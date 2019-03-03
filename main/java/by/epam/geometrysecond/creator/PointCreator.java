package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.exception.NegativeValueException;
import by.epam.geometrysecond.exception.NotEnoughDataInListException;

import java.util.List;

public class PointCreator extends Creator
{
    private final int NUMBER_OF_COORDINATES=2;

    @Override
    public Point createFigure(List dataForPoint) throws NotEnoughDataInListException, NegativeValueException
    {
        if(dataForPoint.size()<NUMBER_OF_COORDINATES)
        {
            throw new NotEnoughDataInListException("List dataForPoint has size less "+NUMBER_OF_COORDINATES);
        }
        for(Object coordinate: dataForPoint)
        {
            if(Double.valueOf((String) coordinate)<=0)
            {
                throw new NegativeValueException("One of values in dataForPoint is negative");
            }
        }
        Double x=Double.parseDouble((String) dataForPoint.get(0));
        Double y=Double.parseDouble((String) dataForPoint.get(1));
        Point figure=new Point(x, y);
        return figure;
    }
}