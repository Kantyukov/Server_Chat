package ru.artem.kantyukov.services;




import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientRunnable implements Runnable, Observer {

    private static Socket socket;
    private static ServerService serverService;

    public ClientRunnable(Socket socket, ServerServiceImpl serverService) {
        ClientRunnable.socket = socket;
        ClientRunnable.serverService = serverService;

    }


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Client connected");
        serverService.addObserver(this);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageFromClient;
        while ((messageFromClient = bufferedReader.readLine())!=null){
            System.out.println(messageFromClient);
            serverService.notifyObservers(messageFromClient);
        }

    }

    @Override
    public void notifyMe(String message) throws IOException {
        PrintWriter serverWriter = new PrintWriter(socket.getOutputStream());
        serverWriter.println(message);
        serverWriter.flush();
    }
}
