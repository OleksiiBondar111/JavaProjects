package com.luxoft.userstore.servlets.save;

import com.luxoft.userstore.entity.User;
import com.luxoft.userstore.entityDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by OBondar on 31.01.2019.
 */
public class SaveFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Add New Employee</h1>");
        out.print("<form action='SaveServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td>FirstName:</td><td><input type='text' name='firstName'/></td></tr>");
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName'/> </td></tr>");
        out.print("<tr><td>Salary:</td><td><input type='text' name='salary'/></td></tr>");
        out.print("<tr><td>Date of Birth:</td><td><input type='date' name='dateOfBirth'/></td></tr>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.close();
    }
}
