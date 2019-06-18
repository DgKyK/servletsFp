package ua.alex.project.model.dao.mapper;

import ua.alex.project.model.entity.Question;
import ua.alex.project.model.enums.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class that helps to map the Question entity from DB;
 */
public class QuestionMapper implements ObjectMapper<Question> {
    @Override
    public Question extractFromResultSet(ResultSet rs) throws SQLException {
        Question question = new Question.Builder()
                .setId(rs.getLong("id"))
                .setTestId(rs.getLong("test_id"))
                .setQuestNumber(rs.getInt("quest_number"))
                .setAnswer(Answer.valueOf(rs.getString("answer")))
                .build();
        return question;
    }
}
