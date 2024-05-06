module app.bookmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens app.bookmanagement to javafx.fxml;
    exports app.bookmanagement;
    exports app.bookmanagement.fieldCommands;
    exports app.bookmanagement.controller;
    opens app.bookmanagement.controller to javafx.fxml;
    exports app.bookmanagement.database.databaseAccessObject;
    opens app.bookmanagement.database.databaseAccessObject to javafx.fxml;
    exports app.bookmanagement.database.databaseAccessObjectImplementation;
    opens app.bookmanagement.database.databaseAccessObjectImplementation to javafx.fxml;
    exports app.bookmanagement.database.databaseConnectionSingleton;
    opens app.bookmanagement.database.databaseConnectionSingleton to javafx.fxml;
    exports app.bookmanagement.domain.beans;
    opens app.bookmanagement.domain.beans to javafx.fxml;
    exports app.bookmanagement.validationResultList;
    opens app.bookmanagement.validationResultList to javafx.fxml;
    exports app.bookmanagement.beans;
    opens app.bookmanagement.beans to javafx.fxml;
}