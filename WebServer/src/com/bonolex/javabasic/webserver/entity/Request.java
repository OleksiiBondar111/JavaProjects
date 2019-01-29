package com.bonolex.javabasic.webserver.entity;

import java.util.Map;

/**
 * Created by OBondar on 27.01.2019.
 */
public class Request {

    private String uri;
    private HttpMethod method;
    private Map<String, String> headers;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Request{" +
                "uri='" + uri + '\'' +
                ", method=" + method +
                '}';
    }
}
