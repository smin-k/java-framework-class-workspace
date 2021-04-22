package kr.ac.jejunu;


import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void Get() throws SQLException, ClassNotFoundException {
        Connection_Maker connection_maker = new Jeju_Connection_Maker();
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao(connection_maker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void halla_Get() throws SQLException, ClassNotFoundException {
        Connection_Maker connection_maker = new Halla_Connection_Maker();
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao(connection_maker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        Connection_Maker connection_maker = new Halla_Connection_Maker();
        User user = new User();
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao(connection_maker);

        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        User inserted_user = userDao.get(user.getId());
        assertThat(inserted_user, IsNull.notNullValue());

    }


}