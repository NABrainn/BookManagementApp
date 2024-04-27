module gui.bookmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens app.bookmanagement to javafx.fxml;
    opens app.bookmanagement.domain to javafx.fxml;
    exports app.bookmanagement;
    exports app.bookmanagement.domain;
}