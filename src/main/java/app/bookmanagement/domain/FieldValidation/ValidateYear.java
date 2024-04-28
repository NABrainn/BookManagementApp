package app.bookmanagement.domain.FieldValidation;

import app.bookmanagement.BookManagementController;
import app.bookmanagement.domain.Book;

public class ValidateYear implements Command {

    private Book book;
    private BookManagementController controller;

    public ValidateYear(Book book, BookManagementController controller) {
        this.book = book;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorYear().setText("");
        if(controller.getTextYear().getText().isEmpty()) {
            controller.getErrorYear().setText("Empty field.");
        }
        else {
            try {
                book.setYear(Integer.parseInt(controller.getTextYear().getText()));
            } catch (NumberFormatException e) {
                controller.getErrorYear().setText("Not an int.");
                throw new NumberFormatException();
            }
        }
    }
}
