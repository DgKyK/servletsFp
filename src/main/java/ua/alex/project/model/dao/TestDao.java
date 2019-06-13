package ua.alex.project.model.dao;

import ua.alex.project.model.entity.Test;

import java.sql.SQLException;
import java.util.Optional;

public interface TestDao extends GenericDao<Test> {

    Optional<Test> findByName(String testName);
}
