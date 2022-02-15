package ru.artem.kantyukov.services;



import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@RequiredArgsConstructor
public class ClientRunnable implements Runnable, Observer {

    private static Socket socket;

    public ClientRunnable(Socket socket) {
        ClientRunnable.socket = socket;

    }


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Client connected");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageFromClient;
        while ((messageFromClient = bufferedReader.readLine())!=null){
            System.out.println(messageFromClient);
        }

    }

    @Override
    public void notifyMe(String message) throws IOException {
        PrintWriter serverWriter = new PrintWriter(socket.getOutputStream());
        serverWriter.println(message);
        serverWriter.flush();
    }
}
