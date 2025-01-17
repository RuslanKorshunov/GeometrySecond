package by.epam.geometrysecond.repository;

import by.epam.geometrysecond.action.TriangleAction;
import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.warehouse.Warehouse;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleRepository implements Repository
{
    private static TriangleRepository triangleRepository=new TriangleRepository();
    private Set<Triangle> triangleSet=new HashSet<>();

    private TriangleRepository(){}

    public static TriangleRepository getTriangleRepository()
    {
        return triangleRepository;
    }

    @Override
    public boolean add(Triangle triangle) throws TriangleNotExistsException
    {
        boolean result=false;
        TriangleAction triangleAction=new TriangleAction();
        if(triangleAction.isTriangle(triangle))
        {
            result=triangleSet.add(triangle);
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" can't be added, because it doesn't exit");
        }
        return result;
    }

    @Override
    public boolean remove(Triangle triangle)
    {
        boolean result=false;
        if(triangleSet.remove(triangle))
        {
            Warehouse warehouse=Warehouse.getWarehouse();
            warehouse.remove(triangle.getTriangleId());
            result=true;
        }
        return result;
    }

    @Override
    public List<Triangle> query(Predicate predicate)
    {
        Stream<Triangle> triangleStream=triangleSet.stream();
        List<Triangle> triangleList=(List)triangleStream.filter(predicate).collect(Collectors.toList());
        return triangleList;
    }

    @Override
    public List<Triangle> sort(Comparator comparator)
    {
        List<Triangle> triangleList=new ArrayList<>(triangleSet);
        triangleList.sort(comparator);
        return triangleList;
    }
}