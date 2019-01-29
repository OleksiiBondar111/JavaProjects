package com.bonolex.javabasic.webserver.io;

import com.bonolex.javabasic.webserver.exception.ErrorType;
import com.bonolex.javabasic.webserver.exception.ServerException;

import java.io.*;

import static com.bonolex.javabasic.webserver.exception.ErrorType.*;

/**
 * Created by OBondar on 27.01.2019.
 */
public class ResourceReader {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private String webAppPath;

//    public String readContent(String uri) {
//        File file = new File(webAppPath, uri);
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            StringBuilder content = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                content.append(line);
//                content.append(LINE_SEPARATOR);
//            }
//            return content.toString();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new ServerException(NOT_FOUND);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new ServerException(INTERNAL_SERVER_ERROR);
//        }
//    }

    public InputStream readContent(String uri) {
        File file = new File(webAppPath, uri);
        try  {
            InputStream reader = new FileInputStream(file);
            return reader;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ServerException(NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServerException(INTERNAL_SERVER_ERROR);
        }
    }

    public String getWebAppPath() {
        return webAppPath;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }
}
