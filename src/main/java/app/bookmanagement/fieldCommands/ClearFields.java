package app.bookmanagement.fieldCommands;

import app.bookmanagement.controller.BookManagementController;

public class ClearFields implements Command {

    private BookManagementController controller;
    private boolean result = false;

    public ClearFields(BookManagementController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.getTextTitle().clear();
        controller.getTextAuthor().clear();
        controller.getTextGenre().clear();
        controller.getTextYear().clear();
    }

    @Override
    public boolean getResult() {
        return true;
    }
}
