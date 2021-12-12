package org.example;

import javafx.scene.text.Text;

public class ZubereitungsschritteController {

    public Text Zubereitungsschritt;
    public Text Anleitung;

    public void setZubereitungsschritt(int zubereitungsschritt) {
        Zubereitungsschritt.setText(""+zubereitungsschritt);
    }
    public void setAnleitung(String anleitung) {
        Anleitung.setText(anleitung);
    }
}
