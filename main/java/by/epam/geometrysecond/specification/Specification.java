package by.epam.geometrysecond.specification;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.warehouse.KeyNotFoundException;

public interface Specification
{
    boolean specify(Triangle triangle) throws KeyNotFoundException;
}
