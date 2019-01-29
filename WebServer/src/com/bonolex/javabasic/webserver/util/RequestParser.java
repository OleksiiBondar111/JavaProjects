package com.bonolex.javabasic.webserver.util;

import com.bonolex.javabasic.webserver.entity.HttpMethod;
import com.bonolex.javabasic.webserver.entity.Request;
import com.bonolex.javabasic.webserver.exception.ServerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.bonolex.javabasic.webserver.exception.ErrorType.BAD_REQUEST;
import static com.bonolex.javabasic.webserver.exception.ErrorType.METHOD_NOT_ALLOWED;

/**
 * Created by OBondar on 27.01.2019.
 */
public class RequestParser {

    //GET / HTTP/1.1

    public Request parseRequest(BufferedReader reader) {
        try {
            Request request = new Request();
            String requestLine = reader.readLine();
            injectUriAndMethod(request, requestLine);
            injectHeaders(request, reader);
            return request;
        } catch (IllegalArgumentException e) {
            throw new ServerException(METHOD_NOT_ALLOWED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException(BAD_REQUEST);
        }
    }

    void injectUriAndMethod(Request request, String requestLine) {
        String[] splitRequestLine = requestLine.split(" ");
        request.setMethod(HttpMethod.getByName(splitRequestLine[0]));
        request.setUri(splitRequestLine[1]);

    }

    void injectHeaders(Request request, BufferedReader reader) throws IOException {
        Map<String, String> headers = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            String[] splitedHeader = line.split(": ");
            headers.put(splitedHeader[0], splitedHeader[1]);
        }
        request.setHeaders(headers);

    }
}
