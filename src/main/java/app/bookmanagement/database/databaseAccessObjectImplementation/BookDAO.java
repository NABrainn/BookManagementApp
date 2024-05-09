package app.bookmanagement.database.databaseAccessObjectImplementation;

import app.bookmanagement.beans.Book;
import app.bookmanagement.database.databaseAccessObject.DAO;
import app.bookmanagement.database.databaseConnectionSingleton.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public Book findByTitle(String title) throws SQLException {
        String query = "select * from books where title=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, title);
        Book book = new Book();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while(rs.next()) {
            check = true;

            book.setTitle(rs.getString("title"));
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
    public List<Book> bookList() throws SQLException {
        String query = "select * from books";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> books = new ArrayList<>();

        while(rs.next()) {
            Book book = new Book();

            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setGenre(rs.getString("genre"));
            book.setYear(rs.getInt("year"));
            book.setId(rs.getInt("id"));
            books.add(book);
        }

        return books;
    }

    @Override
    public void add(Book book) throws SQLException {
        String query = "insert into books values(?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getGenre());
        ps.setInt(4, book.getYear());

        ps.executeUpdate();
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
    public void delete(String title) throws SQLException {
        String query = "delete from books where title =?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, title);
        ps.execute();
    }
}
