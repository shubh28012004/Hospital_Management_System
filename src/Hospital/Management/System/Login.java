// Importing necessary packages
package Hospital.Management.System;

// Importing Conn class from another package
import Hospital.Management.System.Conn;

// Importing required classes for GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// Login class extending JFrame and implementing ActionListener
public class Login extends JFrame implements ActionListener {

    // Declaring Global variables which can be used in part of code
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    // Default Constructor for Login class
    Login() {

        // Creating and configuring JLabel for "Username"
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        // Creating and configuring JLabel for "Password"
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        // Creating and configuring JTextField for username input
        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        add(textField);

        // Creating and configuring JPasswordField for password input
        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 179, 0));
        add(jPasswordField);

        // Creating and configuring ImageIcon for login image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login2.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, -30, 400, 300);
        add(label);

        // Creating and configuring JButton for "Login"
        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        // Creating and configuring JButton for "Cancel"
        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.YELLOW);
        b2.setForeground(Color.BLACK    );
        b2.addActionListener(this);
        add(b2);

        // Setting background color for the frame
        getContentPane().setBackground(new Color(109, 164, 170));
        // Setting size of the frame
        setSize(750, 300);
        // Setting location of the frame
        setLocation(400, 270);
        // Setting layout to null
        setLayout(null);
        // Setting frame visibility to true
        setVisible(true);

    }

    // Method for handling button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                // Creating an instance of Conn class for database connection
                Conn c = new Conn();
                // Getting username from textField
                String user = textField.getText();
                // Getting password from jPasswordField
                String Pass = jPasswordField.getText();

                // SQL query to check login credentials
                String q = "select * from login where ID = '" + user + "' and  Password = '" + Pass + "'";
                // Executing the SQL query
                ResultSet resultSet = c.statement.executeQuery(q);

                // If login is successful
                if (resultSet.next()) {
                    // Opening new Reception window
                    new Reception();
                    // Hiding the Login window
                    setVisible(false);
                } else {
                    // Showing invalid message if login fails
                    JOptionPane.showMessageDialog(null, "Invalid");
                }

            } catch (Exception E) {
                // Printing stack trace if an exception occurs
                E.printStackTrace();
            }

        } else {
            // Exiting the program if "Cancel" button is clicked
            System.exit(10);
        }

    }

    // Main method
    public static void main(String[] args) {
        // Creating an instance of Login class
        new Login();
    }

}
