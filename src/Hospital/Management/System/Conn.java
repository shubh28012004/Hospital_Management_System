// DATABASE CONNECTION(MYSQL) FROM JAVA
package Hospital.Management.System;

// Importing required packages for database Connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    // It will be used for database connection
    Connection connection;

    // It will be used for running the query
    Statement statement;

    public Conn(){
        // Handling exception as during database connection there might be exceptions so in order to have smooth running of error we will handle these exception using try-catch block
        try {
            // Connecting java code with Hospital_Management_System present in MySql Workbench
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_System", "root","Maple@2022");

            // Creation object associated with Connection Class
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace(); // Print the overall location of the exception where it has occurred
        }

    }

}
