package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;

    }
    @Bean
    public Connectionmaker connectionMaker() {
        return new Jejuconnectionmaker();
    }
}
