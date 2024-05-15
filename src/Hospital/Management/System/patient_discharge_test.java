package Hospital.Management.System;



import java.util.Scanner;

// Custom exception class for handling discharged patient details
class DischargedPatientException extends Exception {
    public DischargedPatientException(String message) {
        super(message);
    }
}

public class patient_discharge_test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient ID: ");
        String patientId = scanner.nextLine();

        try {
            // Simulating database access and patient discharge status
            boolean isPatientDischarged = isPatientDischarged(patientId);

            if (isPatientDischarged) {
                throw new DischargedPatientException("Patient details not found. Patient may have been discharged.");
            } else {
                System.out.println("Patient details found. Proceed with checkout process.");
                // Perform checkout process
            }
        } catch (DischargedPatientException e) {
            System.out.println("Error: " + e.getMessage());
            // Handle the case where the patient is discharged
        } finally {
            scanner.close();
        }
    }

    // Method to simulate checking if patient is discharged
    private static boolean isPatientDischarged(String patientId) {
        // Simulating patient discharge status
        return patientId.equals("123"); // Assume patient with ID "123" is discharged
    }
}

