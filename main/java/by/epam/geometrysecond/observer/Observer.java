package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.action.TriangleNotExistsException;
import by.epam.geometrysecond.event.TriangleEvent;
import by.epam.geometrysecond.warehouse.KeyNotFoundException;

public interface Observer
{
    void update(TriangleEvent event) throws TriangleNotExistsException, KeyNotFoundException;
}
