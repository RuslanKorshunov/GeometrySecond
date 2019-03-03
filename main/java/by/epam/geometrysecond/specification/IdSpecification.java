package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

import java.util.function.Predicate;

public class IdSpecification implements Predicate<Triangle>
{
    @Override
    public boolean test(Triangle triangle)
    {
        final int MIN_ID=2;
        final int MAX_ID=200;
        long triangleId=triangle.getTriangleId();
        return (triangleId>=MIN_ID && triangleId<=MAX_ID);
    }
}
