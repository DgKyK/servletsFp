package ua.alex.project.model.service;

import ua.alex.project.model.entity.StudentSuccess;

import java.util.List;
import java.util.Map;

public interface StudentSuccessService {
    void saveCurrentResult(Map<String,Boolean> resultTest, String testInfo, String userName);
    List<StudentSuccess> findAllByUserName(String userName);
}
