package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        UserDao userDao = new UserDaoHibernateImpl();
        UserService userService = new UserServiceImpl(userDao);

        userService.createUsersTable();
        userService.saveUser("Jane", "Doe", 25);
        userService.saveUser("John", "Doe", 25);
        userService.removeUserById(1);
    }
}
