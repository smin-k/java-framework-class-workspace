package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Daofactory {

    @Bean
    public Connection_Maker jeju_Connection_Maker() {
        return new Jeju_Connection_Maker();
    }

    @Bean
    public Connection_Maker halla_Connection_Maker() {
        return new Halla_Connection_Maker();
    }

    @Bean
    public UserDao jeju_UserDao() {
        return new UserDao(jeju_Connection_Maker());
    }

    @Bean
    public UserDao halla_UserDao() {
        return new UserDao(halla_Connection_Maker());
    }
}
