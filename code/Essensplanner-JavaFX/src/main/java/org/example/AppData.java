package org.example;

import org.example.apiClient.RestApiClient;
import org.example.apiClient.dto.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.LongStream;

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

    public void logout() {
        this.personDTO = null;
        App.menubarController.showHidde(false);
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

    // Tagesplan
    public void addPlannedWeek(List<TagesplanDTO> tagesplanDTOS){
        System.out.println("gonna save the data");

        tagesplanDTOS.get(0).setIdPersonEmail(this.personDTO.getEmail());
        tagesplanDTOS.get(0).setIdPersonUniqueSessionCode(this.personDTO.getUniqueSessionCode());
        restClient.addPlannedWeek(tagesplanDTOS);
    }

    public void deletePlannedWeek(LocalDate localDate){
        restClient.deletePlannedWeek(Mappings.LocalDateToString(localDate), this.personDTO);
    }

    public List<TagesplanResult> getPlannedWeek(LocalDate localDate){
        return restClient.getPlannedWeek(Mappings.LocalDateToString(localDate), this.personDTO);
    }


    public List<GerichtDTO> getGerichteByIds(List<Long> gerichteIdList) {
        return restClient.getGerichtelistByIds(gerichteIdList);
    }
}
