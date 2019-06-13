package ua.alex.project.model.entity;

import ua.alex.project.model.enums.Answer;

public class Question {
    private long id;
    private long testId;
    private int questNumber;
    private Answer answer;

    public Question() {

    }

    public Question(long id, int testId, int questNumber, Answer answer) {
        this.id = id;
        this.testId = testId;
        this.questNumber = questNumber;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTest() {
        return testId;
    }

    public void setTest(long testId) {
        this.testId = testId;
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

    public static class Builder {
        private Question question;

        public Builder() {
            question = new Question();
        }

        public Builder setId(long id){
            question.id = id;
            return this;
        }

        public Builder setTestId(long testId){
            question.testId = testId;
            return this;
        }

        public Builder setQuestNumber(int questNumber){
            question.questNumber = questNumber;
            return this;
        }

        public Builder setAnswer(Answer answer){
            question.answer = answer;
            return this;
        }

        public Question build(){
            return question;
        }

    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", testId=" + testId +
                ", questNumber=" + questNumber +
                ", answer=" + answer +
                '}';
    }
}
