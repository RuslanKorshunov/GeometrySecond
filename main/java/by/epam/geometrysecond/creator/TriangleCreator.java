package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.NotEnoughDataInListException;

import java.util.List;

public class TriangleCreator extends Creator
{
    private final int NUMBER_OF_POINTS=3;

    @Override
    public Triangle createFigure(List dataForTriangle) throws NotEnoughDataInListException
    {
        if(dataForTriangle.size()!=NUMBER_OF_POINTS)
        {
            throw new NotEnoughDataInListException("List dataForTriangle has size less "+NUMBER_OF_POINTS);
        }
        Point first=(Point) dataForTriangle.get(0);
        Point second=(Point) dataForTriangle.get(1);
        Point third=(Point) dataForTriangle.get(2);
        Triangle figure=new Triangle(first, second, third);
        return figure;
    }
}