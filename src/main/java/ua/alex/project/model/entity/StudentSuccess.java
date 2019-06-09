package ua.alex.project.model.entity;

import ua.alex.project.model.enums.TestStatus;

public class StudentSuccess {
    private long id;
    private String testName;
    private String testTheme;
    private int questNumber;
    private int writeAnswer;
    private int wrongAnswer;
    private TestStatus status;

    public StudentSuccess() {

    }

    public StudentSuccess(long id, String testName, String testTheme, int questNumber, int writeAnswer,
                          int wrongAnswer, TestStatus status) {
        this.id = id;
        this.testName = testName;
        this.testTheme = testTheme;
        this.questNumber = questNumber;
        this.writeAnswer = writeAnswer;
        this.wrongAnswer = wrongAnswer;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestTheme() {
        return testTheme;
    }

    public void setTestTheme(String testTheme) {
        this.testTheme = testTheme;
    }

    public int getQuestNumber() {
        return questNumber;
    }

    public void setQuestNumber(int questNumber) {
        this.questNumber = questNumber;
    }

    public int getWriteAnswer() {
        return writeAnswer;
    }

    public void setWriteAnswer(int writeAnswer) {
        this.writeAnswer = writeAnswer;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public TestStatus getStatus() {
        return status;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }
}
