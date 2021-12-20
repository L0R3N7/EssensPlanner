package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;

import java.io.IOException;

public class PlannerController {
    public SplitPane root;

    @FXML
    private void initialize() {
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());
    }


    public void printEinkaufszettel(ActionEvent actionEvent) {
        System.out.println("Transfer to Einkaufszettel");
        try{
            App.setRoot("Einkaufsliste");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
