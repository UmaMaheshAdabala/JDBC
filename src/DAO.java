import java.net.ConnectException;
import java.sql.*;


 // DAO : Data Access Object

// This is used to create Some Specific methods to query the DataBase without disturbing the main methods

public class DAO {
    public static void main(String[] args) throws Exception {
        PersonQuery pq = new PersonQuery();
        Person p1 = pq.getPerson("Umesh");
        System.out.println(p1.FirstName);
    }
}

class PersonQuery{
    public Person getPerson(String LastName) throws Exception{
        Person p = new Person();
        p.LastName = LastName;
        String Query = "select FirstName from data where LastName=?";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCTEST", "root", "@nony1472");

       PreparedStatement psn = cn.prepareStatement(Query);
       psn.setString(1,LastName);
        ResultSet rs = psn.executeQuery();
        rs.next();
        p.FirstName = rs.getString(1);


        return p;
    }
}

class Person{
    String LastName;
    String FirstName;
}
