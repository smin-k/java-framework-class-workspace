package kr.ac.jejunu;

public class Daofactoy {
    public UserDao getUserDao(){
        return new UserDao(getConnectionMaker);
    }
    public JejuConnectionMaker getConnectionMaker(){
        return new JejuConnectionMaker();
    }

}
