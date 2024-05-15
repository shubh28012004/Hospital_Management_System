package Hospital.Management.System;

import java.sql.ResultSet;
import java.util.Scanner;

// Custom exception class for handling login exceptions
class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

public class Login_Test {

    public static void main(String[] args) {
        try {
            // Creating an instance of Conn class for database connection
            Conn c = new Conn();
            Scanner scanner = new Scanner(System.in);

            // Getting username from user
            System.out.print("Enter username: ");
            String user = scanner.nextLine();

            // Getting password from user
            System.out.print("Enter password: ");
            String pass = scanner.nextLine();

            // SQL query to check login credentials
            String q = "select * from login where ID = '" + user + "'";
            // Executing the SQL query
            ResultSet resultSet = c.statement.executeQuery(q);

            // If username is not found in the database
            if (!resultSet.next()) {
                throw new LoginException("Username not found");
            }

            // If username is found but password does not match
            if (!resultSet.getString("Password").equals(pass)) {
                throw new LoginException("Invalid password");
            }

            // If login is successful
            System.out.println("Login successful!");

        } catch (LoginException le) {
            // Handling custom login exceptions
            System.out.println("Login failed: " + le.getMessage());
        } catch (Exception ex) {
            // Printing stack trace if an exception occurs
            ex.printStackTrace();
        }
    }
}
