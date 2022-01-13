package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import org.example.apiClient.dto.GerichtDTO;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlannerController {
    public SplitPane root;
    public VBox favGerichtList;
    public VBox moGerichtList;
    public VBox diGerichtList;
    public VBox miGerichtList;
    public VBox doGerichtList;
    public VBox frGerichtList;
    public VBox saGerichtList;
    public VBox soGerichtList;
    public TextField gerichteSearch;
    public DatePicker datumEingabe;

    public LocalDate kalenderDate = LocalDate.now();

    public Label diDatum;
    public Label miDatum;
    public Label doDatum;
    public Label frDatum;
    public Label saDatum;
    public Label soDatum;
    public Label moDatum;

    public Label[] wocheDatum;

    List<Pair<Parent, PlannerGerichtConroller>> gerichtObjectListe = new ArrayList<>();

    @FXML
    private void initialize() {
        // Kalender
        wocheDatum = new Label[]{
                moDatum,
                diDatum,
                miDatum,
                doDatum,
                frDatum,
                saDatum,
                soDatum,
        };

        datumEingabe.valueProperty().addListener((ov, oldValue, newValue) -> {
            kalenderDate = newValue.with(DayOfWeek.MONDAY);

            writeDatums(kalenderDate);
        });

        datumEingabe.setShowWeekNumbers(true);
        datumEingabe.setValue(kalenderDate);


        // Fenster - Size
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());

        // Dragable
        initDrag(new VBox[]{moGerichtList, diGerichtList, miGerichtList, doGerichtList, frGerichtList, saGerichtList, soGerichtList});
    }



    private void writeDatums(LocalDate localDate){
        for (int i = 0; i < wocheDatum.length; i++){
            wocheDatum[i].setText(localDate.plusDays(i).format(DateTimeFormatter.ofPattern("dd MM")));
        }
    }

    private void initDrag(VBox[] vBoxes){
        for (VBox vBox : vBoxes){
            vBox.setOnDragOver(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            });
            vBox.setOnDragDropped(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    Dragboard d = dragEvent.getDragboard();
                    vBox.getChildren().add(gerichtObjectListe.get(Integer.valueOf(d.getString())).getKey());
                }
            });
        }
    }

    // Search Funktion
    // Aufbauen der Gerichte Element
    // Dropable
    public void loadGerichte() {
        favGerichtList.getChildren().remove(0, favGerichtList.getChildren().size());
        gerichtObjectListe.clear();

        List<GerichtDTO> gerichtDTOList = App.appData.searchGerichte(gerichteSearch.getText());

        try {
            for (GerichtDTO gerichtDTO : gerichtDTOList){
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PlannerGericht.fxml"));
                Parent parent = fxmlLoader.load();
                PlannerGerichtConroller plannerGerichtConroller = (PlannerGerichtConroller) fxmlLoader.getController();

                favGerichtList.getChildren().add(parent);
                plannerGerichtConroller.setGerichtDTO(gerichtDTO);
                plannerGerichtConroller.setRootSize(favGerichtList.getWidth(), 20);

                gerichtObjectListe.add(new Pair<Parent, PlannerGerichtConroller>(parent, plannerGerichtConroller));

                parent.setOnDragDetected(
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                Dragboard db = parent.startDragAndDrop(TransferMode.ANY);
                                ClipboardContent clipboardContent = new ClipboardContent();
                                clipboardContent.putString(String.valueOf(gerichtObjectListe.size()-1));
                                db.setContent(clipboardContent);
                            }
                        }
                );

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printEinkaufszettel(ActionEvent actionEvent) {
        System.out.println("Transfer to Einkaufszettel");
        try{
            App.setRoot("Einkaufsliste");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
