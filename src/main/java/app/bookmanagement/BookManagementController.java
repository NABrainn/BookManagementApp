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

    final private BookDAO db;

    private Command command;

    public BookManagementController() {
        this.db = new BookDAO();
    }

    public TableView<Book> getTable() {
        return table;
    }

    public TextField getTextAuthor() {
        return textAuthor;
    }

    public TextField getTextGenre() {
        return textGenre;
    }

    public TextField getTextTitle() {
        return textTitle;
    }

    public TextField getTextYear() {
        return textYear;
    }

    public Label getErrorAuthor() {
        return errorAuthor;
    }

    public Label getErrorGenre() {
        return errorGenre;
    }

    public Label getErrorTitle() {
        return errorTitle;
    }

    public Label getErrorYear() {
        return errorYear;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(Command command) {
        command.execute();
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
        CommandResultList results = new CommandResultList();

        setCommand(new ValidateTitle(book, this));
        executeCommand(command);
        results.add(command.getResult());


        setCommand(new ValidateAuthor(book, this));
        executeCommand(command);
        results.add(command.getResult());

        setCommand(new ValidateGenre(book, this));
        executeCommand(command);
        results.add(command.getResult());

        setCommand(new ValidateYear(book, this));
        executeCommand(command);
        results.add(command.getResult());

        results.printResults();

        if(!results.getResults().contains(false)) {
            book.setTitle(textTitle.getText());
            book.setAuthor(textAuthor.getText());
            book.setGenre(textGenre.getText());
            book.setYear(Integer.parseInt(textYear.getText()));

            db.add(book);

            textTitle.clear();
            textAuthor.clear();
            textGenre.clear();
            textYear.clear();
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