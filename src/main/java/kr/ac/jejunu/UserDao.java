package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    public final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Statement_strategy statement_strategy= new get_Statement(id);
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            connection = dataSource.getConnection();


            preparedStatement =statement_strategy.makeStatement(connection);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return user;
    }

    public void insert(User user) throws SQLException, ClassNotFoundException {
        Statement_strategy statement_strategy= new insert_Statement(user);
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement= null;
        try {
            connection = dataSource.getConnection();

            preparedStatement =statement_strategy.makeStatement(connection);
            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            user.setId(resultSet.getInt(1));

        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //리턴
    }

    public void update(User user) throws SQLException {
        Statement_strategy statement_strategy= new update_Statement(user);
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        try {
            connection = dataSource.getConnection();
            preparedStatement =statement_strategy.makeStatement(connection);
            preparedStatement.executeUpdate();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Integer id) throws SQLException {
        Statement_strategy statement_strategy= new delete_Statement(id);
        Connection connection = null;
        PreparedStatement preparedStatement= null;

        try {
            connection = dataSource.getConnection();
            preparedStatement =statement_strategy.makeStatement(connection);
            preparedStatement.executeUpdate();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
