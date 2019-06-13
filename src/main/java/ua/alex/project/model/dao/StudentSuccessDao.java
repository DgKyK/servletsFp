package ua.alex.project.model.dao;

import ua.alex.project.model.entity.StudentSuccess;

import java.util.List;

public interface StudentSuccessDao extends GenericDao<StudentSuccess> {
    List<StudentSuccess> findAllByUserId(long id);
}
