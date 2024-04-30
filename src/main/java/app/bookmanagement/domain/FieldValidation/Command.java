package app.bookmanagement.domain.FieldValidation;

public interface Command {
    void execute();
    boolean getResult();
}
