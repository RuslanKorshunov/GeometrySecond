package by.epam.geometrysecond.repository;

import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.specification.Specification;

import java.util.List;
import java.util.function.Predicate;

public interface Repository
{
    boolean add(Triangle triangle);
    boolean remove(Triangle triangle);
    //TODO
    List<Triangle> query(Predicate predicate);
}
