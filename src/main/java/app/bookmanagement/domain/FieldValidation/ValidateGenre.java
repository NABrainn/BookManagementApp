package app.bookmanagement.domain.FieldValidation;

import app.bookmanagement.BookManagementController;
import app.bookmanagement.domain.Book;

public class ValidateGenre implements Command {

    private Book book;
    private BookManagementController controller;
    private boolean result = false;

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
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
