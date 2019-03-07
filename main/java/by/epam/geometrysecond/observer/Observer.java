package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.event.TriangleEvent;

public interface Observer
{
    void update(TriangleEvent event) throws Exception;
}
