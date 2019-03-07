package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;

public interface Specification
{
    boolean specify(Triangle triangle) throws CustomException;
}
