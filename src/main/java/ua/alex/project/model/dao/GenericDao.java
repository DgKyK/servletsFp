package ua.alex.project.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interface that uses generic type for another DAO interfaces;
 * @param <T>
 */
public interface GenericDao<T> extends AutoCloseable {
    void save(T entity) throws SQLException;
    Optional<T> findById(long id);
    List<T> findAll();
    void close();
}
