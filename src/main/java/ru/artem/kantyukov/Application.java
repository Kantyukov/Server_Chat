package ru.artem.kantyukov;


import ru.artem.kantyukov.services.ServerService;
import ru.artem.kantyukov.services.ServerServiceImpl;


public class Application {

    public static void main(String[] args)  {

        ServerService serverService = new ServerServiceImpl();
        serverService.start();


        }
    }

