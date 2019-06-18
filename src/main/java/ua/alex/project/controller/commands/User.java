package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


/**
 * Description : command that handle User home page;
 */
public class User implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String returnPage = Attributes.PAGE_USER_HOME;


        List<Test> tests = TEST_SERVICE.findAllTests();
        request.getSession().setAttribute("allTests", tests);

        return returnPage;
    }
}
