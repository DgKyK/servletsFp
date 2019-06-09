package ua.alex.project.model.entity;

import ua.alex.project.model.enums.Answer;

public class Question {
    private long id;
    private Test test;
    private int questNumber;
    private Answer answer;

    public Question() {

    }

    public Question(long id, Test test, int questNumber, Answer answer) {
        this.id = id;
        this.test = test;
        this.questNumber = questNumber;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getQuestNumber() {
        return questNumber;
    }

    public void setQuestNumber(int questNumber) {
        this.questNumber = questNumber;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
