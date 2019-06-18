package ua.alex.project.model.dao.mapper;

import ua.alex.project.model.entity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class that helps to map the Test entity from DB;
 */
public class TestMapper implements ObjectMapper<Test> {
    @Override
    public Test extractFromResultSet(ResultSet rs) throws SQLException {
        Test test = new Test.Builder()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setTheme(rs.getString("theme"))
                .setNeedAnswerNumber(rs.getInt("need_answer_numb"))
                .setQuestNumber(rs.getInt("quest_number")).build();
        return test;
    }
}
