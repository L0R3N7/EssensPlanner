package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RezepteController {

    public Text RezeptÜberschrieft;
    public TableColumn GewichtColumn;
    public TableColumn MessartColumn;
    public TableColumn ZutatenColumn;
    public VBox ZubereitungsschritteBerceich;

    @FXML
    private void initialize() {
        fillZubereitungsschritteBerceich();
    }

    public void fillZubereitungsschritteBerceich(){

    }



}
