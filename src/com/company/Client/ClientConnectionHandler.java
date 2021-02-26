package com.company.Client;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientConnectionHandler implements Runnable {

    BufferedReader in;

    public ClientConnectionHandler(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        String newLine;
        try {
            while ((newLine = in.readLine()) != null) {
                System.out.println(newLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
