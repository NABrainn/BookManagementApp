package app.bookmanagement.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public Book findById(Long id) throws SQLException {
        String query = "select * from books where ID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);
        Book book = new Book();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while(rs.next()) {
            check = true;

            book.setTitle(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setGenre(rs.getString("genre"));
            book.setYear(rs.getInt("year"));
            book.setId(rs.getInt("ID"));
        }

        if(check) {
            return book;
        }
        return null;
    }

    @Override
    public List<Book> findAll() throws SQLException {
        String query = "select * from books";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> books = new ArrayList<>();

        while(rs.next()) {
            Book book = new Book();

            book.setTitle(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setGenre(rs.getString("genre"));
            book.setYear(rs.getInt("year"));
            book.setId(rs.getInt("id"));
            books.add(book);
        }

        return books;
    }

    @Override
    public int add(Book book) throws SQLException {
        String query = "insert into books values(?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getGenre());
        ps.setInt(4, book.getYear());

        return ps.executeUpdate();
    }

    @Override
    public void update(Book book) throws SQLException {
        String query = "update books set name=?, author=?, genre=?, year=?, ID=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getGenre());
        ps.setInt(4, book.getYear());
        ps.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String query = "delete from books where id =?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);
        ps.execute();
    }
}
