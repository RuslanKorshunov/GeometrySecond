package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.CustomException;

import java.util.function.Predicate;

public interface Specification
{
    boolean specify(Triangle triangle) throws CustomException;
}
