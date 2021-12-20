package org.example;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class EinkaufslisteController {
    public GridPane root;

    @FXML
    private void initialize() {
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());
    }
}
