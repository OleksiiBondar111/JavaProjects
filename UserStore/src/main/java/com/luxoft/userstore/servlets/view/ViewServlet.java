package com.luxoft.userstore.servlets.view;

import com.luxoft.userstore.entity.User;
import com.luxoft.userstore.entityDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by OBondar on 31.01.2019.
 */
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<a href='SaveFormServlet'>Add New Employee</a>");
        out.println("<h1>Users List</h1>");
        List<User> list = UserDAO.getAllUsers();
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>FirstName</th><th>SecondName</th><th>Salary</th><th>DateOfBirth</th>" +
                "<th>Edit</th><th>Delete</th></tr>");
        for (User user : list) {
            out.print("<tr><td>" + user.getId() + "</td><td>" + user.getFirstName() + "</td><td>" + user.getLastName() + "</td>" +
                    "<td>" + user.getSalary() + "</td><td>" + user.getDateOfBirth() + "</td><td><a href='EditFormServlet?id=" + user.getId() + "'>edit</a></td>"
                    + "<td><a href='DeleteServlet?id=" + user.getId() + "'>delete</a></td></tr>");
        }
        out.print("</table>");
        out.close();
    }
}
