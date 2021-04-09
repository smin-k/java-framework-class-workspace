package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Integer id) throws SQLException {
        //데이터 어딨어? => mysql
        String sql = "select * from  userinfo where id = ?";
        Object[] params = new Object[]{id};
        return jdbcContext.findById(sql, params);
    }

    public void insert(User user) throws SQLException {
        //데이터 어딨어? => mysql
        String sql = "insert into userinfo (name, password) values ( ?, ? )";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        jdbcContext.insert(user, sql, params, this);

    }

    public void update(User user) throws SQLException {
        //데이터 어딨어? => mysql
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);

    }

    public void delete(Integer id) throws SQLException {
        //데이터 어딨어? => mysql
        String sql = "delete from userinfo where id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);

    }


}
