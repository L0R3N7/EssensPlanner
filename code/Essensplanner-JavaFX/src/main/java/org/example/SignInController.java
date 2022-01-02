package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.apiClient.RestApiClient;
import org.example.apiClient.dto.PersonDTO;

import java.io.IOException;

public class SignInController {

    public GridPane root;
    public TextField EMailField;
    public javafx.scene.control.PasswordField PasswordField;
    public javafx.scene.control.PasswordField PasswordField2;
    public Button LoginButton;

    private RestApiClient restApiClient = new RestApiClient();

    @FXML
    private void initialize() {
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());
    }

    public boolean validateInput(){
        return EMailField.getText().length() > 0
                && PasswordField.getText() == PasswordField2.getText()
                && PasswordField.getText().length() > 0;
    }

    public void Login(ActionEvent actionEvent) {
        System.out.println("Start Signing in");

        System.out.println(EMailField.getText() + " "+PasswordField.getText()+" "+PasswordField2.getText());
        /*if (validateInput()){
            System.out.println("Falsche Eingaben\n");
            return;
        }*/

        PersonDTO personDTO = new PersonDTO();
        personDTO.setEmail(EMailField.getText());
        personDTO.setPassword(PasswordField.getText());

        boolean success = App.appData.signIn(personDTO);

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
