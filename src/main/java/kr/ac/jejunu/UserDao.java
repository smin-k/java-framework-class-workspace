package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(DataSource dataSource) {
        jdbcContext = new JdbcContext(dataSource);
    }

    public void insert(User user) throws SQLException, ClassNotFoundException {
        Object[] params = new Object[] {user.getName(),user.getPassword()};
        String sql = "insert into userinfo (name, password) values (?,?)";
        jdbcContext.insert(user, params, sql, this);
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Object[] params = new Object[] {id};
        String sql="select * from userinfo where id = ?";

        return jdbcContext.get(params, sql);
    }

    public void update(User user) throws SQLException {
        Object[] params = new Object[] {user.getName(),user.getPassword(),user.getId()};
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        jdbcContext.update(params, sql);
    }

    public void delete(Integer id) throws SQLException {
        Object[] params = new Object[] {id};
        String sql = "delete from userinfo where id = ? ";
        jdbcContext.update(params, sql);
    }

}

