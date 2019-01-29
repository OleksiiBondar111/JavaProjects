package com.bonolex.javabasic.webserver.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by OBondar on 26.01.2019.
 */
public class Server {
    private int port;
    private String webAppPath;

    public Server() {

    }

    public Server(int port, String webAppPath) {
        this.port = port;
        this.webAppPath = webAppPath;
    }

    public void start() throws IOException {

        System.out.println("Server has been started");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // unable to multithreaded flow
//                Thread thread = new Thread(new ServerTask(socket,webAppPath));
//                thread.start();
                try (Socket socket = serverSocket.accept();
                    BufferedOutputStream socketStreamWriter = new BufferedOutputStream(socket.getOutputStream());
                    BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    RequestHandler requestHandler = new RequestHandler();
                    requestHandler.setReader(socketReader);
                    requestHandler.setStreamWriter(socketStreamWriter);
                    requestHandler.setWebAppPath(webAppPath);
                    try {
                        requestHandler.handle();
                    } catch (Exception e) {
                        System.out.println("Something bad happened, but we still alive");
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getWebAppPath() {
        return webAppPath;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public int getPort() {
        return port;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(3000, "resources/webapp");
        server.start();
    }
}
