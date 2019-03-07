package by.epam.geometrysecond.action;

import by.epam.geometrysecond.entity.Point;
import by.epam.geometrysecond.entity.Triangle;
import by.epam.geometrysecond.exception.TriangleNotExistsException;

import java.util.Arrays;

public class TriangleAction
{
    public boolean isTriangle(Triangle triangle)
    {
        boolean answer=false;
        double[]sides= findSides(triangle);
        if(sides[0]<(sides[1]+sides[2]) && sides[1]<(sides[0]+sides[2]) && sides[2]<(sides[0]+sides[1]))
        {
            answer=true;
        }
        return answer;
    }

    public double calculateSide(Point first, Point second)
    {
        double answer=0;
        double firstSide=first.getX()-second.getX();
        double secondSide=first.getY()-second.getY();
        answer=Math.hypot(firstSide, secondSide);
        return answer;
    }

    public double perimeter(Triangle triangle) throws TriangleNotExistsException
    {
        double perimeter=0;
        if(isTriangle(triangle))
        {
            double[]sides= findSides(triangle);
            perimeter=sides[0]+sides[1]+sides[2];
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return perimeter;
    }

    public double square(Triangle triangle) throws TriangleNotExistsException
    {
        double square=0;
        if(isTriangle(triangle))
        {
            double semiperimeter=perimeter(triangle)/2;
            double[]sides= findSides(triangle);
            square=Math.sqrt(semiperimeter*(semiperimeter-sides[0])*(semiperimeter-sides[1])*(semiperimeter-sides[2]));
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return square;
    }

    public boolean isRightTriangle(Triangle triangle) throws TriangleNotExistsException
    {
        boolean answer=false;
        if(isTriangle(triangle))
        {
            double[]sides= findSides(triangle);
            if(sides[0]==Math.hypot(sides[1], sides[2]) ||
                    sides[1]==Math.hypot(sides[0], sides[2]) ||
                    sides[2]==Math.hypot(sides[0], sides[1]))
            {
                answer=true;
            }
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return answer;
    }

    public boolean isIsoscelesTriangle(Triangle triangle) throws TriangleNotExistsException
    {
        boolean answer=false;
        if(isTriangle(triangle))
        {
            double[]sides= findSides(triangle);
            if(sides[0]==sides[1] || sides[1]==sides[2] || sides[0]==sides[2])
            {
                answer=true;
            }
        }
        else
        {
            throw  new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return answer;
    }

    public boolean isEquilateralTriangle(Triangle triangle) throws TriangleNotExistsException
    {
        boolean answer=false;
        if(isTriangle(triangle))
        {
            double[]sides= findSides(triangle);
            if(sides[0]==sides[1] && sides[1]==sides[2])
            {
                answer=true;
            }
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return answer;
    }

    public boolean isAcuteTriangle(Triangle triangle) throws TriangleNotExistsException
    {
        boolean answer=false;
        if(isTriangle(triangle))
        {
            double[]sides=findSides(triangle);
            Arrays.sort(sides);
            if(sides[2]*sides[2]<sides[0]*sides[0]+sides[1]*sides[1])
            {
                answer=true;
            }
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return answer;
    }

    public boolean isObtuseTriangle(Triangle triangle) throws TriangleNotExistsException
    {
        boolean answer=false;
        if(isTriangle(triangle))
        {
            double[]sides=findSides(triangle);
            Arrays.sort(sides);
            if(sides[2]*sides[2]>sides[0]*sides[0]+sides[1]*sides[1])
            {
                answer=true;
            }
        }
        else
        {
            throw new TriangleNotExistsException(triangle.toString()+" doesn't exist");
        }
        return answer;
    }

    private double[] findSides(Triangle triangle)
    {
        Point first=triangle.getFirst();
        Point second=triangle.getSecond();
        Point third=triangle.getThird();
        double[]sides=new double[3];
        sides[0]=calculateSide(first, second);
        sides[1]=calculateSide(second, third);
        sides[2]=calculateSide(first, third);
        return sides;
    }
}