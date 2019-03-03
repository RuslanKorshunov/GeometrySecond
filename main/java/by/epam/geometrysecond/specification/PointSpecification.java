package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

import java.util.function.Predicate;

public class PointSpecification implements Predicate<Triangle>
{
    @Override
    public boolean test(Triangle triangle)
    {
        final double X=15;
        final double Y=15;
        return (triangle.getFirst().getX()<X && triangle.getFirst().getY()<Y &&
                triangle.getSecond().getX()<X && triangle.getSecond().getY()<Y &&
                triangle.getThird().getX()<X && triangle.getThird().getY()<Y);
    }
}
