package ua.alex.project.model.service.impl;

import ua.alex.project.model.entity.Question;
import ua.alex.project.model.enums.Answer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * class that responsible for tet review(checking for mistakes);
 */
public class TestChecker {

    public static Map<String, Boolean> getTestReview(List<Question> questions, Map<Integer, Answer> passedTest) {
        Map<String, Boolean> checkedTest = new LinkedHashMap<>();
        for(Integer currentQuest : passedTest.keySet()) {
            Answer rightAnswer = questions.get(currentQuest - 1).getAnswer();
            Answer givenAnswer = passedTest.get(currentQuest);
            if(rightAnswer.equals(givenAnswer)) {
                checkedTest.put(currentQuest + ". " + givenAnswer,true);
            } else {
                checkedTest.put(currentQuest + ". " + givenAnswer,false);
            }
        }
        return checkedTest;
    }
}
