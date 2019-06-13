package ua.alex.project.model.dao.mapper;

import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.Test;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.service.TestService;
import ua.alex.project.model.service.UserService;
import ua.alex.project.model.service.impl.TestServiceImpl;
import ua.alex.project.model.service.impl.UserServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class StudentSuccessMapper implements ObjectMapper<StudentSuccess> {
    @Override
    public StudentSuccess extractFromResultSet(ResultSet rs) throws SQLException {
        Test test = findTestFromDb(rs);
        User user = findUserFromDb(rs);

        StudentSuccess studentSuccess = new StudentSuccess.Builder()
                .setId(rs.getLong("id"))
                .setTest(test)
                .setQuestNumber(rs.getInt("questNumber"))
                .setWriteAnswer(rs.getInt("write_answer"))
                .setWrongAnswer(rs.getInt("wrong_answer"))
                .setUserId(user.getId())
                .build();

        return studentSuccess;
    }

    private User findUserFromDb(ResultSet rs) throws SQLException {
        UserService userService = new UserServiceImpl();
        Optional<User> userFromDb = userService.getUserById(rs.getLong("user_id"));
        return userFromDb.get();
    }

    private Test findTestFromDb(ResultSet rs) throws SQLException {
        TestService testService = new TestServiceImpl();
        return testService.findTestById(rs.getLong("test_id"));
    }
}
