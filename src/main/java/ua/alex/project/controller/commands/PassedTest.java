package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.Question;
import ua.alex.project.model.entity.Test;
import ua.alex.project.model.enums.Answer;
import ua.alex.project.model.service.impl.AutoTestPasser;
import ua.alex.project.model.service.impl.TestChecker;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Description : command that responsible for passing and getting results of already passed test;
 */
public class PassedTest implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String returnPage = Attributes.PAGE_TEST;

        String chosenTest = request.getParameter(Attributes.REQUEST_CHOSEN_TEST);
        User userFromSession = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);

        List<Question> questionList = TEST_SERVICE.findAllQuestionsByChosenTest(chosenTest);

        Map<Integer, Answer> passedTest = AutoTestPasser.getPassedTest(questionList.size());
        Map<String, Boolean> checkedTest = TestChecker.getTestReview(questionList, passedTest);

        STUDENT_SUCCESS_SERVICE.saveCurrentResult(checkedTest,chosenTest,userFromSession.getLogin());
        request.getSession().setAttribute(Attributes.REQUEST_CHECKED_TEST, checkedTest);

        return returnPage;
    }
}
