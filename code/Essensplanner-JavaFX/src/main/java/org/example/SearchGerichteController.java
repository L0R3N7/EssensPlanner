package org.example;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.example.apiClient.dto.GerichtDTO;

import java.io.IOException;
import java.util.List;

public class SearchGerichteController {

    @FXML
    public TextField SearchField;
    @FXML
    public VBox vBox;
    public GridPane root;

    @FXML
    private void initialize() {
        ChangeListener<String> Searchlistener = (obs, ov, nv) -> searchGerichte(nv);
        SearchField.textProperty().addListener(Searchlistener);
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());
        vBox.setPrefWidth(App.bpRoot.widthProperty().get());
    }

    private void searchGerichte(String text){
        clearGerichte();

        //HTTP Request
        List<GerichtDTO> dtoArrayList = App.appData.searchGerichte(text);

        if (dtoArrayList.size() != 0){
            dtoArrayList.forEach(a -> buildGerichte(a));
        }
    }

    private void buildGerichte(GerichtDTO gerichteDTO){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Gerichte.fxml"));
            Parent parent = fxmlLoader.load();
            GerichteController controller = (GerichteController) fxmlLoader.getController();

            controller.setGerichteDTO(gerichteDTO);
            var isfav = App.appData.isFavoriteGericht(gerichteDTO.getId());
            if (isfav){
                System.out.println("i lika lika");
            }
            controller.fav = isfav;
            controller.setGerichtFav(isfav);
            //controller.setGerichtBeschreibung(gerichteDTO.getDesc());
            controller.setGerichtName(gerichteDTO.getName());

            vBox.getChildren().add(parent);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void clearGerichte(){
        vBox.getChildren().remove(0, vBox.getChildren().size());
    }


}
