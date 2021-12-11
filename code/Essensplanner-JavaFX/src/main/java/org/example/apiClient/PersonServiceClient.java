package org.example.apiClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.example.apiClient.dto.PersonDTO;

public class PersonServiceClient {
    public static boolean addPersonToApi(PersonDTO p){
        try{
            System.out.println(p.getEmail());
            System.out.println(p.getPassword());

            HttpResponse<String> apiResponse = Unirest.get("http://localhost:8080/hello").asString();
            System.out.println(apiResponse.getBody());

            return true;

        } catch (UnirestException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean login(PersonDTO p ){
        boolean success = false;

        //API Request
        success = true;

        return success;
    }
}
