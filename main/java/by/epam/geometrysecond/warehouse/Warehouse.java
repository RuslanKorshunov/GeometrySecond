package by.epam.geometrysecond.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse
{
    private static Warehouse warehouse=new Warehouse();
    private Map<Long, List<Double>> allData=new HashMap<>();

    private Warehouse(){}

    public static Warehouse getWarehouse()
    {
        return warehouse;
    }

    public void put(long triangleId, double square, double perimeter)
    {
        Long key=triangleId;
        List<Double> data=new ArrayList<>();
        data.add(square);
        data.add(perimeter);
        allData.put(key, data);
    }

    public void remove(long triangleId)
    {
        allData.remove(triangleId);
    }

    public double findPerimeter(long triangleId) throws KeyNotFoundException
    {
        double perimeter=0;
        if(allData.containsKey(triangleId))
        {
            perimeter=allData.get(triangleId).get(1);
        }
        else
        {
            throw new KeyNotFoundException("The triangle with Id="+triangleId+" doesn't exit in Warehouse");
        }
        return perimeter;
    }

    public void changePerimeter(long triangleId, double perimeter) throws KeyNotFoundException
    {
        if(allData.containsKey(triangleId))
        {
            List<Double> data=allData.get(triangleId);
            data.set(1, perimeter);
        }
        else
        {
            throw new KeyNotFoundException("The triangle with Id="+triangleId+" doesn't exit in Warehouse");
        }
    }

    public double findSquare(long triangleId) throws KeyNotFoundException
    {
        double square=0;
        if(allData.containsKey(triangleId))
        {
            square=allData.get(triangleId).get(0);
        }
        else
        {
            throw new KeyNotFoundException("The triangle with Id="+triangleId+" doesn't exit in Warehouse");
        }
        return square;
    }

    public void changeSquare(long triangleId, double square) throws KeyNotFoundException
    {
        if(allData.containsKey(triangleId))
        {
            List<Double> data=allData.get(triangleId);
            data.set(0, square);
        }
        else
        {
            throw new KeyNotFoundException("The triangle with Id="+triangleId+" doesn't exit in Warehouse");
        }
    }
}