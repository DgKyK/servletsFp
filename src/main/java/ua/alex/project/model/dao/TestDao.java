package ua.alex.project.model.dao;

import ua.alex.project.model.entity.Test;
import ua.alex.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface TestDao extends GenericDao<Test> {
    List<Test> findAll();
    Test findAllByUserId(long userId);
    Optional<Test> findById(long id);
    void save(Test test);
}
