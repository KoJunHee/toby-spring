package dao;

import domain.User;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        JUnitCore.main("dao.UserDaoTest");

        ApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user1 = new User();
        user1.setId("tete");
        user1.setName("kkk");
        user1.setPassword("111");
        dao.add(user1);
        User user2 = dao.get("tete");


    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user1 = new User();
        user1.setId("test");
        user1.setName("name");
        user1.setPassword("111");
        dao.add(user1);

        User user2 = dao.get("test");


        //test
        assertThat(user2.getName(), is(user1.getName()));
        assertThat(user2.getPassword(), is(user1.getPassword()));

    }

}
