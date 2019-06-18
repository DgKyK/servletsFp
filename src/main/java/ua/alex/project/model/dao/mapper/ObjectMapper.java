package ua.alex.project.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * abstract class for all mappers that help to map the objects from DB;
 */
public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet rs) throws SQLException;
}
