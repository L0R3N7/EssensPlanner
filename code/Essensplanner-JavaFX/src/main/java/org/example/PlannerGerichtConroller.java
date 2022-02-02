package org.example;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import org.example.apiClient.dto.GerichtDTO;

import java.awt.*;
import java.io.IOException;

public class PlannerGerichtConroller {
    private int inWhichVbox = 7;

    public Label GerichtName;
    public HBox iconbox;
    public GridPane root;
    public ColumnConstraints labelbox;
    public ColumnConstraints iconboxbox;

    Pane trashPane;
    Pane rezeptPane;

    GerichtDTO gerichtDTO;

    @FXML
    private void initialize() {
        SVGPath trash = new SVGPath();
        SVGPath rezept = new SVGPath();

        trash.setContent("M19 24h-14c-1.104 0-2-.896-2-2v-17h-1v-2h6v-1.5c0-.827.673-1.5 1.5-1.5h5c.825 0 1.5.671 1.5 1.5v1.5h6v2h-1v17c0 1.104-.896 2-2 2zm0-19h-14v16.5c0 .276.224.5.5.5h13c.276 0 .5-.224.5-.5v-16.5zm-9 4c0-.552-.448-1-1-1s-1 .448-1 1v9c0 .552.448 1 1 1s1-.448 1-1v-9zm6 0c0-.552-.448-1-1-1s-1 .448-1 1v9c0 .552.448 1 1 1s1-.448 1-1v-9zm-2-7h-4v1h4v-1z");
        rezept.setContent("M8.742 2.397c.82-.861 1.977-1.397 3.258-1.397 1.282 0 2.439.536 3.258 1.397.699-.257 1.454-.397 2.242-.397 3.587 0 6.5 2.912 6.5 6.5 0 2.299-1.196 4.321-3 5.476v9.024h-18v-9.024c-1.803-1.155-3-3.177-3-5.476 0-3.588 2.913-6.5 6.5-6.5.788 0 1.543.14 2.242.397zm6.258 19.603h5v-7.505c-.715.307-1.38.47-1.953.525-.274.026-.518-.176-.545-.45-.025-.276.176-.52.451-.545 1.388-.132 5.047-1.399 5.047-5.525 0-3.036-2.465-5.5-5.5-5.5-1.099 0-1.771.29-2.512.563-1.521-1.596-2.402-1.563-2.988-1.563-.595 0-1.474-.026-2.987 1.563-.787-.291-1.422-.563-2.513-.563-3.035 0-5.5 2.464-5.5 5.5 0 4.13 3.663 5.394 5.048 5.525.274.025.476.269.45.545-.026.274-.27.476-.545.45-.573-.055-1.238-.218-1.953-.525v7.505h5v-3.5c0-.311.26-.5.5-.5.239 0 .5.189.5.5v3.5h4v-3.5c0-.311.26-.5.5-.5s.5.189.5.5v3.5z");
        trash.getStyleClass().add("fill-color");
        rezept.getStyleClass().add("fill-color");


        trashPane = new Pane();
        rezeptPane = new Pane();

        configerPain(trashPane);
        configerPain(rezeptPane);

        trashPane.getChildren().add(trash);
        rezeptPane.getChildren().add(rezept);

        trashPane.setOnMouseClicked(mouseEvent -> {

        });
        rezeptPane.setOnMouseClicked(mouseEvent ->  {
                System.out.println("Weiterleiten zu Rezepte");
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Rezepte.fxml"));
                    Parent parent = fxmlLoader.load();

                    RezepteController controller = (RezepteController) fxmlLoader.getController();
                    controller.buildContent(gerichtDTO);

                    App.setRoot(parent);
                }catch (IOException e){
                    e.printStackTrace();
                }
            });

        addSvg(new Pane[]{rezeptPane});
    }

    private void configerPain(Pane p){
        p.setPrefHeight(Region.USE_COMPUTED_SIZE);
        p.setPrefWidth(Region.USE_COMPUTED_SIZE);
        p.setPadding(new Insets(5));
    }

    private void addSvg(Pane[] svgPaths){
        iconbox.getChildren().remove(0, iconbox.getChildren().size());

        for (Pane svgPath : svgPaths){
            iconbox.getChildren().add(svgPath);
        }

        setPercentWidth();
    }

    public int getInWhichVbox() {
        return inWhichVbox;
    }

    public void setInWhichVbox(int inWhichVbox) {
        this.inWhichVbox = inWhichVbox;
        if (inWhichVbox !=7){
            addSvg(new Pane[]{trashPane, rezeptPane});
        }else {
            addSvg(new Pane[]{rezeptPane});
        }
    }

    private void setPercentWidth(){
        double perWidth = iconbox.getChildren().size() * (root.getWidth()/10);
        labelbox.setPercentWidth(root.getWidth() - perWidth);
        iconboxbox.setPercentWidth(perWidth);
    }

    public void setRootSize(double width, double height) {
        root.setPrefHeight(height);
        root.setPrefWidth(width);
    }

    public void setGerichtDTO(GerichtDTO gerichtDTO) {
        this.gerichtDTO = gerichtDTO;
        GerichtName.setText(gerichtDTO.getName());
    }

    public GerichtDTO getGerichtDTO() {
        return gerichtDTO;
    }
}
