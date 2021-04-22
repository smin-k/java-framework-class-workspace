package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Connectionmaker {
     abstract Connection getConnection() throws ClassNotFoundException, SQLException;
     /*{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=UTC"
                , "root", "5344");
    }*/
}
