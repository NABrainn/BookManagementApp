package app.bookmanagement.domain.FieldCommands;

public interface Command {
    void execute();
    boolean getResult();
}
