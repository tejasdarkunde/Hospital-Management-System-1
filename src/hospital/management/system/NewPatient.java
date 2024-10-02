package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposit;
    JRadioButton r1,r2;
    Choice c1,c2;
    JLabel date;
    JButton b1,b2;
    NewPatient(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel lableName = new JLabel("New Patient Form");
        lableName.setBounds(118,11,260,53);
        lableName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(lableName);

        JLabel lableID = new JLabel("ID : ");
        lableID.setBounds(35,76,200,14);
        lableID.setFont(new Font("Tahoma",Font.BOLD,14));
        lableID.setForeground(Color.black);
        panel.add(lableID);

        comboBox = new JComboBox(new String[] {"Mobile No","Aadhar Card"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel lableNumber = new JLabel("Number : ");
        lableNumber.setBounds(35,111,200,14);
        lableNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        lableNumber.setForeground(Color.black);
        panel.add(lableNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel lableName1 = new JLabel("Name : ");
        lableName1.setBounds(35,151,200,14);
        lableName1.setFont(new Font("Tahoma",Font.BOLD,14));
        lableName1.setForeground(Color.black);
        panel.add(lableName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel lableGender = new JLabel("Gender : ");
        lableGender.setBounds(35,191,200,14);
        lableGender.setFont(new Font("Tahoma",Font.BOLD,14));
        lableGender.setForeground(Color.black);
        panel.add(lableGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.black);
        r1.setBackground(new Color(90,156,163));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.black);
        r2.setBackground(new Color(90,156,163));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel lableDisease = new JLabel("Disease : ");
        lableDisease.setBounds(35,231,200,14);
        lableDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDisease.setForeground(Color.black);
        panel.add(lableDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel lableRoom = new JLabel("Room : ");
        lableRoom.setBounds(35,274,200,14);
        lableRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        lableRoom.setForeground(Color.black);
        panel.add(lableRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from room where Availablity = 'Available'");
            while (resultSet.next()){
                c1.add(resultSet.getString("Room_No"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel lableDate = new JLabel("Time : ");
        lableDate.setBounds(35,316,200,14);
        lableDate.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDate.setForeground(Color.black);
        panel.add(lableDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.black);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel lableDeposit = new JLabel("Deposit : ");
        lableDeposit.setBounds(35,359,200,17);
        lableDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDeposit.setForeground(Color.black);
        panel.add(lableDeposit);

        JLabel lableDr = new JLabel("Select Doctor : ");
        lableDr.setBounds(35,405,200,17);
        lableDr.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDr.setForeground(Color.black);
        panel.add(lableDr);

        c2 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                c2.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c2.setBounds(271,405,150,20);
        c2.setFont(new Font("Tahoma",Font.BOLD,14));
        c2.setForeground(Color.white);
        c2.setBackground(new Color(3,45,48));
        panel.add(c2);

        b1 = new JButton("Add");
        b1.setBounds(100,470,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(30,86,49));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260,470,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(new Color(30,86,49));
        b2.addActionListener(this);
        panel.add(b2);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,359,150,20);
        panel.add(textFieldDeposit);

        //setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(310,150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           conn c = new conn();
           String radioBTN = null;
           if(r1.isSelected()){
               radioBTN = "Male";
           }else if(r2.isSelected()) {
               radioBTN = "Female";
           }
           String s1 = (String) comboBox.getSelectedItem();
           String s2 = textFieldNumber.getText();
           for(int i=0; i<s2.length();i++){
               char ch = s2.charAt(i);
               if(ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' || ch=='9'){
                   continue;
               }else {
                   JOptionPane.showMessageDialog(null,"Enter Number in Number Box");
                   break;
               }
           }
           String s3 = textName.getText();
           String s4 = radioBTN;
           String s5 = textFieldDisease.getText();
           String s6 = c1.getSelectedItem();
           String s7 = date.getText();
           String s8 = textFieldDeposit.getText();
            String s9 = c2.getSelectedItem();

           try {
               String q = "insert into Patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
               String q1 = "update room set Availablity = 'Occupied' where Room_No = "+s6;
               c.statement.executeUpdate(q);
               c.statement.executeUpdate(q1);
               JOptionPane.showMessageDialog(null,"Details Added Successfully");
               setVisible(false);
           }catch (Exception E){
               E.printStackTrace();
           }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new NewPatient();
    }

}
