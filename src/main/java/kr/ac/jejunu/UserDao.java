package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    Connection_Maker connection_maker;
    UserDao(Connection_Maker connection_maker){
        this.connection_maker = connection_maker;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Connection connection = connection_maker.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        //리턴
        return user;
    }



    public void insert(User user) throws SQLException, ClassNotFoundException {
        Connection connection = connection_maker.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into userinfo (name,password) values (?,?)",Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        user.setId(resultSet.getInt(1));

        preparedStatement.close();
        connection.close();
    }

}