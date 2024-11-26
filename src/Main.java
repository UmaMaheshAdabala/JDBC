import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCTEST";
        String Query = "Select FirstName From data where LastName = \"Ganesh\" ";
        String uname = "root";
        String pass = "@nony1472";
        Connection cn = DriverManager.getConnection(url, uname, pass);
        Statement sn = cn.createStatement();

//        ResultSet res = sn.executeQuery( Query);
//        res.next();
//        System.out.println(res.getString("FirstName"));


        // Fetch Complete Table

//        Query = "select * from data";
//
//        ResultSet res =  sn.executeQuery(Query);
//        while(res.next()){
//            System.out.println(res.getString(1)+" "+res.getString(2));
//        }


        // Insert into database

//        Query = "Insert into data values(\"Mallireddy\", \"Geetha\")";
//
//        int count = sn.executeUpdate(Query);
//        System.out.println(count+" rows Effected");

        // Using PreparedStatement for Dynamic Values

        Query = "Insert into data values (?,?)";
        String LastName = "Manoj";
        String FirstName = "Posipo";
        PreparedStatement psn = cn.prepareStatement(Query);
        psn.setString(1,LastName);
        psn.setString(2,FirstName);
        int  count = psn.executeUpdate();
        System.out.println(count+" rows Effected");

        sn.close();
        cn.close();




    }
}