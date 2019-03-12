package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

public class IdSpecification implements Specification
{
    private final static int MIN_ID=2;
    private final static int MAX_ID=200;

    @Override
    public boolean test(Triangle triangle)
    {
        long triangleId=triangle.getTriangleId();
        return (triangleId>=MIN_ID && triangleId<=MAX_ID);
    }
}
