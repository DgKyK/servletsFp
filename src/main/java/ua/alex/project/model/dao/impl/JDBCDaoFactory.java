package ua.alex.project.model.dao.impl;

import ua.alex.project.model.dao.*;
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
        return new JDBCTestDao(getConnection());
    }


    @Override
    public StudentSuccessDao createStudentSuccessDao() {
        return new JDBCStudentSuccessDao(getConnection());
    }

    @Override
    public QuestionDao createQuestionDao() {
        return new JDBCQuestionDao(getConnection());
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
