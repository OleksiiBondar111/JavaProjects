package com.bonolex.javabasic.webserver.entity;

/**
 * Created by OBondar on 27.01.2019.
 */
public enum HttpMethod {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete"),
    OPTIONS("options"),
    HEAD("head");

    private final String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public static HttpMethod getByName(String name) {
        HttpMethod[] httpMethods = values();
        for (HttpMethod httpMethod : httpMethods) {
            if (httpMethod.name.equalsIgnoreCase(name)) {
                return httpMethod;
            }
        }
        throw new IllegalArgumentException("No method for name: " + name + " found");
    }

    public String getName() {
        return name;
    }


}