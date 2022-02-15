package ru.artem.kantyukov.services;

import java.io.IOException;

public interface Observer  {
    void notifyMe(String message) throws IOException;
}
