module org.example {
    //needed for JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    //needed for HTTP
    requires unirest.java;

    //needed for JSON
    requires java.sql;
    requires com.google.gson;

    //needed for JavaFX
    opens org.example to javafx.fxml;

    //needed for JSON
    opens org.example.apiClient to com.google.gson;


    exports org.example;
}