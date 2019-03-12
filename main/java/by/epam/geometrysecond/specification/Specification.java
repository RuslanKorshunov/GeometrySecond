package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

import java.util.function.Predicate;

public interface Specification extends Predicate<Triangle>
{
    @Override
    default boolean test(Triangle triangle)
    {
        return false;
    }
}
