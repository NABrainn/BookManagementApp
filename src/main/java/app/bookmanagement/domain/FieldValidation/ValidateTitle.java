package app.bookmanagement.domain.FieldValidation;

import app.bookmanagement.BookManagementController;
import app.bookmanagement.domain.Book;

public class ValidateTitle implements Command {

    private Book book;
    private BookManagementController controller;

    public ValidateTitle(Book book, BookManagementController controller) {
        this.book = book;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorTitle().setText("");
        if(controller.getTextTitle().getText().isEmpty()) {
            controller.getErrorTitle().setText("Empty field.");
        }
        else {
            book.setTitle(controller.getTextTitle().getText());
        }
    }
}
