package models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private Server server;
    private PrintWriter printWriter;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            InputStream input = this.socket.getInputStream();
            OutputStream output = this.socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            this.printWriter = new PrintWriter(output, true);

            printClients();

            String clientName = reader.readLine();
            server.addClientName(clientName);

            String serverMessage = "Client: " + clientName + " has connected.";
            server.broadcast(serverMessage, this);
            String clientMessage;

            do {
                clientMessage = reader.readLine();
                serverMessage = String.format("[%s]: %s", clientName, clientMessage);
                server.broadcast(serverMessage, this);
            } while (!clientMessage.equals("**terminate"));

            server.removeClient(clientName, this);
            //socket.close();

            serverMessage = "Client: " + clientName + " has disconnected.";
            server.broadcast(serverMessage, this);

        } catch (Exception e) {
            System.out.println("Error in ClientThread: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void printClients() {
        if (server.hasClients()) {
            sendMessage("Connected clients: " + server.getUserNames());
        } else {
            sendMessage("No clients connected to server");
        }
    }

    public void sendMessage(String message) {
        printWriter.println(message);
    }
}
