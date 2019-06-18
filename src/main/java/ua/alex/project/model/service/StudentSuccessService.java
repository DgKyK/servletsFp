package ua.alex.project.model.service;

import ua.alex.project.model.entity.StudentSuccess;

import java.util.List;
import java.util.Map;

/**
 * Interface that consist of all needed methods of business logic that needs for Students success;
 */
public interface StudentSuccessService {
    void saveCurrentResult(Map<String,Boolean> resultTest, String testInfo, String userName);
    List<StudentSuccess> findAllByUserLogin(String userName);

    List<StudentSuccess> getPageableViewByUserId(int currentPage, int recordsPerPage, long userId);

    int getNumberOfRowsByUserId(long id);
}
