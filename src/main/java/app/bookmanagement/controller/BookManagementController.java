package app.bookmanagement.controller;

import app.bookmanagement.beans.Book;
import app.bookmanagement.database.databaseAccessObjectImplementation.BookDAO;
import app.bookmanagement.fieldValidation.command.Command;
import app.bookmanagement.fieldValidation.commandImplementations.*;
import app.bookmanagement.fieldValidation.validationResultSet.CommandResultSet;
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

    @FXML
    private Label bookCount;

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

    //sets the command to execute
    public void setCommand(Command command) {
        this.command = command;
    }

    //executes set command
    public void executeCommand(Command command) {
        command.execute();
    }

    //renders all books from database as ObservableList
    ObservableList<Book> tableData() throws SQLException {
        return FXCollections.observableArrayList(db.bookList());
    }

    //initial data on application launch
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        try {
            table.setItems(tableData());
            bookCount.setText(String.valueOf(db.bookList().size()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        textSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                regexSearchTitle();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //validates the fields via commands
    //if resultSet is true a book is added and count updated
    //else error messeges are presented
    public void btnAdd() throws SQLException {
        Book book = new Book();
        CommandResultSet results = new CommandResultSet();

        setCommand(new ValidateTitle(this));
        executeCommand(command);
        results.add(command.getResult());


        setCommand(new ValidateAuthor(this));
        executeCommand(command);
        results.add(command.getResult());

        setCommand(new ValidateGenre(this));
        executeCommand(command);
        results.add(command.getResult());

        setCommand(new ValidateYear(this));
        executeCommand(command);
        results.add(command.getResult());


        if(!results.getResults().contains(false)) {
            book.setTitle(textTitle.getText().trim());
            book.setAuthor(textAuthor.getText().trim());
            book.setGenre(textGenre.getText().trim());
            book.setYear(Integer.parseInt(textYear.getText().trim()));

            db.add(book);
            table.setItems(tableData());
            bookCount.setText(String.valueOf(db.bookList().size()));

            getTextTitle().clear();
            getTextAuthor().clear();
            getTextGenre().clear();
            getTextYear().clear();
        }
    }

    //deletes book selected in the table
    public void delBtn() throws SQLException {
        Book book = table.getSelectionModel().getSelectedItem();
        if(book != null) {
            db.delete(book.getTitle());
            table.setItems(tableData());
            bookCount.setText(String.valueOf(db.bookList().size()));
        }
    }

    //renders only those books that match regex expression
    public void regexSearchTitle() throws SQLException {
        ObservableList<Book> ls = db.bookList().stream()
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