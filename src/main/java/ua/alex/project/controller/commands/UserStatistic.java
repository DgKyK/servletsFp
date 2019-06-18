package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

import ua.alex.project.controller.comparator.StudentSuccessComparator;
import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.User;

import java.util.List;


/**
 * Description : command that handle personal user statistic and processing;
 */
public class UserStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        if ( request.getParameter(Attributes.REQUEST_CURRENT_PAGE) != null ) {

            int currentPage = Integer.valueOf(request.getParameter(Attributes.REQUEST_CURRENT_PAGE));
            int recordsPerPage = Attributes.RECORDS_PER_PAGE;


            User sessionUser = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);
            List<StudentSuccess> userSuccess = STUDENT_SUCCESS_SERVICE.getPageableViewByUserId(currentPage, recordsPerPage, sessionUser.getId());
            userSuccess.sort(new StudentSuccessComparator());
            request.getSession().setAttribute(Attributes.REQUEST_SUCCESS, userSuccess);

            int rows = STUDENT_SUCCESS_SERVICE.getNumberOfRowsByUserId(sessionUser.getId());

            int nOfPages = rows / recordsPerPage;

            if (nOfPages % recordsPerPage > 0) {
                nOfPages++;
            }

            request.getSession().setAttribute(Attributes.REQUEST_NUMBER_OF_PAGES, nOfPages);
            request.getSession().setAttribute(Attributes.REQUEST_CURRENT_PAGE, currentPage);
            request.getSession().setAttribute(Attributes.REQUEST_RECORDS_PER_PAGE, recordsPerPage);
        }
        return Attributes.PAGE_USER_STATISTIC;
    }

}
