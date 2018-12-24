
import dao.DaoFactory;
import dao.UserDao;
import domain.User;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext
        UserDao userDao = new DaoFactory().userDao();

        //insert into DB
        User user = new User();
        user.setId("testID");
        user.setName("tester");
        user.setPassword("testPwd");
        userDao.add(user);
        System.out.println(user.getId() + "등록 성공");

        //test
        User user2 = userDao.get(user.getId());
        System.out.println("user id : " + user2.getName());
        System.out.println("user password : " + user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}
