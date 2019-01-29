package com.bonolex.javabasic.webserver.exception;

public enum ErrorType {

    NOT_FOUND(404, "Not found"),
    BAD_REQUEST(400, "Bad request"),
    METHOD_NOT_ALLOWED(405, "Method not allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server error");


    private final int statusCode;
    private final String statusMessage;

    ErrorType(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    //"HTTP/1.1 500 Internal Server Error"
    public String getStatusLine() {
        return "HTTP/1.1" + " " + statusCode + " " + statusMessage;
    }
}
