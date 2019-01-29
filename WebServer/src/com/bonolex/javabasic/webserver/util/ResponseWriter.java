package com.bonolex.javabasic.webserver.util;

import com.bonolex.javabasic.webserver.exception.ErrorType;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by OBondar on 27.01.2019.
 */
public class ResponseWriter {
    private static final String LINE_END = "\n";
    private BufferedOutputStream streamWriter;

    public ResponseWriter(BufferedOutputStream streamWriter) {
        this.streamWriter = streamWriter;
    }

    public void writeSuccessContent(InputStream content) {
        String line = "HTTP/1.1 200 OK";
        try {
            streamWriter.write(line.getBytes(Charset.forName("UTF-8")));
            streamWriter.write(LINE_END.getBytes());
            streamWriter.write(LINE_END.getBytes());
            int bytesRead;
            byte buffer[] = new byte[1024];
            while ((bytesRead = content.read(buffer)) != -1) {
                streamWriter.write(buffer, 0, bytesRead);
            }
            content.close();
            streamWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeErrorResponse(ErrorType errorType) {
        try {
            streamWriter.write(errorType.getStatusLine().getBytes());
            streamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
