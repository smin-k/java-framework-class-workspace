package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete_Statement implements Statement_strategy {
    private int id;

    public delete_Statement(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from userinfo where id = ? ");
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
