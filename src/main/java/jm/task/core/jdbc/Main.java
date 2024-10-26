package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static jm.task.core.jdbc.service.UserService.userDao;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        User user = new User();

        SessionFactory sessionFactory = new Configuration()  //реализация подключения через хайбернет
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        userDao.createUsersTable();


        userDao.saveUser("Name1", "LastName1", (byte) 20);
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        userDao.saveUser("Name4", "LastName4", (byte) 38);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
