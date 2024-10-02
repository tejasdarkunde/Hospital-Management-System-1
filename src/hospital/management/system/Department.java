package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(5,40,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from department_table";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label = new JLabel("Department Name");
        label.setBounds(5,11,105,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1 = new JLabel("Phone Number");
        label1.setBounds(350,11,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JButton b = new JButton("Back");
        b.setBounds(280,390,130,30);
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
        setSize(700,500);
        setLayout(null);
        setLocation(350,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
