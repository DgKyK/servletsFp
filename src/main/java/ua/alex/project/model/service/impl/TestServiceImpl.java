package ua.alex.project.model.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.controller.exception.DataNotFoundException;
import ua.alex.project.model.dao.DaoFactory;
import ua.alex.project.model.dao.QuestionDao;
import ua.alex.project.model.dao.TestDao;
import ua.alex.project.model.entity.Question;
import ua.alex.project.model.entity.Test;
import ua.alex.project.model.service.TestService;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestServiceImpl implements TestService {
    private Logger logger = LogManager.getLogger(getClass());

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Test> findAllTests() {
        try(TestDao testDao = daoFactory.createTestDao()) {

            return testDao.findAll();
        }
    }

    @Override
    public Test findTestByChosenTest(String chosenTest) {
        String[] testInfo = chosenTest.split("\\s\\|\\s");
        long testId = Long.parseLong(testInfo[0]);
        try(TestDao testDao = daoFactory.createTestDao()) {
            Optional<Test> testFromDb = testDao.findById(testId);
            if (testFromDb.isPresent()) {
                return testFromDb.get();
            } else {
                //add your own exception (TestNotFoundException)
                logger.error("test with id : " + testInfo[0] + " not found");
                throw new DataNotFoundException("Test with id : " + testId + "not found");
            }
        }
    }

    @Override
    public List<Question> findAllQuestionsByChosenTest(String chosenTest) {
        String[] testInfo = chosenTest.split("\\s\\|\\s");
        long testId = Long.parseLong(testInfo[0]);
        List<Question> questions;
        try(QuestionDao questionDao = daoFactory.createQuestionDao()) {
            questions = questionDao.findAllQuestionsByTestId(testId);
        }
        return questions;
    }

    @Override
    public Test findTestByName(String testName){
        try(TestDao testDao = daoFactory.createTestDao()) {
            Optional<Test> testFromDb = testDao.findByName(testName);
            if (testFromDb.isPresent()) {
                return testFromDb.get();
            } else {
                logger.error("Test with name : " + testName+ "not found");
                throw new DataNotFoundException("Test with name : " + testName+ "not found");
            }
        }
    }

    @Override
    public Test findTestById(long id) {
        try(TestDao testDao = daoFactory.createTestDao()) {
            Optional<Test> testFromDb = testDao.findById(id);
            if (testFromDb.isPresent()) {
                return testFromDb.get();
            } else {
                logger.error("Test with id : " + id + "not found");
                throw new DataNotFoundException("Test with id : " + id + "not found");
            }
        }
    }
}
