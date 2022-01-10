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
import org.example.apiClient.dto.GerichtDTO;

import java.io.IOException;

public class GerichteController {
    public Text GerichtName;
    public Text GerichtBeschreibung;
    public SVGPath GerichtFav;
    public ImageView GerichtImage;
    public HBox favclicker;
    public GridPane GerichteElementRoot;
    boolean fav;
    GerichtDTO gerichteDTO = null;

    final private EventHandler<MouseEvent> favClickerEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Changed Fav");
            setGerichtFav(!fav);
            App.appData.setFavoriteGericht(gerichteDTO.getId(), fav);

            mouseEvent.consume();
        }
    };

    final private EventHandler<MouseEvent> gerichtWeiterleitungEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Weiterleiten zu Rezepte");
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Rezepte.fxml"));
                Parent parent = fxmlLoader.load();

                RezepteController controller = (RezepteController) fxmlLoader.getController();
                controller.buildContent(gerichteDTO);

                App.setRoot(parent);
            }catch (IOException e){
                e.printStackTrace();
            }

            mouseEvent.consume();
        }
    };

    @FXML
    private void initialize() {
        favclicker.setOnMouseClicked(favClickerEventHandler);
        GerichteElementRoot.setOnMouseClicked(gerichtWeiterleitungEventHandler);
        this.setGerichtFav(fav);
    }


    public void setGerichteDTO(GerichtDTO gerichteDTO) {
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
        System.out.println("i change my star to " + b);
        fav = b;
        GerichtFav.setContent(fav?"M16 6.204l-5.528-0.803-2.472-5.009-2.472 5.009-5.528 0.803 4 3.899-0.944 5.505 4.944-2.599 4.944 2.599-0.944-5.505 4-3.899z":"M16 6.204l-5.528-0.803-2.472-5.009-2.472 5.009-5.528 0.803 4 3.899-0.944 5.505 4.944-2.599 4.944 2.599-0.944-5.505 4-3.899zM8 11.773l-3.492 1.836 0.667-3.888-2.825-2.753 3.904-0.567 1.746-3.537 1.746 3.537 3.904 0.567-2.825 2.753 0.667 3.888-3.492-1.836z");
    }
}
