package app.bookmanagement.fieldValidation.commandImplementations;

import app.bookmanagement.controller.BookManagementController;
import app.bookmanagement.beans.Book;
import app.bookmanagement.fieldValidation.command.Command;

public class ValidateTitle implements Command {

    private BookManagementController controller;
    private boolean result = false;

    public ValidateTitle(BookManagementController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorTitle().setText("");
        if(controller.getTextTitle().getText().isEmpty()) {
            controller.getErrorTitle().setText("Empty field.");
        }
        else if(controller.getTable().getItems().stream()
                .map(Book::getTitle)
                .toList().contains(controller.getTextTitle().getText()))
        {
            controller.getErrorTitle().setText("Duplicate title.");
        }
        else {
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
