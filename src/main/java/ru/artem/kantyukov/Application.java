package ru.artem.kantyukov;


import ru.artem.kantyukov.services.ChatService;
import ru.artem.kantyukov.services.ChatServiceImpl;


public class Application {

    public static void main(String[] args)  {

        ChatService chatService = new ChatServiceImpl();
        chatService.start();


        }
    }

