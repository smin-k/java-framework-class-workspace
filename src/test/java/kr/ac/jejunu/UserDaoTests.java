package kr.ac.jejunu;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void Jejuget() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "smin";
        String password = "5344";

        Daofactory daofactory = new Daofactoy();
        UserDao userDao = daofactory.getUserDao();

        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void Jejuinsert() throws SQLException, ClassNotFoundException {
        String name="smin";
        String password="5344";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        Daofactory daofactory = new Daofactoy();
        UserDao userDao = daofactory.getUserDao();
        userDao.insert(user);

        User insertedUser= userDao.findById(user.getId());

        assertThat(user.getId(), greaterThan(0));
        assertThat(insertedUser.getId(), is(user.getId()));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));

    }

    @Test
    public void Hallaget() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "jmin";
        String password = "5344";

        UserDao userDao = new UserDao(new HallaConnectionMaker());
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void Hallainsert() throws SQLException, ClassNotFoundException {
        String name="jmin";
        String password="5344";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userDao = new UserDao(new HallaConnectionMaker());
        userDao.insert(user);

        User insertedUser= userDao.findById(user.getId());

        assertThat(user.getId(), greaterThan(0));
        assertThat(insertedUser.getId(), is(user.getId()));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));

    }
}