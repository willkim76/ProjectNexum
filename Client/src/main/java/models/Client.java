package models;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String serverName;
    private int port;
    private String userName;

    public Client(String serverName, int port) {
        this.serverName = serverName;
        this.port = port;
    }

    public void execute() {
        try {
            Socket socket = new Socket(serverName, port);

            System.out.println("Connected to Master Server");

            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();

        } catch (IOException e) {
            if (e.getClass() == UnknownHostException.class) {
                System.out.println("Server cannot be reached: " + e.getMessage());
            } else {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
}
