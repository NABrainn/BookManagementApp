package app.bookmanagement;

import app.bookmanagement.domain.Book;
import app.bookmanagement.domain.BookDAO;
import app.bookmanagement.domain.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    @FXML
    private TextField textAuthor;

    @FXML
    private TextField textGenre;

    @FXML
    private TextField textTitle;

    @FXML
    private TextField textYear;

    @FXML
    private Label errorAuthor;

    @FXML
    private Label errorGenre;

    @FXML
    private Label errorTitle;

    @FXML
    private Label errorYear;

    @FXML
    private Button addBtn;

    @FXML
    private Button delBtn;

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

    public void btnAdd() throws SQLException {

        Book book = new Book();

        errorTitle.setText("");
        errorAuthor.setText("");
        errorGenre.setText("");
        errorYear.setText("");

        if(textTitle.getText().isEmpty()) {
            errorTitle.setText("Empty title field.");
        }
        if (textAuthor.getText().isEmpty()) {
            errorAuthor.setText("Empty author field.");
        }
        if (textGenre.getText().isEmpty()) {
            errorGenre.setText("Empty genre field.");
        }

        book.setTitle(textTitle.getText());
        book.setAuthor(textAuthor.getText());
        book.setGenre(textGenre.getText());
        try {
            book.setYear(Integer.parseInt(textYear.getText()));
        }
        catch (Exception e) {
            if (textYear.getText().isEmpty()) {
                errorYear.setText("Empty year field.");
                throw new RuntimeException();
            }
            errorYear.setText("Integer value expected.");
            throw new NumberFormatException();
        }

        textTitle.clear();
        textAuthor.clear();
        textGenre.clear();
        textYear.clear();

        db.add(book);
        table.setItems(initialData());

    }
}