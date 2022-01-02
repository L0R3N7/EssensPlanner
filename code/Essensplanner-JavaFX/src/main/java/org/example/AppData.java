package org.example;

import org.example.apiClient.RestApiClient;
import org.example.apiClient.dto.PersonDTO;

public class AppData {
    private final RestApiClient restClient = new RestApiClient();

    private PersonDTO personDTO;

    public boolean signIn(PersonDTO personDTO){
        this.personDTO = restClient.personSignIn(personDTO);
        return this.personDTO != null;
    }

    public boolean logIn(PersonDTO personDTO){
        this.personDTO = restClient.personLogIn(personDTO);
        return this.personDTO != null;
    }
}
