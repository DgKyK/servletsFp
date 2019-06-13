package ua.alex.project.model.dao;

import ua.alex.project.model.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionDao extends GenericDao<Question> {
    List<Question> findAllQuestionsByTestId(long testId);

}
