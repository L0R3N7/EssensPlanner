package org.example;

import org.example.apiClient.RestApiClient;
import org.example.apiClient.dto.GerichtDTO;
import org.example.apiClient.dto.PersonDTO;

import java.util.List;

public class AppData {
    private final RestApiClient restClient = new RestApiClient();

    private PersonDTO personDTO;


    // Person
    public boolean signIn(PersonDTO personDTO){
        this.personDTO = restClient.personSignIn(personDTO);
        return this.personDTO != null;
    }

    public boolean logIn(PersonDTO personDTO){
        this.personDTO = restClient.personLogIn(personDTO);
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

}
