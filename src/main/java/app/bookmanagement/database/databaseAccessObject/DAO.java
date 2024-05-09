package app.bookmanagement.database.databaseAccessObject;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T findByTitle(String title) throws SQLException;
    List<T> bookList() throws SQLException;
    void add(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(String title) throws SQLException;
}
