package spring.springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

//        UserDao dao = new DaoFactory().userDao();
        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("white_ship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

//        DaoFactory daoFactory = new DaoFactory();
//        UserDao dao1 = daoFactory.userDao();
//        UserDao dao2 = daoFactory.userDao();
//        System.out.println(dao1);
//        System.out.println(dao2);

//        UserDao userDao3 = context.getBean("userDao", UserDao.class);
//        UserDao userDao4 = context.getBean("userDao", UserDao.class);
//        System.out.println(userDao3);
//        System.out.println(userDao4);

    }
}
