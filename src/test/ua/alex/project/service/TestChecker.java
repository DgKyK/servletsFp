package ua.alex.project.service;

import org.junit.Assert;
import org.junit.Test;
import ua.alex.project.model.entity.Question;
import ua.alex.project.model.enums.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestChecker {



    @Test
    public void testCheckerTest() {
        Map<Integer, Answer> passedTest = new HashMap<>();
        passedTest.put(1,Answer.A);
        passedTest.put(2,Answer.A);
        passedTest.put(3,Answer.A);
        passedTest.put(4,Answer.A);
        passedTest.put(5,Answer.A);
        passedTest.put(6,Answer.A);
        passedTest.put(7,Answer.A);
        passedTest.put(8,Answer.A);
        passedTest.put(9,Answer.A);
        passedTest.put(10,Answer.A);


        List<Question> questList = new ArrayList<>();
        questList.add(new Question.Builder().setQuestNumber(1).setAnswer(Answer.B).build());
        questList.add(new Question.Builder().setQuestNumber(2).setAnswer(Answer.C).build());
        questList.add(new Question.Builder().setQuestNumber(3).setAnswer(Answer.B).build());
        questList.add(new Question.Builder().setQuestNumber(4).setAnswer(Answer.A).build()); // 1
        questList.add(new Question.Builder().setQuestNumber(5).setAnswer(Answer.B).build());
        questList.add(new Question.Builder().setQuestNumber(6).setAnswer(Answer.B).build());
        questList.add(new Question.Builder().setQuestNumber(7).setAnswer(Answer.A).build()); // 2
        questList.add(new Question.Builder().setQuestNumber(8).setAnswer(Answer.B).build());
        questList.add(new Question.Builder().setQuestNumber(9).setAnswer(Answer.A).build()); // 3
        questList.add(new Question.Builder().setQuestNumber(10).setAnswer(Answer.B).build());


        Map<String, Boolean> testReview = ua.alex.project.model.service.impl.TestChecker.getTestReview(questList, passedTest);

        int writeAnswers = 0;
        for (String k : testReview.keySet()) {
            if(testReview.get(k)) {
                writeAnswers++;
            }
        }
        Assert.assertEquals(3,writeAnswers);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckerError() {
        Map<Integer, Answer> passedTest = new HashMap<>();
        for(int i = 1; i < 15; i++) {
            passedTest.put(i,Answer.A);
        }

        List<Question> questList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            questList.add(new Question.Builder().setQuestNumber(i).setAnswer(Answer.B).build());
        }

        Map<String, Boolean> testReview = ua.alex.project.model.service.impl.TestChecker.getTestReview(questList, passedTest);
    }
}
