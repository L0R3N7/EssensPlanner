package org.example;

import javafx.event.ActionEvent;
import javafx.event.Event;
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

    List<Pair<Parent, PlannerGerichtConroller>>[] gerichtObjectListe = new ArrayList[8];

    @FXML
    private void initialize() {
        for (int i = 0; i < gerichtObjectListe.length; i++){
            gerichtObjectListe[i] = new ArrayList<>();
        }


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
        for (int i = 0; i < vBoxes.length; i++){
            final int index = i;
            vBoxes[i].setOnDragOver(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            });
            vBoxes[i].setOnDragDropped(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent dragEvent) {
                    Dragboard d = dragEvent.getDragboard();
                    String[] result = d.getString().split(",");
                    int whichTable = Integer.valueOf(result[0]);
                    int tableIndex = Integer.valueOf(result[1]);

                    System.out.println("copy element from "+result[0] +"at"+result[1]+" an do stuff at "+index);

                    if(whichTable == 7){
                        PlannerGerichtConroller draggedElement = gerichtObjectListe[whichTable].get(tableIndex).getValue();
                        //// copy dragged Element
                        // create GerichtObject and fill with data
                        Pair<Parent, PlannerGerichtConroller> temp = createGerichtObject(draggedElement.getGerichtDTO(), index);
                        // add to Vbox
                        vBoxes[index].getChildren().add(temp.getKey());
                        // add to list
                        gerichtObjectListe[index].add(temp);
                        // add drag
                        temp.getKey().setOnDragDetected(mouseEvent -> {
                                        Dragboard db = temp.getKey().startDragAndDrop(TransferMode.ANY);
                                        ClipboardContent clipboardContent = new ClipboardContent();
                                        clipboardContent.putString(String.valueOf(temp.getValue().getInWhichVbox())+","+String.valueOf(gerichtObjectListe[temp.getValue().getInWhichVbox()].indexOf(temp)));
                                        db.setContent(clipboardContent);
                                });

                        System.out.println("1 At"+index+" "+gerichtObjectListe[index].indexOf(temp));
                    }else {
                        if (gerichtObjectListe[index].indexOf(gerichtObjectListe[whichTable].get(tableIndex)) != -1){
                            System.out.println("No duplication please");
                            return;
                        }else {
                            Pair<Parent, PlannerGerichtConroller> temp = gerichtObjectListe[whichTable].remove(tableIndex);
                            temp.getValue().setInWhichVbox(index);
                            vBoxes[index].getChildren().add(temp.getKey());
                            gerichtObjectListe[index].add(temp);
                            System.out.println("2 At"+index+" "+gerichtObjectListe[index].indexOf(temp));
                        }
                    }
                }
            });
        }
    }

    // Such Funktion
    // Aufbauen der Gerichte Element
    // Initialisiert Drag
    public void loadGerichte() {
        favGerichtList.getChildren().remove(0, favGerichtList.getChildren().size());
        gerichtObjectListe[7].clear();

        List<GerichtDTO> gerichtDTOList = App.appData.searchGerichte(gerichteSearch.getText());

        for (GerichtDTO gerichtDTO : gerichtDTOList){
            Pair<Parent, PlannerGerichtConroller> temp = this.createGerichtObject(gerichtDTO, 7);
            if (temp == null){continue;}

            favGerichtList.getChildren().add(temp.getKey());
            temp.getValue().setRootSize(favGerichtList.getWidth(), 20);
            gerichtObjectListe[7].add(temp);

            temp.getKey().setOnDragDetected(
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            Dragboard db = temp.getKey().startDragAndDrop(TransferMode.ANY);
                            ClipboardContent clipboardContent = new ClipboardContent();
                            clipboardContent.putString(String.valueOf(temp.getValue().getInWhichVbox())+","+String.valueOf(gerichtObjectListe[temp.getValue().getInWhichVbox()].indexOf(temp)));
                            db.setContent(clipboardContent);
                        }
                    }
            );

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

    private Pair<Parent, PlannerGerichtConroller> createGerichtObject(GerichtDTO gerichtDTO, int inWhichVbox){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PlannerGericht.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            PlannerGerichtConroller plannerGerichtConroller = (PlannerGerichtConroller) fxmlLoader.getController();
            plannerGerichtConroller.setInWhichVbox(inWhichVbox);
            plannerGerichtConroller.setGerichtDTO(gerichtDTO);
            return new Pair<Parent, PlannerGerichtConroller>(parent, plannerGerichtConroller);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
