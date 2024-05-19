package app.bookmanagement.fieldValidation.commandImplementations;

import app.bookmanagement.controller.BookManagementController;
import app.bookmanagement.fieldValidation.command.Command;

public class ValidateAuthor implements Command {

    private BookManagementController controller;
    private boolean result = false;

    public ValidateAuthor(BookManagementController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorAuthor().setText("");
        if(controller.getTextAuthor().getText().isEmpty()) {
            controller.getErrorAuthor().setText("Empty field.");
        }
        else if(!controller.getTextAuthor().getText().matches("\\D+")) {
            controller.getErrorAuthor().setText("Digit not expected.");
        }
        else {
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
