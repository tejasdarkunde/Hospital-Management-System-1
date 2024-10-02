package Practice;

import java.lang.invoke.StringConcatException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","root");
            Statement st = con.createStatement();

            String s1 = "Rahul";
            String s2 = "104";

            String q = "insert into login values('"+s1+"','"+s2+"')";
            st.executeUpdate(q);

           // String id = "103";
//            String name = "Ashok";
//            String name1 = "Vikram";
//            String q = "insert into login values('"+id+"','"+name+"')";
            //String q = "update login set name = 'Ashok'  where id = "+id;
             //   st.executeUpdate(q);
//            st.executeUpdate(q);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
