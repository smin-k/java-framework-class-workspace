package kr.ac.jejunu;

public class Daofactory {
    public Connection_Maker get_jeju_Connection_Maker() {
        return new Jeju_Connection_Maker();
    }

    public Connection_Maker get_halla_Connection_Maker() {
        return new Halla_Connection_Maker();
    }

    public UserDao get_Jeju_UserDao() {
        return new UserDao(get_jeju_Connection_Maker());
    }

    public UserDao get_Halla_UserDao() {
        return new UserDao(get_halla_Connection_Maker());
    }
}
