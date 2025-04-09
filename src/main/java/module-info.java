module com.lobufo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.base;
    requires transitive java.sql;

    opens com.lobufo to javafx.fxml;
    exports com.lobufo;
}
