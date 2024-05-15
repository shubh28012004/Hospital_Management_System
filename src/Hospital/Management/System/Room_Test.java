package Hospital.Management.System;



import java.sql.ResultSet;
import java.util.Scanner;

// Custom exception class for handling duplicate room numbers
class DuplicateRoomException extends Exception {
    public DuplicateRoomException(String message) {
        super(message);
    }
}

public class Room_Test {

    public static void main(String[] args) {
        try {
            Conn c = new Conn(); // Creating an instance of Conn class for database connection
            Scanner scanner = new Scanner(System.in); // Creating a Scanner object to read user inputs

            // Taking input from user
            System.out.println("Enter ID type (Aadhar Card, Voter Id, Driving License): ");
            String idType = scanner.nextLine();

            System.out.println("Enter ID number: ");
            String idNumber = scanner.nextLine();

            // Check if the ID already exists in the database
            String checkQuery = "select * from Patient_Info where Number = '" + idNumber + "'";
            ResultSet resultSet = c.statement.executeQuery(checkQuery);
            if (resultSet.next()) {
                throw new DuplicateIdException("ID number already exists");
            }

            System.out.println("Enter patient name: ");
            String name = scanner.nextLine();

            System.out.println("Enter gender (Male/Female): ");
            String gender = scanner.nextLine();

            System.out.println("Enter disease: ");
            String disease = scanner.nextLine();

            System.out.println("Enter room number: ");
            String roomNumber = scanner.nextLine();

            // Check if the room number is already assigned to a patient
            String roomCheckQuery = "select * from Patient_Info where Room_Number = '" + roomNumber + "'";
            ResultSet roomResultSet = c.statement.executeQuery(roomCheckQuery);
            if (roomResultSet.next()) {
                throw new DuplicateRoomException("Room number already assigned to a patient");
            }

            System.out.println("Enter deposit amount: ");
            String deposit = scanner.nextLine();

            // Getting current date and time
            java.util.Date date = new java.util.Date();
            String dateTime = date.toString();

            // Inserting patient information into the database
            String query = "insert into Patient_Info values ('" + idType + "', '" + idNumber + "','" + name + "','" + gender + "', '" + disease + "', '" + roomNumber + "', '" + dateTime + "', '" + deposit + "')";
            String query1 = "update room set Availiablity = 'Occupied' where room_no = " + roomNumber;

            c.statement.executeUpdate(query); // Executing the query to add patient information
            c.statement.executeUpdate(query1); // Updating room availability

            System.out.println("Patient added successfully!");

        } catch (DuplicateIdException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DuplicateRoomException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

