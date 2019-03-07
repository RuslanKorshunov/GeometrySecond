package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.exception.IncorrectDataException;

import java.util.List;

public class PointCreator extends Creator
{
    private static final int NUMBER_OF_COORDINATES=2;

    @Override
    public Point createFigure(List dataForPoint) throws IncorrectDataException
    {
        if(dataForPoint.size()<NUMBER_OF_COORDINATES)
        {
            throw new IncorrectDataException("List dataForPoint has size less "+NUMBER_OF_COORDINATES);
        }
        for(Object coordinate: dataForPoint)
        {
            if(Double.valueOf((String) coordinate)<=0)
            {
                throw new IncorrectDataException("One of values in dataForPoint is negative");
            }
        }
        Double x=Double.parseDouble((String) dataForPoint.get(0));
        Double y=Double.parseDouble((String) dataForPoint.get(1));
        Point figure=new Point(x, y);
        return figure;
    }
}