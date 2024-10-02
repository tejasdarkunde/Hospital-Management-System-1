package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_Info extends JFrame {
    Employee_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from employee";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setBounds(10,9,70,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1 = new JLabel("Age");
        label1.setBounds(155,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(280,9,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Salary");
        label3.setBounds(420,9,70,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gmail");
        label4.setBounds(565,9,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Aadhar Number");
        label5.setBounds(700,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

//        JLabel label6 = new JLabel("Department");
//        label6.setBounds(850,9,150,20);
//        label6.setFont(new Font("Tahoma",Font.BOLD,14));
//        panel.add(label6);

        JButton b = new JButton("Back");
        b.setBounds(420,480,120,30);
        b.setBackground(new Color(30,86,49));
        b.setForeground(Color.white);
        panel.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLocation(180,110);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_Info();
    }
}
