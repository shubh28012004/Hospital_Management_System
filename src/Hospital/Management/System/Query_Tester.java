package Hospital.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Query_Tester {

    public static void main(String[] args) {
        // Variables for user ID and password
        String user = "some_user_id";
        String pass = "some_password";
        String s1 = "id_used";
        String s2 = "id_number";
        String s3 = "name";
        String s4 = "Gender";
        String s5 = "disease";
        String s6 = "room_no";
        String s7 = "data";
        String s8 = "deposit";

        // Create an instance of the Conn class to establish the database connection
        Conn conn = new Conn();

        try {
            // SQL query to check login credentials
            String q = "select * from login where ID = '" + user + "' and Password = '" + pass + "'";

            String r = "insert into Patient_Info values ('" + s1 + "', '" + s2 + "','" + s3 + "','" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', '" + s8 + "')"; // Creating a query
            String s = "update room set Availiablity = 'Occupied' where room_no = " + s6; // Creating another query

            // Executing the query and getting the result set
            ResultSet resultSet = conn.statement.executeQuery(q);

            System.out.println(resultSet.getClass().getSimpleName()); // ResultSetImpl is a common class name used for implementations of the ResultSet interface in JDBC.

            int rowsInserted = conn.statement.executeUpdate(r);
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }

            int rowsUpdated = conn.statement.executeUpdate(s);
            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Failed to update data.");
            }

            // Check if the result set has any rows (meaning login is successful)
            if (resultSet.next()) {
                // Login successful
                System.out.println("Login successful!");
            } else {
                // Login failed
                System.out.println("Invalid credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the overall location of the exception where it has occurred
        } finally {
            try {
                // Close the database connection
                conn.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
