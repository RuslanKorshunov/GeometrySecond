package by.epam.geometrysecond.observer;

import by.epam.geometrysecond.exception.CustomException;

public interface Observable
{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers() throws CustomException;
}
