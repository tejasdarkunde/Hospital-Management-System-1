package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.black);
        panel.add(label);

        JLabel label1 = new JLabel("Customer ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.black);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.black);
        panel.add(label2);

        JLabel rn = new JLabel();
        rn.setBounds(200,130,150,20);
        rn.setFont(new Font("Tahoma",Font.BOLD,14));
        rn.setForeground(Color.black);
        panel.add(rn);

        JLabel label5 = new JLabel("Patient Name");
        label5.setBounds(30,180,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.black);
        panel.add(label5);

        JLabel name = new JLabel();
        name.setBounds(200,180,150,20);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.black);
        panel.add(name);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,230,250,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.black);
        panel.add(label3);

        JLabel intime = new JLabel();
        intime.setBounds(200,230,150,20);
        intime.setFont(new Font("Tahoma",Font.BOLD,14));
        intime.setForeground(Color.black);
        panel.add(intime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30,280,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.black);
        panel.add(label4);

        Date date = new Date();

        JLabel outtime = new JLabel(""+date);
        outtime.setBounds(200,280,250,20);
        outtime.setFont(new Font("Tahoma",Font.BOLD,14));
        outtime.setForeground(Color.black);
        panel.add(outtime);



        JButton check = new JButton("Check");
        check.setBounds(170,320,120,30);
        check.setBackground(new Color(30,86,49));
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        rn.setText(resultSet.getString("Room_Number"));
                        intime.setText(resultSet.getString("Time"));
                        name.setText(resultSet.getString("Name"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,320,120,30);
        discharge.setBackground(new Color(30,86,49));
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(rn.getText());
                System.out.println(name.getText());
                System.out.println("Hello");
                conn c = new conn();
                String deposite = null;
                String price = null;

                try {
                    ResultSet rs1 = c.statement.executeQuery("select * from room where Room_No = '" + rn.getText() + "'");
                    while (rs1.next()) {
                         price = rs1.getString("Price");
                    }

                    ResultSet rs = c.statement.executeQuery("Select * from patient_info where Name = '" + name.getText() + "'");
                    while (rs.next()) {
                        deposite = rs.getString("Deposite");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                   System.out.println(price);
                  System.out.println(deposite);

                    if(price.equals("deposite")){
                        try {
                            c.statement.executeUpdate("delete from patient_info where Number = '"+choice.getSelectedItem()+"'");
                            c.statement.executeUpdate("update room set Availablity = 'Available' where Room_No = '"+rn.getText()+"'");
                            JOptionPane.showMessageDialog(null,"Patient Discharge Done...");
                            setVisible(false);
                        }catch (Exception e1){
                            e1.printStackTrace();
                       }
                    }else
                        JOptionPane.showMessageDialog(null,"Please Pay the bill");

            }});

        JButton back = new JButton("Back");
        back.setBounds(320,320,120,30);
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
        setSize(800,400);
        setLayout(null);
        setLocation(280,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
