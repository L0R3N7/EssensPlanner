package org.example;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.apiClient.dto.GerichteDTO;

import java.io.IOException;
import java.util.ArrayList;

public class SearchGerichteController {

    @FXML
    public TextField SearchField;
    @FXML
    public VBox vBox;

    @FXML
    private void initialize() {
        ChangeListener<String> Searchlistener = (obs, ov, nv) -> searchGerichte(nv);
        SearchField.textProperty().addListener(Searchlistener);
    }

    private void searchGerichte(String text){
        clearGerichte();

        //HTTP Request
        // To Do return Arraylist with GerichteDTO

        //Placeholder
        ArrayList<GerichteDTO> arrayList = new ArrayList<>();
        GerichteDTO gericht = new GerichteDTO();
        gericht.setUniqueId(1);
        gericht.setName("Food");
        gericht.setDesc("Protein 90 g, 3000 kcal");
        gericht.setFav(true);
        arrayList.add(gericht);

        arrayList.forEach(a -> buildGerichte(a));
    }

    private void buildGerichte(GerichteDTO gerichteDTO){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Gerichte.fxml"));
            Parent parent = fxmlLoader.load();
            GerichteController controller = (GerichteController) fxmlLoader.getController();

            controller.setGerichteDTO(gerichteDTO);
            controller.setGerichtFav(gerichteDTO.getFav());
            controller.setGerichtBeschreibung(gerichteDTO.getDesc());
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
