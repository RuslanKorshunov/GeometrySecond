package by.epam.geometrysecond.repository;

import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.entity.Triangle;

import java.util.List;
import java.util.function.Predicate;

public interface Repository
{
    boolean add(Triangle triangle) throws TriangleNotExistsException;
    boolean remove(Triangle triangle);
    List<Triangle> query(Predicate predicate);
}
