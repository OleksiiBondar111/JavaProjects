package com.bonolex.javabasic.webserver;

import com.bonolex.javabasic.webserver.server.RequestHandler;

import java.io.*;
import java.net.Socket;

/**
 * Created by OBondar on 27.01.2019.
 */
public class ServerTask implements Runnable {
    private final Socket socket;
    private String webAppPath;

    public ServerTask(Socket socket, String webAppPath) {
        this.socket = socket;
        this.webAppPath = webAppPath;
    }

    @Override
    public void run() {
        try (
                BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            RequestHandler requestHandler = new RequestHandler();
            requestHandler.setReader(socketReader);
            requestHandler.setWriter(socketWriter);
            requestHandler.setWebAppPath(this.webAppPath);
            requestHandler.handle();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
