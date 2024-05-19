package app.bookmanagement.fieldValidation.commandImplementations;

import app.bookmanagement.controller.BookManagementController;
import app.bookmanagement.fieldValidation.command.Command;

public class ValidateYear implements Command {

    private BookManagementController controller;
    private boolean result = false;

    public ValidateYear(BookManagementController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getErrorYear().setText("");
        if(controller.getTextYear().getText().isEmpty()) {
            controller.getErrorYear().setText("Empty field.");
        }
        else if(!controller.getTextYear().getText().matches("[0-9]+") || (controller.getTextYear().getText().startsWith("0") && controller.getTextYear().getText().length() >= 2)) {
            controller.getErrorYear().setText("Not a valid int.");
        }
        else {
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
