package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setBounds(10,11,100,14);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1 = new JLabel("Car Name");
        label1.setBounds(234,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Available");
        label2.setBounds(460,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Location");
        label3.setBounds(686,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JButton b = new JButton("Back");
        b.setBounds(380,500,120,30);
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
        setSize(900,600);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Ambulance();
    }
}
