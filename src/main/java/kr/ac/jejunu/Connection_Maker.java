package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connection_Maker {
    public Connection getConnection() throws ClassNotFoundException,SQLException;
}
