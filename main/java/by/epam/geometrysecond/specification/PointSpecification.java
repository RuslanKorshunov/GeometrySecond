package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

public class PointSpecification implements Specification
{
    private final static double X=15;
    private final static double Y=15;

    @Override
    public boolean test(Triangle triangle)
    {
        return (triangle.getFirst().getX()<X && triangle.getFirst().getY()<Y &&
                triangle.getSecond().getX()<X && triangle.getSecond().getY()<Y &&
                triangle.getThird().getX()<X && triangle.getThird().getY()<Y);
    }
}
