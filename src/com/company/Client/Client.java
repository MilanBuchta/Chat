package com.company.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    static int portNumber = 9000;

    public static void main(String[] args) {
        try {

            Socket socket = new Socket(InetAddress.getLocalHost(), portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader intStd = new BufferedReader(new InputStreamReader(System.in));

            new Thread(new ClientConnectionHandler(in)).start();

            String newLine;
            while ((newLine = intStd.readLine()) != null) {
                out.println(newLine);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
