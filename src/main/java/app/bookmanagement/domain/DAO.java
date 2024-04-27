package app.bookmanagement.domain;

import java.sql.SQLException;
import java.util.List;


public interface DAO<T> {
    T findById(Long id) throws SQLException;
    List<T> findAll() throws SQLException;
    int add(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(Long id) throws SQLException;
}
