package models;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {
    private PrintWriter printWriter;
    private Socket socket;
    private Client client;

    public WriteThread(Socket socket, Client client) throws IOException {
        this.socket = socket;
        this.client = client;
        OutputStream outputStream = socket.getOutputStream();
        printWriter = new PrintWriter(outputStream, true);
    }

    @Override
    public void run() {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter your username:");
        String userName = console.nextLine();
        client.setUserName(userName);
        printWriter.println(userName);

        String userInput;
        do {
            System.out.print("[" + userName + "]: ");
            userInput = console.nextLine();
            printWriter.println(userInput);
        } while (!userInput.equals("**terminate"));

        try {
            socket.close();
            System.out.println("Closing socket from WriteThread.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
