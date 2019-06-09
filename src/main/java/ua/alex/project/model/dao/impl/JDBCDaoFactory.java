package ua.alex.project.model.dao.impl;

import ua.alex.project.model.dao.DaoFactory;
import ua.alex.project.model.dao.StudentSuccessDao;
import ua.alex.project.model.dao.TestDao;
import ua.alex.project.model.dao.UserDao;
import ua.alex.project.constants.Attributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class JDBCDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public TestDao createTestDao() {
        return null;
    }

    @Override
    public StudentSuccessDao createStudentSuccessDao() {
        return null;
    }

    private Connection getConnection() {
        ResourceBundle bundle = ResourceBundle.getBundle(Attributes.DB_PROPERTIES_NAME);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(bundle.getString(Attributes.DB_URL),
                    bundle.getString(Attributes.DB_USERNAME),
                    bundle.getString(Attributes.DB_PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
