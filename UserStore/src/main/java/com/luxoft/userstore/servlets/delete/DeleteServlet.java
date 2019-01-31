package com.luxoft.userstore.servlets.delete;

import com.luxoft.userstore.entityDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by OBondar on 31.01.2019.
 */
public class DeleteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id");
        int id = Integer.parseInt(userId);
        UserDAO.delete(id);
        response.sendRedirect("ViewServlet");
    }
}
