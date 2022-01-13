package org.example;

import org.example.apiClient.RestApiClient;
import org.example.apiClient.dto.GerichtDTO;
import org.example.apiClient.dto.PersonDTO;
import org.example.apiClient.dto.RezeptDTO;

import java.util.List;

public class AppData {
    private final RestApiClient restClient = new RestApiClient();

    private PersonDTO personDTO;


    // Person
    public boolean signIn(PersonDTO personDTO){
        this.personDTO = restClient.personSignIn(personDTO);
        App.menubarController.showHidde(this.personDTO != null);
        return this.personDTO != null;
    }

    public boolean logIn(PersonDTO personDTO){
        this.personDTO = restClient.personLogIn(personDTO);
        App.menubarController.showHidde(this.personDTO != null);
        return this.personDTO != null;
    }

    // Gerichte
    public List<GerichtDTO> searchGerichte(String eingabe){
        return restClient.gerichteSearch(eingabe);
    }

    public boolean isFavoriteGericht(Long id){
        return restClient.gerichteIsFavorite(this.personDTO, id);
    }

    public void setFavoriteGericht(Long id, Boolean b){
        restClient.gerichteSetFavorite(this.personDTO, id, b);
    }

    public List<RezeptDTO> getRezeptById(long uniqueGerichteId) {
        return null;
        //restClient.rezeptGetById(uniqueGerichteId);
    }

    public void logout() {
        this.personDTO = null;
        App.menubarController.showHidde(false);
    }
}
