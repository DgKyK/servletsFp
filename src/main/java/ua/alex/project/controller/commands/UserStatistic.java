package ua.alex.project.controller.commands;

import javax.servlet.http.HttpServletRequest;

public class UserStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/user/user_statistic.jsp";
    }

}
