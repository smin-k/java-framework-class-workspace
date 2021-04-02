package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public JejuConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}

/*
public class Daofactoy {
    public UserDao getUserDao(){
        return new UserDao(getConnectionMaker);
    }
    public JejuConnectionMaker getConnectionMaker(){
        return new JejuConnectionMaker();
    }

}*/
