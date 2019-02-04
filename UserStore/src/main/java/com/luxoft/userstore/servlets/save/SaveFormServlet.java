package com.luxoft.userstore.servlets.save;

import com.luxoft.userstore.entity.User;
import com.luxoft.userstore.entityDAO.UserDAO;
import com.luxoft.userstore.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OBondar on 31.01.2019.
 */
public class SaveFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        Map<String, Object> parameters = new HashMap<>();
        String page = pageGenerator.getPage("create.html", parameters);

        response.getWriter().write(page);
    }
}
