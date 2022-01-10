package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.apiClient.dto.GerichtDTO;
import org.example.apiClient.dto.RezeptDTO;
import org.example.apiClient.dto.ZutatenDTO;

import java.util.ArrayList;
import java.util.List;

public class RezepteController {

    public Text RezeptÜberschrieft;
    public TableColumn GewichtColumn;
    public TableColumn MessartColumn;
    public TableColumn ZutatenColumn;
    public VBox ZubereitungsschritteBerceich;
    public GridPane root;
    public ScrollPane widthwidthwidth;
    public VBox widthwidthwidthwidthwidthwidth;

    @FXML
    private void initialize() {
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());
        widthwidthwidth.setPrefWidth(App.bpRoot.widthProperty().get());
        widthwidthwidthwidthwidthwidth.setPrefWidth(App.bpRoot.widthProperty().get());
        widthwidthwidthwidthwidthwidth.setPrefHeight(App.bpRoot.heightProperty().get());
    }

    public void buildContent(GerichtDTO gerichteDTO){
        //var z = ZutatenlisteDTORequest(gerichteDTO.getId());
        fillZubereitungsschritteBerceich(gerichteDTO.getRezept());
    }

    /*private List<ZutatenDTO> ZutatenlisteDTORequest(long uniqueGerichteId){
        //Placeholder for Response
        List<ZutatenDTO> zutatenlisteDTOArrayList = new ArrayList<>();

        ZutatenDTO zutatenlisteDTO1 = new ZutatenDTO(500, "gramm", "Kidney Bohnen");
        ZutatenDTO zutatenlisteDTO2 = new ZutatenDTO(.1, "kg", "Hühnerfilet");
        ZutatenDTO zutatenlisteDTO3 = new ZutatenDTO(.5, "liter", "Tomatensoßse");

        zutatenlisteDTOArrayList.add(zutatenlisteDTO1);
        zutatenlisteDTOArrayList.add(zutatenlisteDTO2);
        zutatenlisteDTOArrayList.add(zutatenlisteDTO3);

        return zutatenlisteDTOArrayList;
    }*/

    private void fillZubereitungsschritteBerceich( String Rezept){ //ArrayList<ZutatenlisteDTO> AZutatenListDto){
        ZubereitungsschritteBerceich.getChildren().remove(0, ZubereitungsschritteBerceich.getChildren().size());

        Text textRezept = new Text();
        textRezept.setText(Rezept);
        textRezept.setWrappingWidth(ZubereitungsschritteBerceich.getWidth() *.75);

        ZubereitungsschritteBerceich.getChildren().add(textRezept);


        /*AZutatenListDto.forEach(zutatenlisteDTO -> {
            //GewichtColumn.getColumns().add(zutatenlisteDTO.getAmount());
            //MessartColumn.getColumns().add(zutatenlisteDTO.getMessart());
            //ZutatenColumn.getColumns().add(zutatenlisteDTO.getZutatName());
        });*/
    }



}
