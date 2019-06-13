package ua.alex.project.model.dao.impl;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.dao.StudentSuccessDao;
import ua.alex.project.model.dao.dto.StudentSuccessDto;
import ua.alex.project.model.dao.mapper.StudentSuccessMapper;
import ua.alex.project.model.entity.StudentSuccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class JDBCStudentSuccessDao implements StudentSuccessDao {

    private Connection connection;
    private ResourceBundle bundle;

    public JDBCStudentSuccessDao(Connection connection) {
        this.connection = connection;
        bundle = ResourceBundle.getBundle(Attributes.DB_PROPERTIES_NAME);
    }


    @Override
    public List<StudentSuccess> findAllByUserId(long id) {
        List<StudentSuccess> successList = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_ALL_SUCCESS_BY_USER_ID))) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            StudentSuccessMapper mapper = new StudentSuccessMapper();
            while(rs.next()) {
                StudentSuccess success = mapper.extractFromResultSet(rs);
                successList.add(success);
            }
        } catch (SQLException e) {
            //TODO log.warn
            e.printStackTrace();
        }
        return successList;
    }

    @Override
    public void save(StudentSuccess entity) throws SQLException {
        StudentSuccessDto studentSuccessDto = StudentSuccessDto.of(entity);
        try (PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_SAVE_STUDENT_SUCCESS))) {
            ps.setLong(1, studentSuccessDto.getUserId());
            ps.setInt(2, studentSuccessDto.getQuestNumber());
            ps.setInt(3,studentSuccessDto.getWriteAnswer());
            ps.setInt(4,studentSuccessDto.getWrongAnswer());
            ps.setLong(5, studentSuccessDto.getTest_id());
            ps.setString(6, studentSuccessDto.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            //TODO logging for this case
            e.printStackTrace();
        }
    }

    @Override
    public Optional<StudentSuccess> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<StudentSuccess> findAll() {
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
