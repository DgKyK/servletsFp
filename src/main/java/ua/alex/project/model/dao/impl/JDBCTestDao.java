package ua.alex.project.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.constants.Attributes;
import ua.alex.project.model.dao.TestDao;
import ua.alex.project.model.dao.mapper.TestMapper;
import ua.alex.project.model.entity.Test;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Class that implement TestDao Interface with specific methods;
 */
public class JDBCTestDao implements TestDao {
    private Logger logger = LogManager.getLogger(getClass());
    private Connection connection;
    private ResourceBundle bundle;

    public JDBCTestDao(Connection connection) {
        this.connection = connection;
        bundle = ResourceBundle.getBundle(Attributes.DB_PROPERTIES_NAME);
    }

    @Override
    public List<Test> findAll() {
        List<Test> allTests = new ArrayList<>();
        try(Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(bundle.getString(Attributes.DB_SQL_ALL_TESTS));
            TestMapper testMapper = new TestMapper();
            while(rs.next()) {
                Test test = testMapper.extractFromResultSet(rs);
                allTests.add(test);                
            }
        } catch (SQLException e) {
            logger.error("exception called : " + e.getMessage());
            e.printStackTrace();
        }
        return allTests;
    }

    @Override
    public Optional<Test> findById(long id) {

        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_TEST_BY_ID))) {
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            TestMapper testMapper = new TestMapper();
            if(rs.next()) {
                return Optional.of(testMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error("exception called : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Test> findByName(String testName) {
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_TEST_BY_NAME))) {
            ps.setString(1,testName);
            ResultSet rs = ps.executeQuery();
            TestMapper testMapper = new TestMapper();
            if(rs.next()) {
                return Optional.of(testMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error("exception called : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(Test test) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Closing connection ERROR" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
