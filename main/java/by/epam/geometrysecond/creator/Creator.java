package by.epam.geometrysecond.creator;

import by.epam.geometrysecond.entity.Figure;
import by.epam.geometrysecond.exception.IncorrectDataException;

import java.util.List;

public abstract class Creator<T>
{
    public abstract Figure createFigure(List<T> dataForFigure) throws IncorrectDataException;
}