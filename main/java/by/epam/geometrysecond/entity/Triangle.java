package by.epam.geometrysecond.entity;

import by.epam.geometrysecond.event.TriangleEvent;
import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.generator.IdGenerator;
import by.epam.geometrysecond.observer.Observable;
import by.epam.geometrysecond.observer.Observer;
import by.epam.geometrysecond.warehouse.KeyNotFoundException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure, Observable
{
    private final static Logger logger=LogManager.getLogger(Triangle.class);
    private List<Observer> observerList;
    private long triangleId;
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third)
    {
        triangleId= IdGenerator.generateId();
        this.first = first;
        this.second = second;
        this.third = third;
        observerList=new ArrayList<>();
    }

    @Override
    public void attach(Observer observer)
    {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer)
    {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() throws TriangleNotExistsException, KeyNotFoundException
    {
        for(Observer observer: observerList)
        {
            observer.update(new TriangleEvent(this));
        }
    }

    public boolean setPoint(Point point, double x, double y)
    {
        boolean result=false;
        if(point.equals(first) || point.equals(second) || point.equals(third))
        {
            double oldX=point.getX();
            double oldY=point.getY();
            point.setX(x);
            point.setY(y);
            try
            {
                notifyObservers();
                result=true;
            }
            catch(TriangleNotExistsException e)
            {
                logger.log(Level.ERROR, e);
                point.setX(oldX);
                point.setY(oldY);
            }
            catch(KeyNotFoundException e)
            {
                logger.log(Level.ERROR, e);
            }
        }
        return result;
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public Point getThird() {
        return third;
    }

    public long getTriangleId()
    {
        return triangleId;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "triangleId=" + triangleId +
                ", first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return triangleId == triangle.triangleId &&
                first.equals(triangle.first) &&
                second.equals(triangle.second) &&
                third.equals(triangle.third);
    }

    @Override
    public int hashCode()
    {
        final int prime=31;
        int result=1;
        result=result*prime+Long.valueOf(triangleId).hashCode();
        result=result*prime+first.hashCode();
        result=result*prime+second.hashCode();
        result=result*prime+third.hashCode();
        return result;
    }
}