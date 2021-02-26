package com.company.Server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerConnectionHandler {

    private List<ClientData> clientDataList ;


    public ServerConnectionHandler() {
        this.clientDataList = new ArrayList<>();
    }

    public void addSocket(Socket clientSocket) {
        ClientData clientData = new ClientData(clientSocket,this);
        clientDataList.add(clientData);
        new Thread(clientData).start();
    }

    public void update(String message, Socket socket) {
        for (ClientData clientData : clientDataList)
        {
            if(clientData.clientSocket != socket) {
                clientData.write(message);
            }
        }
    }
}
