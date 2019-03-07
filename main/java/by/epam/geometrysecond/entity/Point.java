package by.epam.geometrysecond.entity;

import by.epam.geometrysecond.generator.IdGenerator;

public class Point implements Figure
{
    private long pointId;
    private double x;
    private double y;

    public Point(double x, double y)
    {
        pointId= IdGenerator.generateId();
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "Point{" +
                "pointId=" + pointId +
                ", x=" + x +
                ", y=" + y +
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
        Point point = (Point) o;
        return pointId == point.pointId &&
                Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode()
    {
        final int prime=31;
        int result=1;
        result=prime*result+Double.valueOf(x).hashCode();
        result=prime*result+Long.valueOf(pointId).hashCode();
        result=prime*result+Double.valueOf(y).hashCode();
        return result;
    }
}