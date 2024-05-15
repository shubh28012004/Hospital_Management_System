package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;

    Room(){

        // Creating and configuring the main panel
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Adding an image icon for decoration
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        // Creating a table to display room information
        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);

        try{
            // Fetching room information from the database and displaying it in the table
            Conn c = new Conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        // Adding labels for column headers
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(290,15,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(400,15,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        // Adding a button to go back to the previous window
        JButton back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.YELLOW);
        back.setForeground(Color.black);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Configuring the frame
        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}