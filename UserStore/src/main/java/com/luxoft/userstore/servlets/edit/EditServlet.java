package com.luxoft.userstore.servlets.edit;

import com.luxoft.userstore.entity.User;
import com.luxoft.userstore.entityDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;

import static com.luxoft.userstore.util.Const.SQL_DATE_FORMAT;

/**
 * Created by OBondar on 31.01.2019.
 */
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String salaryString = request.getParameter("salary");
        double salary = Double.parseDouble(salaryString);
        String dateOfBirth = request.getParameter("dateOfBirth");

        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setSalary(salary);
        java.util.Date date;
        String newDate = "";
        try {
            date = SQL_DATE_FORMAT.parse(dateOfBirth);
            newDate = SQL_DATE_FORMAT.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setDateOfBirth(java.sql.Date.valueOf(newDate));

        int status = UserDAO.update(user);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Unable to update record");
        }
        out.close();
    }

}