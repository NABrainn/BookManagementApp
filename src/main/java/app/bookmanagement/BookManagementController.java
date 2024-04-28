package app.bookmanagement;

import app.bookmanagement.domain.Book;
import app.bookmanagement.domain.BookDAO;
import app.bookmanagement.domain.FieldValidation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookManagementController implements Initializable {


    @FXML
    private TableColumn<Book, String> author;

    @FXML
    private TableColumn<Book, String> genre;


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
    private TextField textSearch;

    @FXML
    private Label errorAuthor;

    @FXML
    private Label errorGenre;

    @FXML
    private Label errorTitle;

    @FXML
    private Label errorYear;

    private BookDAO db;

    private Command command;

    public BookManagementController() {
        this.db = new BookDAO();
    }

    public TableView<Book> getTable() {
        return table;
    }

    public void setTable(TableView<Book> table) {
        this.table = table;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public TextField getTextAuthor() {
        return textAuthor;
    }

    public void setTextAuthor(TextField textAuthor) {
        this.textAuthor = textAuthor;
    }

    public TextField getTextGenre() {
        return textGenre;
    }

    public void setTextGenre(TextField textGenre) {
        this.textGenre = textGenre;
    }

    public TextField getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(TextField textTitle) {
        this.textTitle = textTitle;
    }

    public TextField getTextYear() {
        return textYear;
    }

    public void setTextYear(TextField textYear) {
        this.textYear = textYear;
    }

    public Label getErrorAuthor() {
        return errorAuthor;
    }

    public void setErrorAuthor(Label errorAuthor) {
        this.errorAuthor = errorAuthor;
    }

    public Label getErrorGenre() {
        return errorGenre;
    }

    public void setErrorGenre(Label errorGenre) {
        this.errorGenre = errorGenre;
    }

    public Label getErrorTitle() {
        return errorTitle;
    }

    public void setErrorTitle(Label errorTitle) {
        this.errorTitle = errorTitle;
    }

    public Label getErrorYear() {
        return errorYear;
    }

    public void setErrorYear(Label errorYear) {
        this.errorYear = errorYear;
    }

    ObservableList<Book> initialData() throws SQLException {
        return FXCollections.observableArrayList(db.findAll());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        try {
            table.setItems(initialData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        textSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                regexSearch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void btnAdd() throws SQLException {
        Book book = new Book();

        setCommand(new ValidateTitle(book, this));
        executeCommand(command);

        setCommand(new ValidateAuthor(book, this));
        executeCommand(command);

        setCommand(new ValidateGenre(book, this));
        executeCommand(command);

        setCommand(new ValidateYear(book, this));
        executeCommand(command);

        try {
            db.add(book);
        } catch (SQLException e) {
            throw new RuntimeException("The fields might be empty / duplicate title / incorrect type in year field.");
        }
        table.setItems(initialData());
    }

    public void delBtn() throws SQLException {
        Book book = table.getSelectionModel().getSelectedItem();
        db.delete(book.getTitle());
        table.setItems(initialData());
    }

    public void regexSearch() throws SQLException {

        ObservableList<Book> ls = db.findAll().stream()
                .filter(book -> {
                    Pattern pt = Pattern.compile(textSearch.getText());
                    String candidate = book.getTitle();
                    Matcher m = pt.matcher(candidate);
                    return m.find();
                })
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        table.setItems(ls);
    }
}