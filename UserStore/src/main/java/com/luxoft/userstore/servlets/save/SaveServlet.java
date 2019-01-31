package com.luxoft.userstore.servlets.save;

import com.luxoft.userstore.entity.User;
import com.luxoft.userstore.entityDAO.UserDAO;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.luxoft.userstore.util.Const.SQL_DATE_FORMAT;

/**
 * Created by OBondar on 31.01.2019.
 */
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
      //  final SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String salaryString = request.getParameter("salary");
        String dateOfBirth = request.getParameter("dateOfBirth");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        double salary = Double.parseDouble(salaryString);
        user.setSalary(salary);
        Date date;
        String newDate = "";
        try {
            date = SQL_DATE_FORMAT.parse(dateOfBirth);
            newDate = SQL_DATE_FORMAT.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setDateOfBirth(java.sql.Date.valueOf(newDate));

        int status = UserDAO.save(user);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Unable to save record");
        }

        out.close();
    }

}