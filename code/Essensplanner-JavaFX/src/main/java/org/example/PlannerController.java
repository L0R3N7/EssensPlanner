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
import org.example.apiClient.dto.Mappings;
import org.example.apiClient.dto.TagesplanDTO;
import org.example.apiClient.dto.TagesplanResult;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    VBox[] vBoxes;
    @FXML
    private void initialize() {
        vBoxes = new VBox[]{moGerichtList, diGerichtList, miGerichtList, doGerichtList, frGerichtList, saGerichtList, soGerichtList};


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

        // lets you change the date of the calendar
        datumEingabe.valueProperty().addListener((ov, oldValue, newValue) -> {
            kalenderDate = newValue.with(DayOfWeek.MONDAY);
            writeDatums(kalenderDate);
            getGerichtsPlan();
        });

        //Configure the calendar
        datumEingabe.setShowWeekNumbers(true);
        datumEingabe.setValue(kalenderDate);


        // Fenster - Size
        root.setPrefHeight(App.bpRoot.heightProperty().get());
        root.setPrefWidth(App.bpRoot.widthProperty().get());

        // Dragable
        initDrag();
        // Get Data
        System.out.println("get Data");
        getGerichtsPlan();
    }

    // Writes the dates in the labels of the calendar
    private void writeDatums(LocalDate localDate){
        for (int i = 0; i < wocheDatum.length; i++){
            wocheDatum[i].setText(localDate.plusDays(i).format(DateTimeFormatter.ofPattern("dd MM")));
        }
    }

    // lets you drag "gerichte" in the calenda
    private void initDrag(){
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
                        addNewGerichteObj(draggedElement.getGerichtDTO(), index);
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

                    // Save changed Data
                    savePlannedWeek();

                    // Update Date
                    getGerichtsPlan();
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

    //sends data from kalender to the server to save them
    private void savePlannedWeek(){
        List<TagesplanDTO> tagesplanDTOS = new ArrayList<>();

        for (int i = 0; i < 7; i++){
            if (gerichtObjectListe[i].size() == 0){
                continue;
            }

            TagesplanDTO tagesplanDTO = new TagesplanDTO();
            tagesplanDTO.setIdLocalDate(Mappings.LocalDateToString(kalenderDate.plusDays(i)));
            tagesplanDTO.setGerichtListIds(gerichtObjectListe[i].stream()
                    .map(parentPlannerGerichtConrollerPair -> parentPlannerGerichtConrollerPair.getValue().getGerichtDTO().getId())
                    .collect(Collectors.toList()));
            tagesplanDTOS.add(tagesplanDTO);
        }

        App.appData.deletePlannedWeek(kalenderDate);
        App.appData.addPlannedWeek(tagesplanDTOS);
    }

    public void getGerichtsPlan(){
        //Clear the data from before
        clearLocalWeekPlan();

        //Rest - Service - Request
        for (TagesplanResult tagesplanResult : App.appData.getPlannedWeek(this.kalenderDate)){
            System.out.println(tagesplanResult);
            //Fill the Calendar with Data
            long vboxId = Math.abs(ChronoUnit.DAYS.between(this.kalenderDate, Mappings.StringToLocalDate(tagesplanResult.getIdLocalDate())));
            if (vboxId > 6){
                System.out.println("well this is out of scope");
                continue;
            }

            List<GerichtDTO> gerichtDTOList = App.appData.getGerichteByIds(tagesplanResult.getGerichteListe().stream().map(TagesplanResult.GerichteListeElementDto::getGerichtId).collect(Collectors.toList()));
            for (GerichtDTO gerichtDTO : gerichtDTOList){
                System.out.println(gerichtDTO.toString());
                addNewGerichteObj(gerichtDTO, (int)vboxId);
            }
        }
    }
    public void addNewGerichteObj(GerichtDTO gerichtDTO, int index){
        // create GerichtObject and fill with data
        Pair<Parent, PlannerGerichtConroller> temp = createGerichtObject(gerichtDTO, index);
        // add to Vbox
        vBoxes[index].getChildren().add(temp.getKey());
        // add to list
        gerichtObjectListe[index].add(temp);
        // add delete
        temp.getValue().trashPane.setOnMouseClicked(mouseEvent -> {
            gerichtObjectListe[temp.getValue().getInWhichVbox()].remove(temp);
            vBoxes[temp.getValue().getInWhichVbox()].getChildren().remove(temp.getKey());
            savePlannedWeek();
        });
        // add drag
        temp.getKey().setOnDragDetected(mouseEvent -> {
            Dragboard db = temp.getKey().startDragAndDrop(TransferMode.ANY);
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(String.valueOf(temp.getValue().getInWhichVbox())+","+String.valueOf(gerichtObjectListe[temp.getValue().getInWhichVbox()].indexOf(temp)));
            db.setContent(clipboardContent);
        });
        System.out.println("1 At"+index+" "+gerichtObjectListe[index].indexOf(temp));
    }

    public void clearLocalWeekPlan(){
        for (int i = 0; i <= 6; i++){
            if (gerichtObjectListe[i]!=null){gerichtObjectListe[i].clear();}
            if (vBoxes[i] != null){vBoxes[i].getChildren().clear();}
        }
    }
}
