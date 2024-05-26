package spring.springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// DB 접속 및 연결하기.
public class SimpleConnectionMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hihi?serverTimezone=Asia/Seoul&characterEncoding=UTF-8", "root",
                "dhgusdl1**");
        return c;
    }
}
