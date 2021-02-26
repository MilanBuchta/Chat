package com.company.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientData implements Runnable {

    Socket clientSocket;
    BufferedReader in = null;
    PrintWriter out = null;
    ServerConnectionHandler serverConnectionHandler = null;

    public ClientData(Socket clientSocket,ServerConnectionHandler serverConnectionHandler) {
        this.clientSocket = clientSocket;
        this.serverConnectionHandler = serverConnectionHandler;

        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String newLine;
        try {
            while ((newLine = in.readLine()) != null) {
                System.out.println(newLine);
                //out.println("Echo:" + newLine);
                serverConnectionHandler.update(newLine,clientSocket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(String message) {
        out.println(message);
    }

}
