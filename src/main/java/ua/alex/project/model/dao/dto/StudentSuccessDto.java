package ua.alex.project.model.dao.dto;

import ua.alex.project.model.entity.StudentSuccess;

/**
 * DTO for StudentSuccess that helps to represent that entity to form in which that entity present in DB;
 */
public class StudentSuccessDto {
    private long id;
    private int questNumber;
    private int writeAnswer;
    private int wrongAnswer;
    private long userId;
    private long test_id;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTest_id() {
        return test_id;
    }

    public void setTest_id(long test_id) {
        this.test_id = test_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static StudentSuccessDto of(StudentSuccess studentSuccess) {
        StudentSuccessDto  dto = new StudentSuccessDto();

        dto.setId(studentSuccess.getId());
        dto.setQuestNumber(studentSuccess.getQuestNumber());
        dto.setWriteAnswer(studentSuccess.getWriteAnswer());
        dto.setWrongAnswer(studentSuccess.getWrongAnswer());
        dto.setUserId(studentSuccess.getUserId());
        dto.setTest_id(studentSuccess.getTest().getId());
        dto.setStatus(studentSuccess.getStatus().toString());

        return dto;

    }
}
