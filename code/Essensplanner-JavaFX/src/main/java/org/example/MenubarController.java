package org.example;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class MenubarController {
    public MenuItem login;
    public MenuItem signin;
    public MenuItem forgotpassword;
    public MenuItem searchgerichte;
    public MenuItem planner;
    public MenuItem logout;
    public Menu user;

    public void showHidde(boolean isLoggedin){
        login.setDisable(isLoggedin);
        signin.setDisable(isLoggedin);

        forgotpassword.setDisable(!isLoggedin);
        searchgerichte.setDisable(!isLoggedin);
        planner.setDisable(!isLoggedin);
        user.setDisable(!isLoggedin);
        logout.setDisable(!isLoggedin);
    }

    @FXML
    private void initialize() {
        forgotpassword.setVisible(false);

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transferTo("LogIn");
            }
        });
        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transferTo("SignIn");
            }
        });
        forgotpassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transferTo("PasswortVergessen");
            }
        });
        searchgerichte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transferTo("SearchGerichte");
            }
        });
        planner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transferTo("Planner");
            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // logout Action
                App.appData.logout();
                transferTo("LogIn");
            }
        });
    }

    private void transferTo(String dest){
        try{
            App.setRoot(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
