package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.GeneralStatistic;
import ua.alex.project.model.service.impl.GeneralStatisticMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {


        GeneralStatisticMapper mapper = new GeneralStatisticMapper(STUDENT_SUCCESS_SERVICE, USER_SERVICE);
        List<GeneralStatistic> generalStatistic = mapper.getGeneralStatistic();

        request.getSession().setAttribute(Attributes.REQUEST_GENERAL_STATISTIC, generalStatistic);

        return Attributes.PAGE_ADMIN_STATISTIC;
    }
}
