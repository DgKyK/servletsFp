package ua.alex.project.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * Class that implement StudentSuccessDao Interface with specific methods;
 */
public class JDBCStudentSuccessDao implements StudentSuccessDao {
    private Logger logger = LogManager.getLogger(getClass());

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
            logger.error("exception called : " + e.getMessage());
            e.printStackTrace();
        }
        return successList;
    }

    @Override
    public List<StudentSuccess> findLimitViewByUserId(int currentPage, int recordsPerPage, long id) {
        List<StudentSuccess> successList = new ArrayList<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_LIMIT_VIEW_BY_USER_ID))) {
            ps.setLong(1,id);
            ps.setInt(2,start);
            ps.setInt(3,recordsPerPage);
            ResultSet rs = ps.executeQuery();
            StudentSuccessMapper mapper = new StudentSuccessMapper();
            while(rs.next()) {
                StudentSuccess temp = mapper.extractFromResultSet(rs);
                successList.add(temp);
            }
        } catch(SQLException e) {
            logger.error("exception called : " + e.getMessage());
            e.printStackTrace();
        }
        return successList;

    }

    @Override
    public int getRowsCountByUserId(long id) {
        int numOfRows = 0;
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_GET_SUCCES_COUNT_BY_USER_ID))) {
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                numOfRows = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("exception called : " + e.getMessage());
            e.printStackTrace();
        }
        return numOfRows;
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
            logger.error("exception called : " + e.getMessage());
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
            logger.error("Closing connection ERROR" + e.getMessage());
            e.printStackTrace();
        }
    }
}
