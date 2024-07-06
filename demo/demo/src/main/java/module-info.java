module com.example {
    requires javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    opens com.example to javafx.fxml;
    exports com.example;
}
