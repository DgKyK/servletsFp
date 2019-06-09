package ua.alex.project.model.dao.impl;

import ua.alex.project.model.dao.TestDao;
import ua.alex.project.model.entity.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCTestDao implements TestDao {
    private Connection connection;

    public JDBCTestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Test> findAll() {
        return null;
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            //TODO logging for this case
            throw new RuntimeException(e);
        }
    }

    @Override
    public Test findAllByUserId(long userId) {
        return null;
    }

    @Override
    public Optional<Test> findById(long id) {
        return null;
    }

    @Override
    public void save(Test test) {

    }
}
