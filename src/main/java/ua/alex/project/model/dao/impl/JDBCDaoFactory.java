package ua.alex.project.model.dao.impl;

import ua.alex.project.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

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
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            //TODO log.warn("Cant get connection from Pool : " + e.printStackTrace);
            throw new RuntimeException(e);
        }
    }
}
