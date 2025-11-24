// conn.java/make connection java + database
package airline_management_system;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {//
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "1716504726");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
