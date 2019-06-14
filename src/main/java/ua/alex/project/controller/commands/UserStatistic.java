package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.User;

import java.util.List;

public class UserStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Attributes.RECORD_PER_PAGE;


        /*User sessionUser = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);
        List<StudentSuccess> userSuccess = STUDENT_SUCCESS_SERVICE.findAllByUserLogin(sessionUser.getLogin());
        request.getSession().setAttribute(Attributes.REQUEST_SUCCESS, userSuccess);*/
        User sessionUser = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);
        List<StudentSuccess> userSuccess = STUDENT_SUCCESS_SERVICE.getPageableViewByUserId(currentPage, recordsPerPage, sessionUser.getId());
        request.getSession().setAttribute(Attributes.REQUEST_SUCCESS, userSuccess);

        int rows = STUDENT_SUCCESS_SERVICE.getNumberOfRowsByUserId(sessionUser.getId());

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        return Attributes.PAGE_USER_STATISTIC;
    }

}
