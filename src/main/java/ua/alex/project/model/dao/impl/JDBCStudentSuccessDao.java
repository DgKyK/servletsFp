package ua.alex.project.model.dao.impl;

import ua.alex.project.model.dao.StudentSuccessDao;
import ua.alex.project.model.entity.StudentSuccess;

import java.sql.Connection;
import java.util.List;

public class JDBCStudentSuccessDao implements StudentSuccessDao {

    private Connection connection;

    public JDBCStudentSuccessDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<StudentSuccess> getAll() {
        return null;
    }

    @Override
    public StudentSuccess findByLogin(String nickName) {
        return null;
    }

    @Override
    public void save(StudentSuccess user) {

    }
}
