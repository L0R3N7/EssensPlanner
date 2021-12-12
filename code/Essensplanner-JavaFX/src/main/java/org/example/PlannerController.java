package org.example;

import javafx.event.ActionEvent;

import java.io.IOException;

public class PlannerController {
    public void printEinkaufszettel(ActionEvent actionEvent) {
        System.out.println("Transfer to Einkaufszettel");
        try{
            App.setRoot("Einkaufsliste");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
