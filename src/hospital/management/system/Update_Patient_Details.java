package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Time;

public class Update_Patient_Details extends JFrame {
    Update_Patient_Details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Pay Patient Bill");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.black);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number : ");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.black);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time : ");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.black);
        panel.add(label4);

        JTextField textFieldI = new JTextField();
        textFieldI.setBounds(248,174,140,20);
        panel.add(textFieldI);

        JLabel label5 = new JLabel("Amount Paid : ");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.black);
        panel.add(label5);

        JTextField textFieldA = new JTextField();
        textFieldA.setBounds(248,216,140,20);
        panel.add(textFieldA);

        JLabel label6 = new JLabel("Pending Amount : ");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.black);
        panel.add(label6);

        JTextField textFieldP = new JTextField();
        textFieldP.setBounds(248,261,140,20);
        panel.add(textFieldP);

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,30);
        check.setBackground(new Color(30,86,49));
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText((resultSet.getString("Room_Number")));
                        textFieldI.setText((resultSet.getString("Time")));
                        textFieldA.setText((resultSet.getString("Deposite")));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where Room_No = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldA.getText());
                        textFieldP.setText(""+amountPaid);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,30);
        update.setBackground(new Color(30,86,49));
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldI.getText();
                    String amount = textFieldA.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"',Time = '"+ time +"',Deposite = '"+amount+"' where Name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(168,378,89,30);
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
        setSize(950,500);
        setLayout(null);
        setLocation(200,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
