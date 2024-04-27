package app.bookmanagement;

import app.bookmanagement.domain.Book;
import app.bookmanagement.domain.BookDAO;
import app.bookmanagement.domain.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class BookManagementController implements Initializable {


    @FXML
    private TableColumn<Book, String> author;

    @FXML
    private TableColumn<Book, String> genre;

    @FXML
    private TableColumn<Book, Integer> id;

    @FXML
    private TableColumn<Book, String> title;

    @FXML
    private TableColumn<Book, Integer> year;

    @FXML
    private TableView<Book> table;

    private BookDAO db;

    public BookManagementController() {
        this.db = new BookDAO();
    }


    ObservableList<Book> initialData() throws SQLException {
        return FXCollections.observableArrayList(db.findAll());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        genre.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        year.setCellValueFactory(new PropertyValueFactory<Book, Integer>("year"));
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));

        try {
            table.setItems(initialData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAdd() {

    }
}