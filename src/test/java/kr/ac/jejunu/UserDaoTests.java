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
    public static  void setup(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Daofactory.class);
        userDao = applicationContext.getBean("jeju_UserDao",UserDao.class);
    }

    @Test
    public void Get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
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
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        User inserted_user = userDao.get(user.getId());
        assertThat(inserted_user, IsNull.notNullValue());

    }


}