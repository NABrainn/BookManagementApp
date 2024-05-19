package app.bookmanagement.fieldValidation.commandImplementations;

import app.bookmanagement.controller.BookManagementController;
import app.bookmanagement.beans.Book;
import app.bookmanagement.fieldValidation.command.Command;

public class ValidateGenre implements Command {


    private BookManagementController controller;
    private boolean result = false;

    public ValidateGenre(BookManagementController controller) {

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
