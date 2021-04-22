package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(DataSource dataSource) {
        jdbcContext = new JdbcContext(dataSource);
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Statement_strategy statement_strategy = connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
                preparedStatement.setLong(1, id);
                return preparedStatement;
        };
        return jdbcContext.jdbcContextForGet(statement_strategy);
    }

    public void insert(User user) throws SQLException, ClassNotFoundException {
        Statement_strategy statement_strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (name, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement;
        };
        jdbcContext.jdbcContextForInsert(user, statement_strategy);
    }

    public void update(User user) throws SQLException {

        Statement_strategy statement_strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update userinfo set name = ?, password = ? where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());

            return preparedStatement;
        };

        jdbcContext.jdbcContextForUpDel(statement_strategy);
    }

    public void delete(Integer id) throws SQLException {
        Statement_strategy statement_strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from userinfo where id = ? ");
            preparedStatement.setInt(1, id);
            return preparedStatement;
        };
        jdbcContext.jdbcContextForUpDel(statement_strategy);
    }

}

