package hospital.management.system;

import java.sql.Connection;
import java.sql.*;
public class Sample
{
    public static <Statemetn> void main(String args[]) throws SQLException
    {
        int rn=300;
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root","root");
               Statemetn st = (Statemetn) con.createStatement();

        ResultSet rs1 = ((Statement) st).executeQuery("select * from room where Room_No =300");

            while(rs1.next())
        {
            System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
        }

    }
}
