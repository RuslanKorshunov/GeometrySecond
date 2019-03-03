package by.epam.geometrysecond.repository;

import by.epam.geometrysecond.action.TriangleAction;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.TriangleNotExistsException;
import by.epam.geometrysecond.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleRepository implements Repository
{
    private final static Logger logger = LogManager.getLogger(TriangleAction.class.getName());
    private static TriangleRepository triangleRepository=new TriangleRepository();
    private Set<Triangle> triangleSet=new HashSet<>();

    private TriangleRepository(){}

    public static TriangleRepository getTriangleRepository()
    {
        return triangleRepository;
    }

    //TODO бред!
    @Override
    public boolean add(Triangle triangle)
    {
        boolean result=false;
        if(triangleSet.add(triangle))
        {
            TriangleAction triangleAction=new TriangleAction();
            try
            {
                double perimeter = triangleAction.perimeter(triangle);
                double square = triangleAction.square(triangle);
                Warehouse warehouse=Warehouse.getWarehouse();
                warehouse.put(triangle.getTriangleId(), square, perimeter);
                result=true;
            }
            catch(TriangleNotExistsException e)
            {
                remove(triangle);
                logger.log(Level.ERROR, e.getMessage());
            }
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
        /*List<Triangle> triangleSet=new LinkedList<>();
        for(Triangle triangle: this.triangleSet)
        {
            try
            {
                if(specification.specify(triangle))
                {
                    triangleSet.add(triangle);
                }
            }
            catch(CustomException e)
            {
                logger.log(Level.ERROR, e.getMessage());
            }
        }*/
        return triangleList;
    }
}
