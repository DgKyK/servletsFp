package ua.alex.project.model.service.impl;

import ua.alex.project.model.entity.GeneralStatistic;
import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Activity;
import ua.alex.project.model.enums.TestStatus;
import ua.alex.project.model.service.StudentSuccessService;
import ua.alex.project.model.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that helps to map General Statistic of all users for Admin;
 */
public class GeneralStatisticMapper {
    private StudentSuccessService studentSuccessService;

    private UserService userService;

    public GeneralStatisticMapper(StudentSuccessService studentSuccessService, UserService userService) {
        this.studentSuccessService = studentSuccessService;
        this.userService = userService;
    }


    public List<GeneralStatistic> getGeneralStatistic() {
        List<GeneralStatistic> resultStatistic = new ArrayList<>();
        GeneralStatistic temp;
        List<User> allUsers = userService.getAllUsers();
        for(User user : allUsers) {
            List<StudentSuccess> userSuccess = studentSuccessService.findAllByUserLogin(user.getLogin());
            int testsNumber = (int)userSuccess.stream().count();
            temp = new GeneralStatistic.Builder()
                    .setTests(testsNumber)
                    .setPassed( (int)userSuccess.stream().filter( x -> x.getStatus().equals(TestStatus.Passed)).count() )
                    .setFailed( (int)userSuccess.stream().filter( x -> x.getStatus().equals(TestStatus.Failed)).count() )
                    .setLogin(user.getLogin())
                    .setActivity(testsNumber > 4 ? Activity.HIGH : Activity.LOW).build();
            resultStatistic.add(temp);
        }
        return resultStatistic;
    }
}
