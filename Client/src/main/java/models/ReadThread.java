package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private Client client;

    public ReadThread(Socket socket, Client client) throws IOException {
        this.socket = socket;
        this.client = client;
        InputStream inputStream = this.socket.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public void run() {
        while (true) {
            try {
                String response = reader.readLine();
                System.out.println(response);

                if (client.getUserName() != null) {
                    System.out.println("[" + client.getUserName() + "]:");
                }
            } catch (IOException e) {
                System.out.println("Error reading from server");
                e.printStackTrace();
                break;
            }
        }

        System.out.println("ReadThread terminated.");
    }
}
