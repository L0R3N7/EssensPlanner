package org.example;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

import java.io.InputStream;

public class GerichteController {
    public Text GerichtName;
    public Text GerichtBeschreibung;
    public SVGPath GerichtFav;
    public ImageView GerichtImage;



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
        GerichtFav.setContent(b?"M16 6.204l-5.528-0.803-2.472-5.009-2.472 5.009-5.528 0.803 4 3.899-0.944 5.505 4.944-2.599 4.944 2.599-0.944-5.505 4-3.899z":"M16 6.204l-5.528-0.803-2.472-5.009-2.472 5.009-5.528 0.803 4 3.899-0.944 5.505 4.944-2.599 4.944 2.599-0.944-5.505 4-3.899zM8 11.773l-3.492 1.836 0.667-3.888-2.825-2.753 3.904-0.567 1.746-3.537 1.746 3.537 3.904 0.567-2.825 2.753 0.667 3.888-3.492-1.836z");
    }



}
