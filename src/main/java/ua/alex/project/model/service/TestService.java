package ua.alex.project.model.service;

import ua.alex.project.controller.exception.DataNotFoundException;
import ua.alex.project.model.entity.Question;
import ua.alex.project.model.entity.Test;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TestService {
    List<Test> findAllTests();
    Test findTestByChosenTest(String chosenTest);
    List<Question> findAllQuestionsByChosenTest(String chosenTest);
    Test findTestByName(String testName);
    Test findTestById(long id);
}
