package ua.alex.project.model.service.impl;

import ua.alex.project.model.dao.DaoFactory;
import ua.alex.project.model.dao.StudentSuccessDao;
import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.Test;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.TestStatus;
import ua.alex.project.model.service.StudentSuccessService;
import ua.alex.project.model.service.TestService;
import ua.alex.project.model.service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentSuccessServiceImpl implements StudentSuccessService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private TestService testService;
    private UserService userService;

    public StudentSuccessServiceImpl() {
        testService = new TestServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    public void saveCurrentResult(Map<String, Boolean> resultTest, String testInfo, String userLogin) {

        String[] splitted = testInfo.split("\\s\\|\\s");

        int writeAnswers = 0;
        int wrongAnswers = 0;
        for(String current : resultTest.keySet()) {
            if(resultTest.get(current)) {
                writeAnswers++;
            } else wrongAnswers++;
        }
        Test testFromBd = testService.findTestById(Long.parseLong(splitted[0]));
        User currentUser = userService.getUserByLogin(userLogin).get();
        StudentSuccess currentResult = new StudentSuccess.Builder()
                .setUserId(currentUser.getId())
                .setTest(testFromBd)
                .setQuestNumber(testFromBd.getQuestNumber())
                .setWriteAnswer(writeAnswers)
                .setWrongAnswer(wrongAnswers)
                .setStatus((writeAnswers < testFromBd.getNeedAnswerNumber()) ? TestStatus.Failed : TestStatus.Passed).build();
        try(StudentSuccessDao studentSuccessDao = daoFactory.createStudentSuccessDao()) {
            studentSuccessDao.save(currentResult);
        } catch (SQLException e) {
            //TODO log.warn("failed save : " + e.getMessage())
            e.printStackTrace();
        }
    }

    @Override
    public List<StudentSuccess> findAllByUserLogin(String userLogin) {
        Optional<User> userByLogin = userService.getUserByLogin(userLogin);

        List<StudentSuccess> successList = new ArrayList<>();
        try(StudentSuccessDao studentSuccessDao = daoFactory.createStudentSuccessDao()) {
            successList = studentSuccessDao.findAllByUserId(userByLogin.get().getId());
        }
        return successList;
    }
}
