package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {
    @FXML
    private TextField EMailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;


    public void Login(ActionEvent actionEvent) {
        System.out.println("Start Request");

    }
}
