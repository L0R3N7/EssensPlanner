package org.example;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import org.example.apiClient.dto.GerichteDTO;
import org.example.apiClient.dto.RezeptDTO;
import org.example.apiClient.dto.ZutatenlisteDTO;

import java.io.IOException;
import java.util.ArrayList;

public class GerichteController {
    public Text GerichtName;
    public Text GerichtBeschreibung;
    public SVGPath GerichtFav;
    public ImageView GerichtImage;
    public HBox favclicker;
    public GridPane GerichteElementRoot;
    boolean fav = false;



    private GerichteDTO gerichteDTO = null;

    final private EventHandler<MouseEvent> favClickerEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Changed Fav");
            setGerichtFav(!fav);

            //HTTP Request to Change Fav
            // Rezept
            // Zutatenliste
            // Zutat
            // Rezept

            //Placeholder for Response
            ArrayList<ZutatenlisteDTO> zutatenlisteDTOArrayList = new ArrayList<>();
            ArrayList<RezeptDTO> rezeptDTOArrayList = new ArrayList<>();

            ZutatenlisteDTO zutatenlisteDTO1 = new ZutatenlisteDTO(500, "gramm", "Kidney Bohnen");
            ZutatenlisteDTO zutatenlisteDTO2 = new ZutatenlisteDTO(.1, "kg", "Hühnerfilet");
            ZutatenlisteDTO zutatenlisteDTO3 = new ZutatenlisteDTO(.5, "liter", "Tomatensoßse");

            RezeptDTO rezeptDTO1 = new RezeptDTO(1, "Hühnerfilet würzen.");
            RezeptDTO rezeptDTO2 = new RezeptDTO(2, "Hühnerfilet in kleine jeweils 2 cm große Stücke schneiden.");

            zutatenlisteDTOArrayList.add(zutatenlisteDTO1);
            zutatenlisteDTOArrayList.add(zutatenlisteDTO2);
            zutatenlisteDTOArrayList.add(zutatenlisteDTO3);

            rezeptDTOArrayList.add(rezeptDTO1);
            rezeptDTOArrayList.add(rezeptDTO2);

            /*try{
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Rezepte.fxml"));
                Parent parent = fxmlLoader.load();
                RezepteController controller = (RezepteController) fxmlLoader.getController();

                vBox.getChildren().add(parent);
            }catch (IOException e){
                e.printStackTrace();
            }*/


            mouseEvent.consume();
        }
    };

    final private EventHandler<MouseEvent> gerichtWeiterleitungEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Weiterleiten zu Rezepte");

            //HTTP Request
            //

            mouseEvent.consume();
        }
    };

    @FXML
    private void initialize() {
        favclicker.setOnMouseClicked(favClickerEventHandler);
        GerichteElementRoot.setOnMouseClicked(gerichtWeiterleitungEventHandler);
    }


    public void setGerichteDTO(GerichteDTO gerichteDTO) {
        this.gerichteDTO = gerichteDTO;
    }
    public void setGerichtName(String Name) {
        GerichtName.setText(Name);
    }

    public void setGerichtImage(String ImageUrl) {
        GerichtImage.setImage(new Image(ImageUrl));
    }

    public void setGerichtBeschreibung(String gerichtBeschreibung) {
        GerichtBeschreibung.setText(gerichtBeschreibung);
    }

    public void setGerichtFav(Boolean b) {
        fav = b;
        GerichtFav.setContent(fav?"M16 6.204l-5.528-0.803-2.472-5.009-2.472 5.009-5.528 0.803 4 3.899-0.944 5.505 4.944-2.599 4.944 2.599-0.944-5.505 4-3.899z":"M16 6.204l-5.528-0.803-2.472-5.009-2.472 5.009-5.528 0.803 4 3.899-0.944 5.505 4.944-2.599 4.944 2.599-0.944-5.505 4-3.899zM8 11.773l-3.492 1.836 0.667-3.888-2.825-2.753 3.904-0.567 1.746-3.537 1.746 3.537 3.904 0.567-2.825 2.753 0.667 3.888-3.492-1.836z");
    }
}
