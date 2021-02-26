package com.company.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static int portNumber = 9000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            ServerConnectionHandler serverConnectionHandler = new ServerConnectionHandler();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                serverConnectionHandler.addSocket(clientSocket);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
