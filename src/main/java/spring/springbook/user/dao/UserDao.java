package spring.springbook.user.dao;

import spring.springbook.user.domain.User;

import java.sql.*;

// UserDad => User Get, Set 기능구현
public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)"); // sql을 담은 statement
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c
                .prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

//    public Connection getConnection() throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hihi?serverTimezone=Asia/Seoul&characterEncoding=UTF-8", "root",
//                "dhgusdl1**");
//        return c;
//    }

//public class NUserDao extends UserDao {
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//
//    }
//}


    public static void main(String[] args) throws SQLException, ClassNotFoundException {


    }
}
