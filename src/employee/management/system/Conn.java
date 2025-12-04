package employee.management.system;

import com.mysql.cj.jdbc.Driver;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connection;

    Statement statement;

    public Conn(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");      // jdbc

            // connection = DriverManager.getConnection(…) this will help me to connect java with sql
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Akhil#3012");

            // To execute SQL queries.
            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
