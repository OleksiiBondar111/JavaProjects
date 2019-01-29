package com.bonolex.javabasic.webserver;

import com.bonolex.javabasic.webserver.entity.HttpMethod;
import com.bonolex.javabasic.webserver.entity.Request;
import com.bonolex.javabasic.webserver.util.RequestParser;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by OBondar on 27.01.2019.
 */
public class RequestParserTest {

//    @org.junit.Test
//    public void injectUriAndMethodTest() throws Exception {
//        String requestLine = "GET / HTTP/1.1";
//        Request request = new Request();
//        RequestParser requestParser = new RequestParser();
//        requestParser.injectUriAndMethod(request, requestLine);
//        Assert.assertEquals(HttpMethod.GET, request.getMethod());
//        Assert.assertEquals("/", request.getUri());
//
//    }
//
//    @org.junit.Test
//    public void injectHeadersTest() throws Exception {
//        String requestLine = "Host: localhost:3000\n" +
//                "Connection: keep-alive\n" +
//                "Purpose: prefetch\n" +
//                "Upgrade-Insecure-Requests: 1\n" +
//                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36\n" +
//                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\n" +
//                "Accept-Encoding: gzip, deflate, br\n" +
//                "Accept-Language: ru-UA,ru;q=0.9,uk-UA;q=0.8,uk;q=0.7,ru-RU;q=0.6,en-US;q=0.5,en;q=0.4\n" +
//                "Cookie: Idea-735ba44d=d2f0bb99-dd10-4ca5-9632-914bc283da52";
//        InputStream in = new ByteArrayInputStream(requestLine.getBytes(StandardCharsets.UTF_8));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//        Request request = new Request();
//        RequestParser requestParser = new RequestParser();
//        requestParser.injectHeaders(request, new BufferedReader(bufferedReader));
//        Assert.assertTrue(request.getHeaders().containsKey("Host"));

 //   }

}