package ua.alex.project.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> extends AutoCloseable {
    void save(T entity);
    Optional<T> findById(long id);
    List<T> findAll();
    void close();
}
