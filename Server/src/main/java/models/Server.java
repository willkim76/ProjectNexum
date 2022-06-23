package models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private final ServerSocket serverSocket;
    private Set<String> clientNames;
    private Set<ClientThread> clientThreads;

    private final String name;
    private final String key;
    private final int portNumber;

    /**
     * Default constructor, creates a
     */
    public Server() throws IOException {
        this("Master", null);
    }

    public Server(String name, String key) throws IOException {
        this(name, key, 0);
    }

    public Server(String name, String key, int portNumber) throws IOException {
        this.clientNames = new HashSet<>();
        this.clientThreads = new HashSet<>();
        this.name = name;
        this.key = key;
        this.serverSocket = new ServerSocket(portNumber);
        this.portNumber = serverSocket.getLocalPort();
    }

    public void execute() throws IOException {
        System.out.println(String.format("%s server is listening on port: %s", this.name, this.portNumber));

        while (true) {
            Socket socket = this.serverSocket.accept();

            System.out.println("New client has connected.");

            ClientThread newClient = new ClientThread(socket, this);
            this.clientThreads.add(newClient);
            newClient.start();
        }

    }

    public void broadcast(String message, ClientThread origin) {
        this.clientThreads.forEach(client -> {
            if (client != origin) {
                client.sendMessage(message);
            }
        });
    }

    public void removeClient(String clientName, ClientThread client) {
        if (this.clientNames.remove(clientName)) {
            this.clientThreads.remove(client);
            System.out.println("Client " + clientName + "has self terminated");
        }
    }

    public void addClientName(String clientName) {
        this.clientNames.add(clientName);
    }

    public Set<String> getUserNames() {
        return this.clientNames;
    }

    public boolean hasClients() {
        return !this.clientThreads.isEmpty();
    }

    public int getPortNumber() {
        return portNumber;
    }

    public String getName() {
        return name;
    }
}
