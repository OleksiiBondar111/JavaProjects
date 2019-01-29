package com.bonolex.javabasic.webserver.server;

import com.bonolex.javabasic.webserver.exception.ServerException;
import com.bonolex.javabasic.webserver.util.RequestParser;
import com.bonolex.javabasic.webserver.util.ResponseWriter;
import com.bonolex.javabasic.webserver.entity.Request;
import com.bonolex.javabasic.webserver.io.ResourceReader;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;

import static com.bonolex.javabasic.webserver.exception.ErrorType.INTERNAL_SERVER_ERROR;

/**
 * Created by OBondar on 27.01.2019.
 */
public class RequestHandler {

    private BufferedReader reader;
    private BufferedWriter writer;
    private BufferedOutputStream streamWriter;

    private String webAppPath;

    public void handle() {
        // write response
     //   ResponseWriter responseWriter = new ResponseWriter(writer);
        ResponseWriter responseStreamWriter = new ResponseWriter(streamWriter);

        try {
            // parse request
            RequestParser requestParser = new RequestParser();
            Request request = requestParser.parseRequest(reader);
            // read resource
            ResourceReader resourceReader = new ResourceReader();
            resourceReader.setWebAppPath(webAppPath);
            //String content = resourceReader.readContent(request.getUri());
            InputStream content = resourceReader.readContent(request.getUri());
            // write content
             responseStreamWriter.writeSuccessContent(content);
        } catch (ServerException e) {
            e.printStackTrace();
            responseStreamWriter.writeErrorResponse(e.getErrorType());
        } catch (Exception e) {
            responseStreamWriter.writeErrorResponse(INTERNAL_SERVER_ERROR);
        }
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public String getWebAppPath() {
        return webAppPath;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public BufferedOutputStream getStreamWriter() {
        return streamWriter;
    }

    public void setStreamWriter(BufferedOutputStream streamWriter) {
        this.streamWriter = streamWriter;
    }
}
