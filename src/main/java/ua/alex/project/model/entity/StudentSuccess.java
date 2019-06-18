package ua.alex.project.model.entity;

import ua.alex.project.model.enums.TestStatus;

public class StudentSuccess {

    private long id;
    private long userId;
    private int questNumber;
    private int writeAnswer;
    private int wrongAnswer;
    private Test test;
    private TestStatus status;

    public StudentSuccess() {

    }

    public StudentSuccess(long id, long userId, Test test, int questNumber, int writeAnswer,
                          int wrongAnswer, TestStatus status) {
        this.id = id;
        this.userId = userId;
        this.test = test;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public static class Builder {

        private StudentSuccess success;

        public Builder() {
            success = new StudentSuccess();
        }

        public Builder setId(long id){
            success.id = id;
            return this;
        }

        public Builder setUserId(long userIdid){
            success.userId = userIdid;
            return this;
        }

        public Builder setTest(Test test){
            success.test = test;
            return this;
        }

        public Builder setQuestNumber(int questNumber){
            success.questNumber = questNumber;
            return this;
        }

        public Builder setWriteAnswer(int writeAnswers){
            success.writeAnswer = writeAnswers;
            return this;
        }

        public Builder setWrongAnswer(int wrongAnswers){
            success.wrongAnswer = wrongAnswers;
            return this;
        }

        public Builder setStatus(TestStatus status){
            success.status= status;
            return this;
        }

        public StudentSuccess build(){
            return success;
        }
    }

    @Override
    public String toString() {
        return "StudentSuccess{" +
                "id=" + id +
                ", userId=" + userId +
                ", questNumber=" + questNumber +
                ", writeAnswer=" + writeAnswer +
                ", wrongAnswer=" + wrongAnswer +
                ", test=" + test +
                ", status=" + status +
                '}';
    }
}
