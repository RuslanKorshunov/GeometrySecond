package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

import java.util.function.Predicate;

public class IdSpecification implements Predicate<Triangle>
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
