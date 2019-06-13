package ua.alex.project.model.dao.impl;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.dao.QuestionDao;
import ua.alex.project.model.dao.mapper.QuestionMapper;
import ua.alex.project.model.entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class JDBCQuestionDao implements QuestionDao {
    private Connection connection;
    private ResourceBundle bundle;

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
        bundle = ResourceBundle.getBundle(Attributes.DB_PROPERTIES_NAME);
    }

    @Override
    public List<Question> findAllQuestionsByTestId(long testId) {
        List<Question> questions = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_ALL_QUESTIONS_BY_TEST_ID))) {
            ps.setLong(1,testId);
            ResultSet rs = ps.executeQuery();
            QuestionMapper questionMapper = new QuestionMapper();
            while (rs.next()) {
                 Question tempQuestion = questionMapper.extractFromResultSet(rs);
                 questions.add(tempQuestion);
            }
        } catch (SQLException e) {
            //TODO log.warn("exeption when find quest by test_id" + e.getMessage)
        }
        return questions;
    }

    @Override
    public void save(Question entity) throws SQLException {

    }

    @Override
    public Optional<Question> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            //TODO logging for this case
            throw new RuntimeException(e);
        }
    }
}
