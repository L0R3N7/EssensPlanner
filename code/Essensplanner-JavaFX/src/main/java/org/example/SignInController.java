package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.apiClient.PersonServiceClient;
import org.example.apiClient.dto.PersonDTO;

import java.io.IOException;

public class SignInController {
    @FXML
    private TextField EMailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;

    @FXML
    public void Login(ActionEvent actionEvent) {
        /*System.out.println("Start Request");
        boolean success = PersonServiceClient.addPersonToApi(new PersonDTO(EMailField.getText(), PasswordField.getText()));
        System.out.println((success)?"success":"failure");*/

        System.out.println("Start Signing In");
        boolean success = PersonServiceClient.login(new PersonDTO(EMailField.getText(), PasswordField.getText()));

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
