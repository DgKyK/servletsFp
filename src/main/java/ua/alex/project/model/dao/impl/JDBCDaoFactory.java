package ua.alex.project.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class JDBCDaoFactory extends DaoFactory {
    private Logger logger = LogManager.getLogger(getClass());
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
            logger.warn("Cant get connection from Pool : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
