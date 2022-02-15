package ru.artem.kantyukov.services;

import java.io.IOException;

public interface Observable {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers(String message) throws IOException;



}
