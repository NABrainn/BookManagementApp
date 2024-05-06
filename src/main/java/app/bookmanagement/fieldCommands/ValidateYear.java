package app.bookmanagement.fieldCommands;

import app.bookmanagement.controller.BookManagementController;
import app.bookmanagement.beans.Book;

public class ValidateYear implements Command {

    private Book book;
    private BookManagementController controller;
    private boolean result = false;

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
        else if(!controller.getTextYear().getText().matches("[0-9]+")) {
            controller.getErrorYear().setText("Not an int.");
        }
        else {
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
