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
        userDao.createUsersTable();
        userDao.saveUser("Jane", "Doe", 25);
        userDao.saveUser("John", "Doe", 25);
        userDao.saveUser("Jack", "Doe", 25);
        userDao.removeUserById(1);
    }
}
