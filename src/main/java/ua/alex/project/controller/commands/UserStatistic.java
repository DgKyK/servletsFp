package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.User;

import java.util.List;

public class UserStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        User sessionUser = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);
        List<StudentSuccess> userSuccess = STUDENT_SUCCESS_SERVICE.findAllByUserLogin(sessionUser.getLogin());
        request.getSession().setAttribute(Attributes.REQUEST_SUCCESS, userSuccess);

        return Attributes.PAGE_USER_STATISTIC;
    }

}
