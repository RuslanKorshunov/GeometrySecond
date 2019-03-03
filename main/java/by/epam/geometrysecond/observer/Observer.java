package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.event.TriangleEvent;
import by.epam.geometrysecond.exception.CustomException;

public interface Observer
{
    void update(TriangleEvent event) throws CustomException;
}
