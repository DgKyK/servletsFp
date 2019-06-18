package ua.alex.project.model.dao;

import ua.alex.project.model.entity.StudentSuccess;

import java.util.List;

/**
 * Concrete interface for StudentSuccessDao with specific methods;
 */
public interface StudentSuccessDao extends GenericDao<StudentSuccess> {
    List<StudentSuccess> findAllByUserId(long id);

    List<StudentSuccess> findLimitViewByUserId(int currentPage, int recordsPerPage,  long id);

    int getRowsCountByUserId(long id);
}
