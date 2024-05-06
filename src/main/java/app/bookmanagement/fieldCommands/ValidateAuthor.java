package app.bookmanagement.fieldCommands;

import app.bookmanagement.controller.BookManagementController;
import app.bookmanagement.beans.Book;

public class ValidateAuthor implements Command {

    private Book book;
    private BookManagementController controller;
    private boolean result = false;

    public ValidateAuthor(Book book, BookManagementController controller) {
        this.book = book;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorAuthor().setText("");
        if(controller.getTextAuthor().getText().isEmpty()) {
            controller.getErrorAuthor().setText("Empty field.");
        }
        else {
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
