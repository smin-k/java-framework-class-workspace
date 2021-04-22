package kr.ac.jejunu;


import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    Daofactory daofactory = new Daofactory();
    @Test
    public void Get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = daofactory.get_Jeju_UserDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void halla_Get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = daofactory.get_Halla_UserDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "hulk";
        String password = "1234";
        UserDao userDao = daofactory.get_Jeju_UserDao();

        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        User inserted_user = userDao.get(user.getId());
        assertThat(inserted_user, IsNull.notNullValue());

    }


}