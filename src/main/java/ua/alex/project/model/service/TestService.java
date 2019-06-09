package ua.alex.project.model.service;

import ua.alex.project.model.entity.Test;

import java.util.List;

public interface TestService {
    List<Test> findAll();
    Test findTestById(long id);
}
