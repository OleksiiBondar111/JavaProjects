package com.luxoft.userstore.servlets.edit;

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
public class EditFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String stringId=request.getParameter("id");
        int id=Integer.parseInt(stringId);

        User user= UserDAO.getUserById(id);

        response.setContentType("text/html");
        out.println("<h1>Update Employee</h1>");
        out.print("<form action='EditServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+user.getId()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='firstName' value='"+user.getFirstName()+"'/></td></tr>");
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName' value='"+user.getLastName()+"'/> </td></tr>");
        out.print("<tr><td>Salary:</td><td><input type='text' name='salary' value='"+user.getSalary()+"'/></td></tr>");
        out.print("<tr><td>Date of Birth:</td><td><input type='date' name='dateOfBirth' value='"+user.getDateOfBirth()+"'/></td></tr>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}