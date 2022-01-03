package org.example.apiClient;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.example.apiClient.dto.GerichtDTO;
import org.example.apiClient.dto.PersonDTO;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;


public class RestApiClient {

    final ClientConfig clientConfig = new DefaultClientConfig();
    Client client;
    WebResource webResource;

    public RestApiClient() {
        clientConfig.getClasses().add(JacksonJsonProvider.class);
        client = Client.create(clientConfig);
        webResource = client.resource(UriBuilder.fromUri("http://localhost:8080").build());
    }

    public PersonDTO personSignIn(PersonDTO p) {
        PersonDTO personDTOResponse =  webResource.path("person").path("signin").
                type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(PersonDTO.class,p);
        System.out.println(personDTOResponse.toString());
        return personDTOResponse;
    }

    public PersonDTO personLogIn(PersonDTO p) {
        PersonDTO personDTO = webResource.path("person").path("login")
                .type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(PersonDTO.class, p);
        return personDTO;
    }

    public List<GerichtDTO> gerichteSearch(String eingabe) {
        return webResource
                .path("gericht")
                .path("search")
                .path(eingabe)
                .accept(MediaType.APPLICATION_JSON)
                 .get(new GenericType<List<GerichtDTO>>() {});
    }
}
