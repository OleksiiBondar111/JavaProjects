package com.bonolex.javabasic.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by OBondar on 25.01.2019.
 */
public class Server implements Runnable {
    Socket clientSocket;
    private static Server server = new Server();

    private Server() {

    }

    public static  Server getServer(){
       return server;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("ServerTest is started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            Server server = Server.getServer();
            server.setClientSocket(socket);

        }

    }

    @Override
    public void run() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String input;
            while ((input = in.readLine()) != null) {
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println("echo: " + input);
                System.out.println(input);
            }
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}