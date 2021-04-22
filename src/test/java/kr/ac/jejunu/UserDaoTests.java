package kr.ac.jejunu;


import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    static UserDao userDao;
    @BeforeAll
    public static void setup() {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void Get() throws SQLException {

        Integer id = 1;
        String name = "hulk1";
        String password = "1234";

        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException {
        User user = new User();
        String name = "hulk";
        String password = "1234";
        user.setName(name);
        user.setPassword(password);

        userDao.insert(user);
        User Inserted_user = userDao.get(user.getId());
        assertThat(Inserted_user.getName(), is(name));
        assertThat(Inserted_user.getPassword(), is(password));
    }

    @Test
    public void update() throws SQLException {
        User user = new User();
        String name = "hulk";
        String password = "1234";
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        String updated_name= "hulk2";
        String updated_password="1111";

        user.setName(updated_name);
        user.setPassword(updated_password);
        userDao.update(user);

        User updated_user = userDao.get(user.getId());

        assertThat(updated_user.getName(), is(updated_name));
        assertThat(updated_user.getPassword(), is(updated_password));


    }

    @Test
    public void delete() throws SQLException {
        User user = new User();
        String name = "hulk";
        String password = "1234";
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        userDao.delete(user.getId());
        User deleted_user = userDao.get(user.getId());
        assertThat(deleted_user, IsNull.nullValue());

    }

}