package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1356,670);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/hospital.gif"));
        Image image11 = i111.getImage().getScaledInstance(1356,670,Image.SCALE_DEFAULT);
        ImageIcon i222 = new ImageIcon(image11);
        JLabel label21 =new JLabel(i222);
        label21.setBounds(0,0,1356,670);
        panel.add(label21);


        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1356,150);
        panel1.setBackground(new Color(90,156,163));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/doctor.png"));
        Image image = i1.getImage().getScaledInstance(160,180,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label =new JLabel(i2);
        label.setBounds(1100,0,160,180);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/hospitalimage.png"));
        Image image1 = i11.getImage().getScaledInstance(200,100,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 =new JLabel(i22);
        label1.setBounds(830,50,200,100);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(30,86,49));
        btn1.setForeground(Color.white);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(30,86,49));
        btn2.setForeground(Color.white);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(30,86,49));
        btn3.setForeground(Color.white);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("Doctor Details");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(30,86,49));
        btn4.setForeground(Color.white);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_Info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(30,86,49));
        btn5.setForeground(Color.white);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(30,86,49));
        btn6.setForeground(Color.white);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Discharge();
            }
        });

        JButton btn7 = new JButton("Pay Patient Bill");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(30,86,49));
        btn7.setForeground(Color.white);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient_Details();
            }
        });

//        JButton btn8 = new JButton("Hospital Ambulance");
//        btn8.setBounds(510,58,200,30);
//        btn8.setBackground(new Color(30,86,49));
//        btn8.setForeground(Color.white);
//        panel1.add(btn8);
//        btn8.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Ambulance();
//            }
//        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510,58,200,30);
        btn9.setBackground(new Color(30,86,49));
        btn9.setForeground(Color.white);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(510,100,200,30);
        btn10.setBackground(new Color(30,86,49));
        btn10.setForeground(Color.white);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        setSize(1366,768);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
