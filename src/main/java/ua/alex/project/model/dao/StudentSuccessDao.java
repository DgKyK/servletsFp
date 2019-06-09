package ua.alex.project.model.dao;

import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.User;

import java.util.List;

public interface StudentSuccessDao {
    List<StudentSuccess> getAll();
    StudentSuccess findByLogin(String nickName);
    void save(StudentSuccess user);
}
