package hospital.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.black);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status : ");
        status.setBounds(50,73,120,20);
        status.setForeground(Color.black);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(23,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.black);
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel RoomNo = new JLabel("Room Number");
        RoomNo.setBounds(23,162,150,20);
        RoomNo.setForeground(Color.black);
        RoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(RoomNo);

        JLabel available = new JLabel("Availability");
        available.setBounds(200,162,150,20);
        available.setForeground(Color.black);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(370,162,150,20);
        price.setForeground(Color.black);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(545,162,150,20);
        bed.setForeground(Color.black);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton search = new JButton("Search");
        search.setBounds(200,420,120,30);
        search.setBackground(new Color(30,86,49));
        search.setForeground(Color.white);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from room where Availablity = '"+choice.getSelectedItem()+"'";
                try{
                    conn c= new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,30);
        back.setBackground(new Color(30,86,49));
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
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
        new SearchRoom();
    }
}
