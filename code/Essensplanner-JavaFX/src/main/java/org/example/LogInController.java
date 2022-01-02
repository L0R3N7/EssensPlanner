package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.apiClient.dto.PersonDTO;

import java.io.IOException;

public class LogInController {
    @FXML
    public GridPane root;
    @FXML
    private TextField EMailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;

    @FXML
    private void initialize() {
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());
    }

    @FXML
    public void Login(ActionEvent actionEvent) {

        System.out.println("Start Logig In");

        boolean success = App.appData.logIn(new PersonDTO(EMailField.getText(), PasswordField.getText()));

        if (success){
            System.out.println("Weiterleiten");
            try{
                App.setRoot("SearchGerichte");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
