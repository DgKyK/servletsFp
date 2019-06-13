package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

public class UserStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {




        return Attributes.PAGE_USER_STATISTIC;
    }

}
