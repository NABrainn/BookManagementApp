package app.bookmanagement.domain.FieldValidation;

import app.bookmanagement.BookManagementController;
import app.bookmanagement.domain.Book;

public class ValidateGenre implements Command {
    private Book book;
    private BookManagementController controller;

    public ValidateGenre(Book book, BookManagementController controller) {
        this.book = book;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorGenre().setText("");
        if(controller.getTextGenre().getText().isEmpty()) {
            controller.getErrorGenre().setText("Empty field.");
        }
        else {
            book.setGenre(controller.getTextGenre().getText());
        }
    }
}
