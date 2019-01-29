package com.luxoft.jdbctest;

import java.sql.*;
import java.util.StringJoiner;

/**
 * Created by OBondar on 29.01.2019.
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        //String sqlQuery = "SELECT id, Name,Surname,email FROM Users";

        // Get connection string as first parameter
        String connectionString=args[0];
        // Get SQL statement as second parameter
        String sqlQuery =args[1];
        //String sqlQuery = "insert into users values (4,'July','Barns','july.barns@gmail.com')";
      //  Connection connection = DriverManager.getConnection("jdbc:sqlite:G:\\SQLLite\\test.db");
        Connection connection = DriverManager.getConnection(connectionString);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        ResultSetMetaData metaData;
        if (sqlQuery.toUpperCase().startsWith("SELECT")) {
             resultSet = statement.executeQuery(sqlQuery);
             metaData = resultSet.getMetaData();
            StringJoiner stringJoiner = new StringJoiner("   ", "[", "]");
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                stringJoiner.add(metaData.getColumnName(i));
            }
            System.out.println(stringJoiner.toString());
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(" " + resultSet.getString(i) + "  ");
                }
                System.out.println();
            }
        } else{
            int rowsModified=statement.executeUpdate(sqlQuery);
            System.out.println("rowsModified: "+ rowsModified);

        }
        connection.close();

    }
}
